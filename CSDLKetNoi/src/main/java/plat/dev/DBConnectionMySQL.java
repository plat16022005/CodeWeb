package plat.dev;

import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.x.protobuf.MysqlxNotice.Warning.Level;

public class DBConnectionMySQL {
	private static String USERNAME = "root";
	private static String PASSWORD = "@Tuan16022005";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/laptrinhweb";
	private static Connection con;

	public static Connection getConnection() throws SQLException, Exception {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// Test chương trình. Kích phải chuột chọn run as -> java application
	public static void main(String[] args) {
		try {
			Connection conn = DBConnectionMySQL.getConnection();
			Statement stmt = conn.createStatement();
//			stmt.executeUpdate("INSERT INTO User(id, name, address) "
//					+ "VALUES (4, 'Trung', 'HCM')");
			ResultSet rs = stmt.executeQuery("SELECT * FROM account");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString(2) + " " + rs.getString(3));
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//	    try {
//	        new DBConnectionMySQL();
//	        System.out.println("Dit me may");
//	    } catch (Exception e) {
//	    	System.out.println("In cai dau buoi");
//	    }
	}

	private static Object DBConnectionMySQL() {
		// TODO Auto-generated method stub
		return null;
	}
}
