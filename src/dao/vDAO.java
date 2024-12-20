package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class vDAO {
	
	private Connection connect = null;
	
	public vip[] exportV(int id) {
		
		vip[] v = null;
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from v";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			v = new vip[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("name");
				if (result.getInt("ms_id") == id) {
					v[i] = new vip();
					
					String name = result.getString("name");
					Boolean state = result.getInt("state") == 0 ? false : true;
					int ms_id = result.getInt("ms_id");
					
					v[i].setName(name);
					v[i].setState(state);
					v[i].setMs_id(ms_id);
					
					i++;
				}
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return v;
	}
	
}
