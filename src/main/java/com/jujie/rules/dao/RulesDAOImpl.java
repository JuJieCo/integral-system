package com.jujie.rules.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.rules.Rules;
import com.jujie.util.BigdecimalChang;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;




public class RulesDAOImpl extends JdbcDaoSupport{
	@SuppressWarnings("unchecked")
	public List<Rules> queryRulesList(Object[] objs) throws Exception{
		
		List<Object> obj = new ArrayList<Object>();
		
		
			String where = " where 1=1 ";
			if(objs!=null && objs.length>0){
				if(objs.length>=1 && objs[0]!=null&&!"".equals(objs[0])){
					where += " and w.rules_name like '%'+?+'%' ";
					obj.add(objs[0]);
				}
			
			if(objs.length>=2 && objs[1]!=null&&!"".equals(objs[1])){
				if(((Integer) objs[1]) != 0){
					where += " and w.rules_status = ? ";
					obj.add(objs[1]);
				}
			}
	      }
			String sql = "select w.rules_id,w.rules_name,w.rules_cp_funds,w.rules_standard,w.rules_cp_cost,"+
			"w.rules_money_units, w.rules_coefficient ,w.rules_status, w.rules_create_time,w.rules_hold,w.rules_remark "+
			"from integral_rules_info w "+where+ " order by w.Rules_id desc";
			
			
			return this.getJdbcTemplate().query(sql, obj.toArray(), new Rules());		
			}
	public Rules queryRulesByID( Integer rulesId)throws Exception{
		final Rules rules = new  Rules();
		
		String sql = "select  w.Rules_id,w.rules_name,w.rules_cp_funds,w.rules_standard,w.rules_cp_cost,"+
		"w.rules_money_units, w.rules_coefficient ,w.rules_status, w.rules_create_time,w.rules_hold,w.rules_remark "+
		"from integral_rules_info w where  w.Rules_id="+rulesId;
		
		
	this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
		 public void processRow(ResultSet rs) throws SQLException{
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
			 
	 
	
	}});
	    return rules;
		
	}
	public Integer addRulesByID(Rules rules)throws Exception {
		
		final String sql = "insert into integral_rules_info(rules_name,rules_cp_funds,rules_standard,rules_cp_cost,"+
		"rules_money_units,rules_coefficient ,rules_status,rules_create_time,rules_hold,rules_remark)"+
		 "values(?,?,?,?,?,?,?,?,?,?)";
		
		final Object[] objs = {rules.getRulesName().trim(),rules.getRulesCpFunds(),rules.getRulesStandard(), rules.getRulesCpCost(),
				               rules.getRulesMoneyUnits(),rules.getRulesCoefficient(),rules.getRulesStatus(),rules.getRulesCreateTime(),
				               rules.getRulesHold(),rules.getRulesRemark()};
	 	
		KeyHolder keyHolder = new GeneratedKeyHolder(); 
		
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);  
					
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setBigDecimal(++i, BigdecimalChang.returnBigdecimal(DataUtils.getStringK(objs[n++])));
					ps.setString(++i,    DataUtils.getStringK(objs[n++])); 
					ps.setBigDecimal(++i, BigdecimalChang.returnBigdecimal(DataUtils.getStringK(objs[n++])));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setBigDecimal(++i, BigdecimalChang.returnBigdecimal(5,DataUtils.getStringK(objs[n++])));
					ps.setInt(++i,    DataUtils.getInt(objs[n++])); 
					ps.setTimestamp(++i, DateUtils.getTimestamp(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
				 
					return ps;                   
				}

				          
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		 return keyHolder.getKey().intValue();
		   
	}
	
	public void updateRulesByID(Rules rules)throws Exception  {
		

	final String sql = "update integral_rules_info set rules_name=?,rules_cp_funds=?,rules_standard=?,rules_cp_cost=?,"+
	"rules_money_units=?,rules_coefficient=? ,rules_status=?,rules_create_time=?,"+
	 "rules_remark=? where rules_id=?";
	
	final Object[] obj = {rules.getRulesName(),rules.getRulesCpFunds(),rules.getRulesStandard(), rules.getRulesCpCost(),
			               rules.getRulesMoneyUnits(),BigdecimalChang.returnBigdecimal(5,rules.getRulesCoefficient().doubleValue()+""),rules.getRulesStatus(),rules.getRulesCreateTime(),
			               rules.getRulesRemark(),rules.getRulesId()};
	
		this.getJdbcTemplate().update(sql,obj);
	}
	public void deleteRulesByID(Integer rulesId)throws Exception {
		String sql = "delete from  integral_rules_info where rules_id="+rulesId;
		this.getJdbcTemplate().update(sql);
	}

  
		
			
		




}
	


