package test;

import dao.*;
import model_data.*;

public class testData {
	public static void main(String[] args) {
		movie_screening[] ms = new msDAO().exportMovie_screening();
		
		String[][] mn = new mDAO().exportM_name();
		
//		String sql = "INSERT INTO ns \nVALUES";
//		
//		for (int i =0; i<2; i++) {
//			char ch;
//			if (i==0) ch = 'A';
//			else ch = 'B';
//			for (int j = 1; j< 13; j++) {
//				sql += "\n('"+(ch+""+j)+"',0,1001),";
//			}
//		}
//		
//		System.out.println(sql);
		
		for (int i = 1; i<6; i++) {
			new nsDAO().addNS(i);
		}
		
//		String str = "17:30:00";
//		System.out.println(new msDAO().remove_second(str));
		
//		for (int i = 0; i < 3; i++) {
//			System.out.println(mn[0][i]);
//		}
//		for (int i = 0; i < 3; i++) {
//			System.out.println(mn[1][i]);
//		}
//		
	}
	
	private static boolean checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return false;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return true;
		else return checkStaff(sta, n-1, sid, spass);
	}
}
