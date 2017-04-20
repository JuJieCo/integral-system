package com.jujie.integral.server;

import java.util.List;

import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.integral.ExchangeGifts;
import com.jujie.integral.dao.ExchangeGiftsDAOImpl;
public class ExchangeGiftsServerImpl {
	private ExchangeGiftsDAOImpl exchangeGiftsDAO;
	
	
	public void setExchangeGiftsDAO(ExchangeGiftsDAOImpl exchangeGiftsDAO) {
		this.exchangeGiftsDAO = exchangeGiftsDAO;
	}
	public ExchangeGifts exchangeGiftsCustInfo(String custCode)throws Exception {
		   return exchangeGiftsDAO.exchangeGiftsCustInfo(custCode);
	}
	public List<GiftsInfo> getExchangeGiftsInfo(Integer custIntegralRemain)throws Exception{
		   return exchangeGiftsDAO.getExchangeGiftsInfo(custIntegralRemain);
	}
	public void exchangeGifts(Integer custId,Integer giftsId ,GiftsDetails giftsDetails ,Integer giftsIntegral)throws Exception{
		   exchangeGiftsDAO.exchangeGifts( custId, giftsId ,giftsDetails,giftsIntegral);
	}

}
