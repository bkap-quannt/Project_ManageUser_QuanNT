/*
 * Copyright(C) 2015 Luvina Software Company
 * MstGroupDaoImpl.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.dao.impl;
import java.util.ArrayList;
import java.util.List;

import net.luvina.manageuser.dao.MstGroupDao;
import net.luvina.manageuser.entities.MstGroup;
/**
 * @author LA-AM
 *
 */
public class MstGroupDaoImpl extends BaseDaoImpl implements MstGroupDao {

	@Override
	public List<MstGroup> getAllGroups() {
		List<MstGroup> lsGroups = new ArrayList<MstGroup>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT * FROM mst_group");
				// Order by id ASC
				sqlCommand.append(" ORDER BY group_id ASC ");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();

				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						MstGroup group = new MstGroup(rs.getInt("group_id"), rs
								.getString("group_name"));
						lsGroups.add(group);
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return lsGroups;
	}
}
