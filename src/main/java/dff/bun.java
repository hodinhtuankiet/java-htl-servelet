package dff;

import java.sql.Connection;
import java.sql.DriverManager;

public class bun {
	private Connection conn;
	public bun() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;database=NhaXe;encrypt=true;trustServerCertificate=true;";
			String user = "sa";
			String password = "123456";
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Get a connection");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		bun connect = new bun();
	}
}