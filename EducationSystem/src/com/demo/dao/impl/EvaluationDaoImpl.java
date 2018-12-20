package com.demo.dao.impl;

import java.util.Map;

import com.cn.bean.Evaluation;
import com.cn.dao.IEvaluationDao;
import com.cn.dbc.BaseDao;

/**
 * 教学评价类接口实现类
 * @author Sherlock
 *
 */
public class EvaluationDaoImpl implements IEvaluationDao {
	BaseDao bd = new BaseDao();

	@Override
	public int doEvaluation(Evaluation vo) {
		String sql = "insert into evaluation(id,teacherid,content) values(?,?,?)";
		return bd.update(sql,vo.getId(),vo.getTeacherid(),vo.getContent());
	}

	@Override
	public int delEvaluationById(int id) {
		String sql = "delete from evaluation where id = ?";
		return bd.update(sql, id);
	}

	@Override
	public int updateEvaluation(Evaluation vo) {
		String sql = "update evaluation set teacherid=?,content=? where id=?";
		return bd.update(sql,vo.getTeacherid(),vo.getContent(),vo.getId());
	}

	@Override
	public Evaluation findEvaluationById(int id) {
		String sql = "select * from evaluation where id = ?";
		return (Evaluation)bd.query(sql, Evaluation.class, id).get(0);
	}

	@Override
	public Map<Integer, Evaluation> findAllEvaluation() {
		String sql = "select * from evaluation";
		return bd.query(sql, Evaluation.class);
	}

	@Override
	public Map<Integer, Evaluation> findAllEvaluationByteacherid(int teacherid) {
		String sql = "select * from evaluation where teacherid = ? ";
		return bd.query(sql, Evaluation.class, teacherid);
	}

}
