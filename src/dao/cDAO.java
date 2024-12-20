package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class cDAO {
	
	private Connection connect = null;
	
	public couple[] exportC(int id) {
		
		couple[] c = null;
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from couple";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			c = new couple[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("name");
				if (result.getInt("ms_id") == id) {
					c[i] = new couple();
					
					String name = result.getString("name");
					Boolean state = result.getInt("state") == 0 ? false : true;
					int ms_id = result.getInt("ms_id");
					
					c[i].setName(name);
					c[i].setState(state);
					c[i].setMs_id(ms_id);
					
					i++;
				}
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c;
	}
	
}
