package com.jujie.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.jujie.global.BaseBean;
import com.jujie.util.DataUtils;

public class DataDetails extends BaseBean{
	
	private Integer dataId;
	private String dataCustName;
	private String dataCustOrg;
	private String dataCustCodetype;
	private String dataCustCode;
	private String dataCustLevel;
	private String dataVipCode;
	private String dataCardType;
	private String dataCustAddress;
	private String dataCustZipcode;
	private String dataCustAreacode;
	private String dataCustHomephone;
	private String dataCustOfficephone;
	private String dataCustMobile;
	private String dataMoneyTotal;
	private String dataRmbDeposit;
	private String dataUsDeposit;
	private String dataRmbInvestment;
	private String dataUsInvestment;
	private String dataFund;
	private String dataNationaldebt;
	private String dataPhysicalGold;
	private String dataFirstPay;
	private String dataQsLc;
	private String dataThreeStore;
	private String dataXtJh;
	private String dataLcManager;
	private String dataCreditCard;
	private String dataTxCust;
	private String dataYm;
	private Date dataImportTime;
	private Integer dataImportUser;
	private String dataHold1;
	private String dataHold2;
	private String dataHold3;
	private String dataRemark;
	
	

	public Integer getDataId() {
		return dataId;
	}



	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}



	public String getDataCustName() {
		return dataCustName;
	}



	public void setDataCustName(String dataCustName) {
		this.dataCustName = dataCustName;
	}



	public String getDataCustOrg() {
		return dataCustOrg;
	}



	public void setDataCustOrg(String dataCustOrg) {
		this.dataCustOrg = dataCustOrg;
	}



	public String getDataCustCodetype() {
		return dataCustCodetype;
	}



	public void setDataCustCodetype(String dataCustCodetype) {
		this.dataCustCodetype = dataCustCodetype;
	}



	public String getDataCustCode() {
		return dataCustCode;
	}



	public void setDataCustCode(String dataCustCode) {
		this.dataCustCode = dataCustCode;
	}



	public String getDataCustLevel() {
		return dataCustLevel;
	}



	public void setDataCustLevel(String dataCustLevel) {
		this.dataCustLevel = dataCustLevel;
	}



	public String getDataVipCode() {
		return dataVipCode;
	}



	public void setDataVipCode(String dataVipCode) {
		this.dataVipCode = dataVipCode;
	}



	public String getDataCardType() {
		return dataCardType;
	}



	public void setDataCardType(String dataCardType) {
		this.dataCardType = dataCardType;
	}



	public String getDataCustAddress() {
		return dataCustAddress;
	}



	public void setDataCustAddress(String dataCustAddress) {
		this.dataCustAddress = dataCustAddress;
	}



	public String getDataCustZipcode() {
		return dataCustZipcode;
	}



	public void setDataCustZipcode(String dataCustZipcode) {
		this.dataCustZipcode = dataCustZipcode;
	}



	public String getDataCustAreacode() {
		return dataCustAreacode;
	}



	public void setDataCustAreacode(String dataCustAreacode) {
		this.dataCustAreacode = dataCustAreacode;
	}



	public String getDataCustHomephone() {
		return dataCustHomephone;
	}



	public void setDataCustHomephone(String dataCustHomephone) {
		this.dataCustHomephone = dataCustHomephone;
	}



	public String getDataCustOfficephone() {
		return dataCustOfficephone;
	}



	public void setDataCustOfficephone(String dataCustOfficephone) {
		this.dataCustOfficephone = dataCustOfficephone;
	}



	public String getDataCustMobile() {
		return dataCustMobile;
	}



	public void setDataCustMobile(String dataCustMobile) {
		this.dataCustMobile = dataCustMobile;
	}



	public String getDataMoneyTotal() {
		return dataMoneyTotal;
	}



	public void setDataMoneyTotal(String dataMoneyTotal) {
		this.dataMoneyTotal = dataMoneyTotal;
	}



	public String getDataRmbDeposit() {
		return dataRmbDeposit;
	}



	public void setDataRmbDeposit(String dataRmbDeposit) {
		this.dataRmbDeposit = dataRmbDeposit;
	}



	public String getDataUsDeposit() {
		return dataUsDeposit;
	}



	public void setDataUsDeposit(String dataUsDeposit) {
		this.dataUsDeposit = dataUsDeposit;
	}



	public String getDataRmbInvestment() {
		return dataRmbInvestment;
	}



	public void setDataRmbInvestment(String dataRmbInvestment) {
		this.dataRmbInvestment = dataRmbInvestment;
	}



	public String getDataUsInvestment() {
		return dataUsInvestment;
	}



	public void setDataUsInvestment(String dataUsInvestment) {
		this.dataUsInvestment = dataUsInvestment;
	}



	public String getDataFund() {
		return dataFund;
	}



	public void setDataFund(String dataFund) {
		this.dataFund = dataFund;
	}



	public String getDataNationaldebt() {
		return dataNationaldebt;
	}



	public void setDataNationaldebt(String dataNationaldebt) {
		this.dataNationaldebt = dataNationaldebt;
	}



	public String getDataPhysicalGold() {
		return dataPhysicalGold;
	}



	public void setDataPhysicalGold(String dataPhysicalGold) {
		this.dataPhysicalGold = dataPhysicalGold;
	}



	public String getDataFirstPay() {
		return dataFirstPay;
	}



	public void setDataFirstPay(String dataFirstPay) {
		this.dataFirstPay = dataFirstPay;
	}



	public String getDataQsLc() {
		return dataQsLc;
	}



	public void setDataQsLc(String dataQsLc) {
		this.dataQsLc = dataQsLc;
	}



	public String getDataThreeStore() {
		return dataThreeStore;
	}



	public void setDataThreeStore(String dataThreeStore) {
		this.dataThreeStore = dataThreeStore;
	}



	public String getDataXtJh() {
		return dataXtJh;
	}



	public void setDataXtJh(String dataXtJh) {
		this.dataXtJh = dataXtJh;
	}



	public String getDataLcManager() {
		return dataLcManager;
	}



	public void setDataLcManager(String dataLcManager) {
		this.dataLcManager = dataLcManager;
	}



	public String getDataCreditCard() {
		return dataCreditCard;
	}



	public void setDataCreditCard(String dataCreditCard) {
		this.dataCreditCard = dataCreditCard;
	}



	public String getDataTxCust() {
		return dataTxCust;
	}



	public void setDataTxCust(String dataTxCust) {
		this.dataTxCust = dataTxCust;
	}



	public Date getDataImportTime() {
		return dataImportTime;
	}



	public void setDataImportTime(Date dataImportTime) {
		this.dataImportTime = dataImportTime;
	}



	public Integer getDataImportUser() {
		return dataImportUser;
	}



	public void setDataImportUser(Integer dataImportUser) {
		this.dataImportUser = dataImportUser;
	}



	public String getDataHold1() {
		return dataHold1;
	}



	public void setDataHold1(String dataHold1) {
		this.dataHold1 = dataHold1;
	}



	public String getDataHold2() {
		return dataHold2;
	}



	public void setDataHold2(String dataHold2) {
		this.dataHold2 = dataHold2;
	}



	public String getDataHold3() {
		return dataHold3;
	}



	public void setDataHold3(String dataHold3) {
		this.dataHold3 = dataHold3;
	}



	public String getDataRemark() {
		return dataRemark;
	}



	public void setDataRemark(String dataRemark) {
		this.dataRemark = dataRemark;
	}


	

	public String getDataYm() {
		return dataYm;
	}



	public void setDataYm(String dataYm) {
		this.dataYm = dataYm;
	}



	@Override
	public Object mapRow(ResultSet rs, int rownum) throws SQLException {
		DataDetails dataDetails = new DataDetails();
		dataDetails.setDataCardType(DataUtils.getStringK(rs.getString("data_card_type")));
		dataDetails.setDataCreditCard(DataUtils.getStringK(rs.getString("data_credit_card")));
		dataDetails.setDataCustAddress(DataUtils.getStringK(rs.getString("data_cust_address")));
		dataDetails.setDataCustAreacode(DataUtils.getStringK(rs.getString("data_cust_areacode")));
		dataDetails.setDataCustCode(DataUtils.getStringK(rs.getString("data_cust_code")));
		dataDetails.setDataCustCodetype(DataUtils.getStringK(rs.getString("data_cust_codetype")));
		dataDetails.setDataCustHomephone(DataUtils.getStringK(rs.getString("data_cust_homephone")));
		dataDetails.setDataCustLevel(DataUtils.getStringK(rs.getString("data_cust_level")));
		dataDetails.setDataCustMobile(DataUtils.getStringK(rs.getString("data_cust_mobile")));
		dataDetails.setDataCustName(DataUtils.getStringK(rs.getString("data_cust_name")));
		dataDetails.setDataCustOfficephone(DataUtils.getStringK(rs.getString("data_cust_officephone")));
		dataDetails.setDataCustOrg(DataUtils.getStringK(rs.getString("data_cust_org")));
		dataDetails.setDataCustZipcode(DataUtils.getStringK(rs.getString("data_cust_zipcode")));
		dataDetails.setDataFirstPay(DataUtils.getStringK(rs.getString("data_first_pay")));
		dataDetails.setDataFund(DataUtils.getStringK(rs.getString("data_fund")));
		dataDetails.setDataHold1(DataUtils.getStringK(rs.getString("data_hold1")));
		dataDetails.setDataHold2(DataUtils.getStringK(rs.getString("data_hold2")));
		dataDetails.setDataHold3(DataUtils.getStringK(rs.getString("data_hold3")));
		dataDetails.setDataId(DataUtils.getInt(rs.getInt("data_id")));
		dataDetails.setDataYm(DataUtils.getStringK(rs.getString("data_ym")));
		dataDetails.setDataImportTime(rs.getTimestamp("data_import_time"));
		dataDetails.setDataImportUser(DataUtils.getInt(rs.getInt("data_import_user")));
		dataDetails.setDataLcManager(DataUtils.getStringK(rs.getString("data_lc_manager")));
		dataDetails.setDataMoneyTotal(DataUtils.getStringK(rs.getString("data_money_total")));
		dataDetails.setDataNationaldebt(DataUtils.getStringK(rs.getString("data_nationaldebt")));
		dataDetails.setDataPhysicalGold(DataUtils.getStringK(rs.getString("data_physical_gold")));
		dataDetails.setDataQsLc(DataUtils.getStringK(rs.getString("data_qs_lc")));
		dataDetails.setDataRemark(DataUtils.getStringK(rs.getString("data_remark")));
		dataDetails.setDataRmbDeposit(DataUtils.getStringK(rs.getString("data_rmb_deposit")));
		dataDetails.setDataRmbInvestment(DataUtils.getStringK(rs.getString("data_rmb_investment")));
		dataDetails.setDataThreeStore(DataUtils.getStringK(rs.getString("data_three_store")));
		dataDetails.setDataTxCust(DataUtils.getStringK(rs.getString("data_tx_cust")));
		dataDetails.setDataUsDeposit(DataUtils.getStringK(rs.getString("data_us_deposit")));
		dataDetails.setDataUsInvestment(DataUtils.getStringK(rs.getString("data_us_investment")));
		dataDetails.setDataVipCode(DataUtils.getStringK(rs.getString("data_vip_code")));
		dataDetails.setDataXtJh(DataUtils.getStringK(rs.getString("data_xt_jh")));
		return dataDetails;
	}

}
