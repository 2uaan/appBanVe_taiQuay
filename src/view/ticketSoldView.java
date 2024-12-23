package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import controller.*;
import dao.ticketDAO;
import model_component.*;
import model_data.*;

public class ticketSoldView extends JFrame{
	
	private JPanel frame, vertical, horizontal, soldFrame;
	private JScrollPane soldScroll;
	private JButton backToMainPage,  refresh;
	private JLabel stt_col, food_col, drink_col, seat_col, timeDate_col;
	private GridBagConstraints gbc = new GridBagConstraints();
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	
	// Data variable
	private ticket[] t = new ticketDAO().exportTicket();
	
	public static void main(String[] args) {
		new ticketSoldView().setVisible(true);
	}
	
	public ticketSoldView() {
		setTitle("TicKet Sold");
		setSize(1000,675); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		new JButton("✓ Done");
		
		backToMainPage = new JButton("←");
		backToMainPage.setForeground(Color.white);

		
// 		Main Component
//		grid.setRows(1);
		
		Border solid = BorderFactory.createLineBorder(colo.cineBlack);
		
		stt_col = new JLabel(" No.");
		food_col = new JLabel(" Food");
		drink_col = new JLabel(" Drink");
		seat_col = new JLabel(" Seat");
		timeDate_col = new JLabel(" Time/Date:");
		
		stt_col.setBounds(110, 50, 60, 30);
		stt_col.setBorder(solid);
		stt_col.setFont(font.bahnschrift(15));
		
		food_col.setBounds(170, 50, 180, 30);
		food_col.setBorder(solid);
		food_col.setFont(font.bahnschrift(15));
		
		drink_col.setBounds(350, 50, 180, 30);
		drink_col.setBorder(solid);
		drink_col.setFont(font.bahnschrift(15));
		
		seat_col.setBounds(530, 50, 295, 30);
		seat_col.setBorder(solid);
		seat_col.setFont(font.bahnschrift(15));
		
		timeDate_col.setBounds(825, 50, 125, 30);
		timeDate_col.setBorder(solid);
		timeDate_col.setFont(font.bahnschrift(15));
		
		soldFrame = new JPanel();
		soldFrame.setLayout(new GridBagLayout());
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 10, 10, 10);
		
		makeTickketSold();
		
		soldScroll = new JScrollPane(soldFrame);
		soldScroll.setBounds(110, 80, 840, 440);
		
		
		
		add(stt_col);
		add(food_col);
		add(drink_col);
		add(seat_col);
		add(timeDate_col);
		add(soldScroll);
		
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1000,70);
		vertical.setLayout(null);
		horizontal.setLayout(null);
		vertical.setBackground(colo.cineYellowOpa(150));
		horizontal.setBackground(colo.cineYellowOpa(150));
		
//		Component in Vertical Bar

		Border etched = BorderFactory.createEtchedBorder();
		Border margin = BorderFactory.createEmptyBorder(0,0,5,0);
		Border margin2 = BorderFactory.createEmptyBorder(0,0,0,0);
		Border combi = BorderFactory.createCompoundBorder(etched, margin);
		
		backToMainPage.setBounds(10,20,50,40);
		backToMainPage.setFont(font.tilt_neon(35));
		backToMainPage.setFocusPainted(false);
		backToMainPage.setBackground(colo.cineYellow);
		backToMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToMainPage.setBorder(combi);
		backToMainPage.setToolTipText("Main Page");
		backToMainPage.addActionListener(new changePageListener(this, "main", false));
		backToMainPage.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				backToMainPage.setBorder(combi);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Border temp = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown), margin);
				backToMainPage.setBorder(temp);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				backToMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				backToMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		ImageIcon before = new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\interface_icon\\refresh.png");
		Image after = before.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		refresh = new JButton();
		refresh.setIcon(new ImageIcon(after));
		refresh.setBounds(10,70,50,40);
		refresh.setFont(font.tilt_neon(35));
		refresh.setFocusPainted(false);
		refresh.setBackground(colo.cineYellow);
		refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		refresh.setBorder(etched);
		refresh.setToolTipText("Main Page");
		refresh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ticketSoldView ts = new ticketSoldView();
				ts.setVisible(true);
			}
		});
		refresh.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				refresh.setBorder(etched);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Border temp = BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown);
				refresh.setBorder(temp);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				refresh.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				refresh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		vertical.add(refresh);
		vertical.add(backToMainPage);
		
