package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.*;

public class foodDAO {
	
	Connection connect = null;
	
	public food[] exportFood() {
		food[] f = null;
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM food";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("f_name");
				num++;
			}
			
			result = pst.executeQuery();
			f = new food[num];
			int i = 0;
			
			while (result.next()) {
				f[i] = new food();
				
				int food_id, price, amount, num_selected;
				food_id = result.getInt("food_id");
				String f_name = result.getString("f_name");
				price = result.getInt("price");
				amount = result.getInt("amount");
				num_selected = result.getInt("num_selected");
				
				f[i].setFood_id(food_id);
				f[i].setF_name(f_name);
				f[i].setPrice(price);
				f[i].setAmount(amount);
				f[i].setNum_selected(num_selected);
				
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return f;
	}
	
	public int increNum_selected(int food_id) {
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM food"
					+ "\nWHERE food_id = " + food_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			int temp = 0;
			
			while (result.next()) {
				temp = result.getInt("num_selected");
			}
			
			
			temp++;
			num = temp;
			sql = "UPDATE food"
					+ "\nSET num_selected = " + temp
					+ "\nWHERE food_id = " + food_id;
			
			pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
		
	}
	public int decreNum_selected(int food_id) {
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM food"
					+ "\nWHERE food_id = " + food_id;
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			int temp = 0;
			
			while (result.next()) {
				temp = result.getInt("num_selected");
			}
			
			
			temp--;
			num = temp;
			sql = "UPDATE food"
					+ "\nSET num_selected = " + temp
					+ "\nWHERE food_id = " + food_id;
			pst = connect.prepareStatement(sql);
			int kq = pst.executeUpdate();
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return num;
	}
	
	public int getNum_selected(int food_id) {
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM food"
					+ "\nWHERE food_id = " + food_id;
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
