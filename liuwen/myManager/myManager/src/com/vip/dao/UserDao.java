package com.vip.dao;

import java.util.List;

import com.vip.entity.user.UserEntity;


/**
 * UserDao接口
 * 
 * @author Wen
 * @time 2016-11-25
 */
public interface UserDao {

	public List<UserEntity> findByUsernameAndPass(String username, String password);
	
}
