package com.qualapps.ka.data;

import java.util.Date;

public class UserProfileData {

	private long usrProfileId;
	private String usrName;
	private String usrPwd;
	private String usrRole;
	private Date chngDate;
	private String chngType;
	private String chngUser;
	
	public long getUsrProfileId() {
		return usrProfileId;
	}
	public void setUsrProfileId(long usrProfileId) {
		this.usrProfileId = usrProfileId;
	}
	public String getUsrName() {
		return usrName;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public String getUsrPwd() {
		return usrPwd;
	}
	public void setUsrPwd(String usrPwd) {
		this.usrPwd = usrPwd;
	}
	public String getUsrRole() {
		return usrRole;
	}
	public void setUsrRole(String usrRole) {
		this.usrRole = usrRole;
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

}
