package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import event.model.Type;
import event.util.DBConnect;

public class removeTypeService {

	private int success;
	
	public void rmoveType(Type type) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//delete type
			preparedStatement = connection.prepareStatement("DELETE FROM types WHERE id=?");
			preparedStatement.setInt(1, type.getId());
			preparedStatement.execute();
			
			setSuccess(1);
		
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
		}
	}


	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}
	
}
