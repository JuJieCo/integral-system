package com.jujie.agence.dao;

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

import com.jujie.agence.Agence;
import com.jujie.util.DataUtils;
@SuppressWarnings("unchecked")
public class AgenceDAOImpl extends JdbcDaoSupport {

	
	public List<Agence> queryAgencePidList(int pid) throws Exception{
		
		String sql = "select w.agence_id,w.agence_name,w.agence_phone,w.agence_phone2,w.agence_phone3,"+
		"w.agence_address, w.agence_contact ,w.agence_status, w.agence_remark ,w.agence_code,w.agence_level,w.agence_pid "+
		"from integral_agence_info w  where w.agence_pid="+pid;

		return this.getJdbcTemplate().query(sql, new Agence());
	
	}
	public List<Agence> queryAgenceList(Object[] objs) {
		
		List<Object> obj = new ArrayList<Object>();	
			String where = " where 1=1 ";
			if(objs!=null && objs.length>0){
				if(objs.length>=1 && objs[0]!=null&&!"".equals(objs[0])){
					where += " and w.agence_name like '%'+?+'%' ";
					obj.add(objs[0]);
				}
				if(objs.length>=2 && objs[1]!=null&&!"".equals(objs[1])){
					if(((Integer) objs[1]) != 0){
						where += " and w.agence_status = ? ";
						obj.add(objs[1]);
					}
				}
				if(objs.length>=3 && objs[2]!=null&&!"".equals(objs[2])){
						where += " and w.agence_contact like '%'+?+'%' ";
						obj.add(objs[2]);		
				}
					
				
			}
			
			String sql = "select w.agence_id,w.agence_name,w.agence_phone,w.agence_phone2,w.agence_phone3,"+
			"w.agence_address, w.agence_contact ,w.agence_status, w.agence_remark ,w.agence_code,w.agence_level,w.agence_pid "+
			"from integral_agence_info w "+where+ "order by w.agence_id ";

			return this.getJdbcTemplate().query(sql, obj.toArray(), new Agence());
		
		}

	public Agence queryAgenceByID( Integer AgenceId)throws Exception{
		final Agence agence = new  Agence();
		
		String sql = "select  w.agence_id,w.agence_name,w.agence_phone,w.agence_phone2,w.agence_phone3,"+
		"w.agence_address, w.agence_contact ,w.agence_status, w.agence_remark ,w.agence_code,w.agence_level,w.agence_pid "+
		"from integral_agence_info w where w.agence_id="+AgenceId;
		
		
	this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
		 public void processRow(ResultSet rs) throws SQLException{
			
			 agence.setAgenceId(rs.getInt("agence_id"));
			 agence.setAgenceName(rs.getString("agence_name"));
			 agence.setAgencePhone(rs.getString("agence_phone"));
			 agence.setAgencePhone2(rs.getString("agence_phone2"));
			 agence.setAgencePhone3(rs.getString("agence_phone3"));
			 agence.setAgenceAddress(rs.getString("agence_address"));
			 agence.setAgenceContact(rs.getString("agence_contact"));
			 agence.setAgenceStatus(rs.getInt("agence_status"));
			 agence.setAgenceRemark(rs.getString("agence_remark"));
			 agence.setAgenceCode(rs.getString("agence_code"));
			 agence.setAgenceLevel(rs.getInt("agence_level"));
			 agence.setAgencePid(rs.getInt("agence_pid"));
		 
	
	}});
	    return agence;
		
	}

	public Integer addAgenceByID(Agence agence)throws Exception {
		
		final String sql = "insert into integral_agence_info(agence_name,agence_phone,agence_phone2,"+
		 "agence_phone3,agence_address,agence_contact,agence_status,"+
		 "agence_remark,agence_code,agence_level,agence_pid)values(?,?,?,?,?,?,?,?,?,?,?)";
		
		final Object[] objs = {agence.getAgenceName(),agence.getAgencePhone(),agence.getAgencePhone2(),agence.getAgencePhone3(),
				agence.getAgenceAddress(),agence.getAgenceContact(),agence.getAgenceStatus(),agence.getAgenceRemark(),
				agence.getAgenceCode(),agence.getAgenceLevel(),agence.getAgencePid()};
		
		KeyHolder keyHolder = new GeneratedKeyHolder();   
		
		try{
			this.getJdbcTemplate().update(new PreparedStatementCreator(){         
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);  
					
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++])); 
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));    
					ps.setString(++i, DataUtils.getStringK(objs[n++])); 
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));  
					ps.setInt(++i,    DataUtils.getInt(objs[n++]));  
					
					return ps;                   
				}

				          
			}, keyHolder);    
		}catch(Exception e){
			e.printStackTrace();
		}
		 return keyHolder.getKey().intValue();
		   
	}

	public void updateAgenceByID(Agence agence)throws Exception  {
		

		String sql = "update integral_agence_info set agence_name=?,agence_phone=?,agence_phone2=? ,"+
		"agence_phone3=? ,agence_address=?, agence_contact=? ,agence_status=?,"+
		"agence_remark=? ,agence_code=?,agence_level=?,agence_pid=? where agence_id=?";
		
		Object[] obj={agence.getAgenceName(),agence.getAgencePhone(),agence.getAgencePhone2(),agence.getAgencePhone3(),
				agence.getAgenceAddress(),agence.getAgenceContact(),agence.getAgenceStatus(),agence.getAgenceRemark(),
				agence.getAgenceCode(),agence.getAgenceLevel(),agence.getAgencePid(),agence.getAgenceId()};
				
		this.getJdbcTemplate().update(sql,obj);
	}

	public void deleteAgenceByID(Integer AgenceId)throws Exception {
		String sql = "delete from  integral_agence_info where agence_id="+AgenceId;
		this.getJdbcTemplate().update(sql);
	}

}

