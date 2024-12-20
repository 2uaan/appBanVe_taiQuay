package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.near_screen;
import model_data.*;

public class nsDAO {
	
	private Connection connect = null;
	private msDAO msdao = new msDAO();
	
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
				String temp = result.getString("name");
				if (result.getInt("ms_id") == id) num++;
			}
			
			result = pst.executeQuery();
			ns = new near_screen[num];
			int i = 0;
			
			while (result.next()) {
				String temp = result.getString("name");
					if (result.getInt("ms_id") == id) {
					ns[i] = new near_screen();
					
					String name = result.getString("name");
					Boolean state = result.getInt("state") == 0 ? false : true;
					int ms_id = result.getInt("ms_id");
					
					ns[i].setName(name);
					ns[i].setState(state);
					ns[i].setMs_id(ms_id);
					
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
	
	public void addNS(int num) {
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "INSERT INTO couple \nVALUES";
			
			for (int j = 1; j<13; j++) {
				sql+= "\n(?,0,100"+num+"),";
			}
			
			sql = remove_second(sql) + ";";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			for (int i =0; i<2; i++) {
				char ch;
				if (i==0) ch = 'E';
				else ch = 'F';
				for (int j = 1; j< 7; j++) {
					pst.setString(i*6 + j, ch+""+j);
				}
			}
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
	
}
