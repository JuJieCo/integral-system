package com.jujie.wzj.server;

import java.util.List;
import com.jujie.wzj.Wzj;
import com.jujie.wzj.dao.WzjDaoImpl;

public class WzjServerImpl {
	
	private WzjDaoImpl wzjDao;


	public void setWzjDao(WzjDaoImpl wzjDao) {
		this.wzjDao = wzjDao;
	}
	
	public List<Wzj> queryWzjList(Object[] objs) throws Exception {
		return wzjDao.queryWzjList(objs);
	}
	public Wzj queryWzjByID(Integer wzjOrgId) throws Exception {
		return wzjDao.queryWzjByID(wzjOrgId);
	}
	public void addWzj(Wzj wzj) throws Exception {
		wzjDao.addWzj(wzj);
	}
	public void updateWzj(Wzj wzj) throws Exception {
		wzjDao.updateWzj(wzj);
	}
	public void deleteWzj(Integer wzjOrgId) throws Exception {
		wzjDao.deleteWzj(wzjOrgId);
	}

}
