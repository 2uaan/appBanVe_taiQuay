package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class vDAO {
	
	private Connection connect = null;
	
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
					v[i] = new vip();
					
					String name = result.getString("m_name");
					Boolean state = result.getInt("state") == 0 ? false : true;
					int ms_id = result.getInt("ms_id");
					Boolean is_selected = result.getInt("is_selected") == 0 ? false : true;
					
					v[i].setName(name);
					v[i].setState(state);
					v[i].setMs_id(ms_id);
					v[i].setIs_selected(is_selected);
					
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
