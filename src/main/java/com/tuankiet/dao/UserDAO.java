package com.tuankiet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tuankiet.model.User;

public class UserDAO {
	private String url = "jdbc:sqlserver://localhost:1433;database=users;encrypt=true;trustServerCertificate=true;";
	private String user = "sa";
	private String password = "123456";
	
	private static final String INSERT_CLIENT_SQL =  "INSERT INTO client" + " (name,email,address,phone,room) VALUES "
			+ "(?,?,?,?,?)";
	
	private static final String SELECT_CLIENT_BY_ID =  "select id,name,email,address,phone,room from client where id=?";
	
	private static final String SELECT_ALL_CLIENT =  "select id,name,email,address,phone,room from client where id=?";
	
	private static final String DELETE_CLIENT_SQL =  "delete from client where id= ?";
	
	private static final String UPDATE_CLIENT_SQL =  "update client set name=?,email=?,address=?,phone=?,room=? where id=?;";
	
	protected Connection getConnection()
	{
		Connection conn=null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String url = "jdbc:sqlserver://localhost:1433;database=users;encrypt=true;trustServerCertificate=true;";
				String user = "sa";
				String password = "123456";
				conn = DriverManager.getConnection(url, user, password);
				System.out.println("Get a connection");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conn;
	}
	public void insertClient(User client)
	{
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getEmail());
			preparedStatement.setString(3, client.getAddress());
			preparedStatement.setString(4, client.getPhone());
			preparedStatement.setString(5, client.getRoom());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateClient(User client) throws SQLException
	{
		boolean rowUpdated;
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL)) {
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getEmail());
			preparedStatement.setString(3, client.getAddress());
			preparedStatement.setString(4, client.getPhone());
			preparedStatement.setString(5, client.getRoom());
			
			preparedStatement.setInt(6, client.getId());
			
			rowUpdated = preparedStatement.executeUpdate() >0;
		}
		return rowUpdated;
	}
	public User selectUser(int id) 
	{
		User user = null;
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID)) {
			preparedStatement.setInt(1, id);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String room = rs.getString("room");
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	public List<User> selectAllUser() 
	{
		List<User> users = new ArrayList<>();
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID)) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String room = rs.getString("room");
				users.add(new User(name, email, address, phone, room));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	public boolean deleteClient(int id) throws SQLException
	{
		boolean rowDelete;
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
			preparedStatement.setInt(1, id);
			
			
			rowDelete = preparedStatement.executeUpdate() >0;
		}
		return rowDelete;
	}
	
}
