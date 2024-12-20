package model_data;

public class vip {
	
	private String name;
	private boolean state;
	private int ms_id;
	
	public vip(String name, boolean state, int ms_id) {
		super();
		this.name = name;
		this.state = state;
		this.ms_id = ms_id;
	}

	public vip() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public int getMs_id() {
		return ms_id;
	}

	public void setMs_id(int ms_id) {
		this.ms_id = ms_id;
	}
	
}
