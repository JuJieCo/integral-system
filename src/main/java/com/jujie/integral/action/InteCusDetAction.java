package com.jujie.integral.action;

import java.util.List;

import com.jujie.global.action.BaseActionSupper;
import com.jujie.integral.IntegraCusDetails;
import com.jujie.integral.server.InteCusDetServerImpl;
import com.jujie.util.DataUtils;
import com.jujie.util.page.Page;

@SuppressWarnings("serial")
public class InteCusDetAction extends BaseActionSupper {

	private IntegraCusDetails integraCusDetails;

	private List<IntegraCusDetails> integraCusDetailsList;

	public IntegraCusDetails getIntegraCusDetails() {
		return integraCusDetails;
	}

	public void setIntegraCusDetails(IntegraCusDetails integraCusDetails) {
		this.integraCusDetails = integraCusDetails;
	}

	public List<IntegraCusDetails> getIntegraCusDetailsList() {
		return integraCusDetailsList;
	}

	public void setIntegraCusDetailsList(
			List<IntegraCusDetails> integraCusDetailsList) {
		this.integraCusDetailsList = integraCusDetailsList;
	}

	public String queryAllIntegraCusDetails() {
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		try {
			if (integraCusDetails == null) {
				Object[] objs = new Object[] { null };
				Page page = new Page();
				integraCusDetailsList = InteCusDetServer.findAllIntegraCusDetails(objs, page);
			} else {
				Object[] objs = new Object[] { integraCusDetails.getCust_details_id() };
				Page page = new Page();
				integraCusDetailsList = InteCusDetServer.findAllIntegraCusDetails(objs, page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	public String queryIntegraCusDetailsByID() {
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		String cust_details_id = request.getParameter("cust_details_id");
		String method = request.getParameter("method");
		try {
			
	
			if(!"".equals(method) && method!=null){
			if ("show".equals(method)&& method != null) {
				integraCusDetails = InteCusDetServer.findIntegraCusDetailsByID(DataUtils.getInt(cust_details_id));
				return "showrules";
			}
			if ("showedit".equals(method)&& method != null) {
				request.setAttribute("editsub", "1");
				integraCusDetails = InteCusDetServer.findIntegraCusDetailsByID(DataUtils.getInt(cust_details_id));
				request.setAttribute("rulesCreateTime","");
				return "updateofedit";
			
			   }
			 }
			} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusDetails();
	}
	
	public String showAdd() {
		request.setAttribute("editsub", "0");

		return "addofedit";
	}
	public String addIntegraCusDetails() {
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		try {		
			if(integraCusDetails != null){
				InteCusDetServer.addIntegraCusDetails(integraCusDetails);
				integraCusDetails=null;	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusDetails();
	}
	public String updateIntegraCusDetails() {
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		try {
			InteCusDetServer.updateIntegraCusDetails(integraCusDetailsList);
			integraCusDetails=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusDetails();
	}
	public String  setInteCusDetDaoImpl() {
		InteCusDetServerImpl InteCusDetServer = (InteCusDetServerImpl) this.getService("InteCusDetServer");
		String cust_details_id = request.getParameter("cust_details_id");
		try {
			InteCusDetServer.deleteIntegraCusDetails(DataUtils.getInt(cust_details_id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryAllIntegraCusDetails();
	}
  


}
