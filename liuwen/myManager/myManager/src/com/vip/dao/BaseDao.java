package com.vip.dao;


import java.util.List;

/**
 * BaseDao接口
 * 
 * @author Wen
 * 
 */
public interface BaseDao<T> {
	
	
	/**
	 * 保存一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public void save(T o);
	
	/**
	 * 删除一个对象
	 * 
	 * @param o
	 *            对象
	 */
	
	public void update(T o);
	
	/**
	 * 更新一个对象
	 * 
	 * @param o
	 *            对象
	 */

	public void delete(T o);
	
	/**
	 * 更新一个对象
	 * 
	 * @param o
	 *            对象
	 */

	public void saveOrUpdate(T o);
	
	/**
	 * 保存或更新一个对象
	 * 
	 * @param o
	 *            对象
	 */
	public List<T> find(String hql,List<Object> param);

}
