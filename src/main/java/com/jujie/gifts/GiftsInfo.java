package com.jujie.gifts;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jujie.global.BaseBean;

public class GiftsInfo extends BaseBean {
	private Integer giftsId;
	private String giftsType;
	private String giftsName;
	private Integer giftsTotal;
	private Integer giftsCalls;
	private Integer giftsRemain;
	private Integer giftsIntegral;
	private Integer wzjOrgId;
	private Date giftsStartTime;
	private Date giftsEndTime;
	private Integer giftsStatus;
	private String giftsHold;
	private String giftsRemark;
	
	private String wzjOrgName;



	public String getWzjOrgName() {
		return wzjOrgName;
	}

	public void setWzjOrgName(String wzjOrgName) {
		this.wzjOrgName = wzjOrgName;
	}

	public Integer getGiftsId() {
		return giftsId;
	}

	public void setGiftsId(Integer giftsId) {
		this.giftsId = giftsId;
	}

	public String getGiftsType() {
		return giftsType;
	}

	public void setGiftsType(String giftsType) {
		this.giftsType = giftsType;
	}

	public String getGiftsName() {
		return giftsName;
	}

	public void setGiftsName(String giftsName) {
		this.giftsName = giftsName;
	}

	public Integer getGiftsTotal() {
		return giftsTotal;
	}

	public void setGiftsTotal(Integer giftsTotal) {
		this.giftsTotal = giftsTotal;
	}

	public Integer getGiftsCalls() {
		return giftsCalls;
	}

	public void setGiftsCalls(Integer giftsCalls) {
		this.giftsCalls = giftsCalls;
	}

	public Integer getGiftsRemain() {
		return giftsRemain;
	}

	public void setGiftsRemain(Integer giftsRemain) {
		this.giftsRemain = giftsRemain;
	}
	public Integer getGiftsIntegral() {
		return giftsIntegral;
	}

	public void setGiftsIntegral(Integer giftsIntegral) {
		this.giftsIntegral = giftsIntegral;
	}

	public Integer getWzjOrgId() {
		return wzjOrgId;
	}

	public void setWzjOrgId(Integer wzjOrgId) {
		this.wzjOrgId = wzjOrgId;
	}

	public Date getGiftsStartTime() {
		return giftsStartTime;
	}

	public void setGiftsStartTime(Date giftsStartTime) {
		this.giftsStartTime = giftsStartTime;
	}

	public Date getGiftsEndTime() {
		return giftsEndTime;
	}

	public void setGiftsEndTime(Date giftsEndTime) {
		this.giftsEndTime = giftsEndTime;
	}

	public Integer getGiftsStatus() {
		return giftsStatus;
	}

	public void setGiftsStatus(Integer giftsStatus) {
		this.giftsStatus = giftsStatus;
	}

	public String getGiftsHold() {
		return giftsHold;
	}

	public void setGiftsHold(String giftsHold) {
		this.giftsHold = giftsHold;
	}

	public String getGiftsRemark() {
		return giftsRemark;
	}

	public void setGiftsRemark(String giftsRemark) {
		this.giftsRemark = giftsRemark;
	}

	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		 GiftsInfo giftsInfo = new GiftsInfo();
		 giftsInfo.setGiftsId(rs.getInt("gifts_id"));
		 giftsInfo.setGiftsType(rs.getString("gifts_type"));
		 giftsInfo.setGiftsName(rs.getString("gifts_name"));
		 giftsInfo.setGiftsTotal(rs.getInt("gifts_total"));
		 giftsInfo.setGiftsCalls(rs.getInt("gifts_calls"));
		 giftsInfo.setGiftsRemain(rs.getInt("gifts_remain"));
		 giftsInfo.setGiftsIntegral(rs.getInt("gifts_integral"));
		 giftsInfo.setWzjOrgId(rs.getInt("wzj_org_id"));
		 giftsInfo.setGiftsStartTime(rs.getDate("gifts_starttime"));
		 giftsInfo.setGiftsEndTime(rs.getDate("gifts_endtime"));
		 giftsInfo.setGiftsStatus(rs.getInt("gifts_status"));
		 giftsInfo.setGiftsHold(rs.getString("gifts_hold"));
		 giftsInfo.setGiftsRemark(rs.getString("gifts_remark"));
		 giftsInfo.setWzjOrgName(rs.getString("wzj_org_name")); 
		return giftsInfo;
	}

}
