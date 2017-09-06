package com.vip.dao.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vip.dao.BaseDao;


/**
 * BaseDao实现类
 * 
 * @author Wen
 * 
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T o) {
		this.getCurrentSession().save(o);
	}

	@Override
	public List<T> find(String hql, List<Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.size()>0){
			for(int i=0;i<param.size();i++){
				q.setParameter(i, param.get(i));
			}
		}
		try{
			return q.list();
		}catch (Exception e) {
			System.out.println("数据库操作错误!!!");
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(T o) {
		this.getCurrentSession().update(o);
		
	}

	@Override
	public void delete(T o) {
		this.getCurrentSession().delete(o);
		
	}

	@Override
	public void saveOrUpdate(T o) {
		this.getCurrentSession().saveOrUpdate(o);
		
	}

}
