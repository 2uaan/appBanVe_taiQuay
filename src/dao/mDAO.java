package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.jdbc_new;
import model_data.movie;

public class mDAO {
	
	Connection connect = null;
	
	public movie[] exportMovie(){
		movie[] m = null;
		int num = 0;
		
		try {
			connect = jdbc_new.getConnection();
			
			String sql = "SELECT * FROM movie";
			PreparedStatement pst = connect.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			
			while (result.next()) {
				String temp = result.getString("m_name");
				num++;
			}
			
			result = pst.executeQuery();
			m = new movie[num];
			int i = 0;
			
			while(result.next()) {
				m[i] = new movie();
				int m_id = result.getInt("m_id");
				String m_name = result.getString("m_name");
				int duration = result.getInt("duration");
				String premiere_day =  result.getString("premiere_day");
				
				m[i].setM_id(m_id);
				m[i].setM_name(m_name);
				m[i].setDuration(duration);
				m[i].setPremiere_day(premiere_day);
				i++;
			}
			
			jdbc_new.closeConnection(connect);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return m;
	}
	
	public String[][] exportM_name() {
		movie[] m = exportMovie();
		String[][] mn = new String[2][m.length];
		
		for (int i = 0; i < m.length; i++) {
			mn[1][i] = m[i].getM_name();
			mn[0][i] = m[i].getM_id() +"";
 		}
		
		return mn;
	}
	
	public String exportMSelected_name(int m_id) {
		String name = "";
		movie m[] = exportMovie();
		
		for (int i = 0; i<m.length; i++)
			if (m[i].getM_id() == m_id) name = m[i].getM_name();
		
		return name;
	}
	
}
