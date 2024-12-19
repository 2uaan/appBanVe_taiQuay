package model_data;

public class movie {
	
	private int m_id;
	private String m_name;
	private int duration;
	private String premiere_day;
	
	public movie(int m_id, String m_name, int duration, String premiere_day) {
		super();
		this.m_id = m_id;
		this.m_name = m_name;
		this.duration = duration;
		this.premiere_day = premiere_day;
	}

	public movie() {
		
	}
	
	public int getM_id() {
		return m_id;
	}

	public void setM_id(int m_id) {
		this.m_id = m_id;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getPremiere_day() {
		return premiere_day;
	}

	public void setPremiere_day(String premiere_day) {
		this.premiere_day = premiere_day;
	}
	
}
