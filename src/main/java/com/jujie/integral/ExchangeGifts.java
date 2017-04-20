package com.jujie.integral;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.jujie.global.BaseBean;

public class ExchangeGifts  extends BaseBean{
	private Integer custId;
	private String custName;
	private String custCode;
	private Integer custIntegralRemain;
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
	public Integer getCustIntegralRemain() {
		return custIntegralRemain;
	}




	public void setCustIntegralRemain(Integer custIntegralRemain) {
		this.custIntegralRemain = custIntegralRemain;
	}




	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		ExchangeGifts exchangeGifts = new ExchangeGifts();
		exchangeGifts.setCustId(rs.getInt("cust_id"));
		exchangeGifts.setCustName(rs.getString("cust_name"));
		exchangeGifts.setCustCode(rs.getString("cust_code"));
		exchangeGifts.setCustIntegralRemain(rs.getInt("cust_integral_remain"));
		return exchangeGifts;
	}

}
