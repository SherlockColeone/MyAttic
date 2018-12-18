package com.yueqian.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shop.domain.OrderItem;
import com.shop.domain.Product;
import com.shop.utils.PageBean;
import com.shop.utils.UUIDUtlis;
import com.yueqian.dao.OrderItemDao;
import com.yueqian.dao.ProductDao;

public class OrderItemService {
	private OrderItem orderItem;
	private ProductDao productDao;
	private OrderItemDao orderItemDao;

	public List<OrderItem> findProductList() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		orderItemDao = (OrderItemDao) ac.getBean("OrderItemDao");
		return orderItemDao.findOrderItemList();
	}

	public PageBean findPageBean(int currentPage, int currentTootal) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productDao = (ProductDao) ac.getBean("ProductDao");
		// 当前页
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);

		// 每页显示记录数
		// private int currentTootal;

		pageBean.setCurrentTootal(currentTootal);

		// 总记录数(条数)
		// private int totalCount;
		// 查询总记录数
		long totalCount = productDao.getTotalCount();
		int count = (int) totalCount;
		pageBean.setTotalCount(count);

		// 总页码
		// private int totalPage;

		// totalCount/currentTootal

		// double / int = double

		int totalPage = (int) Math.ceil((totalCount * 1.0 / currentTootal));

		// double 能不能直接转int？ 可以

		pageBean.setTotalPage(totalPage);

		/**
		 * 总页码应该怎么求呢？
		 * 
		 * 总记录 每页显示几条 总页码
		 * 
		 * 10 4 （10/4） = 2 2.5 3
		 * 
		 * 11 4 (11/4) = 2.75 3
		 * 
		 * 12 4 3
		 * 
		 * 13 4 4
		 * 
		 * 14 4 4
		 * 
		 * 15 4 4
		 * 
		 * 16 4 4
		 * 
		 * 公式： ？
		 */
		// 使用分页limit查询返回的数据
		// private List<T> productList = new ArrayList<T>();

		/**
		 * 1. 开始索引
		 *
		 * 2. 每页显示几条
		 * 
		 */

		// (当前页?-1)*每页记录数(10)

		int index = (currentPage - 1) * currentTootal;
		List<Product> productList = null;
		productList = productDao.getProductListByLimit(index, currentTootal);
		pageBean.setProductList(productList);

		return pageBean;
	}

	public Product findProductBypid(String pid) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productDao = (ProductDao) ac.getBean("ProductDao");
		return productDao.findProductBypid(pid);
	}

	/**
	 * 设置产品属性并传到DAO层
	 * 
	 * @param vo
	 *            新增产品
	 * @return 是否成功添加
	 */
	public boolean addProduct(Product vo) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productDao = (ProductDao) ac.getBean("ProductDao");
		// 设置产品id
		vo.setPid(UUIDUtlis.getUUID2());
		// 设置产品日期为当前日期
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		vo.setPdate(strDate);
		vo.setPflag(0);
		productDao.doProduct(vo);
		return true;
	}

	/**
	 * 修改后的商品信息传到DAO层
	 * 
	 * @param vo
	 *            商品对象
	 * @return 是否成功修改
	 */
	public boolean modifyProduct(Product vo) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productDao = (ProductDao) ac.getBean("ProductDao");
		// 设置商品日期为当前日期
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(date);
		vo.setPdate(strDate);
		productDao.updateProduct(vo);
		return true;
	}

	/**
	 * 删除商品
	 * 
	 * @param pid
	 *            商品编号
	 * @return 是否删除成功
	 */
	public int delProduct(String pid) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		productDao = (ProductDao) ac.getBean("ProductDao");
		productDao.delProduct(pid);
		return 1;
	}

	public ProductDao getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
}
