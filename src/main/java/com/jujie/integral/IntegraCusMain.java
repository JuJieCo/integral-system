package com.jujie.integral;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jujie.customerinfo.CustomerInfo;
import com.jujie.global.BaseBean;

public class IntegraCusMain extends BaseBean {
	
	private Integer cust_main_id;//编号
	private CustomerInfo integralCustomer;//客户
	private List<IntegraCusDetails> integraCusDetailsList;
 	private Integer cust_main_time;//年度
	private Integer cust_integral_totle;//累计积分
	private Integer cust_integral_calls;//兑换积分
	private Integer cust_integral_remain;//积分结余
	private Integer cust_main_status;//状态0:正常 1:冻结
	private String cust_main_remark;//备注
    private Date new_integral_date;//操作作日期
    public IntegraCusMain(){
		    integralCustomer =new CustomerInfo();
        	integraCusDetailsList=new ArrayList<IntegraCusDetails>();
	}
	
	public Integer getCust_main_id() {
		return cust_main_id;
	}

	public void setCust_main_id(Integer cust_main_id) {
		this.cust_main_id = cust_main_id;
	}
 	public Integer getCust_main_time() {
		return cust_main_time;
	}

	public void setCust_main_time(Integer cust_main_time) {
		this.cust_main_time = cust_main_time;
	}

	public Date getNew_integral_date() {
		return new_integral_date;
	}

	public void setNew_integral_date(Date new_integral_date) {
		this.new_integral_date = new_integral_date;
	}

	 
	public Integer getCust_integral_totle() {
		return cust_integral_totle;
	}

	public void setCust_integral_totle(Integer cust_integral_totle) {
		this.cust_integral_totle = cust_integral_totle;
	}

	public Integer getCust_integral_calls() {
		return cust_integral_calls;
	}

	public void setCust_integral_calls(Integer cust_integral_calls) {
		this.cust_integral_calls = cust_integral_calls;
	}

	public Integer getCust_integral_remain() {
		return cust_integral_remain;
	}

	public void setCust_integral_remain(Integer cust_integral_remain) {
		this.cust_integral_remain = cust_integral_remain;
	}

	public Integer getCust_main_status() {
		return cust_main_status;
	}

	public void setCust_main_status(Integer cust_main_status) {
		this.cust_main_status = cust_main_status;
	}

	public String getCust_main_remark() {
		return cust_main_remark;
	}

	public void setCust_main_remark(String cust_main_remark) {
		this.cust_main_remark = cust_main_remark;
	}
	
	public List<IntegraCusDetails> getIntegraCusDetailsList() {
		return integraCusDetailsList;
	}

	public void setIntegraCusDetailsList(
			List<IntegraCusDetails> integraCusDetailsList) {
		this.integraCusDetailsList = integraCusDetailsList;
	}

 
	public CustomerInfo getIntegralCustomer() {
		return integralCustomer;
	}

	public void setIntegralCustomer(CustomerInfo integralCustomer) {
		this.integralCustomer = integralCustomer;
	}

	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		IntegraCusMain integraCusMain = new IntegraCusMain();
		integraCusMain.setCust_main_id(rs.getInt("cust_main_id"));
	//	CustomerInfo integralCustomer= new CustomerInfo();
		integralCustomer.setCustId(rs.getInt("cust_id"));
	    integraCusMain.setIntegralCustomer(integralCustomer);
		integraCusMain.setCust_main_time(rs.getInt("cust_main_time"));
		integraCusMain.setCust_integral_totle(rs.getInt("cust_integral_totle"));
		integraCusMain.setCust_integral_calls(rs.getInt("cust_integral_calls"));
		integraCusMain.setCust_integral_remain(rs.getInt("cust_integral_remain"));
		integraCusMain.setCust_main_status(rs.getInt("cust_main_status"));
	    integraCusMain.setCust_main_remark(rs.getString("cust_main_remark"));
	 
		return integraCusMain;
	}

	
}
