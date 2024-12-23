package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class nsDAO {
	
	private Connection connect = null;
	private msDAO msdao = new msDAO();
	
	public void updateIs_selected() {
			
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE ns"
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
			
			String sql = "UPDATE ns"
					+ "\nSET state = 1"
					+ "\nWHERE is_selected = 1";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean getState_ns(String name, int ms_id) {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT state FROM ns"
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
	
	public void setState_ns(String name, int ms_id) {
			
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE ns"
					+ "\nSET state = 1"
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public boolean getIs_selected_ns(String name, int ms_id) {	
		boolean check = false;
				
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT is_selected FROM ns"
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
	
	public void setIs_selected_ns(String name, int ms_id, boolean yn) {
		
		int temp = yn ? 1 : 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "UPDATE ns"
					+ "\nSET is_selected = " + temp
					+ "\nWHERE m_name = '"+name+"' AND ms_id = "+ms_id+";";
			PreparedStatement pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public near_screen[] exportNS() {
		
		near_screen[] ns = null;
		int id = msdao.exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from ns";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("m_name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			ns = new near_screen[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("m_name");
					if (result.getInt("ms_id") == id) {
						ns[i] = new near_screen(
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
		
		return ns;
	}
	
	public String remove_second(String time) {
		String temp = "";
		for (int i = 0; i < time.length()-1; i++) temp += time.charAt(i);
		return temp;
	}
	
	public void addNS(int ms_id) {
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "INSERT INTO ns \nVALUES";
			
			for (int j = 1; j<25; j++) {
				sql+= "\n(?,0,"+ms_id+",0),";
			}
			
			sql = remove_second(sql) + ";";
			
			System.out.println(sql);
			
			PreparedStatement pst = connect.prepareStatement(sql);
			for (int i =0; i<2; i++) {
				char ch;
				if (i==0) ch = 'A';
				else ch = 'B';
				for (int j = 1; j< 13; j++) {
					pst.setString(i*12 + j, ch+""+j);
				}
			}
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
	public boolean checkSelected() {
		boolean check = false;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM ns";
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
	
	public near_screen[] get_nsSelected() {
		near_screen[] ns = null;
		int id = new msDAO().exportSelected_ms().getMs_id();
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from ns"
					+ "\nWHERE ms_id = " + id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
				if (temp != 0) num++;
				else continue;
			}
			
			result = pst.executeQuery();
			ns = new near_screen[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt("is_selected");
					if (temp != 0) {
						ns[i] = new near_screen(
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
		
		return ns;
	}
	
	public near_screen[] get_nsStateTrue(int ms_id) {
		near_screen[] ns = null;
		int num = 0;
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "Select * from ns "
					+ "\nWHERE ms_id = "+ms_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				int temp = result.getInt("state");
				if (temp != 0) num++;
				else continue;
			}
			
			result = pst.executeQuery();
			ns = new near_screen[num];
			int i = 0;
			
			while (result.next()) {
				int temp = result.getInt(2);
					if (temp != 0) {
						ns[i] = new near_screen(
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
		
		return ns;
	}
	
	
}
