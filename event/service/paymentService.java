package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import event.model.Card;
import event.model.Type;
import event.util.DBConnect;

public class paymentService {
	
	private int success;

	public void confirmPayment(Type type,Card card) {
		Connection connection;
		PreparedStatement preparedStatement;
		String cardNumber=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check card
			preparedStatement = connection.prepareStatement("select * from cards where cardNumber=? and ccv=? and month=? and year=?");
			preparedStatement.setString(1, card.getCardNumber());
			preparedStatement.setInt(2, card.getCcv());
			preparedStatement.setInt(3, card.getMonth());
			preparedStatement.setInt(4, card.getYear());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				cardNumber = rs.getString(2);
			}
			
			if(cardNumber != null) {
				
				//insert value
				preparedStatement = connection.prepareStatement("insert into payment (cardNumber,amount,packageId,userEmail,cancel,refund) values (?,?,?,?,?,?)");
				preparedStatement.setString(1, card.getCardNumber());
				preparedStatement.setDouble(2, type.getPrice());
				preparedStatement.setInt(3, type.getId());
				preparedStatement.setString(4, card.getUserEmail());
				preparedStatement.setInt(5, 0);
				preparedStatement.setInt(6, 0);
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setSuccess(1);
				
			}else {
				setSuccess(0);
			}
			rs.close();
			
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
