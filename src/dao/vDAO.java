package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class vDAO {
	
	private Connection connect = null;
	
	public void updateIs_selected() {
			
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE v"
					+ "\nSET is_selected = 0;";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void selectedToState() {
		try {
			connect = jdbc_new.getConnection();
			
			String sql = "UPDATE v"
					+ "\nSET state = 1"
					+ "\nWHERE is_selected = 1";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean getState_v(String name, int ms_id) {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT state FROM v"
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
	
	public void setState_v(String name, int ms_id) {
			
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE v"
					+ "\nSET state = 1"
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean getIs_selected_v(String name, int ms_id) {	
		boolean check = false;
				
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT is_selected FROM v"
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
	
	public void setIs_selected_v(String name, int ms_id, boolean yn) {
			
		int temp = yn ? 1 : 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE v"
					+ "\nSET is_selected = " + temp
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public vip[] exportV() {
		
		vip[] v = null;
		int id = new msDAO().exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from v";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("m_name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			v = new vip[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("m_name");
				if (result.getInt("ms_id") == id) {
					v[i] = new vip(
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
		
		return v;
	}
	
	public boolean checkSelected() {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM v";
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
	
	public vip[] get_vipSelected() {
		vip[] v = null;
		int id = new msDAO().exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from v";
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
			v = new vip[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
				if (result.getInt("ms_id") == id) {
					if (temp != 0) {
						v[i] = new vip(
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
		
		return v;
	}
	
	public vip[] get_vStateTrue(int ms_id) {
		vip[] v = null;
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from v "
					+ "\nWHERE ms_id = "+ms_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("state");
				if (temp != 0) num++;
				else continue;
			}
			
			result = pst.executeQuery();
			v = new vip[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt(2);
					if (temp != 0) {
						v[i] = new vip(
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
		
		return v;
	}
	
}
