package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.movie;
import model_data.movie_screening;

public class msDAO {
	
	Connection connect = null;
	
	public movie_screening[] selectMS_whereM_id(int m_id) {
		movie_screening ms[] = null;
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM movie_screening"
					+ "\nWHERE m_id = ?";
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, m_id);
			ResultSet result = pst.executeQuery();
			
			while ( result.next()) {
				String temp = result.getString(4);
				num++;
			}
			result = pst.executeQuery();
			ms = new movie_screening[num];
			int i = 0;
			while ( result.next()) {
				ms[i] = new movie_screening(
						result.getInt(1), 
						result.getInt(2),
						result.getInt(3),
						result.getString(4), 
						result.getString(5), 
						result.getString(6), 
						result.getInt(7) == 0 ? false : true
								);
				i++;
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ms;
	}
	
	public movie_screening exportSelected_ms() {
		movie_screening ms = new movie_screening();
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "SELECT * "
					+ "\nFROM movie_screening"
					+ "\nWHERE state = 1;";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			
			ResultSet kq = pst.executeQuery();
			
			while(kq.next()) {
				int ms_id, m_id, order_cinema;
				String time_in, time_out, day;
				
				ms_id = kq.getInt("ms_id");
				m_id = kq.getInt("m_id");
				order_cinema = kq.getInt("order_cinema");
				time_in = kq.getString("time_in");
				time_out = kq.getString("time_out");
				day = kq.getString("day");
				boolean state = kq.getInt("state") ==0 ? false : true;
				
				ms.setMs_id(ms_id);
				ms.setM_id(m_id);
				ms.setOrder_cinema(order_cinema);
				ms.setTime_in(time_in);
				ms.setTime_out(time_out);
				ms.setDay(day);
				ms.setState(state);
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ms;
	}
	
	public void updateMS_state(int id, boolean state) {
		
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "UPDATE movie_screening"
					+ "\nSET state = ?"
					+ "\nWHERE ms_id = ?";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, state ? 1 : 0);
			pst.setString(2, id+"");
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void updateAll_MS_state(boolean state) {
			
		try {
			
			connect = jdbc_new.getConnection();
			String sql = "UPDATE movie_screening"
					+ "\nSET state = ?";
			
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setInt(1, state ? 1 : 0);
			
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public movie_screening[] exportMovie_screening(){
		movie_screening[] ms = null;
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
			
			ms = new movie_screening[num];
			int i = 0;
			
			while(result.next()) {
				ms[i] = new movie_screening();
				int ms_id, m_id, order_cinema;
				String time_in, time_out, day;
				
				ms_id = result.getInt("ms_id");
				m_id = result.getInt("m_id");
				order_cinema = result.getInt("order_cinema");
				time_in = result.getString("time_in");
				time_out = result.getString("time_out");
				day = result.getString("day");
				boolean state = result.getInt("state") ==0 ? false : true;
				
				ms[i].setMs_id(ms_id);
				ms[i].setM_id(m_id);
				ms[i].setOrder_cinema(order_cinema);
				ms[i].setTime_in(time_in);
				ms[i].setTime_out(time_out);
				ms[i].setDay(day);
				ms[i].setState(state);
				
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ms;
	}
	
}
