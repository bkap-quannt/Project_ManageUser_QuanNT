/*
 * Copyright(C) 2015 Luvina Software Company
 * TblDetailUserJapanDaoImpl.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.dao.impl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.TblDetailUserJapanDao;
import net.luvina.manageuser.entities.TblDetailUserJapan;
import net.luvina.manageuser.entities.TblUser;
/**
 * @author LA-AM
 *
 */
public class TblDetailUserJapanDaoImpl extends BaseDaoImpl implements
TblDetailUserJapanDao {

	////

	/////
	////
	@Override
	public TblDetailUserJapan checkIdUser(int idUser) {
		TblDetailUserJapan japanDao = null;
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand
						.append("SELECT detail_user_japan_id,user_id,code_level,start_date,end_date,total ");
				sqlCommand.append("FROM tbl_detail_user_japan AS jp ");
				sqlCommand.append("Where jp.user_id  = '" + idUser + "'");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						japanDao = new TblDetailUserJapan(rs
								.getInt("detail_user_japan_id"), rs
								.getInt("user_id"), rs.getString("code_level"),
								rs.getDate("start_date"), rs
										.getDate("end_date"), rs
										.getInt("total"));
					}
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();
		}
		return japanDao;
	}
}
