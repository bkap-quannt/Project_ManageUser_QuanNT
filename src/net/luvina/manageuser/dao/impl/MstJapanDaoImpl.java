/**
 * Copyright (C) 2015 by Luvina Software Company
 *Project_ManageUser_QuanNT, net.luvina.manageuser.dao.impl
 *MstJapanDaoImpl.java, Jul 9, 2015 NguyenTruongQuan
 */
package net.luvina.manageuser.dao.impl;

import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.MstJapanDao;
import net.luvina.manageuser.entities.MstJapan;

/**
 * @author Administrator
 *
 */
public class MstJapanDaoImpl extends BaseDaoImpl implements MstJapanDao {


	@Override
	public List<MstJapan> getAllMstjapan() {
		// TODO Auto-generated method stub
		List<MstJapan> listJapan = new ArrayList<MstJapan>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand
						.append("SELECT code_level,name_level FROM mst_japan");
				// Order by id ASC
				sqlCommand.append(" ORDER BY code_level ASC ");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();

				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						MstJapan group = new MstJapan(rs
								.getString("code_level"), rs
								.getString("name_level"));
						listJapan.add(group);
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return listJapan;
	}
}
