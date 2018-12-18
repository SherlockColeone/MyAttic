package com.shop.admin.action.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.shop.domain.Category;
import com.shop.domain.Product;
import com.yueqian.service.CategoryService;
import com.yueqian.service.ProductService;

public class AdminProductEditAction extends ActionSupport implements ModelDriven<Product>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Product product;
	private ProductService productService;
	private CategoryService categoryService;
	
	@Override
	public String execute() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productService = (ProductService) ac.getBean("ProductService");
		categoryService = (CategoryService) ac.getBean("CategoryService");
		//获取参数pid
		HttpServletRequest request = ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		//通过pid查询该商品
		Product product = productService.findProductBypid(pid);
		request.setAttribute("product", product);
		//查询所有商品分类
		List<Category> categoryList = categoryService.findAllCategory();
		request.setAttribute("categoryList", categoryList);
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

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
}
