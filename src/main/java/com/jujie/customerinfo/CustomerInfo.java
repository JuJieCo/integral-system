package com.jujie.customerinfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jujie.global.BaseBean;

public class CustomerInfo  extends BaseBean{
	private Integer custId;
	private String 	custName;
	private String 	custCode;
	private Date 	custBirthday;
	private String 	custAddress;
	private String 	custAreaCode;
	private String 	custHomePhone;
	private String 	custOfferPhone;
	private String 	custMobile;
	private String 	custEmail;
	private String 	custZipCode;
	private Integer custLevel;
	private Integer custStatus;
	private Date 	custRegistTime;
	private Integer custCpAgence;
	private Integer custCpManager;//
	private Integer agenceId;//
	private String 	custHold;
	private String 	custRemark;
	private String agenceName;
	private String sysUserName; 
	private Integer sysUserLevel;
	private Integer sysUserId;
	

	public Integer getSysUserLevel() {
		return sysUserLevel;
	}
	public void setSysUserLevel(Integer sysUserLevel) {
		this.sysUserLevel = sysUserLevel;
	}
	public Integer getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}
	public Integer getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(Integer custLevel) {
		this.custLevel = custLevel;
	}
	
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustCode() {
		return custCode;
	}
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	public Date getCustBirthday() {
		return custBirthday;
	}
	public void setCustBirthday(Date custBirthday) {
		this.custBirthday = custBirthday;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public String getCustAreaCode() {
		return custAreaCode;
	}
	public void setCustAreaCode(String custAreaCode) {
		this.custAreaCode = custAreaCode;
	}
	public String getCustHomePhone() {
		return custHomePhone;
	}
	public void setCustHomePhone(String custHomePhone) {
		this.custHomePhone = custHomePhone;
	}
	public String getCustOfferPhone() {
		return custOfferPhone;
	}
	public void setCustOfferPhone(String custOfferPhone) {
		this.custOfferPhone = custOfferPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getCustZipCode() {
		return custZipCode;
	}
	public void setCustZipCode(String custZipCode) {
		this.custZipCode = custZipCode;
	}

	public Integer getCustStatus() {
		return custStatus;
	}
	public void setCustStatus(Integer custStatus) {
		this.custStatus = custStatus;
	}
	public Date getCustRegistTime() {
		return custRegistTime;
	}
	public void setCustRegistTime(Date custRegistTime) {
		this.custRegistTime = custRegistTime;
	}
	public Integer getCustCpAgence() {
		return custCpAgence;
	}
	public void setCustCpAgence(Integer custCpAgence) {
		this.custCpAgence = custCpAgence;
	}
	public Integer getCustCpManager() {
		return custCpManager;
	}
	public void setCustCpManager(Integer custCpManager) {
		this.custCpManager = custCpManager;
	}
	public Integer getAgenceId() {
		return agenceId;
	}
	public void setAgenceId(Integer agenceId) {
		this.agenceId = agenceId;
	}
	public String getCustHold() {
		return custHold;
	}
	public void setCustHold(String custHold) {
		this.custHold = custHold;
	}
	public String getCustRemark() {
		return custRemark;
	}
	public void setCustRemark(String custRemark) {
		this.custRemark = custRemark;
	}
	public String getAgenceName() {
		return agenceName;
	}
	public void setAgenceName(String agenceName) {
		this.agenceName = agenceName;
	}
	public String getSysUserName() {
		return sysUserName;
	}
	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}
	
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCustId(rs.getInt("cust_id"));
		customerInfo.setCustName(rs.getString("cust_name"));
		customerInfo.setCustCode(rs.getString("cust_code"));
		customerInfo.setCustBirthday(rs.getDate("cust_birthday"));
		customerInfo.setCustAddress(rs.getString("cust_address"));
		customerInfo.setCustAreaCode(rs.getString("cust_areacode"));
		customerInfo.setCustHomePhone(rs.getString("cust_homephone"));
		customerInfo.setCustOfferPhone(rs.getString("cust_offerphone"));
		customerInfo.setCustMobile(rs.getString("cust_mobile"));
		customerInfo.setCustEmail(rs.getString("cust_email"));
		customerInfo.setCustZipCode(rs.getString("cust_zipcode"));
		customerInfo.setCustLevel(rs.getInt("cust_level"));
		customerInfo.setCustStatus(rs.getInt("cust_status"));
		customerInfo.setCustRegistTime(rs.getDate("cust_regist_time"));
		customerInfo.setCustCpAgence(rs.getInt("cust_cp_agence"));
		customerInfo.setCustCpManager(rs.getInt("cust_cp_manager"));
		customerInfo.setAgenceId(rs.getInt("agence_id"));
		customerInfo.setCustHold(rs.getString("cust_hold"));
		customerInfo.setCustRemark(rs.getString("cust_remark"));
		customerInfo.setAgenceName(rs.getString("agence_name"));
		customerInfo.setSysUserName(rs.getString("sys_user_name"));
		customerInfo.setSysUserLevel(rs.getInt("sys_user_level"));
		customerInfo.setSysUserId(rs.getInt("sys_user_id"));
		return customerInfo;
	}

}
