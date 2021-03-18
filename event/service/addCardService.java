package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import event.model.Card;
import event.util.DBConnect;

public class addCardService {
	
	private int success;

	public void addCard(Card card) {
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
				cardNumber=null;
				
				preparedStatement = connection.prepareStatement("select * from usercards where cardNumber=?");
				preparedStatement.setString(1, card.getCardNumber());
				ResultSet rs1 = preparedStatement.executeQuery();
				
				while(rs1.next())
				{
					cardNumber = rs1.getString(2);
				}
				
				if(cardNumber==null) {
					
					//insert value
					preparedStatement = connection.prepareStatement("insert into usercards (cardNumber,ccv,month,year,userEmail) values (?,?,?,?,?)");
					preparedStatement.setString(1, card.getCardNumber());
					preparedStatement.setInt(2, card.getCcv());
					preparedStatement.setInt(3, card.getMonth());
					preparedStatement.setInt(4, card.getYear());
					preparedStatement.setString(5, card.getUserEmail());
					preparedStatement.execute();
					preparedStatement.close();
					connection.close();
					setSuccess(1);
					
				}else {
					setSuccess(2);
				}
				rs1.close();
				
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
