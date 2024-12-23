package test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import dao.*;
import model_data.*;
import view.loginView;
import view.newTicketView;
import view.acceptView.welcomeStaffView;

public class testData {
	
	public static void main(String[] args) {
		welcomeStaffView lg = new welcomeStaffView();
		lg.setVisible(true);
	}
}
