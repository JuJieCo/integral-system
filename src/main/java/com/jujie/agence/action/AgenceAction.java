package com.jujie.agence.action;

import java.util.List;

import com.jujie.agence.Agence;
import com.jujie.agence.server.AgenceServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.util.DataUtils;

@SuppressWarnings("serial")
public class AgenceAction extends BaseActionSupper {
	private Agence agence;
	private List<Agence> agenceList;
	private String s_token;
	public Agence getAgence() {
		return agence;
	}
	public void setAgence(Agence agence) {
		this.agence = agence;
	}
	public List<Agence> getAgenceList() {
		return agenceList;
	}
	public void setAgenceList(List<Agence> agenceList) {
		this.agenceList = agenceList;
	}
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	public String queryAgenceList() {
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		try {
			if (agence == null) {
				Object[] objs = new Object[] { null, null, null };

				agenceList = agenceServer.queryAgenceList(objs);
			} else {
				Object[] objs = new Object[] { agence.getAgenceName(),
						agence.getAgenceStatus(), agence.getAgenceContact() };
				agenceList = agenceServer.queryAgenceList(objs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	public String queryAgenceByID() {
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		String agenceId = request.getParameter("agenceId");
		String method = request.getParameter("method");
		try {
			
			if(!"".equals(method) && method!=null){
			if ("show".equals(method)&& method != null) {
				agence = agenceServer.queryAgenceByID(DataUtils.getInt(agenceId));
				return "showagence";
			}
			if ("showedit".equals(method)&& method != null) {
				request.setAttribute("editsub", "1");
				agence = agenceServer.queryAgenceByID(DataUtils.getInt(agenceId));
				return "updateofedit";
			
			   }
			 }
			} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryAgenceList();
	}
	public String showAdd() {
		request.setAttribute("editsub", "0");
		request.setAttribute("pid", request.getParameter("agenceId"));
		return "addofedit";
	}
	public String addAgence() {
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		try {		
			if(agence != null){
				agenceServer.addAgenceByID(agence);
				agence=null;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryAgenceList();
	}
	public String updateAgence() {
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		try {
			Agence agence_tp = agenceServer.queryAgenceByID(DataUtils.getInt(agence.getAgenceId()));
			agence.setAgenceLevel(agence_tp.getAgenceLevel());
			agence.setAgencePid(agence_tp.getAgencePid());
			agenceServer.updateAgenceByID(agence);
			agence=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryAgenceList();
	}
	public String deleteAgence() {
		AgenceServerImpl agenceServer = (AgenceServerImpl) this.getService("agenceServer");
		String agenceId = request.getParameter("agenceId");
		try {
			agenceServer.deleteAgenceByID(DataUtils.getInt(agenceId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryAgenceList();
	}
}
