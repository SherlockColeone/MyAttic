package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Admin;
import com.cn.dao.IAdminDao;
import com.cn.dbc.BaseDao;

/**
 * 管理员类接口实现类
 * @author Sherlock
 *
 */
public class AdminDaoImpl implements IAdminDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doAdmin(Admin vo) {
		String sql = "insert into admin(id,name,sex,phone,idcard,birth,password,address,birthplace,entrytime,"
				+ "position,identity) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return bd.update(sql,vo.getId(),vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),
			vo.getAddress(),vo.getBirthplace(),vo.getEntrytime(),vo.getPosition(),vo.getIdentity());
	}

	@Override
	public int delAdminById(int id) {
		String sql = "delete from admin where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateAdmin(Admin vo) {
		String sql = "update admin set name=?,sex=?,phone=?,idcard=?,birth=?,password=?,address=?,birthplace=?,"
				+ "entrytime=?,position=?,identity=? where id=?";
		return bd.update(sql,vo.getName(),vo.getSex(),vo.getPhone(),vo.getIdcard(),vo.getBirth(),vo.getPassword(),vo.getAddress(),
			vo.getBirthplace(),vo.getEntrytime(),vo.getPosition(),vo.getIdentity(),vo.getId());
	}

	@Override
	public Admin findAdminById(int id) {
		String sql = "select * from admin where id = ?";
		return (Admin)bd.query(sql, Admin.class, id).get(0);
	}

	@Override
	public int updatePasswordById(int id,String pwd) {
		String sql = "update admin set password=? where id=?";
		return bd.update(sql,pwd,id);
	}

	@Override
	public int updateInitPasswordById(int id) {
		String sql = "update admin set password = '123456' where id = ?";
		return bd.update(sql,id);
	}

	@Override
	public Map<Integer, Admin> findAllAdmin() {
		String sql = "select * from admin";
		return bd.query(sql, Admin.class);
	}

	@Override
	public Admin findAdminByIdAndPwd(int id, String pwd) {
		String sql = "select * from admin where id = ? and password = ?";
		return (Admin)bd.query(sql, Admin.class, id, pwd).get(0);
	}

}
