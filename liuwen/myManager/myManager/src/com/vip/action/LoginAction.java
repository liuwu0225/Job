package com.vip.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.vip.service.imp.UserServiceImp;

@Action(value="login",results = {
		@Result(name="index",location="pages/index/index.html"),
		@Result(name="error",location="pages/error/error.jsp")
		})
public class LoginAction extends ActionSupport{
	/**
	 * Login Action Class
	 */
	private static final long serialVersionUID = -3478371435021137086L;
	private String username;
	private String password;
	
	@Autowired
	private UserServiceImp userServiceImp;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		String username = this.username;
		String password = this.password;
		boolean flag = userServiceImp.isExitByUserNameAndPass(username,password);
		if(flag){
			return "index";
		}
		return "error";
	}
}
