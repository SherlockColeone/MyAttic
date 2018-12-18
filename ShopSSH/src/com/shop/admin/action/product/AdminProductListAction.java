package com.shop.admin.action.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class AdminProductListAction {
	private ProductService productService;
	
	public String getproductList() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		// 请求service层获取数据
		List<Product> productList = productService.findProductList();
		// ServletActionContext.getRequest() 获取 HttpServletRequest
		HttpServletRequest request = ServletActionContext.getRequest();
		// 将数据存储在request中
		request.setAttribute("productList", productList);
		return "list";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
