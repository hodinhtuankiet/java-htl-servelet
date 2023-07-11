package com.tuankiet.insert;

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

@WebServlet("/insert2")
public class insert2 extends HttpServlet {
	private USerDAO userDAO;
	private static final long serialVersionUID = 1L;
	public void init() {
		userDAO = new USerDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String room = request.getParameter("room");
		User newUser = new User(name, email, address, phone, room);
		try {
			userDAO.insertUser(newUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Logout");
	}

}
