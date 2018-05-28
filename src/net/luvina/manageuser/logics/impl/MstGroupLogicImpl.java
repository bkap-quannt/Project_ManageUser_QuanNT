/*
 * Copyright(C) 2015 Luvina Software Company
 * MstGroupLogicImpl.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.logics.impl;
import java.util.List;

import net.luvina.manageuser.dao.impl.MstGroupDaoImpl;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.logics.MstGroupLogic;
/**
 * @author LA-AM
 *
 */
public class MstGroupLogicImpl {

	public List<MstGroup> getAllGroup() {
		MstGroupDaoImpl daoImpl = new MstGroupDaoImpl();
		List<MstGroup> lsGroup = daoImpl.getAllGroups();
		return lsGroup;
	}
}
