package com.tuankiet.neww;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.dao.USerDAO;

@WebServlet("/account")
public class account extends HttpServlet {
	private USerDAO userDAO;
	private static final long serialVersionUID = 1L;
	public void init() {
		userDAO = new USerDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<com.xadmin.usermanagement.model.Account> listUser = userDAO.selectAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("Account.jsp");
		dispatcher.forward(request, response);
	}

}