//		Componen in Horizontal Bar		
		
		
		deco_goc();
		add(vertical);
		add(horizontal);
		
		
	}
	
	public void makeTickketSold() {
		
		int left = 0;
		if (t.length > 3) left = 15;
		for (int i = t.length - 1; i >= 0; i--) {
			JPanel temp = new JPanel();
			temp.setPreferredSize(new Dimension(0, 100));
			temp.setBackground(colo.cineYellow);
			temp.setLayout(new GridBagLayout());
			GridBagConstraints gbcc = new GridBagConstraints();
			
			String food, drink, seat, td;
			food = t[i].getFood();
			drink =t[i].getDrink();
			seat = t[i].getSeat();
			td = t[i].getDay_time();
			
			food = strArray_to_foodLabel(str_to_strArray(food));
			drink = strArray_to_foodLabel(str_to_strArray(drink));
			seat = detachSeat_byChar(seat, '~');
			td = detachSeat_byChar(td, ' ');
			
			
			gbcc.gridx = 0;
			gbcc.gridy = 0;
			gbcc.weightx = 1;
			gbcc.weighty = 1;
			gbcc.gridheight = 1;
			gbcc.gridwidth = 1;
			gbcc.fill = GridBagConstraints.VERTICAL;
			gbcc.insets = new Insets(0, 0, 0, 0);
			
			JLabel stt, foodL, drinkL, seatL, timeDateL;
			
			stt = new JLabel((i+1)+"", JLabel.CENTER);
			stt.setPreferredSize(new Dimension(40,0));
			stt.setBorder(BorderFactory.createLineBorder(colo.cineBlack));
			stt.setFont(font.tilt_neon(15));
			temp.add(stt, gbcc);
			gbcc.gridx++;
			
			foodL = new JLabel(food);
			foodL.setPreferredSize(new Dimension(180 ,0));
			foodL.setBorder(BorderFactory.createLineBorder(colo.cineBlack));
			foodL.setFont(font.tilt_neon(15));
			temp.add(foodL, gbcc);
			gbcc.gridx++;
			
			drinkL = new JLabel(drink);
			drinkL.setPreferredSize(new Dimension(180,0));
			drinkL.setBorder(BorderFactory.createLineBorder(colo.cineBlack));
			drinkL.setFont(font.tilt_neon(15));
			temp.add(drinkL, gbcc);
			gbcc.gridx++;
			
			seatL = new JLabel(seat);
			seatL.setPreferredSize(new Dimension(295,0));
			seatL.setBorder(BorderFactory.createLineBorder(colo.cineBlack));
			seatL.setFont(font.tilt_neon(20));
			temp.add(seatL, gbcc);
			gbcc.gridx++;
			
			timeDateL = new JLabel(td);
			timeDateL.setPreferredSize(new Dimension(105 - left,0));
			timeDateL.setBorder(BorderFactory.createLineBorder(colo.cineBlack));
			timeDateL.setFont(font.tilt_neon(15));
			temp.add(timeDateL, gbcc);
			gbcc.gridx++;
			
			
			soldFrame.add(temp, gbc);
			gbc.gridy++;
		}
		
	}
	
	public String detachSeat_byChar(String str, char ch) {
		String temp = "<html><div>&nbsp ";
		if (str.equals("")) temp = " ---";
		else {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ch) {
					temp+= "<br>&nbsp ";
				}else {
					temp += str.charAt(i);					
				}
			}
			temp+= "</div></html>";
		}
		return temp;
	}
	
	public static String strArray_to_foodLabel(String[] strArray) {
		String food = "<html><div>&nbsp ";
		
//		System.out.println(strArray.length == 0);
		
		if (strArray == null) food = " ---";
		else {
			
			for (int i = 0; i < strArray.length; i++) {
				food+= strArray[i];
				if (i%2 == 1 && i != strArray.length-1) food += "<br>&nbsp ";
				else food += " || ";
			}
			food = food.substring(0, food.length()-4);
			
			food += "</div></html>";
		}
		
//		System.out.println(food);
		
		return food;
	}
	
	public static String[] str_to_strArray(String str) {
		String strArray[] = null;
		String temp = "";
		int num = 0;
		
		if (!(str.equals(""))) {
			
			for (int i = 0; i< str.length(); i++) {
				if (i == str.length()-4) break;
				if (str.charAt(i) == '|' && str.charAt(i+1) == '|') {
					num++;
				}
			}
			
			strArray =  new String[num+1];
			int n = 0;
			for (int i = 0 ; i < str.length(); i++) {
				
				if (str.charAt(i) != ' ' && str.charAt(i) != '|') temp += str.charAt(i);
				
				if (i > str.length() - 3) {
					if (i == str.length()-1) {
						strArray[n] = temp;
						n++;
						temp = "";
					}
				}else {
					if (str.charAt(i) == ' ' && str.charAt(i+1) == '|') {
						strArray[n] = temp;
						n++;
						temp = "";
					}
				}
				
				
			}
		}
		
		
		return strArray;
	}
	
	public void deco_goc() {
		JPanel vuong = new JPanel();
		Circle tron = new  Circle(50, colo.back);
		vuong.setBounds(70,545,25,25);
		vuong.setBackground(colo.cineYellowOpa(150));
		tron.setBounds(70,520,50,50);
		tron.setBackground(colo.transparent);
		
		frame.add(tron);
		frame.add(vuong);
	}
	
}
