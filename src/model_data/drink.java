package model_data;

public class drink {
	
	private int drink_id;
	private String d_name;
	private int price;
	private int amount;
	private int num_selected;
	
	public drink(int drink_id, String d_name, int price, int amount, int num_selected) {
		super();
		this.drink_id = drink_id;
		this.d_name = d_name;
		this.price = price;
		this.amount = amount;
		this.num_selected= num_selected;
	}
	
	public drink() {
		
	}

	public int getNum_selected() {
		return num_selected;
	}

	public void setNum_selected(int num_selected) {
		this.num_selected = num_selected;
	}

	public int getDrink_id() {
		return drink_id;
	}

	public void setDrink_id(int drink_id) {
		this.drink_id = drink_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public String getPriceK() {
		int temp = price;
		String newPrice = temp/1000 + "K";
		return newPrice;
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
