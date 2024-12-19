package model_data;

public class staff {
	private int staff_id;
	private String staff_name;
	private boolean state;
	private String password;
	
	public staff(int staff_id, String staff_name, boolean state, String password) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.state = state;
		this.password = password;
	}
	
	public staff() {
		
	}

	public int getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
