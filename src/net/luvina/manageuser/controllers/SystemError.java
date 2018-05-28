package net.luvina.manageuser.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.luvina.manageuser.entities.TblUser;
import net.luvina.manageuser.entities.UserInfor;
import net.luvina.manageuser.logics.impl.TblUserLogicImpl;
import net.luvina.manageuser.utils.Common;
import net.luvina.manageuser.utils.Constant;
import net.luvina.manageuser.utils.MessageProperties;

/**
 * Servlet implementation class SystemError
 */
public class SystemError extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String message = "";
		String template = "";
		HttpSession session = request.getSession();
		if (!"".equals(Common.checkLogin(session))) {
			template = Common.checkLogin(session);
			response.sendRedirect("index.jsp");
		} else {
			String type = request.getParameter("type");
			if ("SYSTEM_ERROR".equals(type)) {
				message = MessageProperties.getMessage("ER015");
				request.setAttribute("message", message);
				template = Constant.SYSTEM_ERROR;
				RequestDispatcher req = request.getRequestDispatcher(template);
				req.forward(request, response);
			}else{
				message = MessageProperties.getMessage("ER015");
				request.setAttribute("message", message);
				template = Constant.SYSTEM_ERROR;
				RequestDispatcher req = request.getRequestDispatcher(template);
				req.forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
