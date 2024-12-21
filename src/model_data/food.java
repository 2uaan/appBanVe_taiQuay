package model_data;

public class food {
	
	private int food_id;
	private String f_name;
	private int price;
	private int amount;
	private int num_selected;
	
	public food(int food_id, String f_name, int price, int amount, int num_selected) {
		super();
		this.food_id = food_id;
		this.f_name = f_name;
		this.price = price;
		this.amount = amount;
		this.num_selected = num_selected;
	}
	
	public food() {
		
	}
	
	public int getNum_selected() {
		return num_selected;
	}

	public void setNum_selected(int num_selected) {
		this.num_selected = num_selected;
	}

	public int getFood_id() {
		return food_id;
	}

	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
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
