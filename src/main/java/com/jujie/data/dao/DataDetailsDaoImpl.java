package com.jujie.data.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.jujie.data.DataDetails;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
@SuppressWarnings("unchecked")
public class DataDetailsDaoImpl extends BaseJdbcDao {
	
	public void addDataDetails(final List<DataDetails> list) throws Exception {
		StringBuffer sd = new StringBuffer("insert into integral_data_details(");
		sd.append("data_cust_name,data_cust_org,data_cust_codetype,data_cust_code,");
		sd.append("data_cust_level,data_vip_code,data_card_type,data_cust_address,");
		sd.append("data_cust_zipcode,data_cust_areacode,data_cust_homephone,data_cust_officephone,");
		sd.append("data_cust_mobile,data_money_total,data_rmb_deposit,data_us_deposit,data_rmb_investment,");
		sd.append("data_us_investment,data_fund,data_nationaldebt,data_physical_gold,data_first_pay,");
		sd.append("data_qs_lc,data_three_store,data_xt_jh,data_lc_manager,data_credit_card,data_tx_cust,");
		sd.append("data_ym,data_import_time,data_import_user,data_hold1,data_hold2,data_hold3,data_remark)");
		sd.append(" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DataDetails dataDetails = list.get(i);
				int n = 0;
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustName()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustOrg()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustCodetype()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustCode()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustLevel()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataVipCode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCardType()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustAddress()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustZipcode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustAreacode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustHomephone()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustOfficephone()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustMobile()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataMoneyTotal()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRmbDeposit()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataUsDeposit()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRmbInvestment()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataUsInvestment()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataFund()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataNationaldebt()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataPhysicalGold()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataFirstPay()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataQsLc()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataThreeStore()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataXtJh()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataLcManager()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCreditCard()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataTxCust()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataYm()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(dataDetails.getDataImportTime()));
				ps.setInt(++n, DataUtils.getInt(dataDetails.getDataImportUser()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold1()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold2()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold3()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRemark()));
			}
			
