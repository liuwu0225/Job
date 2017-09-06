package com.vip.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 * 
 * @author Wen
 * @Time 2016-11-25
 * 
 */
@Entity
@Table(name="USER")
public class UserEntity implements Serializable{

	private static final long serialVersionUID = -6261715452562965923L;
	
	/**ID*/
	private String id;
	/**用户名*/
	private String username;
	/**密码*/
	private String password;
	/**权限*/
	private String authority;
	
	@Id
	@Column(name="id",nullable=true,length=8)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserEntity() {
		super();
	}
	@Column(name="authority")
	public String getAuthority() {
		return authority;
	}
	
	public UserEntity(String id, String username, String password,
			String authority) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authority = authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", username=" + username
				+ ", password=" + password + ", authority=" + authority + "]";
	}

}
