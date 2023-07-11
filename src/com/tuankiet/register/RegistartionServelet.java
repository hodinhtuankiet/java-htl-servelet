package com.tuankiet.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register")
public class RegistartionServelet extends HttpServlet {
	private Connection conn = null;
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("name");
		String uemail = request.getParameter("email");
		String upassword = request.getParameter("pass");
		String ucontact = request.getParameter("contact");
		RequestDispatcher dispatcher = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;database=users;encrypt=true;trustServerCertificate=true;";
			String user = "sa";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pst = conn.prepareStatement("insert into users(uname,uemail,upassword,ucontact) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upassword);
			pst.setString(4, ucontact);
			
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			if(rowCount > 0)
			{
			request.setAttribute("status", "success");	
			}else {
			request.setAttribute("status", "failed");	
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		    if (conn != null) {
		        try {
		            conn.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	}
	
}
