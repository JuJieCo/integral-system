package com.jujie.data.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jujie.data.DataDetails;
import com.jujie.data.dao.DataDetailsDaoImpl;
import com.jujie.util.page.Page;

public class DataDetailsServerImpl {

	private DataDetailsDaoImpl dataDetailsDao;

	public DataDetailsDaoImpl getDataDetailsDao() {
		return dataDetailsDao;
	}

	public void setDataDetailsDao(DataDetailsDaoImpl dataDetailsDao){
		this.dataDetailsDao = dataDetailsDao;
	}
	
	@SuppressWarnings("unused")
	public void incrementalImport(String ym,List<DataDetails> list) throws Exception {
		List<DataDetails> addList = new ArrayList<DataDetails>();
		List<DataDetails> updateList = new ArrayList<DataDetails>();
		int i = 0 ;
		for (DataDetails dataDetails : list) {
			DataDetails ds = dataDetailsDao.findDataDetailsByNameCode(ym, dataDetails.getDataCustName(), dataDetails.getDataCustCode());
		 	if(ds!=null){
				dataDetails.setDataId(ds.getDataId());
				updateList.add(dataDetails);
			}else{
				addList.add(dataDetails);
			}
		}
		dataDetailsDao.addDataDetails(addList);
		dataDetailsDao.updateDataDetails(updateList);
	} 
	
	public void basicImporting(String ym,List<DataDetails> list) throws Exception {
		dataDetailsDao.deleteDataDetails(ym);
		dataDetailsDao.addDataDetails(list);
	} 
	
	public List<DataDetails> queryAllDataDetailsByYM(String ym) throws Exception { 
		return dataDetailsDao.findAllDataDetailsByYM(ym);
	}
	
	public DataDetails queryDataDetailsByNameCode(String ym,String name,String code) throws Exception {
		return dataDetailsDao.findDataDetailsByNameCode(ym, name, code);
	}
	
	public void updateDataDetailsStatus(int id,String status) throws Exception {
		dataDetailsDao.updateDataDetailsStatus(id, status);
	}
	
	public List<DataDetails> queryAllDataDetailsByCond(Page page,Object[] objs) throws Exception {
		return dataDetailsDao.findAllDataDetailsByCond(page, objs);
	}
	
	public List findReprotForCustem() throws Exception {
		return dataDetailsDao.findReprotForCustem();
	}
	public List findReprotForMoneyChang() throws Exception {
		return dataDetailsDao.findReprotForMoneyChang();
	}
	public DataDetails queryDataDetailsByID(int id) throws Exception {
		return dataDetailsDao.findDataDetailsByID(id);
	}
	
	public void updateDataDetails(DataDetails dataDetails) throws Exception {
		dataDetailsDao.updateDataDetails(dataDetails);
	}
	
	
	
	
	public void updateTempTable() throws Exception {
		dataDetailsDao.updataTabel();
		dataDetailsDao.updataTabel1();
	}
}
