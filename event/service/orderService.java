package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import event.model.Card;
import event.model.Order;
import event.util.DBConnect;

public class orderService {

	public ArrayList<Order> getOrders(String user) {
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT p.id,p.cardNumber,p.amount,t.name,p.cancel,p.refund FROM payment p,types t where p.packageId=t.id and userEmail=?");
			preparedStatement.setString(1, user);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Order order = new Order();
				
				order.setId(Integer.parseInt(resultSet.getString(1)));
				order.setCardNumber(resultSet.getString(2));
				order.setAmount(Double.parseDouble(resultSet.getString(3)));
				order.setOrderPackage(resultSet.getString(4));
				order.setCancel(Integer.parseInt(resultSet.getString(5)));
				order.setRefund(Integer.parseInt(resultSet.getString(6)));
				
				orderList.add(order);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return orderList;
	}
	
	public ArrayList<Order> getOrders() {
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection connection;
		PreparedStatement preparedStatement;
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("SELECT p.id,p.cardNumber,p.amount,t.name,p.cancel,p.refund FROM payment p,types t where p.packageId=t.id");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Order order = new Order();
				
				order.setId(Integer.parseInt(resultSet.getString(1)));
				order.setCardNumber(resultSet.getString(2));
				order.setAmount(Double.parseDouble(resultSet.getString(3)));
				order.setOrderPackage(resultSet.getString(4));
				order.setCancel(Integer.parseInt(resultSet.getString(5)));
				order.setRefund(Integer.parseInt(resultSet.getString(6)));
				
				orderList.add(order);
				
			}
			
			preparedStatement.close();
			connection.close();
			
		}catch (ClassNotFoundException | SQLException  e) {
	
			System.out.println(e.getMessage());
		}
	
		return orderList;
	}
	
}
