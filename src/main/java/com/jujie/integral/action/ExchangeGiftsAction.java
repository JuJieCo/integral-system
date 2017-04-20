package com.jujie.integral.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.global.action.BaseActionSupper;
import com.jujie.integral.ExchangeGifts;
import com.jujie.integral.server.ExchangeGiftsServerImpl;
import com.jujie.user.User;

public class ExchangeGiftsAction  extends BaseActionSupper {

	
	private static final long serialVersionUID = 1L;
	
	private ExchangeGifts exchangeGifts;
	private List<ExchangeGifts> exchangeGiftsList;
	private List<GiftsInfo> giftsInfoList;
	public List<GiftsInfo> getGiftsInfoList() {
		return giftsInfoList;
	}

	public void setGiftsInfoList(List<GiftsInfo> giftsInfoList) {
		this.giftsInfoList = giftsInfoList;
	}

	public ExchangeGifts getExchangeGifts() {
		return exchangeGifts;
	}

	public void setExchangeGifts(ExchangeGifts exchangeGifts) {
		this.exchangeGifts = exchangeGifts;
	}

	public List<ExchangeGifts> getExchangeGiftsList() {
		return exchangeGiftsList;
	}

	public void setExchangeGiftsList(List<ExchangeGifts> exchangeGiftsList) {
		this.exchangeGiftsList = exchangeGiftsList;
	}
 

	public String exchangeGiftsPage(){
		return "exchangelist";
	}

	
	public String exchangeGiftsCustInfo(){
		
		ExchangeGiftsServerImpl exchangeGiftsServer = (ExchangeGiftsServerImpl) this.getService("exchangeGiftsServer");
		String custCode = request.getParameter("custcode");
			try {
				exchangeGifts = exchangeGiftsServer.exchangeGiftsCustInfo(custCode);
				Integer custIntegralRemain = exchangeGifts.getCustIntegralRemain();
				if(custIntegralRemain==null){
					request.setAttribute("message", "此客户不存在或已冻结!");
					request.setAttribute("custcode", custCode);
					return "exchangelist";
				}
				giftsInfoList = exchangeGiftsServer.getExchangeGiftsInfo(custIntegralRemain);
				if(giftsInfoList.size()==0){
					request.setAttribute("message", "此客户没有足够的积分!");
					request.setAttribute("tag","tag");
					request.setAttribute("custName", exchangeGifts.getCustName());
					request.setAttribute("custIntegralRemain", custIntegralRemain);
					request.setAttribute("custcode", custCode);
					return "exchangelist";
				}
				request.setAttribute("custcode", custCode);
				String custId = exchangeGifts.getCustId().toString();
				request.setAttribute("custId", custId);	
				
				if(custIntegralRemain!=null){
					request.setAttribute("tag","tag");
					request.setAttribute("custName", exchangeGifts.getCustName());
					request.setAttribute("custIntegralRemain", custIntegralRemain);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}			
			return "exchangelist";
		}
	
	
	public String exchangeGifts(){
		User sysUser = (User)session.get("sessionUser"); 
		Integer giftsDetailsOper = sysUser.getSysUserId();
		Integer giftsDetailsAgence = sysUser.getSysUserAgence().getAgenceId();
		String giftsId = request.getParameter("giftsId");
		String custId = request.getParameter("custId");
		String giftsIntegral = request.getParameter("giftsIntegral");
		String custCode = request.getParameter("custcode");
		
		ExchangeGiftsServerImpl exchangeGiftsServer = (ExchangeGiftsServerImpl) this.getService("exchangeGiftsServer");
		try {
			Integer custIdInt = null;
			Integer giftsIdInt = null;
			Integer giftsIntegralInt = null;
			
			if(!"".equals(custId)&&custId!=null){
				custIdInt = Integer.valueOf(custId);
			}
			if(!"".equals(giftsId)&&giftsId!=null){
				giftsIdInt = Integer.valueOf(giftsId);
			}
			if(!"".equals(giftsIntegral)&&giftsIntegral!=null){
				giftsIntegralInt = Integer.valueOf(giftsIntegral);
			}
			GiftsDetails giftsDetails = new  GiftsDetails();
			 giftsDetails.setGiftsId(giftsIdInt);
			 giftsDetails.setCustId(custIdInt);
			 giftsDetails.setGiftsDetailsTime(new Date());
			 giftsDetails.setGiftsDetailsCost(giftsIntegralInt);
			 giftsDetails.setGiftsDetailsStatus(0);
			 giftsDetails.setGiftsDetailsOper(giftsDetailsOper);
			 giftsDetails.setGiftsDetailsAgence(giftsDetailsAgence);
			if(custIdInt!=null&&giftsIdInt!=null&&giftsDetails!=null&&giftsIntegralInt!=null){
				exchangeGiftsServer.exchangeGifts(custIdInt, giftsIdInt,giftsDetails,giftsIntegralInt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("custcode", custCode);
		return this.exchangeGiftsCustInfo();
	}

}
