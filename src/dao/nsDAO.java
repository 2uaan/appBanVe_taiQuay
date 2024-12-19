package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import database.jdbc_new;

public class nsDAO {
	
	Connection connect = null;
			
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
			
			System.out.println(sql);
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
			
	
}
