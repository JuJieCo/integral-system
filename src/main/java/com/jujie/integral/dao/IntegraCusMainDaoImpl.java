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

public class IntegraCusMainDaoImpl extends BaseJdbcDao {
	
	public Integer addIntegraCusMain(IntegraCusMain integraCusMain) throws Exception {
		final StringBuffer sql = new StringBuffer("insert into integral_customer_main(");
		sql.append("cust_id,cust_main_time,cust_integral_totle,cust_integral_calls,");
		sql.append("cust_integral_remain,cust_main_status,cust_main_remark) ");
		sql.append(" values(?,?,?,?,?,?,?)");
		final Object[] objs = {integraCusMain.getIntegralCustomer().getCustId(),integraCusMain.getCust_main_time(),integraCusMain.getCust_integral_totle(),integraCusMain.getCust_integral_calls(),
				integraCusMain.getCust_integral_remain(),integraCusMain.getCust_main_status(),integraCusMain.getCust_main_remark()};
	 	
        KeyHolder keyHolder = new GeneratedKeyHolder();   
		
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql.toString(),PreparedStatement.RETURN_GENERATED_KEYS);  
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++])); 
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));    
				 	return ps;                   
				}

				          
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		 return keyHolder.getKey().intValue();
	  }
	public void addIntegraCusMain(final List<IntegraCusMain> list) throws Exception {
		StringBuffer sd = new StringBuffer("insert into IntegraCusMain(");
		sd.append("cust_id,cust_main_time,cust_integral_totle,cust_integral_calls,");
		sd.append("cust_integral_remain,cust_main_status,cust_main_remark ");
		sd.append(" values(?,?,?,?,?,?,?)");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
		        IntegraCusMain integraCusMain = list.get(i);
		        int n = 0;
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getIntegralCustomer().getCustId()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_time()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_totle()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_calls()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_remain()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_status()));
				ps.setString(++n, DataUtils.getStringK(integraCusMain.getCust_main_remark())); 
			}
			@Override
			public int getBatchSize() {
				
				return list.size();
			}
		});
	}
	public void updateIntegraCusMain(final List<IntegraCusMain> list) throws Exception {
		StringBuffer sd = new StringBuffer("update integral_customer_main set ");
		sd.append("cust_id=?,cust_main_time=?,cust_integral_totle=?,cust_integral_calls=?,");
		sd.append("cust_integral_remain=?,cust_main_status=?,cust_main_remark=? ");
		sd.append(" where cust_main_id=? ");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				IntegraCusMain integraCusMain = list.get(i);
				int n = 0;
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getIntegralCustomer().getCustId()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_time()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_totle()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_calls()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_remain()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_status()));
				ps.setString(++n, DataUtils.getStringK(integraCusMain.getCust_main_remark())); 
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_id()));
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		 	 
		});
	}
	
	public void exchangCusMain(String remain ,String cus_id)throws Exception{
		 StringBuffer sd = new StringBuffer("update integral_customer_main set ");
		 sd.append("cust_integral_remain=?");
		 sd.append(" where cust_main_id=? ");
	     Object[] objs = {cus_id,remain};
	     this.getJdbcTemplate().update(sd.toString(),objs);
	}
	
	public void updateIntegraCusMainByCusMain(final List<IntegraCusMain> list) throws Exception {
		StringBuffer sd = new StringBuffer("update integral_customer_main set ");
		 sd.append("cust_integral_remain=?,cust_main_status=?,new_integral_date=?");
		 sd.append(" where cust_main_id=? ");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				IntegraCusMain integraCusMain = list.get(i);
				int n = 0;
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_integral_remain()));
				ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_status()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(integraCusMain.getNew_integral_date()));
			 	ps.setInt(++n, DataUtils.getInt(integraCusMain.getCust_main_id()));
			}

			@Override
			public int getBatchSize() {
				return list.size();
			}
		 	 
		});
	}
	@SuppressWarnings("unchecked")
	public IntegraCusMain findIntegraCusMainByID(Integer cust_main_id) throws Exception {
		String sql = "select * from integral_customer_main where  cust_main_id=?";
		List<IntegraCusMain> list = this.getJdbcTemplate().query(sql,new Object[]{cust_main_id}, new IntegraCusMain());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public IntegraCusMain findCusMainByCustID(Integer cust_id) throws Exception {
		String sql = "select * from integral_customer_main where  cust_id=?";
		List<IntegraCusMain> list = this.getJdbcTemplate().query(sql,new Object[]{cust_id}, new IntegraCusMain());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@SuppressWarnings("static-access")
	public List<IntegraCusMain> findAllIntegraCusMain(Object[] objs,Page page) throws Exception {
		final List<IntegraCusMain>  integraCusMainList=new ArrayList<IntegraCusMain>();
		List<Object> obj = new ArrayList<Object>();
		String sql = "select customerMain.*,customerInfo.cust_name,customerInfo.cust_code,customerInfo.cust_mobile,customerInfo.cust_status,customerInfo.cust_level,agenceInfo.agence_id,agenceInfo.agence_name,agenceInfo.agence_phone,agenceInfo.agence_address,agenceInfo.agence_contact from integral_customer_main customerMain left join integral_customer_info customerInfo on customerMain.cust_id=customerInfo.cust_id left join integral_agence_info agenceInfo on customerInfo.agence_id = agenceInfo.agence_id " +
		 "where 1=1 ";
		if(objs!=null&&objs.length>0){
			if(objs[0]!=null&&!"".equals(DataUtils.getStringK(objs[0]))){
				sql += " and customerInfo.cust_name like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if(objs[1]!=null&&!"".equals(DataUtils.getStringK(objs[1]))){
				sql += " and customerInfo.cust_code like '%'+?+'%' ";
				obj.add(objs[1]);
			}
			if(objs[2]!=null&&!"".equals(DataUtils.getStringK(objs[2]))){
				sql += " and customerInfo.cust_mobile like '%'+?+'%' ";
				obj.add(objs[2]);
			}
			if(objs[3]!=null&&!"".equals(DataUtils.getStringK(objs[3]))){
				sql += " and customerInfo.cust_status=?";
				obj.add(objs[3]);
			}
			if(objs[4]!=null&&!"".equals(DataUtils.getStringK(objs[4]))){
				sql += " and customerInfo.agence_id=?";
				obj.add(objs[4]);
			}
			
		}
		sql += " order by customerMain.cust_integral_remain desc ";
		this.getJdbcTemplate().query(PageUtils.fyPage(sql, obj.toArray(), page, this.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL), obj.toArray(),new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				IntegraCusMain integraCusMain = new IntegraCusMain();
				integraCusMain.setCust_main_id(rs.getInt("cust_main_id"));
				integraCusMain.getIntegralCustomer().setCustId(rs.getInt("cust_id"));
			    integraCusMain.getIntegralCustomer().setCustName(rs.getString("cust_name"));
			    integraCusMain.getIntegralCustomer().setCustCode(rs.getString("cust_code"));
			    integraCusMain.getIntegralCustomer().setCustMobile(rs.getString("cust_mobile"));
			    integraCusMain.getIntegralCustomer().setCustLevel(rs.getInt("cust_level"));
			    integraCusMain.getIntegralCustomer().setAgenceId(rs.getInt("agence_id"));
			    integraCusMain.getIntegralCustomer().setAgenceName(rs.getString("agence_name"));
			    integraCusMain.getIntegralCustomer().setCustStatus(rs.getInt("cust_status"));
				integraCusMain.setCust_main_time(rs.getInt("cust_main_time"));
				integraCusMain.setCust_integral_totle(rs.getInt("cust_integral_totle"));
				integraCusMain.setCust_integral_calls(rs.getInt("cust_integral_calls"));
				integraCusMain.setCust_integral_remain(rs.getInt("cust_integral_remain"));
				integraCusMain.setCust_main_status(rs.getInt("cust_main_status"));
			    integraCusMain.setCust_main_remark(rs.getString("cust_main_remark"));
			    integraCusMain.setNew_integral_date(rs.getDate("new_integral_date"));
			    integraCusMainList.add(integraCusMain);
			}
		 });
		return integraCusMainList;
	}
	 
	@SuppressWarnings("unchecked")
	public List<IntegraCusDetails> getIntegraCusDetailsBycustId(int cust_id) throws Exception {
		 String sql = "select  * from integral_customer_main  where cust_details_id=?";
		 
		 return this.getJdbcTemplate().query(sql, new Object[]{cust_id},new IntegraCusDetails());
	}
	public void deleteIntegraCusMain(Integer cust_main_id) throws Exception {
		this.getJdbcTemplate().update("delete from integral_customer_main where cust_main_id="+cust_main_id);
	}
	
}
