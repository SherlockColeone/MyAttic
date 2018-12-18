package com.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.OrderItem;
import com.shop.domain.Product;
import com.shop.utils.PageBean;
import com.yueqian.service.ProductService;

public class OrderListAction extends ActionSupport{
	private Product product;
	private OrderItem orderItem;
	private ProductService productService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		HttpServletRequest request = ServletActionContext.getRequest();
		// List<Product> productList = service.findProductList();
		// 2.将数据库查询出来的数据存在request中
		/** 
		 * 在pageBean中已经包含分页的所有信息
		 * 
		 * 比如：页码
		 * 
		 * 比如： List
		 */
		// web层调用service层拿到需要的分页数据
		// 当前页码
		// String parameter = request.getParameter("page");
		// 接收用户从前台jsp中传入的页码编号值
		String currentPageStr = request.getParameter("currentPage");
		/**
		 * 处理当 currentPage 为null 问题
		 */
		if (currentPageStr == null)
			currentPageStr = "1";
		int currentPage = Integer.parseInt(currentPageStr);
		// 每页显示记录数
		int currentTootal = 12;
		PageBean<Product> pageBean = null;
		pageBean = productService.findPageBean(currentPage, currentTootal);
		request.setAttribute("pageBean", pageBean);
		return SUCCESS;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}
	
}
