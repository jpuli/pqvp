package com.qualapps.ka.data;

import java.util.Date;

public class ArtifactData {
	
	private long artifId;
	private String artifLoc;
	private String artifType;
	private String artifDesc;
	private long artId;
	private Date chngDate;
	private String chngType;
	private String chngUser;
	
	public long getArtifId() {
		return artifId;
	}
	public void setArtifId(long artifId) {
		this.artifId = artifId;
	}
	public String getArtifLoc() {
		return artifLoc;
	}
	public void setArtifLoc(String artifLoc) {
		this.artifLoc = artifLoc;
	}
	public String getArtifType() {
		return artifType;
	}
	public void setArtifType(String artifType) {
		this.artifType = artifType;
	}
	public String getArtifDesc() {
		return artifDesc;
	}
	public void setArtifDesc(String artifDesc) {
		this.artifDesc = artifDesc;
	}
	public long getArtId() {
		return artId;
	}
	public void setArtId(long artId) {
		this.artId = artId;
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
