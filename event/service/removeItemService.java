package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import event.model.Item;
import event.util.DBConnect;

public class removeItemService {

	private int success;
	
	public void removeItem(Item item) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//delete type
			preparedStatement = connection.prepareStatement("DELETE FROM items WHERE id=?");
			preparedStatement.setInt(1, item.getId());
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
