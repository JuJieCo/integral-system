package com.jujie.integral;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import com.jujie.global.BaseBean;

public class IntegraCusDetails extends BaseBean {
	private Integer cust_details_id;//客户积分明细编号
 	private IntegraCusMain integraCusMain;//客户积分主表编号
	private Date cust_details_integral_date;//客户积分产生时间
	private Integer rules_id;//积分规则编号
	private BigDecimal cust_money;//本次资金数量
	private Integer cust_details_integral;//本次产生积分
	private Integer cust_details_status;//状态
	private Date cust_details_createtime;//明细产生时间
    private String cust_details_remark;//备注
	private String cust_details_hold1;//预留字段1
	private String cust_details_hold2;//预留字段2
	
	
	public IntegraCusDetails(){
		integraCusMain = new IntegraCusMain();
 	
	}
	public Integer getCust_details_id() {
		return cust_details_id;
	}


	public void setCust_details_id(Integer cust_details_id) {
		this.cust_details_id = cust_details_id;
	}
 
	public IntegraCusMain getIntegraCusMain() {
		return integraCusMain;
	}
	public void setIntegraCusMain(IntegraCusMain integraCusMain) {
		this.integraCusMain = integraCusMain;
	}
	public Date getCust_details_integral_date() {
		return cust_details_integral_date;
	}


	public void setCust_details_integral_date(Date cust_details_integral_date) {
		this.cust_details_integral_date = cust_details_integral_date;
	}


	public Integer getRules_id() {
		return rules_id;
	}


	public void setRules_id(Integer rules_id) {
		this.rules_id = rules_id;
	}


	public BigDecimal getCust_money() {
		return cust_money;
	}


	public void setCust_money(BigDecimal cust_money) {
		this.cust_money = cust_money;
	}


	public Integer getCust_details_integral() {
		return cust_details_integral;
	}


	public void setCust_details_integral(Integer cust_details_integral) {
		this.cust_details_integral = cust_details_integral;
	}


	public Integer getCust_details_status() {
		return cust_details_status;
	}


	public void setCust_details_status(Integer cust_details_status) {
		this.cust_details_status = cust_details_status;
	}


	public Date getCust_details_createtime() {
		return cust_details_createtime;
	}


	public void setCust_details_createtime(Date cust_details_createtime) {
		this.cust_details_createtime = cust_details_createtime;
	}


	public String getCust_details_remark() {
		return cust_details_remark;
	}


	public void setCust_details_remark(String cust_details_remark) {
		this.cust_details_remark = cust_details_remark;
	}


	public String getCust_details_hold1() {
		return cust_details_hold1;
	}


	public void setCust_details_hold1(String cust_details_hold1) {
		this.cust_details_hold1 = cust_details_hold1;
	}


	public String getCust_details_hold2() {
		return cust_details_hold2;
	}


	public void setCust_details_hold2(String cust_details_hold2) {
		this.cust_details_hold2 = cust_details_hold2;
	}


	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		IntegraCusDetails integraCusDetails = new IntegraCusDetails();
		integraCusDetails.setCust_details_id(rs.getInt("cust_details_id"));
		IntegraCusMain integraCusMain= new IntegraCusMain();
		integraCusMain.setCust_main_id(rs.getInt("cust_main_id"));
		integraCusDetails.setIntegraCusMain(integraCusMain);
	    integraCusDetails.setCust_details_integral_date(rs.getDate("cust_details_integral_date"));
		integraCusDetails.setRules_id(rs.getInt("rules_id"));
		integraCusDetails.setCust_money(rs.getBigDecimal("cust_money"));
		integraCusDetails.setCust_details_integral(rs.getInt("cust_details_integral"));
		integraCusDetails.setCust_details_status(rs.getInt("cust_details_status"));
		integraCusDetails.setCust_details_createtime(rs.getDate("cust_details_createtime"));
		integraCusDetails.setCust_details_remark(rs.getString("cust_details_remark"));
		integraCusDetails.setCust_details_hold1(rs.getString("cust_details_hold1"));
		integraCusDetails.setCust_details_hold2(rs.getString("cust_details_hold2"));
		return integraCusDetails;
	}
	
	
}
