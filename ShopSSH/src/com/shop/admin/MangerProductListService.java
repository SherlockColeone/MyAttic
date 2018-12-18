package com.shop.admin;

import java.sql.SQLException;
import java.util.List;

import com.shop.domain.Product;

public class MangerProductListService {

	MangerProductListDao dao = new MangerProductListDao();
	
	public List<Product> getProductList() throws SQLException {
		
		return dao.getProductList();
	}

}
