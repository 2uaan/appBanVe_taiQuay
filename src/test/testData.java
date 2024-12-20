package test;

import dao.*;
import model_data.*;

public class testData {
	public static void main(String[] args) {
//		near_screen[] temp = new nsDAO().exportNS();
		
//		movie_screening ms_select = new msDAO().exportSelected_ms();
		
//		System.out.println(ms_select.getDay());
		
//		boolean check = new nsDAO().getState_ns("A2", 1001);
//		if (check) System.out.println("Ghe da ban");
//		else System.out.println("Ghe trong");
//		
//		new nsDAO().setState_ns("A2", 1001);
//		
//		check = new nsDAO().getState_ns("A2", 1001);
//		if (check) System.out.println("Ghe da ban");
//		else System.out.println("Ghe trong");
		
//		System.out.println("df");
		for (int i = 0 ; i< 5; i ++) System.out.println(new foodDAO().increNum_selected(3001));;
	
		
//		String str = "17:30:00";
//		System.out.println(new msDAO().remove_second(str));
		
//		for (int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i].getD_name() + "-----" + i + "-----" + temp[i].getPrice());
//		}
		
//		
	}
	
	private static boolean checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return false;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return true;
		else return checkStaff(sta, n-1, sid, spass);
	}
}
