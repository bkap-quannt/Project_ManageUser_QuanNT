/*
 * Copyright(C) 2015 Luvina Software Company
 * TblUserLogicImpl.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.logics.impl;
import java.sql.Date;
import java.util.List;

import net.luvina.manageuser.dao.TblDetailUserJapanDao;
import net.luvina.manageuser.dao.impl.TblDetailUserJapanDaoImpl;
import net.luvina.manageuser.dao.impl.TblUserDaoImpl;
import net.luvina.manageuser.entities.TblDetailUserJapan;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.TblUserLogic;
import net.luvina.manageuser.utils.Common;
/**
 * @author LA-AM
 *
 */
public class TblUserLogicImpl implements TblUserLogic {

	@Override
	public Boolean existLoginId(String loginId, String password) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		TblUser user = userDao.getUserByLoginId(loginId, password);
		Boolean result = false;
		if (user != null) {
			result = true;
		}
		return result;
	}

	@Override
	public List<UserInfor> getListUsers(TblUser tblUser, int offset, int limit,
			String sortType, String sortfull_name, String sortcode_level,
			String sortend_date) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<UserInfor> lsUsers = userDao.getListUser(tblUser, offset, limit,
				sortType, sortfull_name, sortcode_level, sortend_date);
		return lsUsers;
	}

	@Override
	public int getTotalUsers(TblUser tblUser) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		int totalUsers = userDao.getTotalUsers(tblUser);
		return totalUsers;
	}

	@Override
	public List<TblUser> getListLoginUser(String loginname) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<TblUser> lsLogin = userDao.getListLoginUser(loginname);
		return lsLogin;
	}

	@Override
	public List<TblUser> getListEmail(String email) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<TblUser> lsEmail = userDao.getListEmail(email);
		return lsEmail;
	}

	@Override
	public List<TblUser> getListIdUser(int iduser) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<TblUser> lsIdUser = userDao.getListIdUser(iduser);
		return lsIdUser;
	}

///
///
///

	@Override
	public List<TblUser> checkEmailOrLogin(String checkemailorlogin,
			String value, int id) {
		TblUserDaoImpl userDao = new TblUserDaoImpl();
		List<TblUser> lsIdUser = userDao.checkEmailOrLogin(checkemailorlogin,
				value, id);
		return lsIdUser;
	}
////
///
}
