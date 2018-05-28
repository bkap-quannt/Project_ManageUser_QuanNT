/*
 * Copyright(C) 2015 Luvina Software Company
 * TblUserDaoImpl.java, Jul 9, 2015, Nguyễn Trường Quân
 */
package net.luvina.manageuser.dao.impl;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import net.luvina.manageuser.dao.TblUserDao;
import net.luvina.manageuser.entities.MstGroup;
import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.utils.Common;
/**
 * @author LA-AM
 *
 */
public class TblUserDaoImpl extends BaseDaoImpl implements TblUserDao {

	@Override
	public TblUser getUserByLoginId(String username, String password) {
		TblUser tblUser = null;
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();

				// create SQL
				sqlCommand.append("SELECT u.* ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("WHERE ");
				sqlCommand.append("u.login_name = '" + username + "'");
				sqlCommand.append(" AND ");
				sqlCommand.append("u.password = '" + password + "'");

				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());

				// run SQL
				rs = preparedStatement.executeQuery();

				// read result from SQL
				if (rs != null) {
					while (rs.next()) {

//						tblUser = new TblUser(rs.getInt("user_id"), rs
//                                .getString("full_name"), rs.getString("email"),
//                                rs.getString("tel"),rs.getString("login_name"), rs.getString("password"));

						tblUser = new TblUser(rs.getInt("user_id"), rs
								.getInt("group_id"),
								rs.getString("login_name"), rs
										.getString("password"), rs
										.getInt("check_account"), rs
										.getString("full_name"), rs
										.getString("full_name_kana"), rs
										.getString("email"), rs
										.getString("tel"), rs
										.getDate("birthday"));
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return tblUser;
	}

	@Override
	public List<UserInfor> getListUser(TblUser user, int offset, int limit,
			String sortType, String sortfullName, String sortcodeLevel,
			String sortendDate) {
		List<UserInfor> lsUsers = new ArrayList<UserInfor>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String name = user.getFullName();
				String fullName = user.getFullName().trim();
				int groupId = user.getGroupId();
				// create SQL
				sqlCommand.append("SELECT u.user_id, u.login_name,u.password, u.full_name,u.full_name_kana, ");
				sqlCommand.append("u.email,u.tel , u.birthday ,g.group_name,g.group_id, ");
				sqlCommand.append("mj.name_level, mj.code_level,j.start_date,j.end_date, j.total ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("INNER JOIN mst_group AS g ");
				sqlCommand.append("ON g.group_id=u.group_id ");
				sqlCommand.append("LEFT JOIN tbl_detail_user_japan AS j ");
				sqlCommand.append("INNER JOIN mst_japan AS mj ");
				sqlCommand.append("ON mj.code_level = j.code_level ");
				sqlCommand.append("ON u.user_id = j.user_id ");
				sqlCommand.append("WHERE ");
				sqlCommand.append("u.check_account=1 ");
				// Conditions search
				if (groupId > 0 && name.length() > 0) {
					sqlCommand.append(" AND ");
					sqlCommand.append("u.group_id = " + groupId);
					sqlCommand.append(" AND ");
					sqlCommand.append("u.full_name  LIKE'%" + fullName + "%' ");
				} else {
					if (groupId > 0) {
						sqlCommand.append(" AND ");
						sqlCommand.append("u.group_id = " + groupId);
					}
					if (name.length() > 0) {
						sqlCommand.append(" AND ");
						sqlCommand.append("u.full_name  LIKE'%" + fullName
								+ "%' ");
					}
				}
				if ("".equals(sortType)) {
					// Order by full_name ASC
					sqlCommand.append(" ORDER BY u.full_name ASC ");
					sqlCommand.append("  LIMIT " + offset + " , " + limit);
				} else {
					if ("full_name".equals(sortType)) {
						if ("ASC".equals(sortfullName)) {
							sqlCommand.append(" ORDER BY u.full_name ASC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						} else if ("DESC".equals(sortfullName)) {
							sqlCommand.append(" ORDER BY u.full_name DESC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						}
					}
					if ("code_level".equals(sortType)) {
						if ("DESC".equals(sortcodeLevel)) {
							sqlCommand.append(" ORDER BY mj.name_level ASC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						} else if ("ASC".equals(sortcodeLevel)) {
							sqlCommand.append(" ORDER BY mj.name_level DESC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						}
					}
					if ("end_date".equals(sortType)) {
						if ("ASC".equals(sortendDate)) {
							sqlCommand.append(" ORDER BY j.end_date ASC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						} else if ("DESC".equals(sortendDate)) {
							sqlCommand.append(" ORDER BY j.end_date DESC ");
							sqlCommand.append("  LIMIT " + offset + " , "
									+ limit);
						}
					}
					System.out.println("full - name" + sortType);
				}

				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				System.out.println("Sql " + sqlCommand.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						UserInfor userInfor = new UserInfor();
						userInfor.setId(rs.getInt("user_id"));
						userInfor.setGroupId(rs.getInt("group_id"));
						userInfor.setloginName(Common.escapeHTML(rs
								.getString("login_name")));
						userInfor.setPassword(Common.escapeHTML(rs
								.getString("password")));
						userInfor.setFullName(Common.escapeHTML(rs
								.getString("full_name")));
						userInfor.setFullNameKana(Common.escapeHTML(rs
								.getString("full_name_kana")));
						userInfor.setEmail(Common.escapeHTML(rs
								.getString("email")));
						userInfor.setTel(rs.getString("tel"));
						userInfor.setBirthday(rs.getDate("birthday"));
						userInfor.setGroupName(rs.getString("group_name"));
						userInfor.setCodelevel(rs.getString("code_level"));
						userInfor.setNamelevel(rs.getString("name_level"));
						userInfor.setStartdate(rs.getDate("start_date"));
						userInfor.setEnddate(rs.getDate("end_date"));
						userInfor.setTotal(rs.getString("total"));
						lsUsers.add(userInfor);
					}
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}

		return lsUsers;
	}

	@Override
	public int getTotalUsers(TblUser user) {
		int totalUsers = 0;
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				String name = user.getFullName();
				String fullName = user.getFullName().trim();
				int grpId = user.getGroupId();

				// create SQL
				sqlCommand.append("SELECT count(*) AS total ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("INNER JOIN mst_group AS g ");
				sqlCommand.append("ON u.group_id = g.group_id ");

				// Conditions search
				if (grpId > 0 && name.length() > 0) {
					sqlCommand.append("WHERE ");
					sqlCommand.append("u.group_id = " + grpId);
					sqlCommand.append(" AND ");
					sqlCommand.append("u.full_name Like '%" + fullName + "%' ");
				} else {
					if (grpId > 0) {
						sqlCommand.append("WHERE ");
						sqlCommand.append("u.group_id = " + grpId);
					}
					if (name.length() > 0) {
						sqlCommand.append("WHERE ");
						sqlCommand.append("u.full_name Like'%" + fullName
								+ "%' ");
					}
				}
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());

				// run SQL
				rs = preparedStatement.executeQuery();

				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						totalUsers = rs.getInt("total");
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return totalUsers;
	}

	@Override
	public List<TblUser> getListLoginUser(String loginname) {

		List<TblUser> lsLoginUsers = new ArrayList<TblUser>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT login_name ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("Where u.login_name = '" + loginname + "'");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						TblUser tblUser = new TblUser(rs
								.getString("login_name"));
						lsLoginUsers.add(tblUser);
					}
					rs.close();
				}
			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();
		}
		return lsLoginUsers;
	}

	@Override
	public List<TblUser> getListEmail(String isemail) {
		// TODO Auto-generated method stub
		List<TblUser> lsEmail = new ArrayList<TblUser>();
		System.out.println("email " + isemail);
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT email ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("Where u.email = '" + isemail + "'");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						TblUser tblUser = new TblUser(rs.getString("email"));
						lsEmail.add(tblUser);
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return lsEmail;
	}

	@Override
	public List<TblUser> getListIdUser(int iduser) {
		List<TblUser> lsIdUser = new ArrayList<TblUser>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT user_id ");
				sqlCommand.append("FROM tbl_user AS u ");
				sqlCommand.append("Where u.user_id = '" + iduser + "'");
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						TblUser tblUser = new TblUser(rs.getInt("user_id"));
						lsIdUser.add(tblUser);
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return lsIdUser;
	}


/////

////

///

	@Override
	public List<TblUser> checkEmailOrLogin(String checkemailorlogin,
			String valuecheck, int id) {
		List<TblUser> lsIdUser = new ArrayList<TblUser>();
		if (connectToDB()) {
			try {
				StringBuilder sqlCommand = new StringBuilder();
				sqlCommand.append("SELECT user_id, login_name, email ");
				sqlCommand.append("FROM tbl_user AS u ");
				if ("loginName".equals(checkemailorlogin)) {
					sqlCommand.append("Where u.user_id = '" + id + "' ");
					sqlCommand.append("OR u.login_name = '" + valuecheck + "'");
				} else if ("email".equals(checkemailorlogin)) {
					sqlCommand.append("Where u.user_id = '" + id + "' ");
					sqlCommand.append("OR u.email = '" + valuecheck + "' ");
				}
				preparedStatement = connection.prepareStatement(sqlCommand
						.toString());
				// run SQL
				rs = preparedStatement.executeQuery();
				// read result from SQL
				if (rs != null) {
					while (rs.next()) {
						TblUser tblUser = new TblUser(rs.getInt("user_id"), rs
								.getString("email"), rs.getString("login_name"));
						lsIdUser.add(tblUser);
					}
					rs.close();
				}

			} catch (Exception e) {
				System.out.println("an exception occur: " + e.getMessage());
			}
			closeConnect();

		}
		return lsIdUser;
	}

////
///
}
