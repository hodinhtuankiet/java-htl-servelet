package com.xadmin.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xadmin.usermanagement.model.User;


public class USerDAO {
	private String url = "jdbc:sqlserver://localhost:1433;database=users;encrypt=true;trustServerCertificate=true;";
	private String user = "sa";
	private String password = "123456";

	private static final String INSERT_CLIENT_SQL =  "INSERT INTO customer" + " (name,email,address,phone,room) VALUES "
			+ "(?,?,?,?,?)";
	
	private static final String SELECT_CLIENT_BY_ID =  "select id,name,email,address,phone,room from customer where id=?";
	
	private static final String SELECT_ALL_CLIENT =  "select * from customer";
	
	private static final String DELETE_CLIENT_SQL =  "delete from customer where id= ?";
	
	private static final String UPDATE_CLIENT_SQL =  "update customer set name=?,email=?,address=?,phone=?,room=? where id=?;";
	public USerDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;database=users;encrypt=true;trustServerCertificate=true;";
			String user = "sa";
			String password = "123456";
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(User client) throws SQLException {
		System.out.println(INSERT_CLIENT_SQL);
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SQL)) {
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getEmail());
			preparedStatement.setString(3, client.getAddress());
			preparedStatement.setString(4, client.getPhone());
			preparedStatement.setString(5, client.getRoom());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(String id) {
		User user = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String room = rs.getString("room");
				user = new User(name, email, address, phone, room);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {

		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				String room = rs.getString("room");
				users.add(new User(id,name, email, address, phone, room));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(String id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL);) {
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User client) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT_SQL);) {
			preparedStatement.setString(1, client.getName());
			preparedStatement.setString(2, client.getEmail());
			preparedStatement.setString(3, client.getAddress());
			preparedStatement.setString(4, client.getPhone());
			preparedStatement.setString(5, client.getRoom());
			preparedStatement.setString(6, client.getId());

			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}