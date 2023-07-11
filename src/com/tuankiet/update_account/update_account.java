package com.tuankiet.update_account;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xadmin.usermanagement.dao.USerDAO;
import com.xadmin.usermanagement.model.User;

@WebServlet("/delete_account")
public class update_account extends HttpServlet {
	private USerDAO userDAO;
	private static final long serialVersionUID = 1L;
	public void init() {
		userDAO = new USerDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uemail = request.getParameter("uemail");
		try {
			userDAO.deleteAccount(uemail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("account");
	}

}
