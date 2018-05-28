/*
 * Copyright(C) 2015 Luvina Software Company
 *
 * ListUserServlet.java, July 07, 2015 Nguyễn Trường Quân
 */
package net.luvina.manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.luvina.manageuser.utils.Constant;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		session.removeAttribute("loginId");
		session.removeAttribute("password");
		session.removeAttribute("key_search_full_name");
		session.removeAttribute("key_search_group_id");
		session.removeAttribute("sortByFullName");
		session.removeAttribute("sortByCodeLevel");
		session.removeAttribute("sortByEndDate");
		session.removeAttribute("sortType");
		session.removeAttribute("userInfor");
		session.removeAttribute("birthday");
		session.removeAttribute("dateStart");
		session.removeAttribute("dateEnd");

		// Goto page login
		RequestDispatcher req = request.getRequestDispatcher(Constant.ADM001);
		req.forward(request, response);
	}

}
