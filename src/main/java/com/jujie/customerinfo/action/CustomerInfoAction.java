package com.jujie.customerinfo.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.jujie.agence.Agence;
import com.jujie.agence.server.AgenceServerImpl;
import com.jujie.customerinfo.CustomerInfo;
import com.jujie.customerinfo.server.CustomerInfoServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.user.User;
import com.jujie.user.server.UserServerImpl;
import com.jujie.util.DataUtils;
import com.jujie.util.page.Page;

public class CustomerInfoAction extends BaseActionSupper{
	
	private static final long serialVersionUID = 1L;
	
	private List<CustomerInfo> customerInfoList;
	
	private CustomerInfo customerInfo;
	private String s_token;
	private Page page;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<CustomerInfo> getCustomerInfoList() {
		return customerInfoList;
	}
	public void setCustomerInfoList(List<CustomerInfo> customerInfoList) {
		this.customerInfoList = customerInfoList;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	

	public String queryCustomerInfoList(){
		if(page==null){
			page = new Page(1);
		}
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		UserServerImpl userServer = (UserServerImpl) this.getService("userServer");
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		String returnVal = "";
		User sysUser = (User)session.get("sessionUser"); 
		String userId = null;
		String agenceIds = null;
		if(sysUser.getSysUserIsManger()==1){
			userId = sysUser.getSysUserId()+"";
		}else{
			List<Agence> agenceList = new ArrayList<Agence>();
			Agence agence = new Agence();
			agence.setAgenceId(sysUser.getSysUserAgence().getAgenceId());
			agenceList.add(agence);
			try {
				agenceList.addAll(agenceServer.queryAgencePidList(sysUser.getSysUserAgence().getAgenceId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(agenceList!=null&&agenceList.size()>0){
				for(int i = 0 ; i < agenceList.size() ; i++ ){
					if(i==0){
						agenceIds = new String(agenceList.get(i).getAgenceId()+"");
					}else{
						agenceIds += ","+agenceList.get(i).getAgenceId();
					}
					
				}
			}
		}
		//String right = request.getParameter("right");
		try {
			String method2 = request.getParameter("method2");
		
			if(!"multiple".equals(method2)){
				if(customerInfo==null){
					Object[] objs = new  Object[]{null,null,null};
					customerInfoList = customerInfoServer.queryCustomerInfoList(objs,userId,agenceIds,page);
				}else{
					Object[] objs = new  Object[]{customerInfo.getCustName(),customerInfo.getCustStatus(), customerInfo.getCustLevel()};
					customerInfoList = customerInfoServer.queryCustomerInfoList(objs,userId,agenceIds,page);
				}
				returnVal = "customerinfolist";
			}else{
				if(customerInfo==null){
					Object[] objs = new  Object[]{null,null,null,null,null,null,null,null,null,userId,agenceIds};
					customerInfoList = customerInfoServer.multipleQueryCustomerInfoList(objs,userId,agenceIds,page);
				}else{
				
					String stimes = request.getParameter("stime");
					String etimes = request.getParameter("etime");
					String stime = stimes.replaceAll("-","");
					String etime = etimes.replaceAll("-","");

					Object[] objs = new  Object[]{customerInfo.getCustName(),customerInfo.getCustCode() ,
							customerInfo.getCustMobile(),
							customerInfo.getCustStatus(), customerInfo.getCustLevel(),
							customerInfo.getCustCpAgence(),customerInfo.getCustCpManager(),stime ,etime,userId,agenceIds};
					
					customerInfoList = customerInfoServer.multipleQueryCustomerInfoList(objs,userId,agenceIds,page);
				}
				returnVal = "multiplequery";
			}
			request.setAttribute("umglist", userServer.queryManagerUser());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if(right!=null&&"1".equals(right)){
//			request.setAttribute("right", "1");
//		}
		String noManager = request.getParameter("noManager");
		if(noManager==null){
			noManager="";				
		}
		request.setAttribute(noManager, "noManager");		
		request.setAttribute("getSysUserIsManger", sysUser.getSysUserIsManger());
		return returnVal;
	}
	
	
	
	
	
	
	public String queryCustomerInfoByID() {
		
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		String custId = request.getParameter("custId");
		String method= request.getParameter("method");
		String right= request.getParameter("right");
		try {
			if(!"".equals(method)&&method!=null){
				customerInfo = customerInfoServer.queryCustomerInfoByID(DataUtils.getInt(custId));
				if("show".equals(method)&&method!=null){
					return "showcustomerinfo";
				}
				if("showedit".equals(method)&&method!=null){
					request.setAttribute("editsub", "1");
					customerInfo = customerInfoServer.queryCustomerInfoByID(DataUtils.getInt(custId));
					
					List<Agence> allAgence = customerInfoServer.queryAllAgence();
					List<User> allUser = customerInfoServer.queryAllCustCpManager();
					
					String method2 = request.getParameter("method2");
					request.setAttribute("method2", method2);
					request.setAttribute("right", right);
					request.setAttribute("allAgence", allAgence);
					request.setAttribute("allUser", allUser);
					
					return "updateofedit";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryCustomerInfoList();
	}
	
	
	
	
	
	public String showAdd(){
		User sysUser = (User)session.get("sessionUser"); 
		String userId = null;
		if(sysUser.getSysUserIsManger()==1){
			userId = sysUser.getSysUserId()+"";
		}
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		try {
			customerInfo = customerInfoServer.showAdd(userId);
			customerInfo.setCustCpManager(Integer.valueOf(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		request.setAttribute("custRegistTime",sdf.format(new Date()));
		request.setAttribute("editsub", "0");
		
		return "addofedit";
	}
	
	
	
	
	public String addCustomerInfo(){
		
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		try {
			if(customerInfo!=null){
				customerInfoServer.addCustomerInfo(customerInfo);
				customerInfo=null;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.queryCustomerInfoList();
	}
	
	
	
	
	public String updateCustomerInfo(){
		
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		String right = request.getParameter("right");
		try {			
//			if("1".equals(right)&&right!=null){
//				Integer custCpManager =null;
//				custCpManager = customerInfoServer.getCustManagerByName(customerInfo.getSysUserName());
//				if(custCpManager!=null){
//					customerInfo.setCustCpManager(custCpManager);
//					customerInfoServer.updateCustomerInfo(customerInfo ,right);
//				}else{
//					String noManager= "名称为"+customerInfo.getSysUserName()+"的系统用户不存在，修改失败！";
//					request.setAttribute("noManager", noManager);
//					
//			        String method2 = request.getParameter("method2");
//					request.setAttribute("method2", method2);
//					request.setAttribute("right", right);
//					customerInfo=null;
//					return this.queryCustomerInfoList();
//				}
//			}else{
//				customerInfoServer.updateCustomerInfo(customerInfo ,right);
//			}
		
			customerInfoServer.updateCustomerInfo(customerInfo ,right);
	        String method2 = request.getParameter("method2");
			request.setAttribute("method2", method2);
			request.setAttribute("right", right);
			customerInfo=null;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		customerInfo=null;
		String method2 = request.getParameter("method2");
		request.setAttribute("method2", method2);
		request.setAttribute("right", right);
		return this.queryCustomerInfoList();
	}
	

	
	
	
	public String changeCustomerInfoStatus(){
		
		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		try {
			String custStatus = request.getParameter("custStatus");
			String custId = request.getParameter("custId");
			if("1".equals(custStatus)){
				custStatus="2";
			}else{
				custStatus="1";
			}
			customerInfoServer.changeCustomerInfoStatus(custStatus,custId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String method2 = request.getParameter("method2");
		request.setAttribute("method2", method2);
		return this.queryCustomerInfoList();
	}
	
	
	public String queryBirthdayReminder(){

		CustomerInfoServerImpl customerInfoServer = (CustomerInfoServerImpl) this.getService("customerInfoServer");
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		User sysUser = (User)session.get("sessionUser"); 
		String userId = null;
		String agenceIds = null;
		if(sysUser.getSysUserIsManger()==1){
			userId = sysUser.getSysUserId()+"";
		}else{
			List<Agence> agenceList = new ArrayList<Agence>();
			Agence agence = new Agence();
			agence.setAgenceId(sysUser.getSysUserAgence().getAgenceId());
			agenceList.add(agence);
			try {
				agenceList.addAll(agenceServer.queryAgencePidList(sysUser.getSysUserAgence().getAgenceId()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(agenceList!=null&&agenceList.size()>0){
				for(int i = 0 ; i < agenceList.size() ; i++ ){
					if(i==0){
						agenceIds = new String(agenceList.get(i).getAgenceId()+"");
					}else{
						agenceIds += ","+agenceList.get(i).getAgenceId();
					}					
				}
			}
		}try{			
			
			customerInfoList = customerInfoServer.queryBirthdayReminder(userId,agenceIds);
			Calendar calendar = Calendar.getInstance();
			String todayMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
			String nextWeekday =  String.valueOf(calendar.get(Calendar.DATE) + 7);
			
		
			if(nextWeekday.length()==1){
				nextWeekday= "0"+nextWeekday;
			}
			String dayOfNextWeek =todayMonth+nextWeekday;

			for (CustomerInfo customerInfo : customerInfoList) {
				if(!"".equals(customerInfo.getCustRemark())&&customerInfo.getCustRemark()!=null){
					Integer birthdayInt = Integer.valueOf(customerInfo.getCustRemark()); 
					if(birthdayInt<Integer.valueOf(dayOfNextWeek)){
						customerInfo.setCustHold("0");
					}else{
						customerInfo.setCustHold("1");
					}
					String birthday = customerInfo.getCustRemark().substring(0, 2)+"月"+customerInfo.getCustRemark().substring(2, 4)+"日";
					customerInfo.setCustRemark(birthday);
				}
			}
	 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "birthdayreminder";
	}
	


}
