package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.Type;
import event.util.DBConnect;

public class eventTypesService {
	
	public ArrayList<Type> getTypes() {
		
		ArrayList<Type> typeList = new ArrayList<Type>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("select id,name,price from types");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Type type = new Type();
				
				type.setId(Integer.parseInt(resultSet.getString(1)));
				type.setType(resultSet.getString(2));
				type.setPrice(Double.parseDouble(resultSet.getString(3)));
				
				typeList.add(type);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return typeList;
	}
	
	public ArrayList<Type> getPackageTypes() {
		
		ArrayList<Type> typeList = new ArrayList<Type>();
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT distinct t.id,t.name,t.price FROM types t,items i where i.typeId=t.id");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Type type = new Type();
				
				type.setId(Integer.parseInt(resultSet.getString(1)));
				type.setType(resultSet.getString(2));
				type.setPrice(Double.parseDouble(resultSet.getString(3)));
				
				typeList.add(type);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {

			System.out.println(e.getMessage());
		}
		
		return typeList;
	}

}
