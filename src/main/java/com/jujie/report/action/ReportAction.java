package com.jujie.report.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jujie.data.DataDetails;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.report.QueryDate;
import com.jujie.report.server.ReportServerImpl;
import com.jujie.user.User;
import com.jujie.util.DataUtils;
import com.jujie.util.page.Page;

@SuppressWarnings("serial")
public class ReportAction extends BaseActionSupper {
    private DataDetails dataDetails;
    private String ym;
    private String s_token;  
    private Page page;
	public String queryDataDetailsByCond(){
		ReportServerImpl server = (ReportServerImpl)this.getService("reportServer");
		if(dataDetails!=null){
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDateForDetails(page, new Object[]{
						dataDetails.getDataYm()
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			page = new Page(1);
		try {
			Date d=new Date();
			SimpleDateFormat sf=new SimpleDateFormat("yyyyMM");
			List<DataDetails> list = server.queryDateForDetails(page, new Object[]{sf.format(d)});
			this.getCxt().put("dataList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return "reportData";
	}
	
	public String queryByAccLevel(){
		ReportServerImpl server = (ReportServerImpl)this.getService("reportServer");
		String acclevel = request.getParameter("acclevel");
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryAllDataDetailsByCond(page, new Object[]{
						null,acclevel,null
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return "acclevel";
	}
	public String queryDetailsByTime(){
		ReportServerImpl server = (ReportServerImpl)this.getService("reportServer");
		if(dataDetails!=null){
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDetailsByTime(page, new Object[]{
						dataDetails.getDataCustName(),dataDetails.getDataCreditCard(),dataDetails.getDataCustLevel(),dataDetails.getDataYm(),dataDetails.getDataHold1()			
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{	
		
		if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDetailsByTime(page, new Object[]{
						null,null,null
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "assets";
	}
	public String queryHonest(){
		ReportServerImpl server = (ReportServerImpl)this.getService("reportServer");
		if(dataDetails!=null){
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDetailsByHonest(page, new Object[]{
						dataDetails.getDataYm(),dataDetails.getDataHold1(),dataDetails.getDataCustName(),dataDetails.getDataCustLevel()				
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDetailsByHonest(page, new Object[]{
						null,null,null
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "honest";
	}
	public List<DataDetails> encopyDataDetails(List<List<List<String>>> srcList){
		User sysUser = (User)session.get("sessionUser");
		List<DataDetails> list = new ArrayList<DataDetails>();
		if(srcList!=null&&srcList.size()>0){
			for (List<List<String>> rcList : srcList) {
				for(int i = 3 ; i < rcList.size() ; i++ ){
					System.out.println("row:"+i);
					int n = 0 ;
					DataDetails  dataDetails = new DataDetails();
					dataDetails.setDataCustName(rcList.get(i).get(n++));
					dataDetails.setDataCustOrg(rcList.get(i).get(n++));
					dataDetails.setDataCustCodetype(rcList.get(i).get(n++));
					String custCode = rcList.get(i).get(n++);
					if(custCode!=null&&!"".equals(custCode)){
						if(custCode.startsWith("_")){
							custCode = custCode.substring(1, custCode.length());
						}
					}
					dataDetails.setDataCustCode(custCode);
					dataDetails.setDataCustLevel(rcList.get(i).get(n++));
					dataDetails.setDataVipCode(rcList.get(i).get(n++));
					dataDetails.setDataCardType(rcList.get(i).get(n++));
					dataDetails.setDataCustAddress(rcList.get(i).get(n++));
					dataDetails.setDataCustZipcode(rcList.get(i).get(n++));
					String areacode = rcList.get(i).get(n++);
					if(areacode!=null&&!"".equals(areacode)){
						areacode = "0"+areacode;
					}
					dataDetails.setDataCustAreacode(areacode);
					String homephone = rcList.get(i).get(n++);
					if(homephone!=null&&!"".equals(homephone)){
						if(homephone.startsWith("29")){
							homephone = homephone.replaceFirst("29", "029-");
						}
					}
					dataDetails.setDataCustHomephone(homephone);
					String officephone = rcList.get(i).get(n++);
					if(officephone!=null&&!"".equals(officephone)){
						if(officephone.startsWith("29")){
							officephone = officephone.replaceFirst("29", "029-");
						}
					}
					dataDetails.setDataCustOfficephone(officephone);
					String mobile = rcList.get(i).get(n++);
					if(mobile!=null&&!"".equals(mobile)){
						if(mobile.startsWith("_")){
							mobile = mobile.substring(1, mobile.length());
						}
					}
					dataDetails.setDataCustMobile(mobile);
					dataDetails.setDataMoneyTotal(rcList.get(i).get(n++));
					dataDetails.setDataRmbDeposit(rcList.get(i).get(n++));
					dataDetails.setDataUsDeposit(rcList.get(i).get(n++));
					dataDetails.setDataRmbInvestment(rcList.get(i).get(n++));
					dataDetails.setDataUsInvestment(rcList.get(i).get(n++));
					dataDetails.setDataFund(rcList.get(i).get(n++));
					dataDetails.setDataNationaldebt(rcList.get(i).get(n++));
					dataDetails.setDataPhysicalGold(rcList.get(i).get(n++));
					dataDetails.setDataFirstPay(rcList.get(i).get(n++));
					dataDetails.setDataQsLc(rcList.get(i).get(n++));
					dataDetails.setDataThreeStore(rcList.get(i).get(n++));
					dataDetails.setDataXtJh(rcList.get(i).get(n++));
					dataDetails.setDataLcManager(rcList.get(i).get(n++));
					try{
						dataDetails.setDataCreditCard(rcList.get(i).get(n++));
					}catch(Exception e){
						dataDetails.setDataCreditCard("");
					}
					try{
						dataDetails.setDataTxCust(rcList.get(i).get(n++));
					}catch(Exception e){
						dataDetails.setDataTxCust("");
					}
					dataDetails.setDataHold1("1");

					dataDetails.setDataYm(DataUtils.getStringK(ym));
					dataDetails.setDataImportTime(new Date());
					dataDetails.setDataImportUser(sysUser.getSysUserId());

					list.add(dataDetails);
				}
			}
		}
		return list;
	}
	
	//综合查询
	public String queryDetailsByAll(){
		ReportServerImpl server = (ReportServerImpl)this.getService("reportServer");
		if(dataDetails!=null){
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryDetailsByAll(page, new Object[]{
						dataDetails.getDataMoneyTotal(),dataDetails.getDataHold1(),dataDetails.getDataRmbDeposit(),dataDetails.getDataHold2(),
						dataDetails.getDataUsDeposit(),dataDetails.getDataHold3(),dataDetails.getDataRmbInvestment(),dataDetails.getDataRemark(),
						dataDetails.getDataUsInvestment(),dataDetails.getDataVipCode(),dataDetails.getDataThreeStore(),dataDetails.getDataCardType(),
						dataDetails.getDataFirstPay(),dataDetails.getDataCustZipcode(),dataDetails.getDataCustLevel(),dataDetails.getDataYm()
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			page = new Page(1);
		try {
			List<DataDetails> list = server.queryDetailsByAll(page, new Object[]{null,null,null});
			this.getCxt().put("dataList", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
			return "querys";
	}
	
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public DataDetails getDataDetails() {
		return dataDetails;
	}

	public void setDataDetails(DataDetails dataDetails) {
		this.dataDetails = dataDetails;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	
	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}
	



}
