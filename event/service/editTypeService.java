package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import event.model.Type;
import event.util.DBConnect;

public class editTypeService {

	private int success;
	
	public void editType(Type type) {
		Connection connection;
		PreparedStatement preparedStatement;
		String name=null;
		int id=0;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check type name
			preparedStatement = connection.prepareStatement("select * from types where name=?");
			preparedStatement.setString(1, type.getType());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				id= rs.getInt(1);
				name = rs.getString(2);	
			}
			
			if(name==null||id==type.getId()) {
				
				//update value
				preparedStatement = connection.prepareStatement("UPDATE types SET name=?,price=? where id=?");
				preparedStatement.setString(1, type.getType());
				preparedStatement.setDouble(2, type.getPrice());
				preparedStatement.setInt(3, type.getId());
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
