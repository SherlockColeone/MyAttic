package com.shop.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.domain.Cart;
import com.shop.domain.CartItem;
import com.shop.domain.Order;
import com.shop.domain.OrderItem;
import com.shop.domain.Product;
import com.shop.domain.User;
import com.shop.utils.UUIDUtlis;
import com.yueqian.service.OrderService;
import com.yueqian.service.ProductService;
import sun.misc.UUDecoder;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// 根据方法的名称判断到底做什么事情
		String methodName = request.getParameter("method");

		// 如果接收到到method方法名是：delete 说明要删除购物车
		if (methodName.equals("delete")) {
			// 进行删除的逻辑了

			// 接收用户传递过来的pid
			String deletePid = request.getParameter("pid");
			/**
			 * 从购物车中取出session
			 * 
			 *
			 */
			Cart cart = (Cart) session.getAttribute("cart");
			if (cart != null) {
				Map<String, CartItem> cartItems = cart.getCartItems();
				// 顺便把总价格 需要更新 （总价 - 当前pid对应的小计）
				// 更新总价
				double total = cart.getTotal();
				// 根据pid找到对应商品商品对应的小计信息
				CartItem cartItem = cartItems.get(deletePid);
				double subtotal = cartItem.getSubtotal();
				// 用总价 - 小计
				total = total - subtotal;
				cart.setTotal(total);
				cartItems.remove(deletePid);
				// 不能留下白板，重定向到购物车界面 cart.jsp
				response.sendRedirect(request.getContextPath() + "/cart.jsp");

			}

		}
		// 清空购物车
		else if (methodName.equals("clearCart")) {
			session = request.getSession();
			session.removeAttribute("cart");
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}
		// 订单的逻辑
		else if (methodName.equals("addOrder")) {
			// 判断用户是否登录
			User user = (User) session.getAttribute("user");
			if (user == null) {
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			} else {
				Cart cart = (Cart) session.getAttribute("cart"); // 购物车
				Order order = new Order();
				// private String oid; // 订单的id
				String uuid = UUIDUtlis.getUUID2();
				System.out.println(uuid);
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

				// 调用service层
				OrderService service = new OrderService();
				try {
					service.submitOrder(order);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// 将数据存储在域中
				session.setAttribute("order", order);
				// 将页面重定向到order_info.jsp
				response.sendRedirect(request.getContextPath() + "/order_info.jsp");
			}

		}
		// 添加购物车功能
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
			ProductService service = new ProductService();
			Product product = service.findProductBypid(pid);
			// buyNum
			// subtotal (单价 * 数量)
			// 获取单价
			double shop_price = product.getShop_price();
			double subtotal = shop_price * buyNum;
			// 购物车项 在一个购物车中有若干个 购物车项
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setBuyNum(buyNum);
			item.setSubtotal(subtotal);
			// 将 cartItem 封装在真正的购物车中！！
			// 先判断是否有购物车 ，我们这里使用session实现购物车，所以我们就去判断session域中是否存储的有购物车
			session = request.getSession();
			Cart cart = (Cart) session.getAttribute("cart");
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
				cart.getCartItems().put(product.getPid(), item);
			}
			// 计算总价格
			// 使用total + subtotal
			double total = cart.getTotal() + subtotal;
			cart.setTotal(total);
			// 将装满东西的篮子存在session域中
			session.setAttribute("cart", cart);
			// 转发或者重定向
			// request.getRequestDispatcher("/cart.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/cart.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
