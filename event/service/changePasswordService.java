package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import event.model.User;
import event.util.DBConnect;

public class changePasswordService {

	private int userChange;
	
	public void changePassword(User user) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		String email=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check email
			preparedStatement = connection.prepareStatement("select * from users where email=? and password=?");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				email = rs.getString(4);	
			}
			
			if(email!=null) {
				
				//update value
				preparedStatement = connection.prepareStatement("UPDATE users SET password=? where email=?");
				preparedStatement.setString(1, Base64.getEncoder().encodeToString(user.getNewPassword().getBytes()));
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setUserChange(1);
				
			}else {
				setUserChange(0);
			}
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
	}
		
	
	public int getUserChange() {
		return userChange;
	}

	public void setUserChange(int userChange) {
		this.userChange = userChange;
	}

}

