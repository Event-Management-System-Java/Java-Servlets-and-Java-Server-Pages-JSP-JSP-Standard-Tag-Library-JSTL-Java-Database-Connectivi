package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import event.model.Order;
import event.util.DBConnect;

public class orderCancelService {
	
	private int success;

	public void orderCancel(Order order) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			connection = DBConnect.getDBConnection();
			preparedStatement = connection.prepareStatement("UPDATE payment SET cancel=?,refund=? where id=?");
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, 1);
			preparedStatement.setInt(3, order.getId());
			preparedStatement.execute();
			setSuccess(1);
			preparedStatement.close();
			connection.close();
			
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

	public void orderCancelAdmin(Order order) {
		Connection connection;
		PreparedStatement preparedStatement;
		
		try {
			
			if(order.getRefund()==2) {
				
				connection = DBConnect.getDBConnection();
				preparedStatement = connection.prepareStatement("DELETE FROM payment WHERE id=?");
				preparedStatement.setInt(1, order.getId());
				preparedStatement.execute();
				setSuccess(1);
				preparedStatement.close();
				connection.close();
				
			}else if(order.getRefund()==3) {
				
				connection = DBConnect.getDBConnection();
				preparedStatement = connection.prepareStatement("UPDATE payment SET cancel=?,refund=? where id=?");
				preparedStatement.setInt(1, 0);
				preparedStatement.setInt(2, 3);
				preparedStatement.setInt(3, order.getId());
				preparedStatement.execute();
				setSuccess(2);
				preparedStatement.close();
				connection.close();
				
			}
			
		}catch (ClassNotFoundException | SQLException  e) {
			setSuccess(0);
		}
		
	}

}
