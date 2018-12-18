package com.shop.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.domain.Product;
import com.yueqian.service.ProductService;

public class ProductInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		// 接收用户从jsp传递过来的pid
		String pid = request.getParameter("pid");
		//  调用serivice		
		ProductService service = new ProductService();
		Product product = service.findProductBypid(pid);		
		// 将查询到的单个商品信息存在request域中		
		request.setAttribute("product", product);
	  // 进行转发到jsp
		request.getRequestDispatcher("/product_info.jsp").forward(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
