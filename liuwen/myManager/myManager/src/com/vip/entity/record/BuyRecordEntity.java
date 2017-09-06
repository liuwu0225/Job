package com.vip.entity.record;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 购物记录实体类
 * 
 * @author Wen
 * @Time 2016-11-25
 * 
 */

@Entity
@Table(name="BUY_RECODER")
public class BuyRecordEntity {
	/**ID*/
	private String id;
	/**FID:与CUSTOMER关联字段*/
	private String fid;
	/**消费类型:01精品   02特价*/
	private String type;
	/**消费品牌:01七匹狼  02忘不了  03其他*/
	private String brand;
	/**货号*/
	private String artNo;
	/**单价*/
	private String singlePrice;
	/**数量*/
	private String count;
	/**金额*/
	private String amount;
	/**本单购物时间*/
	private String shoppingTime;
	
	@Id
	@Column(name="id",nullable=true,length=8)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Column(name="fid")
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getArtNo() {
		return artNo;
	}
	public void setArtNo(String artNo) {
		this.artNo = artNo;
	}
	public String getSinglePrice() {
		return singlePrice;
	}
	public void setSinglePrice(String singlePrice) {
		this.singlePrice = singlePrice;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getShoppingTime() {
		return shoppingTime;
	}
	public void setShoppingTime(String shoppingTime) {
		this.shoppingTime = shoppingTime;
	}
	
	
}
