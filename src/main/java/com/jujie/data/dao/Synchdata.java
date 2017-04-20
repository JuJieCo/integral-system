/*package com.jujie.data.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Synchdata {
private DatabaseAccessFactory daf = new DatabaseAccessFactory();
	*//**
	 * 更新第三方存管日均余额
	 *//*
	public void updataTabel() {	
		String sql = "update  integral_data_details set integral_data_details.data_three_store=Round(CK_total/day_total,2)"
				+ " from dbo.depo_date,dbo.integral_data_details"
				+ "where integral_data_details.data_cust_code=depo_date.ID_CARD and dbo.depo_date.imp_time='"
				+ this.getCurrTime() + "'";
		try {
			daf.getDataAccessInstance().executeSQL(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*//**
	 * 
	 *//*
	public void updataTabel1() {
		String sql = "update  integral_data_details set integral_data_details.data_first_pay=Round(GD_total/day_total,2)"
				+ " from dbo.loan_date,dbo.integral_data_details"
				+ "where integral_data_details.data_cust_code=loan_date.ID_CARD and dbo.loan_date.imp_time='"
				+this.getCurrTime()+ "'";
		try {
			daf.getDataAccessInstance().executeSQL(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	*//**
	 * 获取当前月份
	 * 
	 * @return
	 *//*
	public String getCurrTime() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM");
		String curr_month = df.format(d);
		return curr_month;
	}

}
*/