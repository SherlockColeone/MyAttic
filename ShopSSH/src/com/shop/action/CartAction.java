package com.shop.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.shop.domain.Cart;
import com.shop.domain.CartItem;
import com.shop.domain.Order;
import com.shop.domain.OrderItem;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.utils.UUIDUtlis;
import com.yueqian.service.OrderService;
import com.yueqian.service.ProductService;

public class CartAction extends ActionSupport {
	private Cart cart;
	private CartItem cartItem;
	private User user;
	private Order order;
	private Product product;
	private OrderService orderService;
	private ProductService productService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 根据方法的名称判断到底做什么事情
		String methodName = request.getParameter("method");		
		// 如果接收到到method方法名是：delete 说明要删除购物车
		if (methodName.equals("delete")) {
			// 接收用户传递过来的pid
			String deletePid = request.getParameter("pid");
			cart = (Cart) session.getAttribute("cart");
			if (cart != null) {
				Map<String, CartItem> cartItems = cart.getCartItems();
				// 顺便把总价格 需要更新 （总价 - 当前pid对应的小计）
				// 更新总价
				double total = cart.getTotal();
				// 根据pid找到对应商品商品对应的小计信息
				cartItem = cartItems.get(deletePid);
				double subtotal = cartItem.getSubtotal();
				// 用总价 - 小计
				total = total - subtotal;
				cart.setTotal(total);
				cartItems.remove(deletePid);
				return "cart";
			}
			// 清空购物车
			else if (methodName.equals("clearCart")) {
				session = request.getSession();
				session.removeAttribute("cart");
				return "cart";
			}
			// 订单的逻辑
			else if (methodName.equals("addOrder")) {
				// 判断用户是否登录
				user = (User) session.getAttribute("user");
				if (user == null) {
					return "gologin";
				}
				else {
					cart = (Cart) session.getAttribute("cart"); // 购物车
					// private String oid; // 订单的id
					String uuid = UUIDUtlis.getUUID2();
					order.setOid(uuid);
					// private Date ordertime; // 下订单时间
					order.setOrdertime(new Date());
					// private double total; // 总计
					order.setTotal(cart.getTotal());
					// private int state; // 订单的支付状态
					order.setState(0); // 未支付
					// private String address;// 收货人地址
					order.setAddress(null);
					// private String name;// 收货人名字
					order.setName(null);
					// private String telephone;// 收货人电话
					order.setTelephone(null);
					// private User uid; // 用户的id
					order.setUid(user); // ? 怎么处理呢？？？？？？
					Map<String, CartItem> cartItems = cart.getCartItems(); // 购物车项
					Set<Entry<String, CartItem>> entrySet = cartItems.entrySet();
					// Set<String> keySet = cartItems.keySet();
					List<OrderItem> list = new ArrayList<OrderItem>();
					for (Entry<String, CartItem> item : entrySet) {
						OrderItem orderitem = new OrderItem();
						CartItem cartitem = item.getValue();
						// private String itemid; //订单项id
						String uuid2 = UUIDUtlis.getUUID2();
						// System.out.println(uuid2);
						orderitem.setItemid(uuid2);
						// private int count;// 数量
						orderitem.setCount(cartitem.getBuyNum());
						// private double subtotal; // 小计
						orderitem.setSubtotal(cartitem.getSubtotal());
						// private Product pid; // 商品id
						orderitem.setPid(cartitem.getProduct());
						// private Order oid; // 订单的id 一个订单项属于哪个订单的
						orderitem.setOid(order);
						// 将多个订单订单项封装在一个订单中
						// order.getOrderItems().add(orderitem);
						list.add(orderitem);
					}
					order.setOrderItems(list);	
					//调用逻辑层
					orderService.submitOrder(order);
					// 将数据存储在域中
					session.setAttribute("order", order);
					return "order_info";
				}
			}
			else {
				// 正常的去查询购物车信息
				// 接收用户从jsp传递过来的参数
				// 商品id
				String pid = request.getParameter("pid");
				// 购买数量
				int buyNum = Integer.parseInt(request.getParameter("buyNum"));
				// System.out.println(pid);
				// System.out.println(buyNum);
				// 将数据封装成CartItem
				// product
				productService = new ProductService();
				product = productService.findProductBypid(pid);
				// buyNum
				// subtotal (单价 * 数量)
				// 获取单价
				double shop_price = product.getShop_price();
				double subtotal = shop_price * buyNum;
				// 购物车项 在一个购物车中有若干个 购物车项
				cartItem.setProduct(product);
				cartItem.setBuyNum(buyNum);
				cartItem.setSubtotal(subtotal);
				// 将 cartItem 封装在真正的购物车中！！
				// 先判断是否有购物车 ，我们这里使用session实现购物车，所以我们就去判断session域中是否存储的有购物车
				session = request.getSession();
				cart = (Cart) session.getAttribute("cart");
				if (cart == null) {
					// 你没有购物车,需要创建一个新的
					cart = new Cart();
				}

				// 将干个 cartItem购物车项存储在购物车中
				/**
				 * 问题:每次都是根据id获取到一个商品直接放入购物车
				 * 
				 * 1.如果购物车中已经存在了该id对应的商品，那么就应该将 原有数量+1
				 * 
				 * 商品数量 修改了
				 * 小计
				 * 
				 * 总价
				 * 
				 * 都需要修改
				 * 
				 * 2.如果购物车中不存在该id对应的商品，那么就直接放入购物车
				 */
				Map<String, CartItem> cartItems = cart.getCartItems();
				if (cartItems.containsKey(pid)) {
					// 如果存在，那么应该让商品数量+1
					CartItem cartItem = cartItems.get(pid);
					int oldBuyNum = cartItem.getBuyNum();
					buyNum += oldBuyNum;

					cartItem.setBuyNum(buyNum);

					// 小计的更新
					// buyNum * product.getShop_price();

					// 使用新的小计 + 旧的小计 = 最新的小计

					double oldSubtotal = cartItem.getSubtotal();

					double newSubtotal = oldSubtotal + subtotal;

					cartItem.setSubtotal(newSubtotal);

				} else {
					// 购物车不存在对应的商品
					cart.getCartItems().put(product.getPid(), cartItem);
				}
				// 计算总价格
				// 使用total + subtotal
				double total = cart.getTotal() + subtotal;
				cart.setTotal(total);
				// 将装满东西的篮子存在session域中
				session.setAttribute("cart", cart);
				return "cart";
			}
		}
		return SUCCESS;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartItem getCartItem() {
		return cartItem;
	}

	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
