package com.jujie.integral.server;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jujie.agence.Agence;
import com.jujie.agence.dao.AgenceDAOImpl;
import com.jujie.customerinfo.CustomerInfo;
import com.jujie.customerinfo.dao.CustomerInfoDaoImpl;
import com.jujie.data.DataDetails;
import com.jujie.data.dao.DataDetailsDaoImpl;
import com.jujie.integral.IntegraCusDetails;
import com.jujie.integral.IntegraCusMain;
import com.jujie.integral.dao.BigdecimalChang;
import com.jujie.integral.dao.InteCusDetDaoImpl;
import com.jujie.integral.dao.IntegraCusMainDaoImpl;
import com.jujie.rules.Rules;
import com.jujie.rules.dao.RulesDAOImpl;
import com.jujie.user.User;
import com.jujie.user.dao.UserDaoImpl;

import com.jujie.util.DateUtils;
import com.jujie.util.page.Page;

public class IntegraCusMainServerImpl {

	private IntegraCusMainDaoImpl integraCusMainDao;
	private DataDetailsDaoImpl dataDetailsDao;//原始数据
 	private CustomerInfoDaoImpl customerInfoDao;//客户信息
    private RulesDAOImpl rulesDAO;//积分规则
    private InteCusDetDaoImpl inteCusDetDaoImpl;//积分明细
    private UserDaoImpl userDao;
    private AgenceDAOImpl agenceDAO;

