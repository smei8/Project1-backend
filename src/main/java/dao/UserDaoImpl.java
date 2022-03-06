package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.UserPojo;

public class UserDaoImpl implements UserDao {

	@Override
	public List<UserPojo> fetchAllAccounts() {
		List<UserPojo> allEmployees  = new ArrayList<UserPojo>();
		Connection conn = DBUtil.obtainConnection();	

		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM users;";
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				UserPojo userpojo = new UserPojo();
				userpojo.setUserID(rs.getInt(1));
				userpojo.setUsername(rs.getString(2));
				userpojo.setFullName(rs.getString(4));
				userpojo.setEmail(rs.getString(5));
				allEmployees.add(userpojo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allEmployees;
	}

	@Override
	public UserPojo fetchAAccount(int userId) {
		UserPojo userpojo = null;
		Connection conn = DBUtil.obtainConnection();

		Statement stmt;
		try {
			stmt = conn.createStatement();
			String query = "SELECT * FROM users WHERE user_id=" + userId;
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				userpojo = new UserPojo();
				userpojo.setUserID(rs.getInt(1));
				userpojo.setUsername(rs.getString(2));
				userpojo.setPassword(rs.getString(3));
				userpojo.setFullName(rs.getString(4));
				userpojo.setEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userpojo;
	}

	@Override
	public UserPojo updateAccount(UserPojo userpojo) {
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "UPDATE users SET password='"+userpojo.getPassword()+"' WHERE user_id="+userpojo.getUserID();
			int rows = stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userpojo;
	}

}
