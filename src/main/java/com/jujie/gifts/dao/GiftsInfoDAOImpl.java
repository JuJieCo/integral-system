package com.jujie.gifts.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.gifts.GiftsInfo;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
import com.jujie.wzj.Wzj;

public class GiftsInfoDAOImpl  extends BaseJdbcDao{
	@SuppressWarnings("static-access")
	public List<GiftsInfo> queryGiftsInfoList(Object[] objs , Page page)throws Exception{
		final List<GiftsInfo> giftsInfoList = new ArrayList<GiftsInfo>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1";
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and gifts_type like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				where += " and gifts_name like '%'+?+'%' ";
				obj.add(objs[1]);
			}
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				where += " and gifts_status = ? ";
				obj.add(objs[2]);
			}	
		}
		String sql ="select * from integral_gifts_info "+where+" order by gifts_id desc";
		this.getJdbcTemplate().query(PageUtils.fyPage(sql, obj.toArray(), page, this.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL), obj.toArray(),new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 GiftsInfo giftsInfo = new GiftsInfo();
				 giftsInfo.setGiftsId(rs.getInt("gifts_id"));
				 giftsInfo.setGiftsType(rs.getString("gifts_type"));
				 giftsInfo.setGiftsName(rs.getString("gifts_name"));
				 giftsInfo.setGiftsTotal(rs.getInt("gifts_total"));
				 giftsInfo.setGiftsCalls(rs.getInt("gifts_calls"));
				 giftsInfo.setGiftsRemain(rs.getInt("gifts_remain"));
				 giftsInfo.setGiftsIntegral(rs.getInt("gifts_integral"));
				 giftsInfo.setWzjOrgId(rs.getInt("wzj_org_id"));
				 giftsInfo.setGiftsStartTime(rs.getDate("gifts_starttime"));
				 giftsInfo.setGiftsEndTime(rs.getDate("gifts_endtime"));
				 giftsInfo.setGiftsStatus(rs.getInt("gifts_status"));
				 giftsInfo.setGiftsHold(rs.getString("gifts_hold"));
				 giftsInfo.setGiftsRemark(rs.getString("gifts_remark"));
				 giftsInfoList.add(giftsInfo);
			 }
		 }); 
		return giftsInfoList;
	}
	
	@SuppressWarnings("unchecked")
	public GiftsInfo queryGiftsInfo(String giftsId) throws Exception{

		String sql ="select w.wzj_org_name , g.*  from integral_gifts_info g , integral_wzj_org w " +
				" where g.wzj_org_id = w.wzj_org_id and gifts_id = "+giftsId;
		List<GiftsInfo> list = this.getJdbcTemplate().query(sql, new GiftsInfo());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public int addGiftsInfo(GiftsInfo giftsInfo) throws Exception {
		final String sql = "insert into integral_gifts_info(gifts_type,gifts_name,gifts_total,gifts_calls," +
				"gifts_remain,gifts_integral,wzj_org_id,gifts_starttime,gifts_endtime,gifts_status," +
				"gifts_hold,gifts_remark ) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		final Object[] objs ={giftsInfo.getGiftsType(),giftsInfo.getGiftsName(),giftsInfo.getGiftsTotal(),
				giftsInfo.getGiftsCalls(),giftsInfo.getGiftsRemain(),giftsInfo.getGiftsIntegral(),
				giftsInfo.getWzjOrgId(),giftsInfo.getGiftsStartTime(),giftsInfo.getGiftsEndTime(),
				giftsInfo.getGiftsStatus(),giftsInfo.getGiftsHold(),giftsInfo.getGiftsRemark()};
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 try {
				this.getJdbcTemplate().update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);  
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++])); 
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setDate(++i, DateUtils.getSqlDate(objs[n++]));
					ps.setDate(++i, DateUtils.getSqlDate(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					return ps;    
					}  
				 },keyHolder);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			 return keyHolder.getKey().intValue();  
		}
	
	public void updateGiftsInfo(GiftsInfo giftsInfo) throws Exception{
		String sql = "update integral_gifts_info set gifts_type=?,gifts_name=?," +
				" gifts_total=?,gifts_remain=?,gifts_integral=?,wzj_org_id=?,gifts_starttime=?," +
				"gifts_endtime=?,gifts_status=?,gifts_hold=?,gifts_remark=? where gifts_id=?";
		Object[] objs = {giftsInfo.getGiftsType(),giftsInfo.getGiftsName(),giftsInfo.getGiftsTotal(),
				giftsInfo.getGiftsRemain(),giftsInfo.getGiftsIntegral(),giftsInfo.getWzjOrgId(),
				giftsInfo.getGiftsStartTime(),giftsInfo.getGiftsEndTime(),giftsInfo.getGiftsStatus(),
				giftsInfo.getGiftsHold(),giftsInfo.getGiftsRemark(),giftsInfo.getGiftsId()};
		this.getJdbcTemplate().update(sql,objs);
	}
	
	public void deleteGiftsInfo(String[] giftsId) throws Exception{
		String[] sql = new String[giftsId.length];
		 sql[0] = "delete from integral_gifts_info where gifts_id="+giftsId[0];
		this.getJdbcTemplate().batchUpdate(sql);
	}	
	
	public List<Wzj> queryWzjList()throws Exception{
		final List<Wzj> wzjList = new ArrayList<Wzj>();
		String sql ="select * from integral_wzj_org where wzj_org_status =1";
		 this.getJdbcTemplate().query(sql,new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 Wzj wzj = new Wzj();
				 wzj.setWzjOrgId(rs.getInt("wzj_org_id"));
				 wzj.setWzjOrgName(rs.getString("wzj_org_name"));
				 wzjList.add(wzj);
			 }
		 }); 
		return wzjList;
	}

}
