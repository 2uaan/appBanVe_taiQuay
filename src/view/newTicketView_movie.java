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
import dao.*;
import model_component.*;
import model_data.*;


public class newTicketView_movie extends JFrame{
	
	//Interface variable
	private JPanel frame, vertical, horizontal, screen, chairFrame, chair1, chair2, poster;
	private JLabel img_poster;
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	private JButton done,backToMainPage, movie, drink_food, backToNewTicket;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	// Data variable
	private chairPrice[] cp = new chairPrice().get_chairPrices();
	private String[] note = {"Near Screen ("+cp[0].getPriceK()+")", "Vip ("+cp[1].getPriceK()+")", "Couple ("+cp[2].getPriceK()+")", "Sold", "Selecting"};
	private near_screen[] ns = new nsDAO().exportNS();
	private vip[] v = new vDAO().exportV();
	private couple[] c = new cDAO().exportC();
	private movie_screening ms_select = new msDAO().exportSelected_ms();
	private nsDAO nsdao = new nsDAO();
	private vDAO vdao = new vDAO();
	private cDAO cdao = new cDAO();
	
	public static void main(String[] args) {
		new newTicketView_movie().setVisible(true);
	}
	
	public newTicketView_movie() {
		setTitle("New Ticket: Movie");
		setSize(1400,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		done = new JButton("✓ Done");
		backToMainPage = new JButton("←");
		backToNewTicket = new JButton();
		backToNewTicket.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\interface_icon\\movie_reel.png"));
		backToNewTicket.setBounds(120, 30, 50,40);
		backToNewTicket.setBackground(colo.cineYellow);
		backToNewTicket.setMargin(new Insets(0, 0, 0, 0));
		backToNewTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToNewTicket.addActionListener(new changePageListener(this, "newTicket", false));
		backToNewTicket.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				backToNewTicket.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				backToNewTicket.setBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				backToNewTicket.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				backToNewTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		add(backToNewTicket);
		
		
//		Component in BigFrame :>>>>
		
		poster = new JPanel();
		poster.setBounds(995,30,340,510);
		
		img_poster = new JLabel();
		if (ms_select.getM_id() != 0) {
			img_poster.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p"+(ms_select.getM_id()%10)+".png"));
		}
		
		poster.add(img_poster);
		add(poster);
		
		screen = new JPanel();
		screen.setBackground(colo.cineBlack);
		screen.setBounds(375, 20, 305, 60);
		screen.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		// The "Screen" in the screen
		JLabel in_screen = new JLabel("SCREEN");
		in_screen.setFont(font.tilt_neon(40).deriveFont(Font.BOLD));
		in_screen.setForeground(Color.white);
		screen.add(in_screen);
		
		chairFrame = new JPanel();
		chairFrame.setBackground(colo.cineBrownOpa(0));
		chairFrame.setBounds(110, 120, 835, 425);
		chairFrame.setLayout(null);
		chair1 = new JPanel();
		chair1.setBackground(colo.cineBrownOpa(0));
		chair1.setBounds(5,5, 395,395);
		chair1.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(colo.cineBrown), BorderFactory.createEmptyBorder(0,0,5,5)));
		chair1.setLayout(new GridBagLayout());
		
		chair2 = new JPanel(); 
		chair2.setBackground(colo.cineBrownOpa(0));
		chair2.setBounds(435,5,395,395);
		chair2.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(colo.cineBrown), BorderFactory.createEmptyBorder(0,0,5,5)));
//		chair2.setBorder(BorderFactory.createLineBorder(colo.cineBrown));
		chair2.setLayout(new GridBagLayout());
		
		add_ns_chair();
		add_v_chair();
		add_c_chair();
		
		chairFrame.add(chair1);
		chairFrame.add(chair2);
		
		add(screen);
		add(chairFrame);
		
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1400,70);
		vertical.setLayout(null);
		horizontal.setLayout(null);
		vertical.setBackground(colo.cineBrownOpa(150));
		horizontal.setBackground(colo.cineBrownOpa(150));
		
//		Component in Vertical Bar

		Border etched = BorderFactory.createEtchedBorder();
		Border margin = BorderFactory.createEmptyBorder(0,0,5,0);
		Border margin2 = BorderFactory.createEmptyBorder(0,0,0,0);
		Border combi = BorderFactory.createCompoundBorder(etched, margin);
		
		backToMainPage.setBounds(10,20,50,40);
		backToMainPage.setFont(font.tilt_neon(35));
		backToMainPage.setFocusPainted(false);
		backToMainPage.setBackground(colo.cineBrown);
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
				Border temp = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white, Color.white), margin);
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
		
		movie = new JButton("Movie");
		movie.setBounds(10, 100, 50,30);
		movie.setFont(font.tilt_neon(15).deriveFont(Font.BOLD));
		movie.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		movie.setBackground(colo.cineYellow);
		movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		movie.setBorder(BorderFactory.createEtchedBorder());
		movie.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				movie.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				movie.setBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				movie.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		drink_food = new JButton("F&D");
		drink_food.setBounds(10, 140, 50, 30);
		drink_food.setFont(font.tilt_neon(15).deriveFont(Font.BOLD));
		drink_food.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		drink_food.setBackground(colo.cineYellow);
		drink_food.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		drink_food.setBorder(BorderFactory.createEtchedBorder());
		drink_food.addActionListener(new changePageListener(this, "newTicket_food", false));
		drink_food.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				drink_food.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				drink_food.setBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				drink_food.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				drink_food.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		vertical.add(backToMainPage);
		vertical.add(movie);
		vertical.add(drink_food);
		
