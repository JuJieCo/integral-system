package com.jujie.gifts.server;

import java.util.List;

import com.jujie.gifts.GiftsDetails;
import com.jujie.gifts.GiftsInfo;
import com.jujie.gifts.dao.GiftsDetailsDAOImpl;
import com.jujie.gifts.dao.GiftsInfoDAOImpl;
import com.jujie.util.page.Page;
import com.jujie.wzj.Wzj;


public class GiftsServerImpl {

	private GiftsInfoDAOImpl giftsInfoDAO;
	private GiftsDetailsDAOImpl giftsDetailsDAO;
	public void setGiftsInfoDAO(GiftsInfoDAOImpl giftsInfoDAO) {
		this.giftsInfoDAO = giftsInfoDAO;
	}
	public void setGiftsDetailsDAO(GiftsDetailsDAOImpl giftsDetailsDAO) {
		this.giftsDetailsDAO = giftsDetailsDAO;
	}
	public List<GiftsInfo> queryGiftsInfoList(Object[] objs, Page page)throws Exception{
		return giftsInfoDAO.queryGiftsInfoList(objs,page);
	}
	public GiftsInfo queryGiftsInfo(String giftsId) throws Exception{
		return giftsInfoDAO.queryGiftsInfo(giftsId);
	}
	public int addGiftsInfo(GiftsInfo giftsInfo) throws Exception {
		return giftsInfoDAO.addGiftsInfo(giftsInfo);
	}
	public void updateGiftsInfo(GiftsInfo giftsInfo) throws Exception{
		giftsInfoDAO.updateGiftsInfo(giftsInfo);
	}
	public void deleteGiftsInfo(String[] giftsId) throws Exception{
		giftsInfoDAO.deleteGiftsInfo(giftsId);
	}
	public List<Wzj> queryWzjList()throws Exception{
		return giftsInfoDAO.queryWzjList();
	}
	public List<GiftsDetails> queryGiftsDetailsList(Object[] objs,String userId,String agenceIds,Page page)throws Exception{
		return giftsDetailsDAO.queryGiftsDetailsList(objs,userId,agenceIds,page);
	}
	public void exchangeGiftsBackout(Integer giftsDetailsId ,Integer giftsId , Integer custId,Integer giftsDetailsCost)throws Exception{
		giftsDetailsDAO.exchangeGiftsBackout(giftsDetailsId,giftsId,custId,giftsDetailsCost);
	}


}
