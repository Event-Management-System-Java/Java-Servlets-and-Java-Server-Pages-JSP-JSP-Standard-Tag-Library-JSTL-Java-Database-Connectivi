package event.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import event.model.Item;
import event.util.DBConnect;

public class editItemService {

	private int success;
	
	public void editItem(Item item) {
		Connection connection;
		PreparedStatement preparedStatement;
		int id=0;
		String name=null;
		
		try {
			connection = DBConnect.getDBConnection();
			
			//check item name
			preparedStatement = connection.prepareStatement("select * from items where item_name=? and typeId=?");
			preparedStatement.setString(1, item.getName());
			preparedStatement.setInt(2, item.getTypeId());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next())
			{
				id= rs.getInt(1);
				name = rs.getString(2);
			}
			
			if(name==null||id==item.getId()) {
				
				//insert value
				preparedStatement = connection.prepareStatement("UPDATE items SET item_name=?,typeId=?,hours=?,minutes=? where id=?");
				preparedStatement.setString(1, item.getName());
				preparedStatement.setInt(2, item.getTypeId());
				preparedStatement.setInt(3, item.getHours());
				preparedStatement.setInt(4, item.getMinutes());
				preparedStatement.setInt(5, item.getId());
				preparedStatement.execute();
				preparedStatement.close();
				connection.close();
				setSuccess(1);
				
			}else {
				setSuccess(0);
			}
		
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
