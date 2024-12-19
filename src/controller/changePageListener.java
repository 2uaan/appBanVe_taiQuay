package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dao.staffDAO;
import view.*;


public class changePageListener implements ActionListener{
	private JFrame sourcePage;
	private String landingPage;
	private boolean sourceOn;
	
	
	public changePageListener(JFrame sourcePage, String landingPage, boolean sourceOn) {
		this.sourcePage = sourcePage;
		this.landingPage = landingPage;
		this.sourceOn = sourceOn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sourcePage.setVisible(sourceOn);
		switch (landingPage) {
		case "login":{
			new staffDAO().staffOff();
			loginView temp = new loginView();
			temp.setVisible(true);
			break;
		}
		case "main":{
			mainPageView temp = new mainPageView();
			temp.setVisible(true);
			break;
		}
		case "newTicket":{
			newTicketView temp = new newTicketView();
			temp.setVisible(true);
			break;
		}
		case "ticketSold":{
			ticketSoldView temp = new ticketSoldView();
			temp.setVisible(true);
			break;
		}
		case "allMovie":{
			allMovieView temp = new allMovieView();
			temp.setVisible(true);
			break;
		}
		case "newTicket_movie":{
			newTicketView_movie temp = new newTicketView_movie();
			temp.setVisible(true);
			break;
		}
		case "newTicket_food":{
			newTicketView_food temp = new newTicketView_food();
			temp.setVisible(true);
			break;
		}
	}
	}

	
	
}
