package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	public static void addNewUser(User user) throws SQLException {
		Connection conn = DB.connect();
		String query = Query.insertNewUser;
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, user.uName);
		statement.setString(2, user.uPassword);
		statement.setString(3, user.uPhoneNo);
		statement.setString(4, user.uEmail);
		statement.setDate(5,Date.valueOf(user.dob));
		statement.setString(6, user.ucountry);
		statement.setString(7, user.ustate);
		statement.setString(8, user.ucity);
		statement.setString(9, user.upincode);
		statement.setString(10, user.uGender);
		statement.setBinaryStream(11, user.uProfilePic);
		statement.setString(12, user.uAddress);
		statement.executeUpdate();
		statement.close();
		conn.close();
	}

	public static int AuthenticateUser(String text, String text2) throws SQLException {
		Connection connection = DB.connect();
		String query = Query.authUser;

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, text2);
		statement.setString(2, text);
		ResultSet resultSet;
		resultSet = statement.executeQuery();
		int count=0;
		while(resultSet.next()) {
			data u = data.getInstance();
			u.setUserID(resultSet.getString(1));
			u.setUser(resultSet.getString(3));
			u.setProfilePicture(resultSet.getBinaryStream(4));
			count++;
		}
		statement.close();
		connection.close();
		return count;
		
	}
	
	
//	add user details function
	public static User details(int uid) throws SQLException {
		User user = new User();
		Connection conn = DB.connect();
		String query = Query.getUser;
		
		PreparedStatement statement = conn.prepareStatement(query);
		statement.setString(1, Integer.toString(uid));
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()) {
			user.uId = resultSet.getInt(1);
			user.uName = resultSet.getString(2);
			user.uPassword = resultSet.getString(3);
			user.uPhoneNo = resultSet.getString(4);
			user.uEmail = resultSet.getString(5);
			Date date = resultSet.getDate(6);
			user.dob = date.toLocalDate();
			user.ucountry = resultSet.getString(7);
			user.ustate = resultSet.getString(8);
			user.ucity = resultSet.getString(9);
			user.upincode = resultSet.getString(10);
			user.uProfilePic = resultSet.getBinaryStream(12);
			
		}
		statement.close();
		conn.close();
		return user;
		
	}
}
