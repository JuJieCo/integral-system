package com.jujie.rules;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jujie.global.BaseBean;

public class Rules extends BaseBean {

	private Integer rulesId;
	private String rulesName;
	private BigDecimal rulesCpFunds;
	private String rulesStandard;
	private BigDecimal rulesCpCost;
	private String rulesMoneyUnits;
	private BigDecimal rulesCoefficient;
	private Integer rulesStatus;
	private Date rulesCreateTime;
	private String rulesHold;
	private String rulesRemark;

	 
	

	public Integer getRulesId() {
		return rulesId;
	}


	public void setRulesId(Integer rulesId) {
		this.rulesId = rulesId;
	}


	public String getRulesName() {
		return rulesName;
	}


	public void setRulesName(String rulesName) {
		this.rulesName = rulesName;
	}


	public BigDecimal getRulesCpFunds() {
		return rulesCpFunds;
	}


	public void setRulesCpFunds(BigDecimal rulesCpFunds) {
		this.rulesCpFunds = rulesCpFunds;
	}


	public String getRulesStandard() {
		return rulesStandard;
	}


	public void setRulesStandard(String rulesStandard) {
		this.rulesStandard = rulesStandard;
	}


	public BigDecimal getRulesCpCost() {
		return rulesCpCost;
	}


	public void setRulesCpCost(BigDecimal rulesCpCost) {
		this.rulesCpCost = rulesCpCost;
	}


	public String getRulesMoneyUnits() {
		return rulesMoneyUnits;
	}


	public void setRulesMoneyUnits(String rulesMoneyUnits) {
		this.rulesMoneyUnits = rulesMoneyUnits;
	}


	public BigDecimal getRulesCoefficient() {
		return rulesCoefficient;
	}


	public void setRulesCoefficient(BigDecimal rulesCoefficient) {
		this.rulesCoefficient = rulesCoefficient;
	}


	public Integer getRulesStatus() {
		return rulesStatus;
	}


	public void setRulesStatus(Integer rulesStatus) {
		this.rulesStatus = rulesStatus;
	}


	public Date getRulesCreateTime() {
		return rulesCreateTime;
	}


	public void setRulesCreateTime(Date rulesCreateTime) {
		this.rulesCreateTime = rulesCreateTime;
	}


	public String getRulesHold() {
		return rulesHold;
	}


	public void setRulesHold(String rulesHold) {
		this.rulesHold = rulesHold;
	}


	public String getRulesRemark() {
		return rulesRemark;
	}


	public void setRulesRemark(String rulesRemark) {
		this.rulesRemark = rulesRemark;
	}


	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
          
		 Rules rules =new Rules();	
		 
		 rules.setRulesId(rs.getInt("Rules_id"));
		 rules.setRulesName(rs.getString("Rules_name"));
		 rules.setRulesCpFunds(rs.getBigDecimal("rules_cp_funds"));
		 rules.setRulesStandard(rs.getString("rules_standard"));
		 rules.setRulesCpCost(rs.getBigDecimal("rules_cp_cost"));
		 rules.setRulesMoneyUnits(rs.getString("rules_money_units"));
		 rules.setRulesCoefficient(rs.getBigDecimal("rules_coefficient"));
		 rules.setRulesStatus(rs.getInt("rules_status"));
		 rules.setRulesCreateTime(rs.getDate("rules_create_time"));
		 rules.setRulesHold(rs.getString("rules_hold"));
		 rules.setRulesRemark(rs.getString("rules_remark"));
		 
 
		return rules;

	}

}
