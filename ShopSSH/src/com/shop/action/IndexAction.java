package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Product;
import com.yueqian.service.IndexService;

public class IndexAction extends ActionSupport implements ModelDriven<Product>{
	private Product product;
	private IndexService indexService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		indexService = (IndexService) ac.getBean("IndexService");
		List<Product> hotProductList = indexService.getHotProductList();
		List<Product> newProductList = indexService.getNewProductList();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("hotProductList",hotProductList);
		request.setAttribute("newProductList", newProductList);
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

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}
	
}
