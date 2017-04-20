package com.jujie.user;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.agence.Agence;
import com.jujie.global.BaseBean;

public class User extends BaseBean{

	private Integer sysUserId;
	private String  sysUserDept;
	private String  sysUserName;
	private Integer sysUserLevel;
	private Agence sysUserAgence;
	private String  sysUserCode;
	private Integer sysUserStatus;
	private Integer sysUserIsManger;

	public Agence getSysUserAgence() {
		return sysUserAgence;
	}



	public void setSysUserAgence(Agence sysUserAgence) {
		this.sysUserAgence = sysUserAgence;
	}



	public Integer getSysUserIsManger() {
		return sysUserIsManger;
	}



	public void setSysUserIsManger(Integer sysUserIsManger) {
		this.sysUserIsManger = sysUserIsManger;
	}



	public Integer getSysUserId() {
		return sysUserId;
	}



	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}



	public String getSysUserDept() {
		return sysUserDept;
	}



	public void setSysUserDept(String sysUserDept) {
		this.sysUserDept = sysUserDept;
	}



	public String getSysUserName() {
		return sysUserName;
	}



	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}



	public Integer getSysUserLevel() {
		return sysUserLevel;
	}



	public void setSysUserLevel(Integer sysUserLevel) {
		this.sysUserLevel = sysUserLevel;
	}

	public String getSysUserCode() {
		return sysUserCode;
	}



	public void setSysUserCode(String sysUserCode) {
		this.sysUserCode = sysUserCode;
	}



	public Integer getSysUserStatus() {
		return sysUserStatus;
	}



	public void setSysUserStatus(Integer sysUserStatus) {
		this.sysUserStatus = sysUserStatus;
	}



	@Override
	public User mapRow(ResultSet rs, int rownum) throws SQLException {
		User user = new User();
		user.setSysUserDept(rs.getString("sys_user_dept"));
		user.setSysUserLevel(rs.getInt("sys_user_level"));
		user.setSysUserName(rs.getString("sys_user_name"));
		user.setSysUserAgence(new Agence().mapRow(rs, rownum));
		user.setSysUserCode(rs.getString("sys_user_code"));
		user.setSysUserStatus(rs.getInt("sys_user_status"));
		user.setSysUserId(rs.getInt("sys_user_id"));
		user.setSysUserIsManger(rs.getInt("sys_user_isManger"));
		return user;
	}
	
	
}
