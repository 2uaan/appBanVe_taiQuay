package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.drink;
import model_data.drink;

public class drinkDAO {
	
	Connection connect = null;
	
	public drink[] exportDrink() {
		drink[] d = null;
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM drink";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("d_name");
				num++;
			}
			
			result = pst.executeQuery();
			d = new drink[num];
			int i = 0;
			
			while (result.next()) {
				d[i] = new drink();
				
				int drink_id, price, amount, num_selected;
				drink_id = result.getInt("drink_id");
				String d_name = result.getString("d_name");
				price = result.getInt("price");
				amount = result.getInt("amount");
				num_selected = result.getInt("num_selected");
				
				d[i].setDrink_id(drink_id);
				d[i].setD_name(d_name);
				d[i].setPrice(price);
				d[i].setAmount(amount);
				d[i].setNum_selected(num_selected);
				
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return d;
	}
	
	public int increNum_selected(int drink_id) {
		int num = 0;	
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM drink"
					+ "\nWHERE drink_id = " + drink_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			int temp = 0;
			
			while (result.next()) {
				temp = result.getInt("num_selected");
			}
			
			
			temp++;
			num = temp;
			sql = "UPDATE drink"
					+ "\nSET num_selected = " + temp
					+ "\nWHERE drink_id = " + drink_id;
			pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
	
	public int decreNum_selected(int drink_id) {
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM drink"
					+ "\nWHERE drink_id = " + drink_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			int temp = 0;
			
			while (result.next()) {
				temp = result.getInt("num_selected");
			}
			
			
			temp--;
			num = temp;
			sql = "UPDATE drink"
					+ "\nSET num_selected = " + temp
					+ "\nWHERE drink_id = " + drink_id;
			pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
	
	public int getNum_selected(int drink_id) {
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM drink"
					+ "\nWHERE drink_id = " + drink_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			int temp = 0;
			
			while (result.next()) {
				temp = result.getInt("num_selected");
			}
			num = temp;
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
	
}
