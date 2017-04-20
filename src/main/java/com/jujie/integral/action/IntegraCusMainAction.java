package com.jujie.integral.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import com.jujie.agence.Agence;
import com.jujie.agence.server.AgenceServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.integral.IntegraCusDetails;
import com.jujie.integral.IntegraCusMain;
import com.jujie.integral.server.InteCusDetServerImpl;
import com.jujie.integral.server.IntegraCusMainServerImpl;
import com.jujie.integral.util.DateJsonValue;
import com.jujie.util.DataUtils;
import com.jujie.util.page.Page;

@SuppressWarnings("serial")
public class IntegraCusMainAction extends BaseActionSupper {
	
	
	private IntegraCusMain integraCusMain;
	private List<IntegraCusMain>  integraCusMainList;
	List<Agence> agenceListagenceList = new ArrayList<Agence>();
	List<IntegraCusDetails> integraCusDetailsList=new ArrayList<IntegraCusDetails>();
    private Page page;
	
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	 public IntegraCusMain getIntegraCusMain() {
		return integraCusMain;
	}
	public void setIntegraCusMain(IntegraCusMain integraCusMain) {
		this.integraCusMain = integraCusMain;
	}
	public List<IntegraCusMain> getIntegraCusMainList() {
		return integraCusMainList;
	}
	public void setIntegraCusMainList(List<IntegraCusMain> integraCusMainList) {
		this.integraCusMainList = integraCusMainList;
	}
	
	
	public List<IntegraCusDetails> getIntegraCusDetailsList() {
		return integraCusDetailsList;
	}
	public void setIntegraCusDetailsList(
			List<IntegraCusDetails> integraCusDetailsList) {
		this.integraCusDetailsList = integraCusDetailsList;
	}
	public List<Agence> getAgenceListagenceList() {
		return agenceListagenceList;
	}
	public void setAgenceListagenceList(List<Agence> agenceListagenceList) {
		this.agenceListagenceList = agenceListagenceList;
	}
	public String queryAllIntegraCusMain() {
	 	if(page==null){
			page = new Page(1);
		}
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		Object[] agenceObjs = new Object[] { null, null, null };
		try {
			if (integraCusMain == null) {
				Object[] objs = new Object[] { null,null,null,null,null};
			 	integraCusMainList = integraCusMainServer.findAllIntegraCusMain(objs, page);
		
			} else {
				Object[] objs = new Object[] { integraCusMain.getIntegralCustomer().getCustName(),integraCusMain.getIntegralCustomer().getCustCode(),integraCusMain.getIntegralCustomer().getCustMobile(),integraCusMain.getIntegralCustomer().getCustStatus(),integraCusMain.getIntegralCustomer().getAgenceId()};
			 	integraCusMainList = integraCusMainServer.findAllIntegraCusMain(objs, page);
			}
		  agenceListagenceList = agenceServer.queryAgenceList(agenceObjs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 	return "list";
	}
	
	public String queryIntegraCusMainByID() {
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
		String cust_main_id = request.getParameter("cust_main_id");
		String method = request.getParameter("method");
		try {
		  if(!"".equals(method) && method!=null){
			if ("show".equals(method)&& method != null) {
				integraCusMain = integraCusMainServer.findIntegraCusMainByID(DataUtils.getInt(cust_main_id));
				return "showrules";
			}
			if ("showedit".equals(method)&& method != null) {
				request.setAttribute("editsub", "1");
				integraCusMain = integraCusMainServer.findIntegraCusMainByID(DataUtils.getInt(cust_main_id));
				request.setAttribute("rulesCreateTime","");
				return "updateofedit";
			
			   }
			 }
			} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusMain();
	}
	
	public String showAdd() {
		request.setAttribute("editsub", "0");

		return "addofedit";
	}
	public String addIntegraCusMain() {
	     IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");//积分主表
		 String ym =request.getParameter("ym");
		 try {
			 if(page==null){
					page = new Page(1);
					page.setPageSize(1000);
				}
			integraCusMainServer.addIntegraCusMain(ym,page);
			this.getCxt().put("result", 1);
		} catch (Exception e) {
			e.printStackTrace();
			this.getCxt().put("result", 0);
		}
		 return  "sumIntegraCusMain";
	}
	public String updateIntegraCusMain() {
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
		try {
			integraCusMainServer.updateIntegraCusMain(integraCusMainList);
	 	} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusMain();
	}
	public String  deleteIntegraCusMain() {
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
		String cust_main_id = request.getParameter("cust_main_id");
		try {
			integraCusMainServer.deleteIntegraCusMain(DataUtils.getInt(cust_main_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusMain();
	}
	 
	public String isEmpty(){
		request.setAttribute("message", "请输入至少一个查询条件!");
		return "mangerMain";
	}
	public String noCustomer(){
		request.setAttribute("message", "无此客户或此客户已冻结!");
		return "mangerMain";
	}
	 
	public String queryExchangeCusMain(){
		if(page==null){
			page = new Page(1);
		}
		String custName = request.getParameter("custName");
		String custCode = request.getParameter("custCode");
		request.setAttribute("custName", custName);
		request.setAttribute("custCode", custCode);
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
    	if("".equals(custName)&&"".equals(custCode)){
			return this.isEmpty();
		}else{
			try {
			  	try {
					if (integraCusMain == null) {
						Object[] objs = new Object[] { custName,custCode,null,null,null};
					 	integraCusMainList = integraCusMainServer.findAllIntegraCusMain(objs, page);
				
					} else {
						Object[] objs = new Object[] { custName,custCode,null,null,null};
					 	integraCusMainList = integraCusMainServer.findAllIntegraCusMain(objs, page);
					}
				 	} catch (Exception e) {
					e.printStackTrace();
				}
			 	if(integraCusMainList.size()==0){
					return this.noCustomer();
				}
				 
				
		 	} catch (Exception e) {
				e.printStackTrace();
			}
	
			return "exchangeCusMainlist";
		}
	
	}
	public String updateExchangCusMain() {
		IntegraCusMainServerImpl integraCusMainServer = (IntegraCusMainServerImpl) this.getService("IntegraCusMainServer");
		try {
			integraCusMainServer.exchangCusMain(request.getParameter("cust_main_id"),request.getParameter("cust_integral_remain"));
	 	} catch (Exception e) {
			e.printStackTrace();
		}
	   	request.setAttribute("custName", request.getParameter("custName"));
		request.setAttribute("custCode", request.getParameter("custCode"));
		return  this.queryExchangeCusMain();
	}
	public String queryByCusMainId(){
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		try {
			integraCusDetailsList=InteCusDetServer.queryIntegraCusDetails(DataUtils.getInt(request.getParameter("cusMainId")));
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValue(null));
			JSONArray jsonArray = JSONArray.fromObject(integraCusDetailsList,jsonConfig);
		    response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
}

	
	


