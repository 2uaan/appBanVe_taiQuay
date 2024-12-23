package dao;

import java.sql.*;

import database.jdbc_new;
import model_data.*;

public class ticketDAO {
	
	Connection connect = null;
	
	public ticket[] exportTicket() {
		ticket[] t = null;
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM ticketsold";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while(result.next()) {
				String temp = result.getString(2);
				num++;
			}
			
			result = pst.executeQuery();
			t = new ticket[num];
			int i = 0;
			
			while (result.next()) {
				t[i] = new ticket(
						result.getInt(1), 
						result.getString(2), 
						result.getString(3), 
						result.getString(4), 
						result.getString(5));
				i++;
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return t;
	}
	
	public void addNewTicket(String food, String drink, String seat, String day_time) {
		try {
			connect = jdbc_new.getConnection();
			String sql = "INSERT INTO ticketsold (food, drink, seat, day_time)"
					+ "\nVALUES(?,?,?,?)";
			PreparedStatement pst = connect.prepareStatement(sql);
			pst.setString(1, food.equals("") ? "" : food);
			pst.setString(2, drink.equals("") ? "" : drink);
			pst.setString(3, seat.equals("") ? "" : seat);
			pst.setString(4, day_time);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
