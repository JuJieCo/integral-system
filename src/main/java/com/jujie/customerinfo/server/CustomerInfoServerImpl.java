package com.jujie.customerinfo.server;

import java.util.List;

import com.jujie.agence.Agence;
import com.jujie.customerinfo.CustomerInfo;
import com.jujie.customerinfo.dao.CustomerInfoDaoImpl;
import com.jujie.user.User;
import com.jujie.util.page.Page;

public class CustomerInfoServerImpl {

	private CustomerInfoDaoImpl customerInfoDao;

	public void setCustomerInfoDao(CustomerInfoDaoImpl customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}
	
	
	
	
	public List<CustomerInfo> queryCustomerInfoList(Object[] objs, String userId ,String agenceIds,Page page)throws Exception{
		return customerInfoDao.queryCustomerInfoList(objs,userId,agenceIds,page);
	}
	
	public List<CustomerInfo> multipleQueryCustomerInfoList(Object[] objs,String userId ,String agenceIds,Page page)throws Exception{
		return customerInfoDao.multipleQueryCustomerInfoList(objs,userId,agenceIds,page);
	}
	
	public CustomerInfo queryCustomerInfoByID(Integer custId) throws Exception{
		return customerInfoDao.queryCustomerInfoByID(custId);
	}
	public List<Agence> queryAllAgence() throws Exception{
		return customerInfoDao.queryAllAgence();
	}
	public List<User> queryAllCustCpManager() throws Exception{
		return customerInfoDao.queryAllCustCpManager();
	}
	public void addCustomerInfo(CustomerInfo customerInfo) throws Exception {
		customerInfoDao.addCustomerInfo(customerInfo);
	}
	
	public void updateCustomerInfo(CustomerInfo customerInfo , String right) throws Exception {
		customerInfoDao.updateCustomerInfo(customerInfo,right);
	}
	
	public void changeCustomerInfoStatus(String custStatus, String custId) throws Exception {
		customerInfoDao.changeCustomerInfoStatus(custStatus,custId);
	}
	
	public CustomerInfo showAdd(String userId)throws Exception{
		return customerInfoDao.showAdd(userId);
	}
	public List<CustomerInfo> queryBirthdayReminder(String userId,String agenceIds)throws Exception{
		return customerInfoDao.queryBirthdayReminder(userId, agenceIds);
	}
//	public Integer getCustManagerByName(String sysUserName)throws Exception{
//		return customerInfoDao.getCustManagerByName(sysUserName);
//	}

}
