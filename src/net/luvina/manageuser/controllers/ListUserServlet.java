/*
 * Copyright(C) 2015 Luvina Software Company
 *
 * ListUserServlet.java, July 07, 2015 Nguyá»…n TrÆ°á»�ng QuÃ¢n
 */
package net.luvina.manageuser.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.luvina.manageuser.entities.*;
//import net.luvina.manageuser.logics.impl.UserLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.utils.MessageProperties;

import net.luvina.manageuser.logics.impl.MstGroupLogicImpl;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;

/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fullnameSearch;
	private int groupId;
	private boolean inited = true;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub



		try {
			String contextPath = request.getContextPath();
			TblUserLogicImpl userLogic = new TblUserLogicImpl();
			MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();
			List<MstGroup> listGroup = new ArrayList<MstGroup>();
			List<UserInfor> listUser = new ArrayList<UserInfor>();
			List<Integer> paging = new ArrayList<Integer>();
			HttpSession session = request.getSession();
			TblUser user = new TblUser();
			String message = "";
			String template = "";
			String sortType = "";
			String sortFullName = "";
			String sortCodeLevel = "";
			String sortEndDate = "";
			String fullNameSearchParam = "";
			String groupIdSessionParam = "";
			String groupIdRequestParam = "";
			String buttonSearch = "";
			String sortTypeParam = "";
			String sortFullNameParam = "";
			String sortCodeLevelParam = "";
			String sortEndDateParam = "";
			int page = 0;
			try {
				if (!"".equals(Common.checkLogin(session))) { // TODO bug 3
					template = Common.checkLogin(session);
					response.sendRedirect("index.jsp");
				} else {
					if (inited) {
						fullnameSearch = "";
						groupId = 0;
					} else {
						// / Get data search from request
						fullNameSearchParam = request.getParameter("full_name");
						groupIdRequestParam = request.getParameter("group_id");

						buttonSearch = request.getParameter("btntk");
						if (fullNameSearchParam != null) {
							fullnameSearch = fullNameSearchParam.trim();
						}
						if (groupIdRequestParam != null) {
							groupIdSessionParam = session.getAttribute(
									"key_search_group_id").toString();
							if (buttonSearch != null) {
								groupId = Integer.parseInt(groupIdRequestParam
										.trim());
							} else if (groupIdSessionParam != null) {
								groupId = Integer.parseInt(groupIdSessionParam
										.trim());
							} else {
								groupId = Integer.parseInt(groupIdRequestParam
										.trim());
							}
						}
					}
				}
				if (request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}

				user.setFullName(Common.escapeInjection(fullnameSearch));
				user.setGroupId(groupId);

				// process Paging
				int totalRecord = userLogic.getTotalUsers(user);
				int limit = Integer.parseInt(MessageProperties
						.getMessage("limit"));
				int range = Integer.parseInt(MessageProperties
						.getMessage("range"));
				int totalPage = (int) Math.ceil((double) totalRecord / limit);
				if (page == 0) {
					page = 1;
				}
				if (totalPage == 0) {
					page = 0;
				}
				if (page > totalPage) {
					page = totalPage;
				}
				int offset = (page > 0) ? limit * ((int) page - 1) : 0;
				// int offset = (page - 1) * limit;
				int currentSection = Common.getCurrentSection(page, range);
				int totalSection = Common.getTotalSection(totalPage, range);
				List<Integer> getListPage = Common.getListPage(totalPage, page, range);
				int minPageSection = getListPage.get(0);
				int maxPageSection = getListPage.get(getListPage.size() - 1);
				// Sort user
				sortTypeParam = request.getParameter("sortType");
				sortFullNameParam = request.getParameter("sortByFullName");
				sortCodeLevelParam = request.getParameter("sortByCodeLevel");
				sortEndDateParam = request.getParameter("sortByEndDate");
				if (sortTypeParam != null) {
					sortType = sortTypeParam.trim();
				}
				if (sortFullNameParam != null) {
					sortFullName = sortFullNameParam.trim();
				}
				if (sortCodeLevelParam != null) {
					sortCodeLevel = sortCodeLevelParam.trim();
				}

				if (sortEndDateParam != null) {
					sortEndDate = sortEndDateParam.trim();
				}

				// Search users
				listUser = userLogic.getListUsers(user, offset, limit,
						sortType, sortFullName, sortCodeLevel, sortEndDate);

				if (listUser.size() == 0) {
					message = MessageProperties.getMessage("MSG005");
				}

				// Set data search on session
				session.setAttribute("key_search_full_name", fullnameSearch);
				session.setAttribute("key_search_group_id", groupId);
				session.setAttribute("sortByFullName", sortFullName);
				session.setAttribute("sortByCodeLevel", sortCodeLevel);
				session.setAttribute("sortByEndDate", sortEndDate);
				session.setAttribute("sortType", sortType);

				// Set data to page jsp
				request.setAttribute("listUser", listUser);
				request.setAttribute("Paging", paging);
				request.setAttribute("getListPage", getListPage);
				request.setAttribute("currentPage", page);
				request.setAttribute("currentSection", currentSection);
				request.setAttribute("totalSection", totalSection);
				request.setAttribute("minPageSection", minPageSection);
				request.setAttribute("maxPageSection", maxPageSection);
				// request.setAttribute("page", page);
				request.setAttribute("full_name", Common
						.escapeHTML(fullnameSearch));

				request.setAttribute("group_id", groupId);

				// Goto page listUser.jsp
				template = Constant.ADM002;

				// get All Groups
				listGroup = groupLogic.getAllGroup();
				request.setAttribute("listGroup", listGroup);
				// Set message
				request.setAttribute("message", message);
				inited = false;
			} catch (Exception e) {
				response.sendRedirect(contextPath + Constant.SYSTEM_ERROR_JSP
						+ "?type=" + Constant.SYSTEM_ERROR_MESSAGER);
			}
			// Forward
			RequestDispatcher req = request.getRequestDispatcher(template);
			req.forward(request, response);

		} catch (Exception ex) {
			System.out.println("an exception occur:" + ex.getMessage());
		}







