package com.jujie.gifts.action;

import java.util.ArrayList;
import java.util.List;

import com.jujie.agence.Agence;
import com.jujie.agence.server.AgenceServerImpl;
import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.server.GiftsServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.user.User;
import com.jujie.util.page.Page;

public class GiftsDetailsAction extends BaseActionSupper {
	private static final long serialVersionUID = 1L;
	private GiftsDetails giftsDetails;
	private List<GiftsDetails> giftsDetailsList;
	private Page page;
		
		
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	private String s_token;
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	
	public GiftsDetails getGiftsDetails() {
		return giftsDetails;
	}
	public void setGiftsDetails(GiftsDetails giftsDetails) {
		this.giftsDetails = giftsDetails;
	}
	public List<GiftsDetails> getGiftsDetailsList() {
		return giftsDetailsList;
	}
	public void setGiftsDetailsList(List<GiftsDetails> giftsDetailsList) {
		this.giftsDetailsList = giftsDetailsList;
	}
	//---------------------------------------------------
	public String queryGiftsDetailsList(){
		if(page==null){
			page = new Page(1);
		}
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
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
		}
		try {
			if(giftsDetails==null){
				giftsDetailsList = giftsServer.queryGiftsDetailsList(new Object[]{null},userId,agenceIds,page);
			}else{
				giftsDetailsList = giftsServer.queryGiftsDetailsList(new Object[]{giftsDetails.getCustName(),giftsDetails.getCustCode()},userId,agenceIds,page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	

	public String exchangeGiftsBackout(){
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
		String giftsDetailsId= request.getParameter("giftsDetailsId");
		String giftsId= request.getParameter("giftsId");
		String custId= request.getParameter("custId");
		String giftsDetailsCost= request.getParameter("giftsDetailsCost");
		
		Integer giftsDetailsIdInt = null;
		Integer giftsIdInt = null;
		Integer custIdInt = null;
		Integer giftsDetailsCostInt = null;
		
		try {
			if(!"".equals(giftsDetailsId)&&null!=giftsDetailsId){
				 giftsDetailsIdInt = Integer.valueOf(giftsDetailsId);
			}
			if(!"".equals(giftsId)&&null!=giftsId){
				giftsIdInt = Integer.valueOf(giftsId);
			}
			if(!"".equals(custId)&&null!=custId){
				custIdInt = Integer.valueOf(custId);
			}
			if(!"".equals(giftsDetailsCost)&&null!=giftsDetailsCost){
				giftsDetailsCostInt = Integer.valueOf(giftsDetailsCost);
			}
			if(giftsDetailsIdInt!=null&&giftsIdInt!=null&&custIdInt!=null&&giftsDetailsCostInt!=null){
				giftsServer.exchangeGiftsBackout(giftsDetailsIdInt,giftsIdInt,custIdInt,giftsDetailsCostInt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.queryGiftsDetailsList();
	}
}
