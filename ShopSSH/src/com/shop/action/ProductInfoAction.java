package com.shop.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class ProductInfoAction extends ActionSupport implements ModelDriven<Product>{
	private Product product;
	private ProductService productService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		product = productService.findProductBypid(pid);		
		// 将查询到的单个商品信息存在request域中		
		request.setAttribute("product", product);
		return SUCCESS;
	}

	@Override
	public Product getModel() {		
		return product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
}
