package com.vip.service.imp;

/**
 * UserService实现类
 * 
 * @author Wen
 * 
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vip.dao.UserDao;
import com.vip.entity.user.UserEntity;
import com.vip.service.UserService;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isExitByUserNameAndPass(String username,String password) {
		List<UserEntity>  users = userDao.findByUsernameAndPass(username,password);
		if(users != null && users.size()>0){
			return true;
		}
		return false;
	}
}
