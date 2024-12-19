package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dao.staffDAO;
import model_data.*;
import view.loginView;
import view.mainPageView;

public class loginListener implements ActionListener{
	private int id;
	private String password;
	private staff[] st = new staffDAO().exportStaff();
	private JFrame sourcePage;
	
	public loginListener(JFrame sourcePage, int id, String password) {
		super();
		this.id = id;
		this.password = password;
		this.sourcePage =sourcePage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(id);
		System.out.println(password);
		if (checkStaff(st, st.length, id, password)) {
			sourcePage.setVisible(false);
			mainPageView temp = new mainPageView();
			temp.setVisible(true);
		}else {
			System.out.println("SOS");
		}
		
	}
	
	private static boolean checkStaff(staff[] sta, int n, int sid, String spass) {
		if (n==0) return false;
		else if (sta[n-1].getStaff_id() == sid && sta[n-1].getPassword().equals(spass)) return true;
		else return checkStaff(sta, n-1, sid, spass);
	}

}
