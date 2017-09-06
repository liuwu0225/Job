package com.vip.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("json-default")
@Namespace("/")
public class BaseAction extends ActionSupport {

/**
 * 基础ACTION,其他ACTION继承此ACTION来获得writeJson和ActionSupport的功能
 * 
 * @author Wen
 */
	private static final long serialVersionUID = 7245492745608707319L;
	
	
}
