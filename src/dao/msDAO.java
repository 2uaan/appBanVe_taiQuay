package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.movie;
import model_data.movie_screening;

public class msDAO {
	
	Connection connect = null;
	
	public String remove_second(String time) {
		String temp = "";
		for (int i = 0; i < time.length()-3; i++) temp += time.charAt(i);
		return temp;
	}
	
	public movie_screening[] exportMovie_screening(){
		movie_screening[] m = null;
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			
			String sql = "SELECT * FROM movie_screening";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("day");
				num++;
			}
			
			result = pst.executeQuery();
			m = new movie_screening[num];
			int i = 0;
			
			while(result.next()) {
				m[i] = new movie_screening();
				int ms_id, m_id, order_cinema;
				String time_in, time_out, day;
				
				ms_id = result.getInt("ms_id");
				m_id = result.getInt("m_id");
				order_cinema = result.getInt("order_cinema");
				time_in = result.getString("time_in");
				time_out = result.getString("time_out");
				day = result.getString("day");
				
				m[i].setMs_id(ms_id);
				m[i].setM_id(m_id);
				m[i].setOrder_cinema(order_cinema);
				m[i].setTime_in(remove_second(time_in));
				m[i].setTime_out(remove_second(time_out));
				m[i].setDay(day);
				
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return m;
	}
	
}
