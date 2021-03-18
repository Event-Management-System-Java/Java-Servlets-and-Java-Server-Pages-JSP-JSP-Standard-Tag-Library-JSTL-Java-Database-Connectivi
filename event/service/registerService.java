package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import event.model.User;
import event.util.DBConnect;
import java.sql.*;
import java.util.Base64;

public class registerService {

	private int userRegister;
	
	public void register(User user) {
		Connection connection;
		PreparedStatement preparedStatement;
		String email=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check email
			preparedStatement = connection.prepareStatement("select * from users where email=?");
			preparedStatement.setString(1, user.getEmail());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				email = rs.getString(4);	
			}
			
			if(email==null) {
				
				//insert value
				preparedStatement = connection.prepareStatement("insert into users (fname,lname,email,password) values (?,?,?,?)");
				preparedStatement.setString(1, user.getFname());
				preparedStatement.setString(2, user.getLname());
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setUserRegister(1);
				
			}else {
				setUserRegister(0);
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}

		
	}

	public int getUserRegister() {
		return userRegister;
	}

	public void setUserRegister(int userRegister) {
		this.userRegister = userRegister;
	}
	
}
