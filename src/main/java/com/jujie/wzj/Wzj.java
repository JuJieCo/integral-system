package com.jujie.wzj;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.jujie.global.BaseBean;

public class Wzj extends BaseBean{
	
	private Integer wzjOrgId;
	private String wzjOrgName;
	private String wzjOrgPhone;
	private String wzjOrgPhone2;
	private String wzjOrgPhone3;
	private String wzjOrgAddress;
	private String wzjOrgContact;
	private Integer wzjOrgStatus;
	private String wzjOrgRemark;
	
	public Integer getWzjOrgId() {
		return wzjOrgId;
	}
	public void setWzjOrgId(Integer wzjOrgId) {
		this.wzjOrgId = wzjOrgId;
	}
	public String getWzjOrgName() {
		return wzjOrgName;
	}
	public void setWzjOrgName(String wzjOrgName) {
		this.wzjOrgName = wzjOrgName;
	}
	public String getWzjOrgPhone() {
		return wzjOrgPhone;
	}
	public void setWzjOrgPhone(String wzjOrgPhone) {
		this.wzjOrgPhone = wzjOrgPhone;
	}
	public String getWzjOrgPhone2() {
		return wzjOrgPhone2;
	}
	public void setWzjOrgPhone2(String wzjOrgPhone2) {
		this.wzjOrgPhone2 = wzjOrgPhone2;
	}
	public String getWzjOrgPhone3() {
		return wzjOrgPhone3;
	}
	public void setWzjOrgPhone3(String wzjOrgPhone3) {
		this.wzjOrgPhone3 = wzjOrgPhone3;
	}
	public String getWzjOrgAddress() {
		return wzjOrgAddress;
	}
	public void setWzjOrgAddress(String wzjOrgAddress) {
		this.wzjOrgAddress = wzjOrgAddress;
	}
	public String getWzjOrgContact() {
		return wzjOrgContact;
	}
	public void setWzjOrgContact(String wzjOrgContact) {
		this.wzjOrgContact = wzjOrgContact;
	}
	public Integer getWzjOrgStatus() {
		return wzjOrgStatus;
	}
	public void setWzjOrgStatus(Integer wzjOrgStatus) {
		this.wzjOrgStatus = wzjOrgStatus;
	}
	public String getWzjOrgRemark() {
		return wzjOrgRemark;
	}
	public void setWzjOrgRemark(String wzjOrgRemark) {
		this.wzjOrgRemark = wzjOrgRemark;
	}
	
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		Wzj wzj = new Wzj();
		wzj.setWzjOrgId(rs.getInt("wzj_org_id"));
		wzj.setWzjOrgName(rs.getString("wzj_org_name"));
		wzj.setWzjOrgPhone(rs.getString("wzj_org_phone"));
		wzj.setWzjOrgPhone2(rs.getString("wzj_org_phone2"));
		wzj.setWzjOrgPhone3(rs.getString("wzj_org_phone3"));
		wzj.setWzjOrgAddress(rs.getString("wzj_org_address"));
		wzj.setWzjOrgContact(rs.getString("wzj_org_contact"));
		wzj.setWzjOrgStatus(rs.getInt("wzj_org_status"));
		wzj.setWzjOrgRemark(rs.getString("wzj_org_remark"));
		return wzj;
	}
	

}
