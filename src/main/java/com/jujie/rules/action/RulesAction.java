package com.jujie.rules.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jujie.global.action.BaseActionSupper;
import com.jujie.rules.Rules;
import com.jujie.rules.server.RulesServerImpl;
import com.jujie.util.DataUtils;


@SuppressWarnings("serial")
public class RulesAction extends BaseActionSupper {
	
	private  Rules rules;
	private List<Rules>  rulesList;
	
	
	public Rules getRules() {
		return rules;
	}
	public void setRules(Rules rules) {
		this.rules = rules;
	}
	public List<Rules> getRulesList() {
		return rulesList;
	}
	public void setRulesList(List<Rules> rulesList) {
		this.rulesList = rulesList;
	}
	public String queryRulesList() {
		RulesServerImpl rulesServer = (RulesServerImpl) this.getService("rulesServer");
		try {
			if (rules == null) {
				Object[] objs = new Object[] { null, null };

				rulesList = rulesServer.queryRulesList(objs);
			} else {
				Object[] objs = new Object[] { rules.getRulesName(),rules.getRulesStatus()};
				rulesList =   rulesServer.queryRulesList(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String queryRulesByID() {
		RulesServerImpl rulesServer = (RulesServerImpl) this.getService("rulesServer");
		String rulesId = request.getParameter("rulesId");
		String method = request.getParameter("method");
		try {
			
			if(!"".equals(method) && method!=null){
			if ("show".equals(method)&& method != null) {
				rules = rulesServer.queryRulesByID(DataUtils.getInt(rulesId));
				return "showrules";
			}
			if ("showedit".equals(method)&& method != null) {
				request.setAttribute("editsub", "1");
				rules = rulesServer.queryRulesByID(DataUtils.getInt(rulesId));
				request.setAttribute("rulesCreateTime","");
				return "updateofedit";
			
			   }
			 }
			} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryRulesList();
	}
	public String showAdd() {
		request.setAttribute("editsub", "0");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    request.setAttribute("rulesCreateTime",sdf.format(new Date()));
		return "addofedit";
	}
	public String addRules() {
		RulesServerImpl rulesServer = (RulesServerImpl) this.getService("rulesServer");
		try {		
			if(rules != null){
				rulesServer.addRulesByID(rules);
				rules=null;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryRulesList();
	}
	public String updateRules() {
		RulesServerImpl rulesServer = (RulesServerImpl) this.getService("rulesServer");
		try {
			rulesServer.updateRulesByID(rules);
			rules=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return  this.queryRulesList();
	}
	public String deleteRules() {
		RulesServerImpl rulesServer = (RulesServerImpl) this.getService("rulesServer");
		String rulesId = request.getParameter("rulesId");
		try {
			rulesServer.deleteRulesByID(DataUtils.getInt(rulesId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryRulesList();
	}
  
	
	
	
	
	
}
