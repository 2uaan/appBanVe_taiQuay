package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import dao.*;
import model_data.*;
import view.newTicketView;

public class testData {
	public static void main(String[] args) {
		//
//		food[] f = new foodDAO().get_foodSelected();
//		drink[] d = new drinkDAO().get_drinkSelected();
//		String food = "";
//		String drink = "";
//		
//		for (int i = 0; i< f.length; i++) {
//			food += f[i].getF_name() + "~" + f[i].getNum_selected();
//		}
//		
//		for (int i = 0; i< d.length; i++) {
//			drink += d[i].getD_name() + "~" + d[i].getNum_selected();
//		}
//		System.out.println(food + drink);
		LocalDate dateNow = LocalDate.now();
		LocalTime timeNow = LocalTime.now();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dateNow.format(formatter);
		formatter = DateTimeFormatter.ofPattern("HH:mm");
        String time = timeNow.format(formatter);
        System.out.println(date);
        System.out.println(time);
		
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
//			System.out.println(temp[i].getMs_id() + "-----" + i + "-----" + temp[i].getName());
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
