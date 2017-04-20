package com.jujie.data.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jujie.data.DataDetails;
import com.jujie.data.server.DataDetailsServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.user.User;
import com.jujie.util.DataUtils;
import com.jujie.util.DownFileUtil;
import com.jujie.util.FileUtil;
import com.jujie.util.ImportExcel;
import com.jujie.util.page.Page;

@SuppressWarnings("serial")
public class DataDetailsAction extends BaseActionSupper {

	private File excelFile;
    private String excelFileContentType;
    private String excelFileFileName;

    private DataDetails dataDetails;
    
    private String ym;
    private String s_token;
    
    private Page page;

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

	public File getExcelFile() {
		return excelFile;
	}

	public void setExcelFile(File excelFile) {
		this.excelFile = excelFile;
	}

	public String getExcelFileContentType() {
		return excelFileContentType;
	}

	public void setExcelFileContentType(String excelFileContentType) {
		this.excelFileContentType = excelFileContentType;
	}

	public String getExcelFileFileName() {
		return excelFileFileName;
	}

	public void setExcelFileFileName(String excelFileFileName) {
		this.excelFileFileName = excelFileFileName;
	}
	
	public String getYm() {
		return ym;
	}

	public void setYm(String ym) {
		this.ym = ym;
	}

	public String importIncremental() {
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		String path = uploadExcel();
		if(path!=null){
			List<List<List<String>>> srcList = ImportExcel.readExcelData(path);
			try {
				server.incrementalImport(ym,encopyDataDetails(srcList));
				this.getCxt().put("result", 1);
				this.getCxt().put("rowNumber", srcList.get(0).size()-3);
			} catch (Exception e) {
				e.printStackTrace();
				this.getCxt().put("result", 0);
			}
		}
		return "import";
	}
	
	public String importBasice() {
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		String path = uploadExcel();
		if(path!=null){
			List<List<List<String>>> srcList = ImportExcel.readExcelData(path);
			try {
				server.basicImporting(ym, encopyDataDetails(srcList));
				this.getCxt().put("result", 1);
				this.getCxt().put("rowNumber", srcList.get(0).size()-3);
			} catch (Exception e) {
				e.printStackTrace();
				this.getCxt().put("result", 0);
			}
		}
		return "import";
	}
	
	public String editAjaxData(){
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		User sysUser = (User)session.get("sessionUser");
		try {
			DataDetails ds = server.queryDataDetailsByID(dataDetails.getDataId());
			
			ds.setDataCustLevel(dataDetails.getDataCustLevel());
			ds.setDataVipCode(dataDetails.getDataVipCode());
			ds.setDataCardType(dataDetails.getDataCardType());
			ds.setDataLcManager(dataDetails.getDataLcManager());
			ds.setDataCreditCard(dataDetails.getDataCreditCard());
			ds.setDataTxCust(dataDetails.getDataTxCust());
			
			ds.setDataMoneyTotal(dataDetails.getDataMoneyTotal());
			ds.setDataFirstPay(dataDetails.getDataFirstPay());
			ds.setDataQsLc(dataDetails.getDataQsLc());
			ds.setDataXtJh(dataDetails.getDataTxCust());
			
			ds.setDataRmbDeposit(dataDetails.getDataRmbDeposit());
			ds.setDataRmbInvestment(dataDetails.getDataRmbInvestment());
			ds.setDataUsDeposit(dataDetails.getDataUsDeposit());
			ds.setDataUsInvestment(dataDetails.getDataUsInvestment());
			
			ds.setDataFund(dataDetails.getDataFund());
			ds.setDataNationaldebt(dataDetails.getDataNationaldebt());
			ds.setDataPhysicalGold(dataDetails.getDataPhysicalGold());
			ds.setDataThreeStore(dataDetails.getDataThreeStore());

			ds.setDataId(dataDetails.getDataId());
			ds.setDataImportTime(new Date());
			ds.setDataImportUser(sysUser.getSysUserId());
			ds.setDataHold1("3");

			server.updateDataDetails(ds);
			
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String queryDataDetailsByCond(){
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		if(dataDetails!=null){
			if(page==null){
				page = new Page(1);
			}
			try {
				List<DataDetails> list = server.queryAllDataDetailsByCond(page, new Object[]{
						dataDetails.getDataYm(),dataDetails.getDataCustName(),dataDetails.getDataCustCode()
				});
				this.getCxt().put("dataList", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "write";
	}
	
	@SuppressWarnings("rawtypes")
	public String queryReport(){
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		 
		 	try {
		 		 List custemList=server.findReprotForCustem();
				 List moneyChangList=server.findReprotForMoneyChang();
				
				 this.getCxt().put("custemList", custemList);
				 this.getCxt().put("moneyChangList", moneyChangList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		 
		return "fxac";
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
	
	public String uploadExcel(){
		 String targetDirectory =servletContext.getRealPath("/upload/file");
         String fileName = FileUtil.resetFileName(excelFileFileName);
         File target = new File(targetDirectory,fileName); 
         if("application/vnd.ms-excel".equals(excelFileContentType)||"application/octet-stream".equals(excelFileContentType)){
        	 try{
     			  FileUtils.copyFile(excelFile, target);
     			  return target.getPath();
     		 } catch (IOException e) {
     			  e.printStackTrace();
     		 } 
         }
         return null;    
	}
	
	public String downTemplate(){
		try{
			String sysPath = servletContext.getRealPath("/");
			System.out.println(sysPath);
			DownFileUtil.getInstance().downFile(sysPath+"/upload/template/dataTemplate.xls", "dataTemplate.xls", response);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	
	//更新 新增加的3个
	public String updateTempTable(){
		DataDetailsServerImpl server = (DataDetailsServerImpl)this.getService("dataDetailsServer");
		try {
			server.updateTempTable();
			this.getCxt().put("resultUp", 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.getCxt().put("resultUp", 0);
		}
		
		return "import";
	}

}
