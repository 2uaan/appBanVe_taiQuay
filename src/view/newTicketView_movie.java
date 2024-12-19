package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;
import controller.*;
import model_component.*;

public class newTicketView_movie extends JFrame{
	
	private JPanel frame, vertical, horizontal, screen, chairFrame, chair1, chair2;
	private colors colo = new colors();
	private fonT font = new fonT();
	private JButton done,backToMainPage, movie, drink_food, backToNewTicket;
	private String[] note = {"Near Screen (75K)", "Vip (95K)", "Couple (200K)", "Sold", "Selecting"};
	
	public static void main(String[] args) {
		new newTicketView_movie().setVisible(true);
	}
	
	public newTicketView_movie() {
		setTitle("New Ticket: Movie");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		done = new JButton("✓ Done");
		backToMainPage = new JButton("←");
		backToNewTicket = new JButton();
		backToNewTicket.setIcon(new ImageIcon("image\\interface_icon\\movie_reel.png"));
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
		chairFrame.setBackground(colo.cineBrownOpa(100));
		chairFrame.setBounds(120, 100, 815, 425);
		chairFrame.setLayout(null);
		chair1 = new JPanel();
		chair1.setBackground(colo.cineBrownOpa(150));
		chair1.setBounds(5,5, 385,385);
		
		chair2 = new JPanel(); 
		chair2.setBackground(colo.cineBrownOpa(150));
		chair2.setBounds(425,5,385,385);
		
		chairFrame.add(chair1);
		chairFrame.add(chair2);
		
		add(screen);
		add(chairFrame);
		
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1000,70);
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
		done.setBounds(820,15,80, 40);
		done.setForeground(Color.white);
		done.setBackground(colo.cineBrown);
		done.setMnemonic(KeyEvent.VK_O);
		done.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
	
	public void note_bar() {
		int xloca = 15;
		
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
