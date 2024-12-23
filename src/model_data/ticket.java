package model_data;

public class ticket {
	
	private int ts_id;
	private String food;
	private String drink;
	private String seat;
	private String day_time;
	
	public ticket(int ts_id, String food, String drink, String seat, String day_time) {
		super();
		this.ts_id = ts_id;
		this.food = food;
		this.drink = drink;
		this.seat = seat;
		this.day_time = day_time;
	}
	
	public ticket() {
		
	}
	
	

	public String getDay_time() {
		return day_time;
	}

	public void setDay_time(String day_time) {
		this.day_time = day_time;
	}

	public int getTs_id() {
		return ts_id;
	}

	public void setTs_id(int ts_id) {
		this.ts_id = ts_id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getDrink() {
		return drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}
	
	
}
