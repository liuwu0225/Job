package com.vip.entity.customer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 顾客实体类
 * 
 * @author Wen
 * @Time 2016-11-25
 * 
 */
@Entity
@Table(name="CUSTOMER")
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 8468811764998339886L;
	
	/**ID*/
	private String ID;
	/**姓名*/
	private String name;
	/**手机号*/
	private String tel;
	/**生日*/
	private String birthday;
	/**年龄*/
	private String age;
	/**外套尺码*/
	private String coatSize;
	/**夹克尺码*/
	private String jacketSize;
	/**衬衫尺码*/
	private String shirtSize;
	/**T-shirt尺码*/
	private String tShirtSize;
	/**腰围*/
	private String waistlineSize;
	/**裤长*/
	private String pantSize;
	
	@Id
	@Column(name="id",nullable=true,length=8)
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="tel")
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Column(name="birthday")
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	@Column(name="age")
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Column(name="coatSize")
	public String getCoatSize() {
		return coatSize;
	}
	public void setCoatSize(String coatSize) {
		this.coatSize = coatSize;
	}
	
	@Column(name="jacketSize")
	public String getJacketSize() {
		return jacketSize;
	}
	public void setJacketSize(String jacketSize) {
		this.jacketSize = jacketSize;
	}
	
	@Column(name="shirtSize")
	public String getShirtSize() {
		return shirtSize;
	}
	public void setShirtSize(String shirtSize) {
		this.shirtSize = shirtSize;
	}
	
	@Column(name="tShirtSize")
	public String gettShirtSize() {
		return tShirtSize;
	}
	public void settShirtSize(String tShirtSize) {
		this.tShirtSize = tShirtSize;
	}
	
	@Column(name="waistlineSize")
	public String getWaistlineSize() {
		return waistlineSize;
	}
	public void setWaistlineSize(String waistlineSize) {
		this.waistlineSize = waistlineSize;
	}
	
	@Column(name="pantSize")
	public String getPantSize() {
		return pantSize;
	}
	public void setPantSize(String pantSize) {
		this.pantSize = pantSize;
	}
	
	@Override
	public String toString() {
		return "CustomerEntity [ID=" + ID + ", name=" + name + ", tel=" + tel
				+ ", birthday=" + birthday + ", age=" + age + ", coatSize="
				+ coatSize + ", jacketSize=" + jacketSize + ", shirtSize="
				+ shirtSize + ", tShirtSize=" + tShirtSize + ", waistlineSize="
				+ waistlineSize + ", pantSize=" + pantSize + "]";
	}
}
