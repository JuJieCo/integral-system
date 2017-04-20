package com.jujie.integral.server;

import java.util.List;

import com.jujie.integral.IntegraCusDetails;
import com.jujie.integral.dao.InteCusDetDaoImpl;
import com.jujie.util.page.Page;

public class InteCusDetServerImpl {
	
	private InteCusDetDaoImpl inteCusDetDaoImpl;

	 
	public void setInteCusDetDaoImpl(InteCusDetDaoImpl inteCusDetDaoImpl){
		this.inteCusDetDaoImpl = inteCusDetDaoImpl;
	}
	
	public Integer addIntegraCusDetails(IntegraCusDetails integraCusDetails) throws Exception {
	      return inteCusDetDaoImpl.addIntegraCusDetails(integraCusDetails);
	} 
	public void addIntegraCusDetails(final List<IntegraCusDetails> list) throws Exception {
	       inteCusDetDaoImpl.addIntegraCusDetails(list);
	} 
	
	public void updateIntegraCusDetails(List<IntegraCusDetails> list) throws Exception {
	       inteCusDetDaoImpl.updateIntegraCusDetails(list);
	} 
	
	public IntegraCusDetails findIntegraCusDetailsByID(Integer cust_details_id) throws Exception {
	       return inteCusDetDaoImpl.findIntegraCusDetailsByID(cust_details_id);
	} 
	
	public List<IntegraCusDetails> findAllIntegraCusDetails(Object[] objs,Page page) throws Exception {
	       return inteCusDetDaoImpl.findAllIntegraCusDetails(objs, page);
	} 
	public List<IntegraCusDetails> queryIntegraCusDetails(Integer cusMainId) throws Exception {
	       return inteCusDetDaoImpl.queryIntegraCusDetails(cusMainId);
	} 
	  
	 
	public void deleteIntegraCusDetails(Integer cust_details_id) throws Exception {
	       inteCusDetDaoImpl.deleteIntegraCusDetails(cust_details_id);
	} 
}
