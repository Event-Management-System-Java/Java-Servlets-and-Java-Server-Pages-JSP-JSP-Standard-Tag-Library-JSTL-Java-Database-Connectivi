package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import event.model.Type;
import event.util.DBConnect;

public class addTypeService {

	private int success;
	
	public void addType(Type type) {
		Connection connection;
		PreparedStatement preparedStatement;
		String name=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check type name
			preparedStatement = connection.prepareStatement("select * from types where name=?");
			preparedStatement.setString(1, type.getType());
			ResultSet rs = preparedStatement.executeQuery();
			 
			while(rs.next())
			{
				name = rs.getString(2);	
			}
			
			if(name==null) {
				
				//insert value
				preparedStatement = connection.prepareStatement("insert into types (name,price) values (?,?)");
				preparedStatement.setString(1, type.getType());
				preparedStatement.setDouble(2, type.getPrice());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setSuccess(1);
				
			}else {
				setSuccess(0);
			}
		
		}catch (ClassNotFoundException | SQLException  e) {
			System.out.println(e.getMessage());
		}
	}


	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
}

