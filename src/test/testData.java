package test;

import dao.*;
import model_data.*;
import view.newTicketView;

public class testData {
	public static void main(String[] args) {
		//
		
//		drink[] temp = new drinkDAO().get_drinkSelected();
//		
//		new foodDAO().updateAmoutAfterBuy();
		for (int i = 1001; i < 1019; i++) {
			new nsDAO().addNS(i);
		}
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
//		for (int i = 0 ; i< 5; i ++) System.out.println(new foodDAO().increNum_selected(3001));;
	
//		System.out.println(new nsDAO().check_numSelected());
//		System.out.println(new vDAO().check_numSelected());
//		System.out.println(new cDAO().check_numSelected());
//		System.out.println(new foodDAO().checkSelected());
//		System.out.println(new drinkDAO().checkSelected());
//		System.out.println(new newTicketView().checkTicket_infor());
		
//		String str = "17:30:00";
//		System.out.println(new msDAO().remove_second(str));
		
//		for (int i = 0; i < temp.length; i++) {
//			System.out.println(temp[i].getD_name() + "-----" + i + "-----" + temp[i].getNum_selected());
//		}
//		
//		System.out.println(price);
		
//		
	}
	
	private static boolean checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return false;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return true;
		else return checkStaff(sta, n-1, sid, spass);
	}
}
