package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import model_component.*;
import dao.*;
import model_data.*;

public class ticketInforView extends JFrame{
	
	//Interface variable
	private JLabel background, qrL, _2uaanCinema, ticketPrice;
	private JLabel topL, movieNameL, dayL, seatL, fndL, timeL;
	private JButton done;
	private JPanel frame, qrFrame, mainFrame;
	private colors colo = new colors();
	private fonT font = new fonT();
	
	//Data variable
	private chairPrice cp[] = new chairPrice().get_chairPrices();
	private movie_screening movie_screening = new msDAO().exportSelected_ms();
	
	public static void main(String[] args) {
		new ticketInforView().setVisible(true);
	}
	
	public ticketInforView() {
		setTitle("Ticket");
		setSize(1020,360);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
//Component in Ticket
		//Ticket information
		String price = "Price: "+ allPrice();
		
		mainFrame = new JPanel();
		mainFrame.setBounds(190, 10, 520, 305);
		mainFrame.setBackground(new Color(0x961414));
		mainFrame.setBorder(BorderFactory.createLineBorder(new Color(0xffceb0), 5));
		mainFrame.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.fill = GridBagConstraints.BOTH;
		
		topL = new JLabel("Customer Ticket:", JLabel.CENTER);
		topL.setFont(font.bahnschrift(18));
		topL.setForeground(Color.white);
		mainFrame.add(topL,gbc);
		
		gbc.gridy++;
		movieNameL = new JLabel(new mDAO().exportMSelected_name(movie_screening.getM_id()).equals("") ? "---" : new mDAO().exportMSelected_name(movie_screening.getM_id()), JLabel.CENTER);
		movieNameL.setFont(font.tilt_neon(50).deriveFont(Font.BOLD));
		movieNameL.setForeground(colo.cineYellow);
		mainFrame.add(movieNameL,gbc);
		
		gbc.gridy++;
		dayL = new JLabel(makeDay(movie_screening), JLabel.CENTER);
		dayL.setFont(font.bahnschrift(18));
		dayL.setForeground(Color.white);
		mainFrame.add(dayL,gbc);
		
		gbc.gridy++;
		seatL = new JLabel(makeSeat(), JLabel.CENTER);
		seatL.setFont(font.tilt_neon(25).deriveFont(Font.BOLD));
		seatL.setForeground(colo.cineYellow);
		mainFrame.add(seatL,gbc);
		
		
		gbc.gridy++;
		fndL = new JLabel(makeFood(), JLabel.CENTER);
		fndL.setFont(font.tilt_neon(18));
		fndL.setForeground(Color.white);
		mainFrame.add(fndL,gbc);
		
		gbc.gridy++;
		timeL = new JLabel(makeTime(movie_screening), JLabel.CENTER);
		timeL.setFont(font.bahnschrift(18));
		timeL.setForeground(Color.white);
		mainFrame.add(timeL,gbc);
		
		
		add(mainFrame);
		
		
		//QR code for money
		qrFrame = new JPanel();
		qrFrame.setBounds(722, 0, 290,330);
		qrFrame.setBackground(new Color(0xffceb0));
		qrFrame.setLayout(null);
		ImageIcon originalIcon = new ImageIcon("image\\qr.png");
		Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		qrL = new JLabel();
		qrL.setIcon(new ImageIcon(scaledImage));
		qrL.setBounds(45,30, 200,200);
		
		_2uaanCinema = new JLabel("2uaan Cinema");
		_2uaanCinema.setBounds(95, 195, 100, 30);
		_2uaanCinema.setFont(font.tilt_neon(15));
		
		ticketPrice = new JLabel(price, JLabel.CENTER);
		ticketPrice.setBounds(0, 240, 290, 30);
		ticketPrice.setFont(font.tilt_neon(25));
	
		
		done = new JButton("Done");
		done.setBounds(105, 280, 80, 35);
		done.setMargin(new Insets(0, 0, 0, 0));
		done.setFont(font.tilt_neon(20).deriveFont(Font.BOLD));
		done.setBackground(colo.cineBrown);
		done.setForeground(colo.cineYellow);
		done.setBorder(BorderFactory.createLoweredBevelBorder());
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		done.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new nsDAO().selectedToState();
				new vDAO().selectedToState();
				new cDAO().selectedToState();
				new foodDAO().updateAmoutAfterBuy();
				new drinkDAO().updateAmoutAfterBuy();
				
				food[] f = new foodDAO().get_foodSelected();
				drink[] d = new drinkDAO().get_drinkSelected();
				String food = "";
				String drink = "";
				String str = makeSeat();
				
				LocalDate dateNow = LocalDate.now();
				LocalTime timeNow = LocalTime.now();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				String date = dateNow.format(formatter);
				formatter = DateTimeFormatter.ofPattern("HH:mm");
		        String time = timeNow.format(formatter);
				
				if (f.length == 0) food = "";
				else {
					for (int i = 0; i< f.length; i++) {
						food += f[i].getF_name() + "~" + f[i].getNum_selected() + " || ";
					}
					food = food.substring(0, food.length()-4);					
				}
				
				if (d.length == 0) drink = "";
				else {					
					for (int i = 0; i< d.length; i++) {
						drink += d[i].getD_name() + "~" + d[i].getNum_selected() + " || ";
					}
					drink = drink.substring(0, drink.length()-4);
				}
				
				
				
				String seat = "";
				
				if (str.equals("  -----  ")) seat = "";
				else {
					
					seat = str.substring(0, str.length()-15) + "~" +str.substring(str.length()-6);
					
					str = seat;
					seat = "";
					for (int i = 0; i< str.length(); i++) {
						if (str.charAt(i) == ' ') {
							continue;
						}else seat += str.charAt(i);
					}
					seat += "~"+ movie_screening.getTime_in();
				}
				
				
				new ticketDAO().addNewTicket(food, drink ,seat, time + " " + date);
				
				mainPageView mp = new mainPageView();
				mp.setVisible(true);
				setVisible(false);
			}
		});
		done.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				done.setBorder(BorderFactory.createLoweredBevelBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				done.setBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		qrFrame.add(done);
		qrFrame.add(ticketPrice);
		qrFrame.add(_2uaanCinema);
		qrFrame.add(qrL);
		
		
		add(qrFrame);
		
		//Background
		originalIcon = new ImageIcon("image\\ticket.png");
        scaledImage = originalIcon.getImage().getScaledInstance(1020, 330, Image.SCALE_SMOOTH);
		background = new JLabel();
		background.setIcon(new ImageIcon(scaledImage));
		background.setBounds(0,-20,this.getWidth(),this.getHeight());
		add(background);
		
	}

	public String makeSeat() {
		String seat = "  -----  ";
		near_screen[] ns = new nsDAO().get_nsSelected();
		vip[] v = new vDAO().get_vipSelected();
		couple[] c = new cDAO().get_coupleSelected();
		if (v.length != 0 || ns.length != 0 || c.length != 0) {
			String temp = "";
			seat += "Room " + movie_screening.getOrder_cinema();
			for (int i = 0; i < ns.length; i++) {
				temp += ns[i].getName() + " - ";
			}
			for (int i = 0; i < v.length; i++) {
				temp += v[i].getName() + " - ";
			}
			for (int i = 0; i < c.length; i++) {
				temp += c[i].getName() + " - ";
			}
			
			if (temp.equals("") == false) temp = temp.substring(0, temp.length()-3);
			seat = temp + seat;
		}
		
		
		return seat;
	}
	
	public String makeFood() {
		food[] f = new foodDAO().get_foodSelected();
		drink[] d = new drinkDAO().get_drinkSelected();
		String fnd = "<html><div style='text-align: center;'>Food: ";
		int check = 0;
		
		if (f.length == 0 && d.length == 0) fnd += "---<br>Drink: ---";
		else {
			if (f.length == 0) {
				fnd += "---";
			}else {
				for (int i = 0; i< f.length; i++) {
					fnd += f[i].getNum_selected() + "-" + f[i].getF_name() + " || ";
				}
				fnd = fnd.substring(0, fnd.length()-4);
			}
			fnd += "<br>Drink:";
			if (d.length ==  0) {
				fnd += " ---";
			}else {
				for (int i = 0; i< d.length; i++) {
					fnd += d[i].getNum_selected() + "-" + d[i].getD_name() + " || ";
				}
				fnd = fnd.substring(0, fnd.length()-4);
			}
		}
		
		fnd = fnd+"</div></html>";
		
		return fnd;
	}
	
	public String makeTime(movie_screening ms) {
		String time = "_____________________________________";
		
		if (ms.getMs_id() == 0) {
			time = "---";
		}else time = ms.getTime_in() +time+ ms.getTime_out();
		
		return time;
	}
	
 	public String makeDay(movie_screening ms) {
 		String newDay = "";
 		if (ms.getMs_id() == 0) {
 			newDay = "---";
 		}else {
 			String day = ms.getDay();
 		
			int d = Integer.parseInt(day.substring(day.length()-2, day.length()));
			int m = Integer.parseInt(day.substring(day.length()-5, day.length()-3));
			int y = Integer.parseInt(day.substring(0, 4));
			
			newDay += d +" ";
			
			switch (m) {
				case 1: {
					newDay += "JANUARY" +", ";
					break;
				}
				case 2: {
					newDay += "FEBRUARY" +", ";
					break;
				}
				case 3: {
					newDay += "MARCH" +", ";
					break;
				}
				case 4: {
					newDay += "APRIL" +", ";
					break;
				}
				case 5: {
					newDay += "MAY" +", ";
					break;
				}
				case 6: {
					newDay += "JUNE" +", ";
					break;
				}
				case 7: {
					newDay += "JULY" +", ";
					break;
				}
				case 8: {
					newDay += "AUGUST" +", ";
					break;
				}
				case 9: {
					newDay += "SEPTEMBER" +", ";
					break;
				}
				case 10: {
					newDay += "OCTOBER" +", ";
					break;
				}
				case 11: {
					newDay += "NOVEMBER" +", ";
					break;
				}
				default:{
					newDay += "DECEMBER" +", ";
					break;
				}
			}
			
			newDay += y +"";
 		}
		return newDay;
	}
	
	public String allPrice() {
		String strPrice = "VND";
		
		int price = new foodDAO().foodSelected_price() 
				+  new drinkDAO().drinkSelected_price()
				+ new nsDAO().get_nsSelected().length * cp[0].getPrice()
				+ new vDAO().get_vipSelected().length * cp[1].getPrice()
				+ new cDAO().get_coupleSelected().length * cp[2].getPrice();
		
		int temp = price;
		while(temp/1000 >0) {
			String tempp = "";
			if (temp%1000 ==  0) tempp = "000";
			else if (temp%1000 < 10) tempp = "00" + temp%1000;
			else if (temp%1000 < 100) tempp = "0" + temp%1000;
			else tempp = temp%1000 + "";
			strPrice = "."+ tempp + strPrice;
			temp/=1000;
		}
		
		strPrice = temp + strPrice;
		
		return strPrice;
	}
	
}
