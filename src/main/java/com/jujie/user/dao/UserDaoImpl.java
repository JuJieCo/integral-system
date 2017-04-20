package com.jujie.user.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.user.User;
import com.jujie.util.DataUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;

public class UserDaoImpl extends BaseJdbcDao {
		
	@SuppressWarnings("unchecked")
	public User queryOneUser(int uuid) throws Exception{
	    String sql = "select su.*,ae.* from sys_user su left join integral_agence_info ae on su.sys_user_agence=ae.agence_id where su.sys_user_id="+uuid;
		List<User> userList = this.getJdbcTemplate().query(sql,new User());
		if(userList!=null&&userList.size()>0){
			return userList.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> queryManagerUser()  throws Exception{
	   String sql = "select su.*,ae.* from sys_user su left join integral_agence_info ae on su.sys_user_agence=ae.agence_id  where 1=1 and su.sys_user_id!=1 and su.sys_user_status=1 and su.sys_user_isManger=1 ";
		sql +=" order by su.sys_user_id desc ";
		return this.getJdbcTemplate().query(sql,new User());
	}
	
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser(Object[] cons,Page page) throws Exception{
		 String sql = "select su.*,ae.* from sys_user su left join integral_agence_info ae on su.sys_user_agence=ae.agence_id  where 1=1 and su.sys_user_id!=1 and su.sys_user_status=1 ";
		List<Object> conList = new ArrayList<Object>();
		if(cons!=null&&cons.length>0){
			if(cons.length>0&&cons[0]!=null&&DataUtils.getInt(cons[0])!=0){
				sql += "and su.sys_user_agence=? ";
				conList.add(cons[0]);
			}
			if(cons.length>1&&cons[1]!=null&&!"".equals(cons[1].toString())){
				sql += "and su.sys_user_name=? ";
				conList.add(cons[1]);
			}
		}
		sql +=" order by su.sys_user_id desc ";
		Object[] objs = conList.toArray();
		return this.getJdbcTemplate().query(PageUtils.fyPage(sql, objs, page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MSSQL),objs,new User());
	}
	@SuppressWarnings("unchecked")
	public List<User> queryAllUser(String userName) throws Exception{
	    String sql = "select su.*,ae.* from sys_user su left join integral_agence_info ae on su.sys_user_agence=ae.agence_id  where 1=1 and su.sys_user_id!=1 and su.sys_user_status=1 ";
		List<Object> conList = new ArrayList<Object>();
		if(userName!=null&&!"".equals(userName)){
		sql += "and su.sys_user_name=? ";
		  conList.add(userName);
		}
		 sql +=" order by su.sys_user_id desc ";
		Object[] objs = conList.toArray();
		return this.getJdbcTemplate().query(sql,objs,new User());
	}
	public int saveOneUser(User user) throws Exception{
		final String sql = "insert into sys_user(sys_user_dept,sys_user_name,sys_user_level,sys_user_agence,sys_user_code,sys_user_status,sys_user_isManger) values(?,?,?,?,?,?,?)";
		final Object[] objs = {user.getSysUserDept(),user.getSysUserName(),user.getSysUserLevel(),user.getSysUserAgence().getAgenceId(),user.getSysUserCode(),1,user.getSysUserIsManger()};
		
		KeyHolder keyHolder = new GeneratedKeyHolder();     
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);                                                 
					ps.setString(++i, DataUtils.getStringK(objs[n++]));    
					ps.setString(++i, DataUtils.getStringK(objs[n++]));   
					ps.setInt(++i, DataUtils.getInt(objs[n++]));    
					ps.setInt(++i, DataUtils.getInt(objs[n++]));    
					ps.setString(++i, DataUtils.getStringK(objs[n++]));    
					ps.setInt(++i, DataUtils.getInt(objs[n++]));   
					ps.setInt(++i, DataUtils.getInt(objs[n++]));   
					return ps;                   
				}             
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();     
	}
	
	public void editOneUser(User user) throws Exception{
		final String sql = "update sys_user set sys_user_dept=?,sys_user_name=?,sys_user_level=?,sys_user_agence=?,sys_user_code=?,sys_user_isManger=? where sys_user_id=?";
		final Object[] objs = {user.getSysUserDept(),user.getSysUserName(),user.getSysUserLevel(),user.getSysUserAgence().getAgenceId(),user.getSysUserCode(),user.getSysUserIsManger(),user.getSysUserId()};
		this.getJdbcTemplate().update(sql,objs);   
	}
	
	public void deleteOneUser(int uuid) throws Exception{
		String sql = "update sys_user set sys_user_status=0 where sys_user_id="+uuid;
		this.getJdbcTemplate().update(sql);
	}
	
}