/*		try {
			//UserLogicImpl userLogic = new UserLogicImpl();
			List<MstGroup> listGroup = new ArrayList<MstGroup>();
			List<TblUser> listUser = new ArrayList<TblUser>();
			HttpSession session = request.getSession();
			TblUser user = new TblUser();
			String message = "";
			String template = "";
			String fullnameSearch = "";
			String sortByFullName = "";
			String sortByCodeLevel = "";
			String sortByEndDate = "";
			String sortType = "";
			int group_id = 0;
			int page = 0;

			TblUserLogicImpl userLogic = new TblUserLogicImpl();
			MstGroupLogicImpl groupLogic = new MstGroupLogicImpl();
			String contextPath = request.getContextPath();
			List<Integer> paging = new ArrayList<Integer>();

			String sortFullName = "";
			String sortCodeLevel = "";
			String sortEndDate = "";
			String fullNameSearchParam = "";
			String groupIdSessionParam = "";
			String groupIdRequestParam = "";
			String buttonSearch = "";
			String sortTypeParam = "";
			String sortFullNameParam = "";
			String sortCodeLevelParam = "";
			String sortEndDateParam = "";


			// Start fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
			// Start fix bug ID 206 Ã¢â‚¬â€œ NTQuan 2015/07/02
			if (!"".equals(Common.checkLogin(session))) {
				// TODO bug 3
				template = Common.checkLogin(session);
				// End fix bug ID 206 Ã¢â‚¬â€œ NTQuan 2015/07/02
			} else {// Get data search from request tÃƒÂ¬m kiÃ¡ÂºÂ¿m
				if (request.getParameter("sortByFullName") != null) {
					sortByFullName = request.getParameter("sortByFullName");
				}
				if (request.getParameter("sortByCodeLevel") != null) {
					sortByCodeLevel = request.getParameter("sortByCodeLevel");
				}
				if (request.getParameter("sortByEndDate") != null) {
					sortByEndDate = request.getParameter("sortByEndDate");
				}
				if (request.getParameter("sortType") != null) {
					sortType = request.getParameter("sortType");
				}
				// End fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				// Get data search from request
				if (request.getParameter("full_name") != null) {
					// Start fix bug ID 291 Ã¢â‚¬â€œ NTQuan 2015/07/01
					fullnameSearch = Common.escapeHTML(request.getParameter(
							"full_name").toString());
					// End fix bug ID 291 Ã¢â‚¬â€œ NTQuan 2015/07/01
				}
				if (request.getParameter("group_id") != null) {
					// Start fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
					if (request.getParameter("timkiem") != null) {
						group_id = Integer.parseInt(request.getParameter(
								"group_id").toString());
					} else if (session.getAttribute("key_search_group_id") != null) {
						group_id = Integer.parseInt(session.getAttribute(
								"key_search_group_id").toString());
					} else {
						group_id = Integer.parseInt(request.getParameter(
								"group_id").toString());
					}
					// End fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				}
				// }
				if (request.getParameter("page") != null) {
					page = Integer.parseInt(request.getParameter("page"));
				}

				user.setFullName(fullnameSearch);
				user.setGroupId(group_id);

				// process Paging
				int totalRecord = userLogic.getTotalUsers(user);
				int limit = Integer.parseInt(MessageProperties
						.getMessage("limit"));
				int totalPage = (int) Math.ceil((double) totalRecord / limit);

				if (page == 0) {
					page = 1;
				}

				if (totalPage == 0) {
					page = 0;
				}
				if (page > totalPage) {
					page = totalPage;
				}
				int offset = (page > 0) ? limit * ((int) page - 1) : 0;

				// create strPaging
				String strPaging = Common.paging(totalRecord, limit, 3,
						"ListUser.do", page, "paging");

				// Search users
				// ///////////listUser = userLogic.getListUsers(user, offset,
				// limit);
				// Start fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				if ("full_name".equals(sortType)) {
					listUser = userLogic.getListUsers(user, offset, limit);
				} else if ("name_level".equals(sortType)) {
					listUser = userLogic.getListUsers(user, offset, limit);
				} else {
					listUser = userLogic.getListUsers(user, offset, limit);
				}
				// End fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				if (listUser.size() == 0) {
					message = MessageProperties.getMessage("msg_001");
				}

				// Set data search on session
				session.setAttribute("key_search_full_name", fullnameSearch);
				session.setAttribute("key_search_group_id", group_id);
				// Start fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				session.setAttribute("sortByFullName", sortByFullName);
				session.setAttribute("sortByCodeLevel", sortByCodeLevel);
				session.setAttribute("sortByEndDate", sortByEndDate);
				session.setAttribute("sortType", sortType);
				// End fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				// Set data to page jsp
				request.setAttribute("listUser", listUser);
				request.setAttribute("strPaging", strPaging);
				request.setAttribute("page", page);
				// Start fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				String str = "";
				for (int i = 0; i < fullnameSearch.length(); i++) {
					str += "\\";
				}
				if (str.equals(fullnameSearch)) {
					fullnameSearch = fullnameSearch.substring(fullnameSearch
							.length() / 2);
				}
				// End fix bug ID 278 Ã¢â‚¬â€œ NTQuan 2015/07/02
				request.setAttribute("full_name", fullnameSearch);
				request.setAttribute("group_id", group_id);

				// Goto page listUser.jsp
				template = Constant.ADM002;
			}
			// get All Groups
			listGroup = userLogic.getAllGroups();
			request.setAttribute("listGroup", listGroup);

			// Set message
			request.setAttribute("message", message);

			// Forward
			RequestDispatcher req = request.getRequestDispatcher(template);
			req.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		*/
	}

}
