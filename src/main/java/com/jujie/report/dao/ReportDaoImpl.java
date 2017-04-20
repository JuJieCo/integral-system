package com.jujie.report.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.jujie.data.DataDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.report.QueryDate;
import com.jujie.util.DataUtils;
import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;
import com.jujie.util.page.PageUtils;
@SuppressWarnings("unchecked")
public class ReportDaoImpl extends BaseJdbcDao {	
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
		//	@Override
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
			
			//@Override
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
			
			//@Override
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
			
			//@Override
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
				sql += " and data_ym= ? ";
				list.add(objs[0]);
			}	
		}
		sql += " order by data_id ";
		return this.getJdbcTemplate().query(PageUtils.fyPage(sql, list.toArray(), page, this.getJdbcTemplate(), Page.DATABASE_TYPE_MSSQL),list.toArray(), new DataDetails());
	} 
	
	public List<DataDetails> findAllDataDetailsByYM(String ym) throws Exception {
		String sql = "select * from integral_data_details where data_ym=?";
		return this.getJdbcTemplate().query(sql,new Object[]{ym}, new DataDetails());
	}
	
	public void deleteDataDetails(String ym) throws Exception {
		this.getJdbcTemplate().update("delete from integral_data_details where data_ym='"+ym+"'");
	}



	public List<DataDetails> findAllDetails(Object[] objs, Page page) {
		final List<DataDetails> reportList = new ArrayList<DataDetails>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1 ";
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and data_ym = ?";
				obj.add(objs[0]);
			}
		}
		String sql = "select data_cust_level,count(*) as acclevel "
				+ " from dbo.integral_data_details " + where + ""
				+ " group by data_cust_level ";
		this.getJdbcTemplate().query(
				PageUtils.fyPage(sql, obj.toArray(), page, this
						.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL),
				obj.toArray(), new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						DataDetails detailsData = new DataDetails();
						detailsData.setDataCustLevel(rs
								.getString("data_cust_level"));
						detailsData.setDataHold1(String.valueOf(rs
								.getInt("acclevel")));
						reportList.add(detailsData);
					}
				});
		return reportList;
	}

	public List<DataDetails> findAllDetailsByTime(Object[] objs, Page page) {
		final List<DataDetails> reportList = new ArrayList<DataDetails>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1";
//dataDetails.getDataCustName(),dataDetails.getDataCreditCard(),dataDetails.getDataCustLevel(),dataDetails.getDataYm(),dataDetails.getDataHold1()
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and data_cust_name like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
			    where += " and data_cust_code like ?+'%' ";
				obj.add(objs[1]);
			}
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				where += " and data_cust_level >= ?";
				obj.add(objs[2]);
			}
			if (objs.length >= 4 && objs[3] != null && !"".equals(objs[3])) {
				where += " and data_ym >= ?";
				obj.add(objs[3]);
			}
			if (objs.length >= 5 && objs[4] != null && !"".equals(objs[4])) {
				where += " and data_ym <= ?";
				obj.add(objs[4]);
			}
		}

		String sql = "select data_cust_code,data_ym ,max(data_cust_name) as data_cust_name,"
				+ " sum(convert(decimal(20,2),data_money_total)) as data_money_total,"
				+ " sum(convert(decimal(20,2),data_rmb_deposit))as data_rmb_deposit,"
				+ " sum(convert(decimal(20,2),data_us_deposit)) as data_us_deposit,"
				+ " sum(convert(decimal(20,2),data_rmb_investment)) as data_rmb_investment,"
				+ " sum(convert(decimal(20,2),data_us_investment)) as data_us_investment,"
				+ " sum(convert(decimal(20,2),data_nationaldebt)) as data_nationaldebt,"
				+ " sum(convert(decimal(20,2),data_first_pay)) as data_first_pay, "
				+ " sum(convert(decimal(20,2),data_three_store)) as data_three_store,"
				+ " max(data_cust_mobile) as data_cust_mobile,max(data_cust_level) data_cust_level"
				+ " from dbo.integral_data_details " + where 
				+ " group by data_cust_code,data_ym "
				+ " order by data_cust_code";
		this.getJdbcTemplate().query(
				PageUtils.fyPage(sql, obj.toArray(), page, this
						.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL),
				obj.toArray(), new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						DataDetails detailsData = new DataDetails();
						detailsData.setDataCreditCard(rs.getString("data_cust_code"));
						detailsData.setDataCustName(rs
								.getString("data_cust_name"));
						detailsData.setDataMoneyTotal(rs
								.getString("data_money_total"));
						detailsData.setDataRmbDeposit(rs
								.getString("data_rmb_deposit"));
						detailsData.setDataUsDeposit(rs
								.getString("data_us_deposit"));
						detailsData.setDataRmbInvestment(rs
								.getString("data_rmb_investment"));
						detailsData.setDataUsInvestment(rs
								.getString("data_us_investment"));
						detailsData.setDataNationaldebt(rs
								.getString("data_nationaldebt"));
						detailsData.setDataFirstPay(rs
								.getString("data_first_pay"));
						detailsData.setDataThreeStore(rs
								.getString("data_three_store"));
						detailsData.setDataCustMobile(rs
								.getString("data_cust_mobile"));
						detailsData.setDataCustLevel(rs
								.getString("data_cust_level"));
						detailsData.setDataCustLevel(rs
								.getString("data_ym"));
						reportList.add(detailsData);
					}
				});
		return reportList;
	}

	public List<DataDetails> findAllDetailsByHonest(Object[] objs, Page page) {
		final List<DataDetails> reportList = new ArrayList<DataDetails>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1";
//dataDetails.getDataYm(),dataDetails.getDataHold1(),dataDetails.getDataCustName(),dataDetails.getDataCustLevel()		
		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and data_ym >= ?";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				where += " and data_ym <= ?";
				obj.add(objs[1]);
			}
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				where += " and data_cust_name <= ?";
				obj.add(objs[2]);
			}
			if (objs.length >= 4 && objs[3] != null && !"0".equals(objs[3])&& !"".equals(objs[3])) {
				where += " and data_cust_level = ?";
				obj.add(objs[3]);
			}
		}

		String sql = "select data_cust_code,data_cust_name,data_cust_level,data_ym "
				+ " from dbo.integral_data_details " + where 
				+ " order by data_cust_code,data_ym,data_cust_level " ;
		this.getJdbcTemplate().query(
				PageUtils.fyPage(sql, obj.toArray(), page, this
						.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL),
				obj.toArray(), new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						DataDetails detailsData = new DataDetails();
						detailsData.setDataCreditCard(rs
								.getString("data_cust_code"));
						detailsData.setDataCustName(rs
								.getString("data_cust_name"));
						detailsData.setDataCustLevel(rs
								.getString("data_cust_level"));
						detailsData.setDataYm(rs.getString("data_ym"));
						reportList.add(detailsData);
					}
				});
		return reportList;
	}
	//综合查询
	public List<DataDetails> findAllDetailsByAll(Object[] objs, Page page) {
		final List<DataDetails> reportList = new ArrayList<DataDetails>();
		List<Object> obj = new ArrayList<Object>();
		String where = " where 1 = 1";
		/*
		 * dataDetails.getDataMoneyTotal(),dataDetails.getDataHold1(),dataDetails.getDataRmbDeposit(),dataDetails.getDataHold2(),
						dataDetails.getDataUsDeposit(),dataDetails.getDataHold3(),dataDetails.getDataRmbInvestment(),dataDetails.getDataRemark(),
						dataDetails.getDataUsInvestment(),dataDetails.getDataVipCode(),dataDetails.getDataThreeStore(),dataDetails.getDataCardType(),
						dataDetails.getDataFirstPay(),dataDetails.getDataCustZipcode(),dataDetails.getDataCustLevel(),dataDetails.getDataYm()
		 * */

		if (objs != null && objs.length > 0) {
			//总资产
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and data_money_total >= ?";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				where += " and data_money_total <= ?";
				obj.add(objs[1]);
			}
			//人民币存款
			if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
				where += " and data_rmb_deposit >= ?";
				obj.add(objs[2]);
			}
			if (objs.length >= 4 && objs[3] != null && !"".equals(objs[3])) {
				where += " and data_rmb_deposit <= ?";
				obj.add(objs[3]);
			}
			//外币存款
			if (objs.length >= 5 && objs[4] != null && !"".equals(objs[4])) {
				where += " and data_us_deposit >= ?";
				obj.add(objs[4]);
			}
			if (objs.length >= 6 && objs[5] != null && !"".equals(objs[5])) {
				where += " and data_us_deposit <= ?";
				obj.add(objs[5]);
			}
			//人民币理财
			if (objs.length >= 7 && objs[6] != null && !"".equals(objs[6])) {
				where += " and data_rmb_investment >= ?";
				obj.add(objs[6]);
			}
			if (objs.length >= 8 && objs[7] != null && !"".equals(objs[7])) {
				where += " and data_rmb_investment <= ?";
				obj.add(objs[7]);
			}
			//外币理财
			if (objs.length >= 9 && objs[8] != null && !"".equals(objs[8])) {
				where += " and data_us_investment >= ?";
				obj.add(objs[8]);
			}
			if (objs.length >= 10 && objs[9] != null && !"".equals(objs[9])) {
				where += " and data_us_investment <= ?";
				obj.add(objs[9]);
			}
			//第三方存管
			if (objs.length >= 11 && objs[10] != null && !"".equals(objs[10])) {
				where += " and data_three_store >= ?";
				obj.add(objs[10]);
			}
			if (objs.length >= 12 && objs[11] != null && !"".equals(objs[11])) {
				where += " and data_three_store <= ?";
				obj.add(objs[11]);
			}
			//个贷
			if (objs.length >= 13 && objs[12] != null && !"".equals(objs[12])) {
				where += " and data_first_pay >= ?";
				obj.add(objs[12]);
			}
			if (objs.length >= 14 && objs[13] != null && !"".equals(objs[13])) {
				where += " and data_first_pay <= ?";
				obj.add(objs[13]);
			}
			//客户级别
			if (objs.length >= 15 && objs[14] != null && !"".equals(objs[14])&& !"0".equals(objs[14])) {
				where += " and data_cust_level >= ?";
				obj.add(objs[14]);
			}
			if (objs.length >= 16 && objs[15] != null && !"".equals(objs[15])) {
				where += " and data_cust_level <= ?";
				obj.add(objs[15]);
			}
			
			
		}
		String sql = "SELECT  data_cust_code, data_cust_name, data_cust_level, data_cust_mobile,"
		        +" data_money_total, data_rmb_deposit, data_us_deposit, data_rmb_investment,"
		        +" data_us_investment, data_nationaldebt, data_first_pay, data_three_store, data_ym"
		        +" FROM integral_data_details " + where;
		
	this.getJdbcTemplate().query(
			PageUtils.fyPage(sql, obj.toArray(), page, this.getJdbcTemplate(), page.DATABASE_TYPE_MSSQL),
			obj.toArray(), new RowCallbackHandler() {
				public void processRow(ResultSet rs) throws SQLException {
					DataDetails detailsData = new DataDetails();
					detailsData.setDataCreditCard(rs.getString("data_cust_code"));
					detailsData.setDataCustName(rs.getString("data_cust_name"));
					detailsData.setDataCustLevel(rs.getString("data_cust_level"));
					detailsData.setDataCustMobile(rs.getString("data_cust_mobile"));
					detailsData.setDataMoneyTotal(rs.getString("data_money_total"));
					detailsData.setDataRmbDeposit(rs.getString("data_rmb_deposit"));
					detailsData.setDataUsDeposit(rs.getString("data_us_deposit"));
					detailsData.setDataRmbInvestment(rs.getString("data_rmb_investment"));
					detailsData.setDataUsInvestment(rs.getString("data_us_investment"));
					detailsData.setDataNationaldebt(rs.getString("data_nationaldebt"));
					detailsData.setDataFirstPay(rs.getString("data_first_pay"));
					detailsData.setDataThreeStore(rs.getString("data_three_store"));							
					reportList.add(detailsData);
				}
			});
	return reportList;
	}

}
