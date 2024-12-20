package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class cDAO {
	
	private Connection connect = null;
	
	public boolean getState_c(String name, int ms_id) {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT state FROM couple"
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("state");
				check = temp == 1 ? true : false;
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return check;
	}
	
	public void setState_c(String name, int ms_id) {
			
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE couple"
					+ "\nSET state = 1"
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean getIs_selected_c(String name, int ms_id) {	
		boolean check = false;
				
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT is_selected FROM couple"
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
				check = temp == 1 ? true : false;
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return check;
		
	}
	
	public void setIs_selected_c(String name, int ms_id, boolean yn) {
			
		int temp = yn ? 1 : 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE couple"
					+ "\nSET is_selected = "+ temp
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public couple[] exportC() {
		
		couple[] c = null;
		int id = new msDAO().exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from couple";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("m_name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			c = new couple[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("m_name");
				if (result.getInt("ms_id") == id) {
					c[i] = new couple();
					
					String name = result.getString("m_name");
					Boolean state = result.getInt("state") == 0 ? false : true;
					int ms_id = result.getInt("ms_id");
					Boolean is_selected = result.getInt("is_selected") == 0 ? false : true;
					
					c[i].setName(name);
					c[i].setState(state);
					c[i].setMs_id(ms_id);
					c[i].setIs_selected(is_selected);
					
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
