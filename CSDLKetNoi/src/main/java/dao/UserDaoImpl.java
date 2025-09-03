package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import plat.dev.DBConnectionMySQL;
import user.User;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String name) {
	    String sql = "SELECT * FROM account WHERE username = ?";
	    try {
	        conn = new DBConnectionMySQL().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, name);
	        rs = ps.executeQuery();

	        if (rs.next()) {
	            User user = new User(0, sql, sql, sql, sql, sql, 0, sql, null);
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setUserName(rs.getString("username"));
	            user.setFullName(rs.getString("fullname"));
	            user.setPassWord(rs.getString("password"));
	            user.setAvatar(rs.getString("avatar"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreatedDate(rs.getDate("createddate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}

	public void insert(User user) {
	    String sql = "INSERT INTO account(email, username, fullname, password, avatar, roleid, phone, createddate) "
	               + "VALUES (?,?,?,?,?,?,?,?)";
	    try (Connection conn = new DBConnectionMySQL().getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, user.getEmail());
	        ps.setString(2, user.getUserName());
	        ps.setString(3, user.getFullName());
	        ps.setString(4, user.getPassWord());
	        ps.setString(5, user.getAvatar());
	        ps.setInt(6, user.getRoleid());
	        ps.setString(7, user.getPhone());

	        if (user.getCreatedDate() != null) {
	            ps.setDate(8, new java.sql.Date(user.getCreatedDate().getTime()));
	        } else {
	            ps.setDate(8, null);
	        }

	        ps.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public void findpass(String email) {
		String sql = "SELECT password from account where email = ?";
		try {
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean checkExistEmail(String email) {
		boolean duplicate = false;
		String query = "select * from account where email = ?";
		try {
			conn = new DBConnectionMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;
	}

	@Override
	public boolean checkExistname(String name) {
		boolean duplicate = false;
		String query = "select * from account where username = ?";
		try {
			conn = new DBConnectionMySQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				duplicate = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return duplicate;

	}

	@Override
	public boolean checkExistPhone(String phone) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean checkExistUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}
}
