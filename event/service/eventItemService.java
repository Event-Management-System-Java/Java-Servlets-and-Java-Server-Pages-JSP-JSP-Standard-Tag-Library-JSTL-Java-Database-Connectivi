package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.Item;
import event.model.Type;
import event.util.DBConnect;

public class eventItemService {

	public ArrayList<Item> getItems() {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select * from items");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Item item = new Item();
				
				item.setId(Integer.parseInt(resultSet.getString(1)));
				item.setName(resultSet.getString(2));
				item.setTypeId(Integer.parseInt(resultSet.getString(3)));
				item.setHours(Integer.parseInt(resultSet.getString(4)));
				item.setMinutes(Integer.parseInt(resultSet.getString(5)));
				
				itemList.add(item);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return itemList;
	}
	
	public ArrayList<Item> getItems(int id) {
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select * from items where typeId=?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Item item = new Item();
				
				item.setId(Integer.parseInt(resultSet.getString(1)));
				item.setName(resultSet.getString(2));
				item.setTypeId(Integer.parseInt(resultSet.getString(3)));
				item.setHours(Integer.parseInt(resultSet.getString(4)));
				item.setMinutes(Integer.parseInt(resultSet.getString(5)));
				
				itemList.add(item);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return itemList;
	}
}