			@Override
			public int getBatchSize() {
				
				return list.size();
			}
		});
	}
	
	public void updateDataDetails(DataDetails dataDetails) throws Exception {
		List<DataDetails> list = new ArrayList<DataDetails>();
		list.add(dataDetails);
		updateDataDetails(list);
	}
	
	public void updateDataDetails(final List<DataDetails> list) throws Exception {
		StringBuffer sd = new StringBuffer("update integral_data_details set ");
		sd.append("data_cust_name=?,data_cust_org=?,data_cust_codetype=?,data_cust_code=?,");
		sd.append("data_cust_level=?,data_vip_code=?,data_card_type=?,data_cust_address=?,");
		sd.append("data_cust_zipcode=?,data_cust_areacode=?,data_cust_homephone=?,data_cust_officephone=?,");
		sd.append("data_cust_mobile=?,data_money_total=?,data_rmb_deposit=?,data_us_deposit=?,data_rmb_investment=?,");
		sd.append("data_us_investment=?,data_fund=?,data_nationaldebt=?,data_physical_gold=?,data_first_pay=?,");
		sd.append("data_qs_lc=?,data_three_store=?,data_xt_jh=?,data_lc_manager=?,data_credit_card=?,data_tx_cust=?,");
		sd.append("data_ym=?,data_import_time=?,data_import_user=?,data_hold1=?,data_hold2=?,data_hold3=?,data_remark=? ");
		sd.append(" where data_id=? ");
		this.getJdbcTemplate().batchUpdate(sd.toString(), new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DataDetails dataDetails = list.get(i);
				int n = 0;
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustName()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustOrg()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustCodetype()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustCode()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustLevel()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataVipCode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCardType()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustAddress()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustZipcode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustAreacode()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustHomephone()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustOfficephone()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCustMobile()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataMoneyTotal()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRmbDeposit()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataUsDeposit()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRmbInvestment()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataUsInvestment()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataFund()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataNationaldebt()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataPhysicalGold()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataFirstPay()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataQsLc()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataThreeStore()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataXtJh()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataLcManager()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataCreditCard()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataTxCust()));
				
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataYm()));
				ps.setTimestamp(++n, DateUtils.getTimestamp(dataDetails.getDataImportTime()));
				ps.setInt(++n, DataUtils.getInt(dataDetails.getDataImportUser()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold1()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold2()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataHold3()));
				ps.setString(++n, DataUtils.getStringK(dataDetails.getDataRemark()));

				ps.setInt(++n, DataUtils.getInt(dataDetails.getDataId()));
			}
			
			@Override
			public int getBatchSize() {
				
				return list.size();
			}
		});
	}
	
	
	public DataDetails findDataDetailsByNameCode(String ym,String name,String code) throws Exception {
		String sql = "select * from integral_data_details where data_ym=? and data_cust_name=? and data_cust_code=?";
		List<DataDetails> list =new ArrayList<DataDetails>();
		 list = this.getJdbcTemplate().query(sql,new Object[]{ym,name,code}, new DataDetails());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public DataDetails findDataDetailsByID(int id) throws Exception {
		String sql = "select * from integral_data_details where data_id="+id;
		List<DataDetails> list = this.getJdbcTemplate().query(sql, new DataDetails());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public void updateDataDetailsStatus(int id,String status) throws Exception {
		String sql = "update integral_data_details set data_hold1='"+status+"' where data_id="+id;
		this.getJdbcTemplate().update(sql);
	}
	
	public List<DataDetails> findAllDataDetailsByCond(Page page,Object[] objs) throws Exception {
		String sql = "select * from integral_data_details where 1=1 ";
		List<Object> list = new ArrayList<Object>();
		if(objs!=null&&objs.length>0){
			if(objs[0]!=null&&!"".equals(objs[0])){
				sql += " and data_ym=? ";
				list.add(objs[0]);
			}
			if(objs[1]!=null&&!"".equals(objs[1])){
				sql += " and data_cust_name like '%'+?+'%' ";
				list.add(objs[1]);
			}
			if(objs[2]!=null&&!"".equals(objs[2])){
				sql += " and data_cust_code like '%'+?+'%' ";
				list.add(objs[2]);
			}
		}
		sql += " order by data_id ";
		return this.getJdbcTemplate().query(PageUtils.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MSSQL),list.toArray(), new DataDetails());
	} 
	public List findReprotForCustem() throws Exception {
		List items = new ArrayList();
		List<String> ymsList = new ArrayList<String>();
		List<String> monthsList= new ArrayList<String>();
		List<String> nameList= new ArrayList<String>();
		List<String> valuesList= new ArrayList<String>();
		
		String sql = "select data_ym from integral_data_details group by data_ym order by data_ym";
		String sql1 = "select count(data_id) sumdataid from integral_data_details";
		String sql2 = "select a.data_ym,isnull(b.sumdeposit,0) sumdepostit from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) sumdeposit,data_ym from integral_data_details where CONVERT (float,data_rmb_deposit) + CONVERT (float,data_us_deposit) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym";
		String sql3 = "select a.data_ym,isnull(b.suminvestment,0) suminvestment from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) suminvestment,data_ym from integral_data_details where CONVERT (float,data_rmb_investment) + CONVERT (float,data_us_investment) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym"; 
		String sql4 = "select a.data_ym,isnull(b.sumfund,0) sumfund from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) sumfund,data_ym from integral_data_details where CONVERT (float,data_fund) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym";
		String sql5 = "select a.data_ym,isnull(b.sumnationaldebt,0) sumnationaldebt from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) sumnationaldebt,data_ym from integral_data_details where CONVERT (float,data_nationaldebt) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym";
		String sql6 = "select a.data_ym,isnull(b.sumfirstpay,0) sumfirstpay from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) sumfirstpay,data_ym from integral_data_details where CONVERT (float,data_first_pay) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym";
		String sql7 = "select a.data_ym,isnull(b.sumthreestore,0) sumthreestore from (select data_ym from integral_data_details group by data_ym ) a left join (select count(data_id) sumthreestore,data_ym from integral_data_details where CONVERT (float,data_three_store) >0 group by data_ym) b on a.data_ym=b.data_ym order by a.data_ym";
	    
	    List yms = this.getJdbcTemplate().queryForList(sql);
		List sumdataidList=this.getJdbcTemplate().queryForList(sql1);
		List sumdepositList=this.getJdbcTemplate().queryForList(sql2);
		List suminvestmentList=this.getJdbcTemplate().queryForList(sql3);
		List sumfundtList=this.getJdbcTemplate().queryForList(sql4);
		List sumnationaldebtList=this.getJdbcTemplate().queryForList(sql5);
		List sumfirstpayList=this.getJdbcTemplate().queryForList(sql6);
		List sumthreestoreList=this.getJdbcTemplate().queryForList(sql7);
		
		for(int i=0;i<yms.size();i++){
	    	Map map =(Map)yms.get(i);
	    	ymsList.add(map.get("data_ym").toString());
	    }
		
	    for(int i=0;i<sumdataidList.size();i++){
	    	Map map =(Map)sumdataidList.get(i);
	    	valuesList.add(map.get("sumdataid").toString());
	    }
	    for(int i=0;i<sumdepositList.size();i++){
	    	Map map =(Map)sumdepositList.get(i);
	    	nameList.add("sumdepostit");
	        monthsList.add(map.get("data_ym").toString());
	      	valuesList.add(map.get("sumdepostit").toString());
	    }
	    for(int i=0;i<suminvestmentList.size();i++){
	    	Map map =(Map)suminvestmentList.get(i);
	    	nameList.add("suminvestment");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("suminvestment").toString());
	    }
	    for(int i=0;i<sumfundtList.size();i++){
	    	Map map =(Map)sumfundtList.get(i);
	    	nameList.add("sumfund");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumfund").toString());
	    }
	    for(int i=0;i<sumnationaldebtList.size();i++){
	    	Map map =(Map)sumnationaldebtList.get(i);
	    	nameList.add("sumnationaldebt");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumnationaldebt").toString());
	    }
	    for(int i=0;i<sumfirstpayList.size();i++){
	    	Map map =(Map)sumfirstpayList.get(i);
	    	nameList.add("sumfirstpay");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumfirstpay").toString());
	    }
	    for(int i=0;i<sumthreestoreList.size();i++){
	    	Map map =(Map)sumthreestoreList.get(i);
	    	nameList.add("sumthreestore");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumthreestore").toString());
	    }
	    items.add(ymsList);
	    items.add(monthsList);
		items.add(valuesList);
		items.add(nameList);
		
	    return items;
	} 
	
	public List findReprotForMoneyChang() throws Exception {
		List moneyChangList = new ArrayList();
		List<String> ymsList = new ArrayList<String>();
		List<String> monthsList= new ArrayList<String>();
		List<String> nameList= new ArrayList<String>();
		List<String> valuesList= new ArrayList<String>();
		String sql = "select data_ym from integral_data_details group by data_ym order by data_ym";
	 	String sql8 = "select max(a.sm) sumdataid from (select sum(CONVERT (float,data_money_total)) sm from integral_data_details group by data_ym ) a";
		String sql9 = "select sum(CONVERT (float,data_rmb_deposit)+CONVERT(float,data_us_deposit)) sumdepostit,data_ym  from integral_data_details group by data_ym order by data_ym";
		String sql10 = "select sum(CONVERT (float,data_rmb_investment)+CONVERT(float,data_us_investment))suminvestment,data_ym  from integral_data_details group by data_ym order by data_ym";
		String sql11 = "select sum(CONVERT (float,data_fund)) sumfund,data_ym  from integral_data_details group by data_ym order by data_ym";
		String sql12 = "select sum(CONVERT (float,data_nationaldebt)) sumnationaldebt,data_ym  from integral_data_details group by data_ym order by data_ym";
		String sql13 = "select sum(CONVERT (float,data_first_pay)) sumfirstpay,data_ym  from integral_data_details group by data_ym order by data_ym";
		String sql14 = "select sum(CONVERT (float,data_three_store)) sumthreestore,data_ym  from integral_data_details group by data_ym order by data_ym";
		
		List yms = this.getJdbcTemplate().queryForList(sql);
		List sumdataidList=this.getJdbcTemplate().queryForList(sql8);
		List sumdepositList=this.getJdbcTemplate().queryForList(sql9);
		List suminvestmentList=this.getJdbcTemplate().queryForList(sql10);
		List sumfundtList=this.getJdbcTemplate().queryForList(sql11);
		List sumnationaldebtList=this.getJdbcTemplate().queryForList(sql12);
		List sumfirstpayList=this.getJdbcTemplate().queryForList(sql13);
		List sumthreestoreList=this.getJdbcTemplate().queryForList(sql14);
		
		for(int i=0;i<yms.size();i++){
	    	Map map =(Map)yms.get(i);
	    	ymsList.add(map.get("data_ym").toString());
	    }
	    for(int i=0;i<sumdataidList.size();i++){
	    	Map map =(Map)sumdataidList.get(i);
	    	valuesList.add(map.get("sumdataid").toString());
	    }
	    for(int i=0;i<sumdepositList.size();i++){
	    	Map map =(Map)sumdepositList.get(i);
	    	nameList.add("sumdeposit");
	        monthsList.add(map.get("data_ym").toString());
	        valuesList.add(map.get("sumdepostit").toString());
	    }
	    for(int i=0;i<suminvestmentList.size();i++){
	    	Map map =(Map)suminvestmentList.get(i);
	    	nameList.add("suminvestment");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("suminvestment").toString());
	    }
	    for(int i=0;i<sumfundtList.size();i++){
	    	Map map =(Map)sumfundtList.get(i);
	    	nameList.add("sumfund");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumfund").toString());
	    }
	    for(int i=0;i<sumnationaldebtList.size();i++){
	    	Map map =(Map)sumnationaldebtList.get(i);
	    	nameList.add("sumnationaldebt");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumnationaldebt").toString());
	    }
	    for(int i=0;i<sumfirstpayList.size();i++){
	    	Map map =(Map)sumfirstpayList.get(i);
	    	nameList.add("sumfirstpay");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumfirstpay").toString());
	    }
	    for(int i=0;i<sumthreestoreList.size();i++){
	    	Map map =(Map)sumthreestoreList.get(i);
	    	nameList.add("sumthreestore");
	        monthsList.add(map.get("data_ym").toString());
	    	valuesList.add(map.get("sumthreestore").toString());
	    }
	    moneyChangList.add(ymsList);
	    moneyChangList.add(monthsList);
	    moneyChangList.add(valuesList);
	    moneyChangList.add(nameList);
	    return moneyChangList;
	} 
	
	public List<DataDetails> findAllDataDetailsByYM(String ym) throws Exception {
		String sql = "select * from integral_data_details where data_ym=?";
		return this.getJdbcTemplate().query(sql,new Object[]{ym}, new DataDetails());
	}
	
	public void deleteDataDetails(String ym) throws Exception {
		this.getJdbcTemplate().update("delete from integral_data_details where data_ym='"+ym+"'");
	}
	
	
	
	
	
	
	
	/**
	 * 更新第三方存管日均余额
	 */
	public void updataTabel()  throws Exception{	
		String sql = "update  integral_data_details set integral_data_details.data_three_store=Round(CK_total/day_total,2)"
				+ " from depo_date, integral_data_details"
				+ " where integral_data_details.data_cust_code=depo_date.ID_CARD and depo_date.imp_time='"
				+ this.getCurrTime() + "'";	
			this.getJdbcTemplate().update(sql);
		
	}
	/**
	 * 
	 */
	public void updataTabel1() throws Exception{
		String sql = "update  integral_data_details set integral_data_details.data_first_pay=Round(GD_total/day_total,2)"
				+ " from loan_date,integral_data_details"
				+ " where integral_data_details.data_cust_code=loan_date.ID_CARD and loan_date.imp_time='"
				+this.getCurrTime()+ "'";
		this.getJdbcTemplate().update(sql);
	}
	/**
	 * 获取当前月份
	 * 
	 * @return
	 */
	public String getCurrTime() {
		Date d = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MM");
		String curr_month = df.format(d);
		return curr_month;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
