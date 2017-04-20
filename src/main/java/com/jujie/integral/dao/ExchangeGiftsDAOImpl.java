package com.jujie.integral.dao;

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

import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.integral.ExchangeGifts;
import com.jujie.integral.IntegraCusMain;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;

public class ExchangeGiftsDAOImpl  extends BaseJdbcDao {
	
	public ExchangeGifts exchangeGiftsCustInfo(String custCode)throws Exception {
		String sql = "select c.cust_id,c.cust_name ,c.cust_code ,i.cust_integral_remain " +
				" from integral_customer_info c, integral_agence_info a, integral_customer_main i " +
				" where a.agence_id=c.agence_id and i.cust_id=c.cust_id and c.cust_status=1 ";
		
				if(!"".equals(custCode)&&custCode!=null){
					sql+=" and c.cust_code ='"+custCode+"'";
				}
				final ExchangeGifts exchangeGifts = new ExchangeGifts();
				 this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
					 public void processRow(ResultSet rs) throws SQLException{
						exchangeGifts.setCustId(rs.getInt("cust_id"));
						exchangeGifts.setCustName(rs.getString("cust_name"));
						exchangeGifts.setCustCode(rs.getString("cust_code"));
						exchangeGifts.setCustIntegralRemain(rs.getInt("cust_integral_remain"));
					 }
				 });	
				return exchangeGifts;
			}

	public List<GiftsInfo> getExchangeGiftsInfo(Integer custIntegralRemain)throws Exception{
		String sql ="select g.* from integral_gifts_info g " +
				" where g.gifts_status=0 and g.gifts_remain>0 and g.gifts_integral<="+custIntegralRemain;
		final List<GiftsInfo> giftsInfoList = new ArrayList<GiftsInfo>();
		 this.getJdbcTemplate().query(sql,new RowCallbackHandler(){
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
	
	
	public void exchangeGifts(Integer custId,Integer giftsId ,GiftsDetails giftsDetails,Integer giftsIntegral)throws Exception{
		this.addGiftsDetails(giftsDetails);
		GiftsInfo giftsInfo = this.queryGiftsInfo(giftsId);
		this.updateGiftsInfo(giftsInfo);
		IntegraCusMain integraCusMain = this.getCustIntegral(custId);
		this.updateIntegraCusMain(integraCusMain,giftsIntegral);
	}
	
	public GiftsInfo queryGiftsInfo(Integer giftsId) throws Exception{
		String sql ="select gifts_id, gifts_total,gifts_calls,gifts_remain " +
				" from integral_gifts_info where gifts_id = "+giftsId;
		final GiftsInfo giftsInfo = new GiftsInfo();
		 this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 giftsInfo.setGiftsId(rs.getInt("gifts_id"));
				 giftsInfo.setGiftsTotal(rs.getInt("gifts_total"));
				 giftsInfo.setGiftsCalls(rs.getInt("gifts_calls"));
				 giftsInfo.setGiftsRemain(rs.getInt("gifts_remain"));
			 }
		 });	
		return giftsInfo;
	}
	public void updateGiftsInfo(GiftsInfo giftsInfo) throws Exception{
		String sql = "update integral_gifts_info set " +
				"gifts_calls=?, gifts_remain=? where gifts_id=?";
		Object[] objs = {giftsInfo.getGiftsCalls()+1,
				giftsInfo.getGiftsRemain()-1 ,giftsInfo.getGiftsId()};
		this.getJdbcTemplate().update(sql,objs);
	}
	public int addGiftsDetails(GiftsDetails giftsDetails) throws Exception {
		final String sql = "insert into integral_gifts_details(gifts_id,cust_id,gifts_details_time," +
				" gifts_details_cost,gifts_details_status,gifts_details_oper,gifts_details_agence )" +
				"  values (?,?,?,?,?,?,?)";
		final Object[] objs ={giftsDetails.getGiftsId(),giftsDetails.getCustId(),
				giftsDetails.getGiftsDetailsTime(), giftsDetails.getGiftsDetailsCost(), 
				giftsDetails.getGiftsDetailsStatus(),giftsDetails.getGiftsDetailsOper(),
				giftsDetails.getGiftsDetailsAgence()};
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 try {
				this.getJdbcTemplate().update(new PreparedStatementCreator(){
					public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);  
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setTimestamp(++i, DateUtils.getTimestamp(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++])); 
					return ps;    
					}  
				 },keyHolder);
			} catch (DataAccessException e) {
				e.printStackTrace();
			}
			 return keyHolder.getKey().intValue();  
		}
	@SuppressWarnings("unchecked")
	public IntegraCusMain getCustIntegral(Integer custId){
		String sql = "select * from integral_customer_main where cust_id=?";
		List<IntegraCusMain> list = this.getJdbcTemplate().query(sql,new Object[]{custId}, new IntegraCusMain());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	public void updateIntegraCusMain(IntegraCusMain integraCusMain ,Integer giftsIntegralInt) throws Exception {
		String sql = "update integral_customer_main set " +
			" cust_integral_calls=?, cust_integral_remain=? "+
			" where cust_id=? ";
		Object[] objs = {integraCusMain.getCust_integral_calls()+giftsIntegralInt,
				integraCusMain.getCust_integral_remain()-giftsIntegralInt,
				integraCusMain.getIntegralCustomer().getCustId()};
		this.getJdbcTemplate().update(sql,objs);
	}
}
