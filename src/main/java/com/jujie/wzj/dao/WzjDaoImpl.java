package com.jujie.wzj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.jujie.global.dao.BaseJdbcDao;
import com.jujie.util.DataUtils;
import com.jujie.wzj.Wzj;

public class WzjDaoImpl extends BaseJdbcDao {

	@SuppressWarnings({ "unused", "unchecked" })
	public List<Wzj> queryWzjList(Object[] objs) throws Exception {
		String where = " where 1=1 ";
		List<Object> obj = new ArrayList<Object>();

		if (objs != null && objs.length > 0) {
			if (objs.length >= 1 && objs[0] != null && !"".equals(objs[0])) {
				where += " and w.wzj_org_name like '%'+?+'%' ";
				obj.add(objs[0]);
			}
			if (objs.length >= 2 && objs[1] != null && !"".equals(objs[1])) {
				if (((Integer) objs[1]) != 0) {
					where += " and w.wzj_org_status = ?";
					obj.add(objs[1]);
				}
				if (objs.length >= 3 && objs[2] != null && !"".equals(objs[2])) {
					where += " and w.wzj_org_contact like '%'+?+'%' ";
					obj.add(objs[2]);
				}

			}
		}
		final List<Wzj> wzjList = new ArrayList<Wzj>();
		final String sql = "select w.wzj_org_id, w.wzj_org_name , w.wzj_org_phone , w.wzj_org_phone2 ," +
				" w.wzj_org_phone3 , w.wzj_org_address , w.wzj_org_contact ,"
				+ " w.wzj_org_status , w.wzj_org_remark from integral_wzj_org w "
				+ where + " order by w.wzj_org_id desc";
		return this.getJdbcTemplate().query(sql, obj.toArray(),new Wzj());
	}

	@SuppressWarnings({ "unused", "unchecked" })
	public Wzj queryWzjByID(Integer WzjOrgId) throws Exception {
		final Wzj wzj = new Wzj();
		final String sql = "select w.wzj_org_id ,w.wzj_org_name,w.wzj_org_phone,w.wzj_org_phone2," +
				"w.wzj_org_phone3 , w.wzj_org_address ,w.wzj_org_contact, w.wzj_org_status ," +
				"w.wzj_org_remark from integral_wzj_org w where w.wzj_org_id=" + WzjOrgId;
		List<Wzj> list = this.getJdbcTemplate().query(sql, new Wzj());
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public Integer addWzj(Wzj wzj) throws Exception {
		final String sql = "insert into integral_wzj_org(wzj_org_name,wzj_org_phone,wzj_org_phone2,"
				+ "wzj_org_phone3,wzj_org_address,wzj_org_contact,wzj_org_status,"
				+ "wzj_org_remark) values(?,?,?,?,?,?,?,?)";
		final Object[] objs = { wzj.getWzjOrgName(), wzj.getWzjOrgPhone(),
				wzj.getWzjOrgPhone2(), wzj.getWzjOrgPhone3(),
				wzj.getWzjOrgAddress(), wzj.getWzjOrgContact(),
				wzj.getWzjOrgStatus(), wzj.getWzjOrgRemark() };
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			this.getJdbcTemplate().update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection con)
						throws SQLException {
					int i = 0;
					int n = 0;
					PreparedStatement ps = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					ps.setInt(++i, DataUtils.getInt(objs[n++]));
					ps.setString(++i, DataUtils.getStringK(objs[n++]));
					return ps;
				}
			}, keyHolder);
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return keyHolder.getKey().intValue();
	}

	public void updateWzj(Wzj wzj) throws Exception {
		final String sql = "update integral_wzj_org set wzj_org_name=?, wzj_org_phone=?, " +
				" wzj_org_phone2=?, wzj_org_phone3=? ,wzj_org_address=?, wzj_org_contact=?, " +
				"wzj_org_status=?, wzj_org_remark=? where wzj_org_id=?";
		final Object[] objs = { wzj.getWzjOrgName(),
				wzj.getWzjOrgPhone(), wzj.getWzjOrgPhone2(),
				wzj.getWzjOrgPhone3(), wzj.getWzjOrgAddress(),
				wzj.getWzjOrgContact(), wzj.getWzjOrgStatus(),
				wzj.getWzjOrgRemark() ,wzj.getWzjOrgId()};
		this.getJdbcTemplate().update(sql, objs);
	}

	public void deleteWzj(Integer WzjOrgId) throws Exception {
		String sql = "delete from integral_wzj_org where wzj_org_id=" + WzjOrgId;
		this.getJdbcTemplate().update(sql);
	}

}
