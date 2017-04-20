package com.jujie.gifts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jujie.global.BaseBean;

public class GiftsDetails extends BaseBean{
	
	private Integer	giftsDetailsId;
	private Integer	giftsId;
	private Integer	custId;
	private Date giftsDetailsTime;
	private Integer	giftsDetailsCost;
	private Integer	giftsDetailsStatus;
	private Integer	giftsDetailsOper;
	private Integer	giftsDetailsAgence;
	private String giftsDetailsHold1;
	private String giftsDetailsHold2;
	private String giftsDetailsRemark;
	
	private String sysUserName;
	private String agenceName; 
	private String custName;
	private String giftsName;
	
	private String custCode;
	
	
	
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getGiftsName() {
		return giftsName;
	}
	public void setGiftsName(String giftsName) {
		this.giftsName = giftsName;
	}
	public String getSysUserName() {
		return sysUserName;
	}
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}
	public String getAgenceName() {
		return agenceName;
	}
	public void setAgenceName(String agenceName) {
		this.agenceName = agenceName;
	}
	public Integer getGiftsDetailsId() {
		return giftsDetailsId;
	}
	public void setGiftsDetailsId(Integer giftsDetailsId) {
		this.giftsDetailsId = giftsDetailsId;
	}
	public Integer getGiftsId() {
		return giftsId;
	}
	public void setGiftsId(Integer giftsId) {
		this.giftsId = giftsId;
	}
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public Date getGiftsDetailsTime() {
		return giftsDetailsTime;
	}
	public void setGiftsDetailsTime(Date giftsDetailsTime) {
		this.giftsDetailsTime = giftsDetailsTime;
	}
	public Integer getGiftsDetailsCost() {
		return giftsDetailsCost;
	}
	public void setGiftsDetailsCost(Integer giftsDetailsCost) {
		this.giftsDetailsCost = giftsDetailsCost;
	}
	public Integer getGiftsDetailsStatus() {
		return giftsDetailsStatus;
	}
	public void setGiftsDetailsStatus(Integer giftsDetailsStatus) {
		this.giftsDetailsStatus = giftsDetailsStatus;
	}
	public Integer getGiftsDetailsOper() {
		return giftsDetailsOper;
	}
	public void setGiftsDetailsOper(Integer giftsDetailsOper) {
		this.giftsDetailsOper = giftsDetailsOper;
	}
	public Integer getGiftsDetailsAgence() {
		return giftsDetailsAgence;
	}
	public void setGiftsDetailsAgence(Integer giftsDetailsAgence) {
		this.giftsDetailsAgence = giftsDetailsAgence;
	}
	public String getGiftsDetailsHold1() {
		return giftsDetailsHold1;
	}
	public void setGiftsDetailsHold1(String giftsDetailsHold1) {
		this.giftsDetailsHold1 = giftsDetailsHold1;
	}
	public String getGiftsDetailsHold2() {
		return giftsDetailsHold2;
	}
	public void setGiftsDetailsHold2(String giftsDetailsHold2) {
		this.giftsDetailsHold2 = giftsDetailsHold2;
	}
	public String getGiftsDetailsRemark() {
		return giftsDetailsRemark;
	}
	public void setGiftsDetailsRemark(String giftsDetailsRemark) {
		this.giftsDetailsRemark = giftsDetailsRemark;
	}

	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		 
		GiftsDetails giftsDetails = new GiftsDetails();
		 giftsDetails.setGiftsDetailsId(rs.getInt("gifts_details_id"));
		 giftsDetails.setGiftsId(rs.getInt("gifts_id"));
		 giftsDetails.setCustId(rs.getInt("cust_id"));
		 giftsDetails.setGiftsDetailsTime(rs.getDate("gifts_details_time"));
		 giftsDetails.setGiftsDetailsCost(rs.getInt("gifts_details_cost"));
		 giftsDetails.setGiftsDetailsStatus(rs.getInt("gifts_details_status"));
		 giftsDetails.setGiftsDetailsOper(rs.getInt("gifts_details_oper"));
		 giftsDetails.setGiftsDetailsAgence(rs.getInt("gifts_details_agence"));
		 giftsDetails.setGiftsDetailsHold1(rs.getString("gifts_details_hold1"));
		 giftsDetails.setGiftsDetailsHold2(rs.getString("gifts_details_hold2"));
		 giftsDetails.setGiftsDetailsRemark(rs.getString("gifts_details_remark"));
		  
		 giftsDetails.setSysUserName(rs.getString("sys_user_name"));
		 giftsDetails.setAgenceName(rs.getString("agence_name"));
		 giftsDetails.setCustName(rs.getString("cust_name"));
		 giftsDetails.setGiftsName(rs.getString("gifts_name"));
		  
		 return giftsDetails;
	}
}
