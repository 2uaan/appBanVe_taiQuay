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
	
	public void updateIs_selected() {
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE couple"
					+ "\nSET is_selected = 0;";
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
					c[i] = new couple(
							result.getString(1), 
							result.getInt(2) == 0 ? false : true, 
							result.getInt(3), 
							result.getInt(4) == 0 ? false : true);
					
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
	
	public boolean checkSelected() {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM couple";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				int temp = result.getInt("is_selected");
				if ( temp != 0) {
					check = true;
					break;
				}
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return check;
	}
	
	public void selectedToState() {
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM couple";
			PreparedStatement pst = connect.prepareStatement(sql);
			
			sql = "UPDATE couple"
					+ "\nSET state = 1"
					+ "\nWHERE is_selected = 1";
			pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public couple[] get_coupleSelected() {
		couple[] c = null;
		int id = new msDAO().exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from couple";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
				if (result.getInt("ms_id") == id) {
					if (temp != 0) num++;
				}
				else continue;
			}
			
			result = pst.executeQuery();
			c = new couple[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
				if (result.getInt("ms_id") == id) {
					if (temp != 0) {
						c[i] = new couple(
								result.getString(1), 
								result.getInt(2) == 0 ? false : true, 
								result.getInt(3), 
								result.getInt(4) == 0 ? false : true);
						i++;
					}
				}
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return c;
	}
	
	public couple[] get_cStateTrue(int ms_id) {
		couple[] c = null;
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from couple"
					+ "\nWHERE ms_id = "+ms_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("state");
				if (temp != 0) num++;
				else continue;
			}
			
			result = pst.executeQuery();
			c = new couple[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt(2);
					if (temp != 0) {
						c[i] = new couple(
								result.getString(1), 
								result.getInt(2) == 0 ? false : true, 
								result.getInt(3), 
								result.getInt(4) == 0 ? false : true);
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
