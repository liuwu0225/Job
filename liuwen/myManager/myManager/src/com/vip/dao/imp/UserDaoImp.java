package com.vip.dao.imp;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.vip.dao.BaseDao;
import com.vip.dao.UserDao;
import com.vip.entity.user.UserEntity;

/**
 * UserDao实现类
 * 
 * @author Wen
 * @time 2016-11-25
 */
@Repository
public class UserDaoImp implements UserDao {
	@Autowired
	BaseDao<UserEntity> baseDao;

	@Override
	@Transactional
	public List<UserEntity> findByUsernameAndPass(String username,String password) {
		String hql = "from UserEntity where username='"+username+"' and password='"+password+"'";
		List<Object> values = new ArrayList<Object>();
		List<UserEntity> users = baseDao.find(hql, values);
		return users;
	}
}
