package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.*;
import event.util.DBConnect;

public class userCardService {
	
	public ArrayList<Card> getCards(String user) {
		
		ArrayList<Card> cardList = new ArrayList<Card>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select * from usercards where userEmail=?");
			preparedStatement.setString(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Card card = new Card();
				
				card.setId(Integer.parseInt(resultSet.getString(1)));
				card.setCardNumber(resultSet.getString(2));
				card.setCcv(Integer.parseInt(resultSet.getString(3)));
				card.setMonth(Integer.parseInt(resultSet.getString(4)));
				card.setYear(Integer.parseInt(resultSet.getString(5)));
				card.setUserEmail(resultSet.getString(6));
				
				cardList.add(card);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return cardList;
	}
	
}
