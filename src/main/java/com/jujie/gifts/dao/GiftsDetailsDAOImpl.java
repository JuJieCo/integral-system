package com.jujie.gifts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.integral.IntegraCusMain;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
@SuppressWarnings("static-access")
public class GiftsDetailsDAOImpl  extends BaseJdbcDao{
	public List<GiftsDetails> queryGiftsDetailsList(Object[] objs,String userId,String agenceIds,Page page)throws Exception{
		final List<GiftsDetails> giftsDetailsList = new ArrayList<GiftsDetails>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1";
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and c.cust_name =? ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				where += " and c.cust_code =?";
				obj.add(objs[1]);
			}
		}
		if(userId!=null){
			where +=" and c.cust_cp_manager= "+userId;
		}else if(agenceIds!=null){
			where+=" and d.gifts_details_agence in("+agenceIds+")";
		}
		String sql ="select d.*, c.cust_name, c.cust_code , g.gifts_name ,s.sys_user_name , a.agence_name  " +
		" from integral_gifts_details d, integral_customer_info c , integral_gifts_info g ," +
		" sys_user s ,integral_agence_info a " +
		 where +" and d.cust_id=c.cust_id  and d.gifts_id=g.gifts_id and d.gifts_details_oper=s.sys_user_id " +
		 " and d.gifts_details_agence=a.agence_id order by c.cust_code desc ";
		this.getJdbcTemplate().query(PageUtils.fyPage(sql, obj.toArray(), page, this.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL), obj.toArray(),new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 GiftsDetails giftsDetails = new GiftsDetails();
				 giftsDetails.setGiftsDetailsId(rs.getInt("gifts_details_id"));
				 giftsDetails.setGiftsId(rs.getInt("gifts_id"));
				 giftsDetails.setCustId(rs.getInt("cust_id"));
				 giftsDetails.setGiftsDetailsTime(rs.getTimestamp("gifts_details_time"));
				 giftsDetails.setGiftsDetailsCost(rs.getInt("gifts_details_cost"));
				 giftsDetails.setGiftsDetailsStatus(rs.getInt("gifts_details_status"));
				 giftsDetails.setGiftsDetailsOper(rs.getInt("gifts_details_oper"));
				 giftsDetails.setGiftsDetailsAgence(rs.getInt("gifts_details_agence"));
				 giftsDetails.setGiftsDetailsHold1(rs.getString("gifts_details_hold1"));
				 giftsDetails.setGiftsDetailsHold2(rs.getString("gifts_details_hold2"));
				 giftsDetails.setGiftsDetailsRemark(rs.getString("gifts_details_remark"));
				  
				 giftsDetails.setSysUserName(rs.getString("sys_user_name"));
				 giftsDetails.setAgenceName(rs.getString("agence_name"));
				 giftsDetails.setCustName(rs.getString("cust_name"));
				 giftsDetails.setGiftsName(rs.getString("gifts_name"));
				 giftsDetails.setCustCode(rs.getString("cust_code"));
				 giftsDetailsList.add(giftsDetails);
			 }
		 }); 
		return giftsDetailsList;
	}
	public void exchangeGiftsBackout(Integer giftsDetailsId ,Integer giftsId , Integer custId,Integer giftsDetailsCost)throws Exception{
		this.updateGiftsDetails(giftsDetailsId);
		GiftsInfo giftsInfo = this.queryGiftsInfo(giftsId);
		this.updateGiftsInfo(giftsInfo);
		IntegraCusMain integraCusMain = this.queryCustIntegral(custId);
		this.updateIntegraCusMain(integraCusMain, giftsDetailsCost);
	}
	
	public void updateGiftsDetails(Integer giftsDetailsId)throws Exception{
		String sql = "update integral_gifts_details set gifts_details_status=1 where gifts_details_id="+giftsDetailsId;
		this.getJdbcTemplate().update(sql);
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
		Object[] objs = {giftsInfo.getGiftsCalls()-1,
		giftsInfo.getGiftsRemain()+1 ,giftsInfo.getGiftsId()};
		this.getJdbcTemplate().update(sql,objs);
	}
	public IntegraCusMain queryCustIntegral(Integer custId){
		String sql = "select cust_id ,cust_integral_calls ,  cust_integral_remain from integral_customer_main where cust_id="+custId;
		final IntegraCusMain integraCusMain = new IntegraCusMain();
		 this.getJdbcTemplate().query(sql, new RowCallbackHandler(){
			 public void processRow(ResultSet rs) throws SQLException{
				 integraCusMain.getIntegralCustomer().setCustId(rs.getInt("cust_id"));
				 integraCusMain.setCust_integral_calls(rs.getInt("cust_integral_calls"));
				 integraCusMain.setCust_integral_remain(rs.getInt("cust_integral_remain"));
			 }
		 });	
		return integraCusMain;
	}
	public void updateIntegraCusMain(IntegraCusMain integraCusMain ,Integer giftsDetailsCost) throws Exception {
		String sql = "update integral_customer_main set " +
		" cust_integral_calls=?, cust_integral_remain=? "+
		" where cust_id=? ";
	Object[] objs = {integraCusMain.getCust_integral_calls()-giftsDetailsCost,
			integraCusMain.getCust_integral_remain()+giftsDetailsCost,
			integraCusMain.getIntegralCustomer().getCustId()};
	this.getJdbcTemplate().update(sql,objs);
	}
}
 