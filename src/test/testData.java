package test;

import dao.*;
import model_data.*;

public class testData {
	public static void main(String[] args) {
		near_screen[] temp = new nsDAO().exportNS();
		
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
		
//		String str = "17:30:00";
//		System.out.println(new msDAO().remove_second(str));
		
		for (int i = 0; i < temp.length; i++) {
			System.out.println(temp[i].getName() + "-----" + i + "-----" + temp[i].isState());
		}
		
//		
	}
	
	private static boolean checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return false;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return true;
		else return checkStaff(sta, n-1, sid, spass);
	}
}
