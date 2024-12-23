package model_data;

public class movie_screening {
	
	private int ms_id;
	private int m_id;
	private int order_cinema;
	private String time_in;
	private String time_out;
	private String day;
	private boolean state;
	
	
	public movie_screening(int ms_id, int m_id, int order_cinema, String time_in, String time_out, String day, boolean state) {
		super();
		this.ms_id = ms_id;
		this.m_id = m_id;
		this.order_cinema = order_cinema;
		this.time_in = time_in;
		this.time_out = time_out;
		this.day = day;
		this.state = state;
	}
	
	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public movie_screening(){
		
	}

	public int getMs_id() {
		return ms_id;
	}

	public void setMs_id(int ms_id) {
		this.ms_id = ms_id;
	}

	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public int getOrder_cinema() {
		return order_cinema;
	}

	public void setOrder_cinema(int order_cinema) {
		this.order_cinema = order_cinema;
	}

	public String getTime_in() {
		return time_in.substring(0, time_in.length()-3);
	}

	public void setTime_in(String time_in) {
		this.time_in = time_in;
	}

	public String getTime_out() {
		return time_out.substring(0, time_out.length()-3);
	}

	public void setTime_out(String time_out) {
		this.time_out = time_out;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
	

}
