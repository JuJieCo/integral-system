package com.jujie.agence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.global.BaseBean;



public class Agence extends BaseBean{
	
	
	private  Integer agenceId ;
	private  String agenceName;
	private  String agencePhone;
	private  String agencePhone2;
	private  String agencePhone3;
	private  String agenceAddress;
	private  String agenceContact;
	private  Integer agenceStatus;
	private  String  agenceRemark;
	private  String  agenceCode;
	private  Integer agenceLevel;
	private  Integer agencePid;
	
	
	
	public Integer getAgenceId() {
		return agenceId;
	}
	public void setAgenceId(Integer agenceId) {
		this.agenceId = agenceId;
	}
	public String getAgenceName() {
		return agenceName;
	}
	public void setAgenceName(String agenceName) {
		this.agenceName = agenceName;
	}
	public String getAgencePhone() {
		return agencePhone;
	}
	public void setAgencePhone(String agencePhone) {
		this.agencePhone = agencePhone;
	}
	public String getAgencePhone2() {
		return agencePhone2;
	}
	public void setAgencePhone2(String agencePhone2) {
		this.agencePhone2 = agencePhone2;
	}
	public String getAgencePhone3() {
		return agencePhone3;
	}
	public void setAgencePhone3(String agencePhone3) {
		this.agencePhone3 = agencePhone3;
	}
	public String getAgenceAddress() {
		return agenceAddress;
	}
	public void setAgenceAddress(String agenceAddress) {
		this.agenceAddress = agenceAddress;
	}
	
	public String getAgenceContact() {
		return agenceContact;
	}
	public void setAgenceContact(String agenceContact) {
		this.agenceContact = agenceContact;
	}
	public Integer getAgenceStatus() {
		return agenceStatus;
	}
	public void setAgenceStatus(Integer agenceStatus) {
		this.agenceStatus = agenceStatus;
	}
	public String getAgenceRemark() {
		return agenceRemark;
	}
	public void setAgenceRemark(String agenceRemark) {
		this.agenceRemark = agenceRemark;
	}
	
	public String getAgenceCode() {
		return agenceCode;
	}
	public void setAgenceCode(String agenceCode) {
		this.agenceCode = agenceCode;
	}
	public Integer getAgenceLevel() {
		return agenceLevel;
	}
	public void setAgenceLevel(Integer agenceLevel) {
		this.agenceLevel = agenceLevel;
	}
	public Integer getAgencePid() {
		return agencePid;
	}
	public void setAgencePid(Integer agencePid) {
		this.agencePid = agencePid;
	}
	public Agence mapRow(ResultSet rs, int rownum) throws SQLException {
		Agence agence = new  Agence();
		agence.setAgenceId(rs.getInt("agence_id"));
		agence.setAgenceName(rs.getString("agence_name"));
		agence.setAgencePhone(rs.getString("agence_phone"));
		agence.setAgencePhone2(rs.getString("agence_phone2"));
		agence.setAgencePhone3(rs.getString("agence_phone3"));
		agence.setAgenceAddress(rs.getString("agence_address"));
		agence.setAgenceContact(rs.getString("agence_contact"));
		agence.setAgenceStatus(rs.getInt("agence_status"));
		agence.setAgenceRemark(rs.getString("agence_remark"));
		agence.setAgenceCode(rs.getString("agence_code"));
		agence.setAgenceLevel(rs.getInt("agence_level"));
		agence.setAgencePid(rs.getInt("agence_pid"));
		return agence;
	}
	
	
	
	
	

}
