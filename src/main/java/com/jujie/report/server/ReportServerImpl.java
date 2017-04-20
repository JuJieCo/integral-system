package com.jujie.report.server;

import java.util.ArrayList;
import java.util.List;

import com.jujie.data.DataDetails;
import com.jujie.report.QueryDate;
import com.jujie.report.dao.ReportDaoImpl;
import com.jujie.util.page.Page;

public class ReportServerImpl {

	private ReportDaoImpl reportDao;


	@SuppressWarnings("unused")
	public void incrementalImport(String ym,List<DataDetails> list) throws Exception {
		List<DataDetails> addList = new ArrayList<DataDetails>();
		List<DataDetails> updateList = new ArrayList<DataDetails>();
		int i = 0 ;
		for (DataDetails dataDetails : list) {
			DataDetails ds = reportDao.findDataDetailsByNameCode(ym, dataDetails.getDataCustName(), dataDetails.getDataCustCode());
		 	if(ds!=null){
				dataDetails.setDataId(ds.getDataId());
				updateList.add(dataDetails);
			}else{
				addList.add(dataDetails);
			}
		}
		reportDao.addDataDetails(addList);
		reportDao.updateDataDetails(updateList);
	} 
	
	public void basicImporting(String ym,List<DataDetails> list) throws Exception {
		reportDao.deleteDataDetails(ym);
		reportDao.addDataDetails(list);
	} 
	
	public List<DataDetails> queryAllDataDetailsByYM(String ym) throws Exception { 
		return reportDao.findAllDataDetailsByYM(ym);
	}
	
	public DataDetails queryDataDetailsByNameCode(String ym,String name,String code) throws Exception {
		return reportDao.findDataDetailsByNameCode(ym, name, code);
	}
	
	public void updateDataDetailsStatus(int id,String status) throws Exception {
		reportDao.updateDataDetailsStatus(id, status);
	}
	
	public List<DataDetails> queryAllDataDetailsByCond(Page page,Object[] objs) throws Exception {
		return reportDao.findAllDataDetailsByCond(page, objs);
	}
	
	public DataDetails queryDataDetailsByID(int id) throws Exception {
		return reportDao.findDataDetailsByID(id);
	}
	
	public void updateDataDetails(DataDetails dataDetails) throws Exception {
		reportDao.updateDataDetails(dataDetails);
	}

	public ReportDaoImpl getReportDao() {
		return reportDao;
	}

	public void setReportDao(ReportDaoImpl reportDao) {
		this.reportDao = reportDao;
	}

	public List<DataDetails> queryDateForDetails(Page page, Object[] obj) {
		return reportDao.findAllDetails(obj,page);
	}

	public List<DataDetails> queryDetailsByTime(Page page, Object[] objs) {
		return reportDao.findAllDetailsByTime(objs,page);
	}
	public List<DataDetails> queryDetailsByAll(Page page, Object[] objs) {
		return reportDao.findAllDetailsByAll(objs,page);
	}
	public List<DataDetails> queryDetailsByHonest(Page page, Object[] objs) {
		return reportDao.findAllDetailsByHonest(objs,page);
	}
}
