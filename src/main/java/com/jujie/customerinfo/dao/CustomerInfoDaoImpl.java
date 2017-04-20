package com.jujie.customerinfo.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.agence.Agence;
import com.jujie.customerinfo.CustomerInfo;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.user.User;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
import com.jujie.wzj.Wzj;
@SuppressWarnings({ "unchecked", "unused" ,"static-access"})


public class CustomerInfoDaoImpl  extends BaseJdbcDao{
	
	
	public List<CustomerInfo> queryCustomerInfoList(Object[] objs , String userId,String agenceIds,Page page)throws Exception{
		final List<Object> obj = new ArrayList<Object>();
		String where = " where 1=1";
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and e.cust_name like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				if (((Integer) objs[1]) != 0) {
					where += " and e.cust_status =? ";
					obj.add(objs[1]);
				}
			}
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				if (((Integer) objs[2]) != 0) {
					where += " and e.cust_level =? ";
					obj.add(objs[2]);
				}
			}
		}
		final StringBuffer sb = new StringBuffer("select * from (select c.*,a.agence_name,s.sys_user_name,s.sys_user_level,s.sys_user_id");
		sb.append(" from integral_customer_info c left join sys_user s on c.cust_cp_manager=s.sys_user_id ");
		sb.append("left join integral_agence_info a on c.agence_id=a.agence_id) e ");
		sb.append(where);
		if(userId!=null){
			sb.append(" and e.sys_user_id= "+userId);
		}else if(agenceIds!=null){
			sb.append(" and e.agence_id in("+agenceIds+") ");
		}
		sb.append(" order by e.cust_id desc ");
	
		return this.getJdbcTemplate().query(PageUtils.fyPage(sb.toString() , obj.toArray(),page,this.getJdbcTemplate(),page.DATABASE_TYPE_MSSQL),obj.toArray(),new CustomerInfo());
	}
	
	
	
	
	
	
	public List<CustomerInfo> multipleQueryCustomerInfoList(Object[] objs , String userId,String agenceIds,Page page)throws Exception{
		final List<Object> obj = new ArrayList<Object>();
		String where = " where 1=1";
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and e.cust_name like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				where += " and e.cust_code =? ";
					obj.add(objs[1]);
			}
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				where += " and e.cust_mobile =? ";
					obj.add(objs[2]);
			}
			
			if (objs.length >= 4 && objs[3] != null && !"".equals(objs[3])) {
				if (((Integer) objs[3]) != 0) {
					where += " and e.cust_status =? ";
					obj.add(objs[3]);
				}
			}
			if (objs.length >= 5 && objs[4] != null && !"".equals(objs[4])) {
				if (((Integer) objs[4]) != 0) {
					where += " and e.cust_level =? ";
					obj.add(objs[4]);
				}
			}
			if (objs.length >= 6 && objs[5] != null && !"".equals(objs[5])) {
				if (((Integer) objs[5]) != 0) {
					where += " and e.cust_cp_agence =? ";
					obj.add(objs[5]);
				}
			}
			if (objs.length >= 7 && objs[6] != null && !"".equals(objs[6])) {
				if (((Integer) objs[6]) != 0) {
					where += " and e.cust_cp_manager =? ";
					obj.add(objs[6]);
				}
			}
			if (objs.length >= 8 && objs[7] != null && !"".equals(objs[7])) {
				
				where += " and cust_regist_time >= ?";
				obj.add(objs[7]);
			}
			if (objs.length >= 9 && objs[8] != null && !"".equals(objs[8])) {
				
				where += " and cust_regist_time <= ?";
				obj.add(objs[8]);
			}
			if (objs.length >= 10 && objs[9] != null && !"".equals(objs[9])) {
				
				where += " and e.sys_user_id= ?";
				obj.add(objs[9]);
			}
			if (objs.length >= 11 && objs[10] != null && !"".equals(objs[10])) {
				
				where += " and e.agence_id in ( "+objs[10]+" )";
			}
			
		
		}
		final StringBuffer sb = new StringBuffer("select * from (select c.*,a.agence_name,s.sys_user_name,s.sys_user_level,s.sys_user_id");
		sb.append(" from integral_customer_info c left join sys_user s on c.cust_cp_manager=s.sys_user_id ");
		sb.append("left join integral_agence_info a on c.agence_id=a.agence_id) e ");
		sb.append(where);
		if(userId!=null){
			sb.append(" and e.sys_user_id= "+userId);
		}else if(agenceIds!=null){
			sb.append(" and e.agence_id in("+agenceIds+") ");
		}
		sb.append(" order by e.cust_id desc ");
		
		return this.getJdbcTemplate().query(PageUtils.fyPage(sb.toString(), obj.toArray(),page,this.getJdbcTemplate(),page.DATABASE_TYPE_MSSQL),obj.toArray(),new CustomerInfo());
		
	
	}
	
	
	
	
	
	public CustomerInfo showAdd(String userId)throws Exception{
		final  String sql = "select s.sys_user_name , a.agence_name  , a.agence_id from   " +
				"sys_user s , integral_agence_info a where a.agence_id=s.sys_user_agence "+
				" and s.sys_user_id=  "+userId;
		final CustomerInfo customerInfo = new CustomerInfo();
		 this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 customerInfo.setAgenceName(rs.getString("agence_name")); 
				 customerInfo.setSysUserName(rs.getString("sys_user_name")); 
				 customerInfo.setAgenceId(rs.getInt("agence_id"));
				 customerInfo.setCustCpAgence(rs.getInt("agence_id"));
			 }
		 });
		 return customerInfo;
	}
	
	
	
	
	
	public CustomerInfo queryCustomerInfoByID(Integer  custId) throws Exception{
		
		final CustomerInfo customerInfo = new CustomerInfo();
		String where = " where 1=1";
		final String sql = "select * from (select c.*,a.agence_name,s.sys_user_name,s.sys_user_level,s.sys_user_id "+
		" from integral_customer_info c left join sys_user s on s.sys_user_id=c.cust_cp_manager "+
		" left join integral_agence_info a on a.agence_id=c.agence_id)e " +
		" where e.cust_id ="+custId; 
		List<CustomerInfo> list = this.getJdbcTemplate().query(sql, new CustomerInfo());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	
	public List<Agence> queryAllAgence() throws Exception{
		final List<Agence> agenceList = new ArrayList<Agence>();
		String sql =  "select agence_id , agence_name from integral_agence_info ";
		 this.getJdbcTemplate().query(sql,new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 Agence agence = new Agence();
				 agence.setAgenceId(rs.getInt("agence_id"));
				 agence.setAgenceName(rs.getString("agence_name"));
				 agenceList.add(agence);
			 }
		 }); 

		return agenceList;
	}
	
	public List<User> queryAllCustCpManager() throws Exception{
		final List<User> userList = new ArrayList<User>();
		String  sql = "select sys_user_id , sys_user_name from sys_user where sys_user_isManger = 1";
		 this.getJdbcTemplate().query(sql,new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 User user = new User();
				 user.setSysUserId(rs.getInt("sys_user_id"));
				 user.setSysUserName(rs.getString("sys_user_name"));
				 userList.add(user);
			 }
		 }); 
		return userList;
	}
	

	
	
