/*
 * Copyright(C) 2015 Luvina Software Company
 * TblUserDao.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.dao;
import java.sql.Date;
import java.util.List;

import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
/**
 * @author LA-AM
 *
 */
public interface TblUserDao extends BaseDao {

	public TblUser getUserByLoginId(String username, String password);
	public int getTotalUsers(TblUser user) ;
	public List<UserInfor> getListUser(TblUser user, int offset, int limit,
			String sortType, String sortfullName, String sortcodeLevel,
			String sortendDate);
	public List<TblUser> getListLoginUser(String loginname);
	public List<TblUser> getListEmail(String email);
///
///
///
	public List<TblUser> getListIdUser(int iduser);
	public List<TblUser> checkEmailOrLogin(String checkemailorlogin,String value, int id);
///
///
}
