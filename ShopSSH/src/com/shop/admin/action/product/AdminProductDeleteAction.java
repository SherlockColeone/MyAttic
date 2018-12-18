package com.shop.admin.action.product;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class AdminProductDeleteAction extends ActionSupport implements ModelDriven<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private ProductService productService;

	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		//获取参数pid
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		//删除商品信息，数据传到业务层
		productService.delProduct(pid);
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
