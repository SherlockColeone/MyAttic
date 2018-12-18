package com.shop.admin.action.product;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class AdminProductSaveAction extends ActionSupport implements ModelDriven<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//获取商品实体类
	private Product product;
	private ProductService productService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		//获取表单的参数并将产品添加到逻辑层
		boolean success = productService.addProduct(product);
		if(success==true) {
			return SUCCESS;
		}
		else {
			return "";
		}
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
