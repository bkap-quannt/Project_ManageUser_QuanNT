/**
 * Copyright (C) 2015 by Luvina Software Company
 *Project_ManageUser_QuanNT, net.luvina.manageuser.logics.impl
 *MstJapanLogicImpl.java, Jul 9, 2015 NguyenTruongQuan
 */
package net.luvina.manageuser.logics.impl;

import java.util.List;

import net.luvina.manageuser.dao.impl.MstJapanDaoImpl;
import net.luvina.manageuser.entities.MstJapan;
import net.luvina.manageuser.logics.MstJapanLogic;

/**
 * @author Administrator
 *
 */
public class MstJapanLogicImpl implements MstJapanLogic {

	@Override
	public List<MstJapan> getAllJapan() {
		// TODO Auto-generated method stub
		MstJapanDaoImpl japanDaoImpl = new MstJapanDaoImpl();
		List<MstJapan> listJapan = japanDaoImpl.getAllMstjapan();
		return listJapan;
	}
}