	public void setAgenceDAO(AgenceDAOImpl agenceDAO) {
		this.agenceDAO = agenceDAO;
	}
	
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}
	 
	public void setInteCusDetDaoImpl(InteCusDetDaoImpl inteCusDetDaoImpl){
		this.inteCusDetDaoImpl = inteCusDetDaoImpl;
	}
	
	public void setRulesDAO(RulesDAOImpl rulesDAO) {
		this.rulesDAO = rulesDAO;
	}
 	
	public void setCustomerInfoDao(CustomerInfoDaoImpl customerInfoDao) {
		this.customerInfoDao = customerInfoDao;
	}
   public void setDataDetailsDao(DataDetailsDaoImpl dataDetailsDao){
		this.dataDetailsDao = dataDetailsDao;
	}
	

	 
	public void setIntegraCusMainDao(IntegraCusMainDaoImpl integraCusMainDao){
		this.integraCusMainDao = integraCusMainDao;
	}
	
	public Integer addIntegraCusMain(String ym,Page page) throws Exception {
		  
		   List<Rules> rulesList =rulesDAO.queryRulesList(null);
		   List<DataDetails>  dataDetailsList=dataDetailsDao.findAllDataDetailsByYM(ym);
		   List<IntegraCusDetails> cusDetailsList;
		   Integer ymInt = Integer.valueOf(ym)-1;
		   String ymString = ymInt.toString().substring(0,4)+"01";
		   Double detailsIntegral = null;
		   Double detailsYe;
		   CustomerInfo customerInfo;
		   List<IntegraCusMain> integraCusMainList=new ArrayList<IntegraCusMain>();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		    for (DataDetails dataDetails : dataDetailsList) {
		    	Integer sumIntegrOld = 0;
                if(!"".equals(dataDetails.getDataHold1())&&("1".equals(dataDetails.getDataHold1())||"3".equals(dataDetails.getDataHold1()))){
               	cusDetailsList=new ArrayList<IntegraCusDetails>();
			    customerInfo = customerInfoDao.queryCustomerInfo(dataDetails.getDataCustName(), dataDetails.getDataCustCode());
			    if(customerInfo!=null&&!"".equals(customerInfo.getCustId())&& customerInfo.getCustId()!=null){
				   DataDetails detailsLate=dataDetailsDao.findDataDetailsByNameCode(ymInt.toString(), dataDetails.getDataCustName(), dataDetails.getDataCustCode());
				   IntegraCusMain cusMain=integraCusMainDao.findCusMainByCustID(customerInfo.getCustId());
				   
				   if(BigdecimalChang.equ(dataDetails.getDataMoneyTotal(),"300000")>=0){
					   customerInfoDao.changeCustomerInfoStatus("1",customerInfo.getCustId().toString());
					} 
				   
				if(detailsLate!=null){
			    	 for (Rules rules : rulesList) {
			    		IntegraCusDetails integraCusDetails=new IntegraCusDetails();
			    		integraCusDetails.setRules_id(rules.getRulesId());
			    		rules.setRulesCoefficient(BigdecimalChang.returnBigdecimal(8,Double.toString(BigdecimalChang.div(1,BigdecimalChang.mul(1, rules.getRulesCpFunds())))));
			    		integraCusDetails.setIntegraCusMain(cusMain);
			    	    integraCusDetails.setCust_details_integral_date(sdf.parse(sdf.format(new Date())));
			     	 
			    		if("001".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbDeposit())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataRmbDeposit(), detailsLate.getDataRmbDeposit());
			    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	  	}else if("002".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsDeposit())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataUsDeposit(), detailsLate.getDataUsDeposit());
			    			 detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	
			    		}else if("003".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbInvestment())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataRmbInvestment(), detailsLate.getDataRmbInvestment());
			    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	
			    		}else if("004".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsInvestment())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataUsInvestment(), detailsLate.getDataUsInvestment());
			    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	
			    		}else if("005".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataFund())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataFund(), detailsLate.getDataFund());
			    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	
				    	}else if("007".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataPhysicalGold())){
			    			detailsYe=BigdecimalChang.sub(dataDetails.getDataPhysicalGold(), detailsLate.getDataPhysicalGold());
			    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	
				    	}
			    	 	if(detailsIntegral!=null&&!"".equals(detailsIntegral)){
			    	 		    BigDecimal bd = new BigDecimal(Double.toString(detailsIntegral));
					    		bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
					    		if(!"0".equals(bd.toString())){
					    			integraCusDetails.setCust_details_integral(Integer.valueOf(bd.toString()));
						    		cusDetailsList.add(integraCusDetails);
					    		}
					    		
			    		 }
			     	}
			    	 if(cusDetailsList!=null&&cusDetailsList.size()>0){
			    		   if("3".equals(dataDetails.getDataHold1())){
			    			    sumIntegrOld=inteCusDetDaoImpl.sumIntegraByCustmainId(cusMain.getCust_main_id());
			    			 	inteCusDetDaoImpl.deleteCusDetailsByYm(cusMain.getCust_main_id(),sdf.format(new Date()));
				               }
						    inteCusDetDaoImpl.addIntegraCusDetails(cusDetailsList);
						    
						    Double sumInteCus=BigdecimalChang.sub(inteCusDetDaoImpl.sumIntegraByCustmainId(cusMain.getCust_main_id()).toString(),sumIntegrOld.toString());
					        
						    IntegraCusMain inMain =new IntegraCusMain();
					    	inMain.setCust_main_id(cusMain.getCust_main_id());
					    
					    	Double integralRemains=BigdecimalChang.add(sumInteCus.toString(),cusMain.getCust_integral_remain().toString());
					    	if(integralRemains<0){
					    		 integralRemains=0.00;
					    	 }
					    	
					    	BigDecimal bdd = new BigDecimal(Double.toString(integralRemains));
					    	bdd = bdd.setScale(0, BigDecimal.ROUND_HALF_UP);
					    	inMain.setCust_integral_remain(Integer.valueOf(bdd.toString()));
				    	    inMain.setCust_main_status(1);
					    	inMain.setNew_integral_date(DateUtils.getTimestamp(new Date()));
					    	integraCusMainList.add(inMain);
						}
					     dataDetailsDao.updateDataDetailsStatus(dataDetails.getDataId(),"2");
			   }else{
				   for (Rules rules : rulesList) {
			    		IntegraCusDetails integraCusDetails=new IntegraCusDetails();
			    		integraCusDetails.setRules_id(rules.getRulesId());
			    		integraCusDetails.setIntegraCusMain(cusMain);
			    		rules.setRulesCoefficient(BigdecimalChang.returnBigdecimal(7,Double.toString(BigdecimalChang.div(1,BigdecimalChang.mul(1, rules.getRulesCpFunds())))));
			    	    integraCusDetails.setCust_details_integral_date(sdf.parse(sdf.format(new Date())));
				   if("001".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbDeposit())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataRmbDeposit(),"");
		    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
		    	 	}else if("002".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsDeposit())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataUsDeposit(),"");
		    			 detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	
		    		}else if("003".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbInvestment())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataRmbInvestment(),"");
		    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	
		    		}else if("004".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsInvestment())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataUsInvestment(),"");
		    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	
		    		}else if("005".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataFund())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataFund(),"");
		    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	
			    	}else if("007".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataPhysicalGold())){
		    			detailsYe=BigdecimalChang.add(dataDetails.getDataPhysicalGold(),"");
		    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
			    	
			    	}
				    if(detailsIntegral!=null&&!"".equals(detailsIntegral)){
		    			BigDecimal bd = new BigDecimal(Double.toString(detailsIntegral));
			    		bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
			    		
			    		if(!"0".equals(bd.toString())){
			    		integraCusDetails.setCust_details_integral(Integer.valueOf(bd.toString()));
			    		cusDetailsList.add(integraCusDetails);
			    		
			    		}
	    	    	}
			     }
				   
				   if(cusDetailsList!=null&&cusDetailsList.size()>0){
					   if("3".equals(dataDetails.getDataHold1())){
		    				//detailsIntegral=BigdecimalChang.sub(BigdecimalChang.returnBigdecimalbydouble(detailsIntegral),BigdecimalChang.returnBigdecimal(inteCusDetDaoImpl.sumIntegraByCustmainId(cusMain.getCust_main_id()).toString()));
						   sumIntegrOld=inteCusDetDaoImpl.sumIntegraByCustmainId(cusMain.getCust_main_id());
						   inteCusDetDaoImpl.deleteCusDetailsByYm(cusMain.getCust_main_id(),sdf.format(new Date()));
			               }
			            inteCusDetDaoImpl.addIntegraCusDetails(cusDetailsList);
			            
			            Double sumInteCus=BigdecimalChang.sub(inteCusDetDaoImpl.sumIntegraByCustmainId(cusMain.getCust_main_id()).toString(),sumIntegrOld.toString());
				        IntegraCusMain inMain =new IntegraCusMain();
				    	inMain.setCust_main_id(cusMain.getCust_main_id());
				    	Double integralRemains=BigdecimalChang.add(sumInteCus.toString(),cusMain.getCust_integral_remain().toString());
				    	if(integralRemains<0){
				    		 integralRemains=0.00;
				    	 }
				    	BigDecimal bdd = new BigDecimal(Double.toString(integralRemains));
				    	bdd = bdd.setScale(0, BigDecimal.ROUND_HALF_UP);
				    	inMain.setCust_integral_remain(Integer.valueOf(bdd.toString()));
			    	    inMain.setCust_main_status(1);
				    	inMain.setNew_integral_date(DateUtils.getTimestamp(new Date()));
				    	integraCusMainList.add(inMain);
					}
				 dataDetailsDao.updateDataDetailsStatus(dataDetails.getDataId(),"2");
		     }
	    }else{
				   
				    customerInfo=new CustomerInfo();
				    customerInfo.setCustName(dataDetails.getDataCustName()); 
				    customerInfo.setCustCode(dataDetails.getDataCustCode());
					customerInfo.setCustAddress(dataDetails.getDataCustAddress());
					customerInfo.setCustAreaCode(dataDetails.getDataCustAreacode()); 
					customerInfo.setCustHomePhone(dataDetails.getDataCustHomephone());
					customerInfo.setCustOfferPhone(dataDetails.getDataCustOfficephone()); 
					customerInfo.setCustMobile(dataDetails.getDataCustMobile());
					customerInfo.setCustZipCode(dataDetails.getDataCustZipcode());
					if(BigdecimalChang.equ(dataDetails.getDataMoneyTotal(), "300000")>=0){
						customerInfo.setCustStatus(1);
					}else{
						customerInfo.setCustStatus(2);
					}
					if(!"".equals(dataDetails.getDataCustCode())&&dataDetails.getDataCustCode().length()==18){
						String custCode=dataDetails.getDataCustCode();
						String year=custCode.substring(6,10);
						String month=custCode.substring(10,12);
						String day=custCode.substring(12,14);
						String birthday=year+"-"+month+"-"+day;
						customerInfo.setCustBirthday(DateUtils.parse(birthday));
					}
					if(!"".equals(dataDetails.getDataCustLevel())){
						if("白金".equals(dataDetails.getDataCustLevel())){
							customerInfo.setCustLevel(1); 
						}else if("白银".equals(dataDetails.getDataCustLevel())){
							customerInfo.setCustLevel(2); 
						}else if("黑金".equals(dataDetails.getDataCustLevel())){
							customerInfo.setCustLevel(3); 
						}else if("黄金".equals(dataDetails.getDataCustLevel())){
							customerInfo.setCustLevel(4); 
						}
						 
					}
				 	customerInfo.setCustRegistTime(DateUtils.getTimestamp(new Date())); 
				 	if(!"".equals(dataDetails.getDataLcManager())&&dataDetails.getDataLcManager()!=null){
				 		List<User> user =userDao.queryAllUser(dataDetails.getDataLcManager());
	                    if(user!=null&&user.size()>0){
	                    	User uuser = user.get(0);
	                    	customerInfo.setCustCpManager(uuser.getSysUserId());
	                    }
				 	}
				  	Object[] agenceobj = new Object[]{dataDetails.getDataCustOrg(),null,null};
                    List<Agence> agenceList = agenceDAO.queryAgenceList(agenceobj);
                    if(agenceList!=null&&agenceList.size()>0){
                    	Agence agence = agenceList.get(0);
                    	customerInfo.setAgenceId(agence.getAgenceId());
                    }
                   	customerInfo.setCustHold(dataDetails.getDataHold1());
					customerInfo.setCustRemark(dataDetails.getDataRemark());
				   
					Integer customerid=customerInfoDao.addCustomerInfo(customerInfo);
					
					IntegraCusMain integraCusMain = new IntegraCusMain();
					integraCusMain.getIntegralCustomer().setCustId(customerid);
				    integraCusMain.setCust_main_time(Integer.valueOf(dataDetails.getDataYm()));
					integraCusMain.setCust_integral_totle(0);
					integraCusMain.setCust_integral_calls(0);
					integraCusMain.setCust_integral_remain(0);
				    integraCusMain.setNew_integral_date(DateUtils.getTimestamp(new Date()));
				    Integer cusid=integraCusMainDao.addIntegraCusMain(integraCusMain);
				    if(ymString.equals(ymInt.toString())){
				    	
				    }else{
				    	 
				    	for (Rules rules : rulesList) {
				    		IntegraCusDetails integraCusDetails=new IntegraCusDetails();
				    		integraCusDetails.setRules_id(rules.getRulesId());
				    		IntegraCusMain cusMain=new IntegraCusMain();
				    		cusMain.setCust_main_id(cusid);
				    		integraCusDetails.setIntegraCusMain(cusMain);
				    		rules.setRulesCoefficient(BigdecimalChang.returnBigdecimal(7,Double.toString(BigdecimalChang.div(1,BigdecimalChang.mul(1, rules.getRulesCpFunds())))));
				    		integraCusDetails.setCust_details_integral_date(sdf.parse(sdf.format(new Date())));
				     	 
				    		if("001".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbDeposit())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataRmbDeposit(),"");
				    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
				    	 	}else if("002".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsDeposit())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataUsDeposit(),"");
				    			 detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
					    	
				    		}else if("003".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataRmbInvestment())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataRmbInvestment(),"");
				    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
					    	
				    		}else if("004".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataUsInvestment())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataUsInvestment(),"");
				    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
					    	
				    		}else if("005".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataFund())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataFund(),"");
				    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
					    	
					    	}else if("007".equals(rules.getRulesHold())&&!"".equals(dataDetails.getDataPhysicalGold())){
				    			detailsYe=BigdecimalChang.add(dataDetails.getDataPhysicalGold(),"");
				    			detailsIntegral=BigdecimalChang.mul(detailsYe,rules.getRulesCoefficient());
					    	
					    	}
				    		if(detailsIntegral!=null&&!"".equals(detailsIntegral)){
				    			 
				    				BigDecimal bd = new BigDecimal(Double.toString(detailsIntegral));
						    		bd = bd.setScale(0, BigDecimal.ROUND_HALF_UP);
						    		if(!"0".equals(bd.toString())){
						    		integraCusDetails.setCust_details_integral(Integer.valueOf(bd.toString()));
						    		cusDetailsList.add(integraCusDetails);
						    		}
				    			
				    		}
				     	}
				    	if(cusDetailsList!=null&&cusDetailsList.size()>0){
				    		inteCusDetDaoImpl.addIntegraCusDetails(cusDetailsList);
					        IntegraCusMain inMain =new IntegraCusMain();
					    	inMain.setCust_main_id(cusid);
					    	inMain.setCust_integral_remain(inteCusDetDaoImpl.sumIntegraByCustmainId(cusid));
					    	inMain.setCust_main_status(1);
					    	inMain.setNew_integral_date(DateUtils.getTimestamp(new Date()));
					    	integraCusMainList.add(inMain);
					    }
				    }
				    dataDetailsDao.updateDataDetailsStatus(dataDetails.getDataId(),"2");
				    //N月条目积分 = [条目N月余额 - (条目N-1月余额)] * 单位积分
				    //N月总积分 = N月条目积分的和 + N-1月总积分结余
				   }
			   }
               
		  }
		    if(integraCusMainList!=null&&integraCusMainList.size()>0){
			       integraCusMainDao.updateIntegraCusMainByCusMain(integraCusMainList);
			  }
		    
			
		   return null;
	} 
 
	public void addIntegraCusMain(List<IntegraCusMain> list) throws Exception {
	       integraCusMainDao.addIntegraCusMain(list);
	} 
	public void updateIntegraCusMain(List<IntegraCusMain> list) throws Exception {
	       integraCusMainDao.updateIntegraCusMain(list);
	} 
	public void exchangCusMain(String remain ,String cus_id) throws Exception {
	       integraCusMainDao.exchangCusMain(remain,cus_id);
	} 
	public IntegraCusMain findIntegraCusMainByID(Integer cust_main_id) throws Exception {
	       return integraCusMainDao.findIntegraCusMainByID(cust_main_id);
	} 
	
	public List<IntegraCusMain> findAllIntegraCusMain(Object[] objs,Page page) throws Exception {
	       return integraCusMainDao.findAllIntegraCusMain(objs, page);
	} 
	public List<IntegraCusDetails> getIntegraCusDetailsBycustId(int cust_id) throws Exception {
	       return integraCusMainDao.getIntegraCusDetailsBycustId(cust_id);
	} 
	 
	public void deleteIntegraCusMain(Integer cust_main_id) throws Exception {
	       integraCusMainDao.deleteIntegraCusMain(cust_main_id);
	} 
}