//	public Integer getCustManagerByName(String sysUserName)throws Exception{
//
//	    String sql = "select sys_user_id from sys_user where sys_user_name='"+sysUserName+"'";
//	    final User user = new User();
//		 this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
//			 public void processRow(ResultSet rs) throws SQLException{
//				
//				 user.setSysUserId(rs.getInt("sys_user_id"));
//			 }
//		 });	
//		return user.getSysUserId();
//	}
	
	
	public Integer addCustomerInfo(CustomerInfo customerInfo) throws Exception {
		final String sql = "insert into integral_customer_info (cust_name,cust_code,cust_birthday,"
			+ "cust_address,cust_areacode,cust_homephone,cust_offerphone,"
			+ "cust_mobile,cust_email,cust_zipcode,cust_level,cust_status,cust_regist_time,"
			+" cust_cp_agence,cust_cp_manager,agence_id,cust_hold,cust_remark) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		final Object[] objs = { customerInfo.getCustName(), customerInfo.getCustCode(),
				customerInfo.getCustBirthday(), customerInfo.getCustAddress(),
				customerInfo.getCustAreaCode(), customerInfo.getCustHomePhone(),
				customerInfo.getCustOfferPhone(), customerInfo.getCustMobile(),
				customerInfo.getCustEmail(), customerInfo.getCustZipCode(),
				customerInfo.getCustLevel(), customerInfo.getCustStatus(),
				customerInfo.getCustRegistTime(), customerInfo.getCustCpAgence(),
				customerInfo.getCustCpManager(), customerInfo.getAgenceId(),
				customerInfo.getCustHold(), customerInfo.getCustRemark()};
				KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator(){
				public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setDate(++i,   DateUtils.getSqlDate(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setInt(++i, 	  DataUtils.getInt(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));
					ps.setDate(++i,   DateUtils.getSqlDate(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					return ps;
				}
			}, keyHolder);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
		}
	
	
	
	
	
	public void updateCustomerInfo(CustomerInfo customerInfo ,String right) throws Exception {
		if("1".equals(right)&&right!=null){
			final String sql = "update integral_customer_info set agence_id=?,cust_cp_manager=?,cust_birthday=?,"
					+ "cust_address=?,cust_areacode=?,cust_homephone=?,cust_offerphone=?,"
					+ "cust_mobile=?,cust_email=?,cust_zipcode=?,cust_level=?,"
					+" cust_remark=? where cust_id=?";
			final Object[] objs = { 
					customerInfo.getAgenceId(),
					customerInfo.getCustCpManager(),
					customerInfo.getCustBirthday(),
					customerInfo.getCustAddress(),
					customerInfo.getCustAreaCode(),
					customerInfo.getCustHomePhone(),
					customerInfo.getCustOfferPhone(),
					customerInfo.getCustMobile(),
					customerInfo.getCustEmail(),
					customerInfo.getCustZipCode(),
					customerInfo.getCustLevel(),
					customerInfo.getCustRemark(),
					customerInfo.getCustId()};
					this.getJdbcTemplate().update(sql, objs);
		}else{
			final String sql = "update integral_customer_info set cust_birthday=?,"
			+ "cust_address=?,cust_areacode=?,cust_homephone=?,cust_offerphone=?,"
			+ "cust_mobile=?,cust_email=?,cust_zipcode=?,cust_level=?,"
			+" cust_remark=? where cust_id=?";
			final Object[] objs = { 
					customerInfo.getCustBirthday(),
					customerInfo.getCustAddress(),
					customerInfo.getCustAreaCode(),
					customerInfo.getCustHomePhone(),
					customerInfo.getCustOfferPhone(),
					customerInfo.getCustMobile(),
					customerInfo.getCustEmail(),
					customerInfo.getCustZipCode(),
					customerInfo.getCustLevel(),
					customerInfo.getCustRemark(),
					customerInfo.getCustId()};
					this.getJdbcTemplate().update(sql, objs);
			}
	}
	
	
	  
	 public CustomerInfo queryCustomerInfo(String custName,String custCode) throws Exception{		
			final CustomerInfo customerInfo = new CustomerInfo();
		 	final String sql = "select * from integral_customer_info where cust_name='"+custName+"' and cust_code='"+custCode+"'"; 	  
		 	this.getJdbcTemplate().query(sql,new RowCallbackHandler(){
				public void processRow(ResultSet rs) throws SQLException {	
					customerInfo.setCustId(rs.getInt("cust_id"));
					customerInfo.setCustName(rs.getString("cust_name"));
					customerInfo.setCustCode(rs.getString("cust_code"));
				    
				}
			 });
		 	
			 
			return customerInfo;
			
		}
	public void changeCustomerInfoStatus(String custStatus, String custId) throws Exception {
		final String sql = "update integral_customer_info set  cust_status=? where cust_id=?";
		final Object[] objs = {custStatus,custId};
		this.getJdbcTemplate().update(sql, objs);
	}
	
	
	
	public List<CustomerInfo> queryBirthdayReminder(String userId,String agenceIds)throws Exception{
		Calendar calendar = Calendar.getInstance();
		String todayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		String nextMonth =  String.valueOf(calendar.get(Calendar.MONTH) + 2);
		String day = String.valueOf(calendar.get(Calendar.DATE));
		if(todayMonth.length()==1){
			todayMonth= "0"+todayMonth;
		}
		if(nextMonth.length()==1){
			nextMonth= "0"+nextMonth;
		}
		if(day.length()==1){
			day= "0"+day;
		}
		String today = todayMonth+day;
		String dayOfNextMonth = nextMonth+day;
		final List<CustomerInfo> customerInfoList =  new ArrayList<CustomerInfo>();
		String where = " where 1=1";
		final StringBuffer sb = new StringBuffer("select * from "+ 
				"(select c.cust_id, c.cust_name,c.cust_code," +
				" right(convert(char(8),c.cust_birthday,112),4) as cust_birthday, " +
				" c.cust_address,c.cust_areacode,c.cust_homephone,c.cust_offerphone,c.cust_mobile," +
				" c.cust_email,c.cust_zipcode,c.cust_level,c.cust_status,c.cust_regist_time,c.cust_cp_agence," +
				" c.cust_cp_manager,c.agence_id,c.cust_hold,c.cust_remark,"+				
				"a.agence_name,s.sys_user_name,s.sys_user_level,s.sys_user_id");
		sb.append(" from integral_customer_info c left join sys_user s on c.cust_cp_manager=s.sys_user_id ");
		sb.append("left join integral_agence_info a on c.agence_id=a.agence_id) e ");
		sb.append(where);
		sb.append(" and cust_birthday>='"+today+"' ");
		sb.append(" and cust_birthday<='"+dayOfNextMonth+"' ");
		if(userId!=null){
			sb.append(" and e.sys_user_id= "+userId);
		}else if(agenceIds!=null){
			sb.append(" and e.agence_id in("+agenceIds+") ");
		}
		sb.append(" order by cust_birthday  ");
		this.getJdbcTemplate().query(sb.toString(),new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 CustomerInfo customerInfo = new CustomerInfo();
				 customerInfo.setCustName(rs.getString("cust_name"));
				 customerInfo.setCustCode(rs.getString("cust_code"));
				 customerInfo.setCustRemark(rs.getString("cust_birthday"));
				 customerInfo.setCustHomePhone(rs.getString("cust_homephone"));
				 customerInfo.setCustOfferPhone(rs.getString("cust_offerphone"));
				 customerInfo.setCustMobile(rs.getString("cust_mobile"));
				 customerInfo.setCustLevel(rs.getInt("cust_level"));
				 customerInfo.setCustStatus(rs.getInt("cust_status"));
				 customerInfo.setCustHold(rs.getString("cust_hold"));
				 customerInfoList.add(customerInfo);
			 }
		 }); 
		return customerInfoList;
	}
}
	