//		Componen in Horizontal Bar		
		done.setFont(new Font("Dialog",Font.BOLD, 15));
		done.setBounds(1220,15,80, 40);
		done.setForeground(Color.white);
		done.setBackground(colo.cineBrown);
		done.setMnemonic(KeyEvent.VK_O);
		done.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		done.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkTicket_infor()) {
					ticketInforView ti = new ticketInforView();
					ti.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Ticket is empty!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		done.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				done.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				done.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				done.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		horizontal.add(done);
		
		note_bar();
		deco_goc();
//		add(bigFrame);
		add(vertical);
		add(horizontal);
		
		
	}
	
	public boolean checkTicket_infor() {
		boolean ns, v, c, food, drink, result = true;
		
		ns = new nsDAO().checkSelected();
		v = new vDAO().checkSelected();
		c = new cDAO().checkSelected();
		food = new foodDAO().checkSelected();
		drink = new drinkDAO().checkSelected();
		
		if (!ns && !v && !c && !food & !drink) result = false;
		
		return result;
	}
	
	public void add_ns_chair() {
		for (int i = 0 ; i < ns.length; i++) {
			String name = ns[i].getName();
			int ms_id = ns[i].getMs_id();
			JButton temp = new JButton(ns[i].getName());
			temp.setBackground(new Color(0x757575));
			temp.setMargin(new Insets(0, 0, 0, 0));
			temp.setFont(font.tilt_neon(20).deriveFont(Font.BOLD));
			
			if(nsdao.getIs_selected_ns(name, ms_id)) {
				temp.setBackground(Color.red);
			}
			if (ns[i].isState()) {
				temp.setBackground(new Color(0x0006BF));
				temp.setText("X");
				temp.setEnabled(false);
			}else {
				temp.addActionListener(new ActionListener() {
									
					@Override
					public void actionPerformed(ActionEvent e) {
						if (new cDAO().checkSelected() || new vDAO().checkSelected()) {
							JOptionPane.showMessageDialog(null, "You must choose the same type of seat!!!","Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else {
							
							if (temp.getBackground() == Color.red) {
								temp.setBackground(new Color(0x757575));
								nsdao.setIs_selected_ns(name, ms_id, false);
							}
							else {
								temp.setBackground(Color.red);
								nsdao.setIs_selected_ns(name, ms_id, true);
							}
						}
					}
				});			
				
			}
			
			if (ns[i].isState()) temp.setBackground(new Color(0x0006BF));
			if (i%12 < 6) {
				gbc.gridx = i%12;
				gbc.gridy = i/12;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);
	
				chair1.add(temp, gbc);
				chair1.setVisible(false);
				chair1.setVisible(true);
			}else {
				gbc.gridx = i%12;
				gbc.gridy = i/12;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);
	
				chair2.add(temp,gbc);
				chair2.setVisible(false);
				chair2.setVisible(true);
			}
		}
	}
	
	public void add_v_chair() {
		for (int i = 0 ; i < v.length; i++) {
			JButton temp = new JButton(v[i].getName());
			temp.setMargin(new Insets(0, 0, 0, 0));
			temp.setFont(font.tilt_neon(20).deriveFont(Font.BOLD));
			temp.setBackground(colo.cineYellow);
			
			String name = v[i].getName();
			int ms_id = v[i].getMs_id();
			if(vdao.getIs_selected_v(name, ms_id)) {
				temp.setBackground(Color.red);
			}
			if (v[i].isState()) {
				temp.setBackground(new Color(0x0006BF));
				temp.setText("X");
				temp.setEnabled(false);
			}else {
				temp.addActionListener(new ActionListener() {
									
					@Override
					public void actionPerformed(ActionEvent e) {
						if (new nsDAO().checkSelected() || new cDAO().checkSelected()) {
							JOptionPane.showMessageDialog(null, "You must choose the same type of seat!!!","Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else {
							
							if (temp.getBackground() == Color.red) {
								temp.setBackground(colo.cineYellow);
								vdao.setIs_selected_v(name, ms_id, false);
							}
							else {
								temp.setBackground(Color.red);
								vdao.setIs_selected_v(name, ms_id, true);
							}
						}
					}
				});			
				
			}
			if (i%12 < 6) {
				gbc.gridx = i%12;
				gbc.gridy = 2 + i/12;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);
	
				chair1.add(temp, gbc);
				chair1.setVisible(false);
				chair1.setVisible(true);
			}else {
//				temp.setBounds((i%12 - 6) * 65 +8  , (2+i/12)*65 + 5,60, 60);
				gbc.gridx = i%12;
				gbc.gridy = 2 + i/12;
				gbc.gridwidth = 1;
				gbc.gridheight = 1;
				gbc.weightx = 1;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);
				
				chair2.add(temp,gbc);
				chair2.setVisible(false);
				chair2.setVisible(true);
			}
		}
	}
	
	public void add_c_chair() {
		for (int i = 0 ; i < c.length; i++) {
			JButton temp = new JButton(c[i].getName());
			temp.setMargin(new Insets(0, 0, 0, 0));
			temp.setFont(font.tilt_neon(20).deriveFont(Font.BOLD));
			temp.setBackground(new Color(0xFF8282));
			
			
			String name = c[i].getName();
			int ms_id = c[i].getMs_id();
			if(cdao.getIs_selected_c(name, ms_id)) {
				temp.setBackground(Color.red);
			}
			if (c[i].isState()) {
				temp.setBackground(new Color(0x0006BF));
				temp.setText("X");
				temp.setEnabled(false);
			}else {
				temp.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (new nsDAO().checkSelected() || new vDAO().checkSelected()) {
							JOptionPane.showMessageDialog(null, "You must choose the same type of seat!!!","Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else {
							if (temp.getBackground() == Color.red) {
								temp.setBackground(new Color(0xFF8282));
								cdao.setIs_selected_c(name, ms_id, false);
							}
							else {
								temp.setBackground(Color.red);
								cdao.setIs_selected_c(name, ms_id, true);
							}
						}
					}
				});			
			}
			
			if (i%6 < 3) {
				gbc.gridx = (i % 6 ) * 2;
				gbc.gridy = 4 + i/6;
				gbc.gridwidth = 2;
				gbc.gridheight = 1;
				gbc.weightx = 2;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);
				
				chair1.add(temp, gbc);
				chair1.setVisible(false);
				chair1.setVisible(true);
			}else {
//				temp.setBounds(((i % 6 ) * 2 + 1) * 60 + 5 , (4 + i/6)*60 + 5, 60, 60);
				gbc.gridx = (i % 6 ) * 2;
				gbc.gridy = 4 + i/6;
				gbc.gridwidth = 2;
				gbc.gridheight = 1;
				gbc.weightx = 2;
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				gbc.insets = new Insets(5, 5, 0, 0);

				chair2.add(temp, gbc);
				chair2.setVisible(false);
				chair2.setVisible(true);
			}
		}
	}
	
	public void note_bar() {
		int xloca = 100;
		
		for (int i = 0; i<5; i++) {
			JPanel tempFrame = new JPanel();
			JPanel vuong = new JPanel();
			Color vuongColor;
			switch (i) {
				case 0: {
					vuongColor = new Color(0x757575);
					break;
				}
				case 1: {
					vuongColor = colo.cineYellow;
					break;
				}
				case 2: {
					vuongColor = new Color(0xFF8282);
					break;
				}
				case 3: {
					vuongColor = new Color(0x0006BF);
					break;
				}
				default:{
					vuongColor = Color.red;
					break;
				}
				
			}
			tempFrame.setLayout(null);
			tempFrame.setBounds(xloca, 15,128, 40);
			tempFrame.setBackground(colo.transparent);
			
			vuong.setBackground(vuongColor);
			vuong.setBounds(0,0,40,40);
			JTextArea noteTemp = new JTextArea(note[i]);
			
			noteTemp.setBounds(40,0,88,40);
			noteTemp.setEditable(false);
			noteTemp.setHighlighter(null);
			noteTemp.setCaretColor(colo.transparent);
			noteTemp.setFont(font.tilt_neon(12));
			noteTemp.setLineWrap(true);
			noteTemp.setWrapStyleWord(true);
			noteTemp.setForeground(colo.cineYellow);
			noteTemp.setBackground(colo.cineBrownOpa(0));
			noteTemp.getCaret().setVisible(false); // Tắt con trỏ chuột
			noteTemp.getCaret().setSelectionVisible(false);
//			noteTemp.setOpaque(false);
			
			noteTemp.setMargin(new Insets(0, 5, 0, 0));
			
			tempFrame.add(vuong);
			tempFrame.add(noteTemp);
			
			horizontal.add(tempFrame);
			horizontal.setVisible(false);
			horizontal.setVisible(true);
			xloca += 148;
			
		}
	}
	
	public void deco_goc() {
		JPanel vuong = new JPanel();
		Circle tron = new  Circle(50, colo.back);
		vuong.setBounds(70,545,25,25);
		vuong.setBackground(colo.cineBrownOpa(150));
		tron.setBounds(70,520,50,50);
		tron.setBackground(colo.transparent);
		
		frame.add(tron);
		frame.add(vuong);
	}
	
}
