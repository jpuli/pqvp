package com.qualapps.ka.data;

import java.util.Date;

public class CategoryData {
	
	private long catId;
	private String catName;
	private String catDescr;
	private Date chngDate;
	private String chngType;
	private String chngUser;
	private long artId;
	
	public long getCatId() {
		return catId;
	}
	public void setCatId(long catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getCatDescr() {
		return catDescr;
	}
	public void setCatDescr(String catDescr) {
		this.catDescr = catDescr;
	}
	public Date getChngDate() {
		return chngDate;
	}
	public void setChngDate(Date chngDate) {
		this.chngDate = chngDate;
	}
	public String getChngType() {
		return chngType;
	}
	public void setChngType(String chngType) {
		this.chngType = chngType;
	}
	public String getChngUser() {
		return chngUser;
	}
	public void setChngUser(String chngUser) {
		this.chngUser = chngUser;
	}
	public long getArtId() {
		return artId;
	}
	public void setArtId(long artId) {
		this.artId = artId;
	}
	
}
