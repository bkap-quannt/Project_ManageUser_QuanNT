/*
 * Copyright(C) 2015 Luvina Software Company
 * TblUserLogic.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.logics;
import java.sql.Date;
import java.util.List;

import net.luvina.manageuser.entities.TblDetailUserJapan;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
/**
 * @author LA-AM
 *
 */
public interface TblUserLogic {

	public Boolean existLoginId(String loginId, String password);

	public int getTotalUsers(TblUser tblUser);

	public List<UserInfor> getListUsers(TblUser tblUser, int offset, int limit,
			String sortType, String sortfullName, String sortcodeLevel,
			String sortendDate);

	public List<TblUser> getListLoginUser(String loginname);

	public List<TblUser> getListEmail(String email);
///
///
///
	public List<TblUser> getListIdUser(int iduser);

	public List<TblUser> checkEmailOrLogin(String checkemailorlogin,
			String value, int id);
///
///
}
