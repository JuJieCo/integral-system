package com.jujie.integral.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.integral.IntegraCusDetails;
import com.jujie.integral.IntegraCusMain;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
 
public class InteCusDetDaoImpl extends BaseJdbcDao {
	public void addIntegraCusDetails(final List<IntegraCusDetails> list) throws Exception {
		StringBuffer sd = new StringBuffer("insert into integra_customer_details(");
		sd.append("cust_main_id,cust_details_integral_date,rules_id,cust_money,");
		sd.append("cust_details_integral,cust_details_status,cust_details_createtime,");
		sd.append("cust_details_remark,cust_details_hold1,cust_details_hold2)");
		sd.append(" values(?,?,?,?,?,?,?,?,?,?)");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
			        IntegraCusDetails integraCusDetails = list.get(i);
			        int n = 0;
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getIntegraCusMain().getCust_main_id()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(integraCusDetails.getCust_details_integral_date()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getRules_id()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_money()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_details_integral()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_details_status()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(integraCusDetails.getCust_details_createtime())); 
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_remark()));
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_hold1()));
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_hold2())); 
			}
			@Override
			public int getBatchSize() {
				
				return list.size();
			}
		});
	}
	 
	public Integer addIntegraCusDetails(IntegraCusDetails integraCusDetails) throws Exception {
		final StringBuffer sql = new StringBuffer("insert into integra_customer_details(");
		sql.append("cust_main_id,cust_details_integral_date,rules_id,cust_money,");
		sql.append("cust_details_integral,cust_details_status,cust_details_createtime, ");
		sql.append("cust_details_remark,cust_details_hold1,cust_details_hold2");
		sql.append(" values(?,?,?,?,?,?,?,?,?,?)");
		 final Object[] objs = {integraCusDetails.getIntegraCusMain().getCust_main_id(),integraCusDetails.getCust_details_integral_date(),integraCusDetails.getRules_id(),integraCusDetails.getCust_money(),
				integraCusDetails.getCust_details_integral(),integraCusDetails.getCust_details_status(),integraCusDetails.getCust_details_createtime(),
				integraCusDetails.getCust_details_remark(),integraCusDetails.getCust_details_hold1(),integraCusDetails.getCust_details_hold2()};
	 	
        KeyHolder keyHolder = new GeneratedKeyHolder();   
		
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);  
					
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setTimestamp(++i, DateUtils.getTimestamp(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++])); 
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));    
				  
					    ps.setInt(++n, DataUtils.getInt(objs[n++]));
						ps.setTimestamp(++n, DateUtils.getTimestamp(objs[n++]));
						ps.setInt(++n, DataUtils.getInt(objs[n++]));
						ps.setInt(++n, DataUtils.getInt(objs[n++]));
						ps.setInt(++n, DataUtils.getInt(objs[n++]));
						ps.setInt(++n, DataUtils.getInt(objs[n++]));
						ps.setTimestamp(++n, DateUtils.getTimestamp(objs[n++])); 
						ps.setString(++n, DataUtils.getStringK(objs[n++]));
						ps.setString(++n, DataUtils.getStringK(objs[n++]));
						ps.setString(++n, DataUtils.getStringK(objs[n++])); 
					
					return ps;                   
				}

				          
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		 return keyHolder.getKey().intValue();
	 	}
	
	public void updateIntegraCusDetails(final List<IntegraCusDetails> list) throws Exception {
		StringBuffer sd = new StringBuffer("update integra_customer_details set ");
		sd.append("cust_id=?,cust_details_integral_date=?,rules_id=?,cust_money=?,");
		sd.append("cust_details_integral=?,cust_details_status=?,cust_details_createtime=?, ");
		sd.append("cust_details_remark=?,cust_details_hold1=?,cust_details_hold2=? ");
		sd.append(" where cust_details_id=? ");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				IntegraCusDetails integraCusDetails = list.get(i);
			    int n = 0;
			    ps.setInt(++n, DataUtils.getInt(integraCusDetails.getIntegraCusMain().getCust_main_id()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(integraCusDetails.getCust_details_integral_date()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getRules_id()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_money()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_details_integral()));
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_details_status()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(integraCusDetails.getCust_details_createtime())); 
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_remark()));
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_hold1()));
				ps.setString(++n, DataUtils.getStringK(integraCusDetails.getCust_details_hold2())); 
				ps.setInt(++n, DataUtils.getInt(integraCusDetails.getCust_details_id()));
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		 	 
		});
	}
	
	@SuppressWarnings("unchecked")
	public  IntegraCusDetails findIntegraCusDetailsByID(Integer cust_details_id) throws Exception {
		String sql = "select * from integra_customer_details where  cust_details_id=?";
		List<IntegraCusDetails> list = this.getJdbcTemplate().query(sql,new Object[]{cust_details_id}, new IntegraCusDetails());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	 @SuppressWarnings("static-access")
	public List<IntegraCusDetails> findAllIntegraCusDetails(Object[] objs,Page page) throws Exception {
		final List<IntegraCusDetails>  integraCusDetailsList=new ArrayList<IntegraCusDetails>();
		List<Object> obj = new ArrayList<Object>();
		String sql = "select * from integra_customer_details where 1=1 ";
		if(objs!=null&&objs.length>0){
			if(objs[0]!=null&&!"".equals(DataUtils.getStringK(objs[0]))){
				sql += " and cust_id =?";
				obj.add(objs[0]);
			}
		}
		sql += " order by cust_details_createtime desc ";
		
		this.getJdbcTemplate().query(PageUtils.fyPage(sql, obj.toArray(), page, this.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL), obj.toArray(),new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				IntegraCusDetails integraCusDetails = new IntegraCusDetails();
				integraCusDetails.setCust_details_id(rs.getInt("cust_details_id"));
				IntegraCusMain integraCusMain= new IntegraCusMain();
				integraCusMain.setCust_main_id(rs.getInt("cust_main_id"));
				integraCusMain.getIntegralCustomer().setCustName(rs.getString("dataCustName"));
				integraCusMain.getIntegralCustomer().setCustCode(rs.getString("dataCustCode"));
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
				integraCusDetailsList.add(integraCusDetails);
			}
		 });
		return integraCusDetailsList;
	}
	 public List<IntegraCusDetails> queryIntegraCusDetails(Integer cusMainId) throws Exception {
			final List<IntegraCusDetails>  integraCusDetailsList=new ArrayList<IntegraCusDetails>();
		 	String sql = "select details.cust_details_integral_date,details.cust_details_integral,rules.rules_name rulesName from integra_customer_details details,integral_rules_info rules where details.rules_id=rules.rules_id and details.cust_main_id ="+cusMainId;
			sql += " order by cust_details_integral_date desc ";
		 	this.getJdbcTemplate().query(sql,new RowCallbackHandler(){

				@Override
				public void processRow(ResultSet rs) throws SQLException {
					IntegraCusDetails integraCusDetails = new IntegraCusDetails();
				    integraCusDetails.setCust_details_integral_date(rs.getDate("cust_details_integral_date"));
//				 	integraCusDetails.setCust_money(rs.getBigDecimal("cust_money"));
					integraCusDetails.setCust_details_integral(rs.getInt("cust_details_integral"));
//					integraCusDetails.setCust_details_status(rs.getInt("cust_details_status"));
//					integraCusDetails.setCust_details_createtime(rs.getDate("cust_details_createtime"));
//					integraCusDetails.setCust_details_remark(rs.getString("cust_details_remark"));
					integraCusDetails.setCust_details_hold1(rs.getString("rulesName"));
//					integraCusDetails.setCust_details_hold2(rs.getString("cust_details_hold2"));
					integraCusDetailsList.add(integraCusDetails);
				}
			 });
			return integraCusDetailsList;
		}
	public void deleteIntegraCusDetails(Integer cust_details_id) throws Exception {
		this.getJdbcTemplate().update("delete from integra_customer_details where cust_details_id="+cust_details_id);
	}
	public void deleteCusDetailsByYm(Integer cust_main_id,String ym) throws Exception {
		this.getJdbcTemplate().update("delete from integra_customer_details where cust_main_id="+cust_main_id+" and cust_details_integral_date='"+ym+"'");
	}
	public  Integer sumIntegraByCustmainId(Integer cust_main_id) throws Exception {
		String sql = "select sum(cust_details_integral) sumIntegral from integra_customer_details " +
				"where cust_main_id="+cust_main_id+" and cust_details_integral_date in(select max(cust_details_integral_date) from integra_customer_details where cust_main_id="+cust_main_id+")";
		
		return this.getJdbcTemplate().queryForInt(sql);
		 
	}
	
}
