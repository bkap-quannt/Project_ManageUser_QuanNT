/*
 * Copyright(C) 2015 Luvina Software Company
 *
 * ListUserServlet.java, July 07, 2015 Nguyễn Trường Quân
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

import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.validates.ValidateUser;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 RequestDispatcher req = request.getRequestDispatcher(Constant.ADM001);
	        req.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String contextPath = request.getContextPath();
	        HttpSession session = request.getSession();
	        List<String> lsErrMessage = new ArrayList<String>();
	        String template = "";

	        String loginId = request.getParameter("loginId").toString();
	        String password = request.getParameter("password").toString();

	        // set data into session
	        session.setAttribute("loginId", loginId);
	        session.setAttribute("password", password);

	        // validate
	        lsErrMessage = ValidateUser.validateLogin(loginId, password);

	        if (lsErrMessage.size() > 0) { // go to page login case error
	            template = Constant.ADM001;
	        } else {
	        	response.sendRedirect(contextPath + "/ListUser.do");
	            return;
	        }
	        // Set lsErrMessage to request
	        request.setAttribute("lsErrMessage", lsErrMessage);

	        // forward ADM001
	        RequestDispatcher req = request.getRequestDispatcher(template);
	        req.forward(request, response);
	    }
}
