package model_data;

import java.sql.*;

import database.jdbc_new;

public class chairPrice {
	
	private String type;
	private int price;
	
	public chairPrice(String type, int price) {
		super();
		this.type = type;
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}
	
	public String getPriceK() {
		int temp = price;
		String newPrice = temp/1000 + "K";
		return newPrice;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public chairPrice() {
		
	}
	
	public chairPrice[] get_chairPrices() {
		chairPrice[] cp = null;
		Connection connect = null;
		int num = 0;
		try {
			connect = jdbc_new.getConnection();
			String sql = "SELECT * FROM chairPrice";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("type");
				num++;
			}
			
			result = pst.executeQuery();
			cp = new chairPrice[num];
			int i = 0;
			while(result.next()) {
				cp[i] = new chairPrice();
				
				String type = result.getString("type");
				int price = result.getInt("price");
				
				cp[i].setType(type);
				cp[i].setPrice(price);
				i++;
			}
			
			jdbc_new.closeConnection(connect);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return cp;
	}
	
}
