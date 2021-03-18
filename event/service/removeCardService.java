package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import event.model.Card;
import event.util.DBConnect;

public class removeCardService {
	
	private int success;

	public void removeCard(Card card) {
		
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//delete type
			preparedStatement = connection.prepareStatement("DELETE FROM usercards WHERE id=?");
			preparedStatement.setInt(1, card.getId());
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
