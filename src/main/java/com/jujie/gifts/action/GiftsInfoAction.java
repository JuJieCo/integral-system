package com.jujie.gifts.action;

import java.util.List;

import com.jujie.gifts.GiftsInfo;
import com.jujie.gifts.server.GiftsServerImpl;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.util.page.Page;
import com.jujie.wzj.Wzj;

public class GiftsInfoAction extends BaseActionSupper {

	private static final long serialVersionUID = 1L;
	private GiftsInfo giftsInfo;
	private List<GiftsInfo> giftsInfoList;
	private String s_token;
	private Page page;	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getS_token() {
		return s_token;
	}
	public void setS_token(String s_token) {
		this.s_token = s_token;
	}
	
	public GiftsInfo getGiftsInfo() {
		return giftsInfo;
	}
	public void setGiftsInfo(GiftsInfo giftsInfo) {
		this.giftsInfo = giftsInfo;
	}
	public List<GiftsInfo> getGiftsInfoList() {
		return giftsInfoList;
	}
	public void setGiftsInfoList(List<GiftsInfo> giftsInfoList) {
		this.giftsInfoList = giftsInfoList;
	}
	public String queryGiftsInfoList(){
		if(page==null){
			page = new Page(1);
		}
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");			
		try {
			if(giftsInfo==null){
				giftsInfoList = giftsServer.queryGiftsInfoList(new Object[]{null,null,null},page);
			}else{
				giftsInfoList = giftsServer.queryGiftsInfoList(new Object[]{giftsInfo.getGiftsType(),giftsInfo.getGiftsName(),giftsInfo.getGiftsStatus()},page);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "list";
	}
	
	public String queryGiftsInfo(){
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
		String method = request.getParameter("method");
		String giftsId = request.getParameter("giftsId");
		if("show".equals(method)&&method!=null){
			try {
				giftsInfo = giftsServer.queryGiftsInfo(giftsId);
			} catch (Exception e) {
				e.printStackTrace();	
			}
			return "show";
		}else{
			try {
				List<Wzj> wzjslist = giftsServer.queryWzjList();
				request.setAttribute("wzjslist", wzjslist);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if("showadd".equals(method)&&method!=null){
				try {
					request.setAttribute("editsub", "0");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if("showupdate".equals(method)&&method!=null){
				try {
					giftsInfo = giftsServer.queryGiftsInfo(giftsId);
					request.setAttribute("editsub", "1");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
			return "showedit";
		}		
	}

	public String addGiftsInfo(){
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
		try {
			giftsInfo.setGiftsCalls(0);
			giftsServer.addGiftsInfo(giftsInfo);
			giftsInfo=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryGiftsInfoList();
	}
	
	public String updateGiftsInfo(){
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
		try {
			giftsServer.updateGiftsInfo(giftsInfo);
			giftsInfo=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryGiftsInfoList();
	}
	
	public String deleteGiftsInfo(){
		GiftsServerImpl giftsServer = (GiftsServerImpl)this.getService("giftsServer");
		String giftsId[] = request.getParameterValues("giftsId");
		try {
			giftsServer.deleteGiftsInfo(giftsId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.queryGiftsInfoList();
	}
	
}
