package com.vip.model;

import java.io.Serializable;

/**
 * JSON模型
 * 
 * @author Wen
 * 
 */
public class Json implements Serializable{
	/**
	 * Json:前后台数据交互类型
	 */
	private static final long serialVersionUID = 2910876334114616372L;
	
	private boolean success = false;  //是否成功
	private String msg = ""; //提示消息
	private Object object = null ; //其他消息
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	
}
