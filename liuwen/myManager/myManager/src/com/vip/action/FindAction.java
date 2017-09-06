package com.vip.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**   
 * Title: Action
 * Description: vip信息查询
 *
 * @author Wen
 * @since 2016-12-06
 *
 */


@SuppressWarnings("serial")
@Action(value="vipAction",results = {
		@Result(name="index",location="pages/index/index.html"),
		@Result(name="error",location="pages/error/error.jsp")
		})
public class FindAction extends BaseAction {
	
	public String execute(){
		System.out.println("3333");
		System.out.println("4444");
		return null;
	}
	
	public String findVipInfo(){
		System.out.println("111");
		System.out.println("222");
		return null;
	}
}
