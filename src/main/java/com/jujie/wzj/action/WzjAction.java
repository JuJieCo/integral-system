package com.jujie.wzj.action;

import java.util.List;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.util.DataUtils;
import com.jujie.wzj.Wzj;
import com.jujie.wzj.server.WzjServerImpl;

public class WzjAction extends BaseActionSupper {
	private static final long serialVersionUID = 1L;
	private List<Wzj> wzjList;
	private Wzj wzj;
	
	private String s_token;
	
	public Wzj getWzj() {
		return wzj;
	}
	public void setWzj(Wzj wzj) {
		this.wzj = wzj;
	}
	public List<Wzj> getWzjList() {
		return wzjList;
	}
	public void setWzjList(List<Wzj> wzjList) {
		this.wzjList = wzjList;
	}

	public String getS_token() {
		return s_token;
	}

	public void setS_token(String s_token) {
		this.s_token = s_token;
	}

	public String queryWzjList(){
		WzjServerImpl wzjServer = (WzjServerImpl) this.getService("wzjServer");
		try {
			
			if(wzj==null){
				Object[] objs = new  Object[]{null,null,null};
				wzjList = wzjServer.queryWzjList(objs);
			}else{
				Object[] objs = new  Object[]{wzj.getWzjOrgName(),wzj.getWzjOrgStatus(), wzj.getWzjOrgContact()};
				wzjList = wzjServer.queryWzjList(objs);
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "wzjlist";
	}
	
	public String queryWzjByID() {
		WzjServerImpl wzjServer = (WzjServerImpl) this.getService("wzjServer");
		String wzjOrgId = request.getParameter("wzjOrgId");
		String method= request.getParameter("method");
		try {
			if(!"".equals(method)&&method!=null){
				wzj = wzjServer.queryWzjByID(DataUtils.getInt(wzjOrgId));
				if("show".equals(method)&&method!=null){
					return "showwzj";
				}
				if("showedit".equals(method)&&method!=null){
					request.setAttribute("editsub", "1");
					wzj = wzjServer.queryWzjByID(DataUtils.getInt(wzjOrgId));
					return "updateofedit";
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryWzjList();
	}
	
	public String showAdd(){
		request.setAttribute("editsub", "0");
		return "addofedit";
	}
	
	public String addWzj(){
		WzjServerImpl wzjServer = (WzjServerImpl) this.getService("wzjServer");
		try {
			if(wzj!=null){
				wzjServer.addWzj(wzj);
				wzj=null;
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.queryWzjList();
	}
	
	public String updateWzj(){
		WzjServerImpl wzjServer = (WzjServerImpl) this.getService("wzjServer");
		try {
			wzjServer.updateWzj(wzj);
			wzj=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryWzjList();
	}
	
	public String deleteWzj() {
		WzjServerImpl wzjServer = (WzjServerImpl) this.getService("wzjServer");
		String wzjOrgId = request.getParameter("wzjOrgId");
		try {
			wzjServer.deleteWzj(DataUtils.getInt(wzjOrgId));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return this.queryWzjList();
	}
	
	
}
