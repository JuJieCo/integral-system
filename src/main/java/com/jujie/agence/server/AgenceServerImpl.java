package com.jujie.agence.server;

import java.util.List;

import com.jujie.agence.Agence;
import com.jujie.agence.dao.AgenceDAOImpl;

public class AgenceServerImpl {

	private AgenceDAOImpl agenceDAO;

	public void setAgenceDAO(AgenceDAOImpl agenceDAO) {
		this.agenceDAO = agenceDAO;
	}

	public List<Agence> queryAgencePidList(int pid) throws Exception{
		return agenceDAO.queryAgencePidList(pid);
	}
	

	public List<Agence> queryAgenceList(Object[] objs )throws Exception {
		return agenceDAO.queryAgenceList(objs);
	}

	public Agence queryAgenceByID(Integer agenceId) throws Exception {
		return agenceDAO.queryAgenceByID(agenceId);
	}

	public void addAgenceByID(Agence agence) throws Exception {
		agenceDAO.addAgenceByID(agence);
	}

	public void updateAgenceByID(Agence agence) throws Exception {
		agenceDAO.updateAgenceByID(agence);
	}

	public void deleteAgenceByID(Integer agenceId) throws Exception {
		agenceDAO.deleteAgenceByID(agenceId);
	}
	

}
