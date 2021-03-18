package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import event.model.User;
import event.util.DBConnect;

public class loginService {
	
	private int loginUser;
	
	public void login(User user) {
		Connection connection;
		PreparedStatement preparedStatement;
		String email=null,type=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check email and password
			preparedStatement = connection.prepareStatement("select * from users where email=? and password=?");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				email = rs.getString(4);
				type = rs.getString(6);
			}
			
			if(email==null) {
				setLoginUser(0);
			}else {
				if(type==null) {
					setLoginUser(1);
				}else if(type.toString().equals("admin")){
					setLoginUser(2);
				}
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}

		
	}

	public int getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(int loginUser) {
		this.loginUser = loginUser;
	}

}
