package com.jujie.rules.server;

import java.util.List;

import com.jujie.rules.Rules;
import com.jujie.rules.dao.RulesDAOImpl;



public class RulesServerImpl {
	private RulesDAOImpl rulesDAO;

	

	public void setRulesDAO(RulesDAOImpl rulesDAO) {
		this.rulesDAO = rulesDAO;
	}

	public List<Rules> queryRulesList(Object[] objs )throws Exception {
		return rulesDAO.queryRulesList(objs);
	}
	public Rules queryRulesByID(Integer rulesId) throws Exception {
		return rulesDAO.queryRulesByID(rulesId);
	}
	public void addRulesByID(Rules rules) throws Exception {
		rulesDAO.addRulesByID(rules);
	}
	public void updateRulesByID(Rules rules) throws Exception {
		rulesDAO.updateRulesByID(rules);
	}
	public void deleteRulesByID(Integer rulesId) throws Exception {
		rulesDAO.deleteRulesByID(rulesId);
	}
	

}
