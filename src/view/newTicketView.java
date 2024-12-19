package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import dao.*;
import controller.*;
import model_component.*;
import model_data.*;

public class newTicketView extends JFrame{
	
	//Interface variable
	private JPanel frame, vertical, horizontal;
	private colors colo = new colors();
	private fonT font = new fonT();
	private JButton done,backToMainPage, movie, drink_food;
	private JPanel bigFrame, smallFrame;
	private JPanel m1, m2, m3, ms1, ms2, ms3;
	private Border etched, margin0, margin5_bottom, combi, margin20_all ;
	private GridBagLayout gb;
	private GridBagConstraints gbc;
	
	// Data variable
	private movie[] m = new mDAO().exportMovie();
	private String[][] movie_name = new mDAO().exportM_name();
	private margin margin = new margin();
	private movie_screening[] ms = new msDAO().exportMovie_screening();
	
	
	public static void main(String[] args) {
		new newTicketView().setVisible(true);
	}
	
	public newTicketView() {
		setTitle("New TicKet");
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
		bigFrame = new JPanel();

		backToMainPage = new JButton("←");
		
		etched = BorderFactory.createEtchedBorder();
		margin0 = margin.marginAll(0);
		margin5_bottom = margin.marginB(5);
		margin20_all = margin.marginAll(20);
		combi = BorderFactory.createCompoundBorder(etched, margin5_bottom);
		
		
//		Component in Main Frame		
		bigFrame.setBackground(colo.cineBrownOpa(100));
		bigFrame.setLayout(null);
		bigFrame.setBounds(120,50,815,470);

		gb = new GridBagLayout();
		smallFrame = new JPanel();
		smallFrame.setBackground(colo.cineBrownOpa(0));
		smallFrame.setLayout(gb);
		smallFrame.setBounds(30,30,755,410);
		
		gbc = new GridBagConstraints();
		
		show_movie_name();
		show_movie_screening();
		
//		gbc.gridx = 0; 
//		gbc.gridy = 0; 
//		gbc.gridwidth = 1;
//		gbc.gridheight = 1; 
//		gbc.weightx = 1; 
//		gbc.weighty = 1;
//		gbc.fill = GridBagConstraints.BOTH;
//		
//		m1 = new JPanel();
//		m1.setBackground(Color.red);
//		smallFrame.add(m1, gbc);
//		
//		gbc.gridx = 0; 
//		gbc.gridy = 1; 
//		
//		m2 = new JPanel();
//		m2.setBackground(Color.yellow);
//		smallFrame.add(m2, gbc);
//		
//		gbc.gridx = 0; 
//		gbc.gridy = 2; 
//		
//		m3 = new JPanel();
//		m3.setBackground(Color.black);
//		smallFrame.add(m3, gbc);
//		
//		gbc.gridx = 1; 
//		gbc.gridy = 0;
//		gbc.weightx = 2;
//		
//		ms1 = new JPanel();
//		ms1.setBackground(Color.blue);
//		smallFrame.add(ms1, gbc);
//		gbc.gridx = 1; 
//		gbc.gridy = 1; 
//		
//		ms2 = new JPanel();
//		ms2.setBackground(Color.white);
//		smallFrame.add(ms2, gbc);
//		gbc.gridx = 1; 
//		gbc.gridy = 2; 
//		
//		ms3 = new JPanel();
//		ms3.setBackground(Color.green);
//		smallFrame.add(ms3, gbc);
		
		bigFrame.add(smallFrame);
		
		
//		Component in Vertical Bar
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1000,70);
		vertical.setLayout(null);
		horizontal.setLayout(null);
		vertical.setBackground(colo.cineBrownOpa(150));
		horizontal.setBackground(colo.cineBrownOpa(150));

		
		backToMainPage.setBounds(10,20,50,40);
		backToMainPage.setFont(font.tilt_neon(35));
		backToMainPage.setFocusPainted(false);
		backToMainPage.setBackground(colo.cineBrown);
		backToMainPage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backToMainPage.setBorder(combi);
		backToMainPage.addActionListener(new changePageListener(this, "main", false));
		backToMainPage.setToolTipText("Main Page");
		backToMainPage.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				backToMainPage.setBorder(combi);
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				Border temp = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white, Color.white), margin5_bottom);
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
		movie.setBorder(BorderFactory.createCompoundBorder(etched, margin0));
		movie.setBackground(colo.cineYellow);
		movie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		movie.setBorder(BorderFactory.createEtchedBorder());
		movie.addActionListener(new changePageListener(this, "newTicket_movie", false));
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
		drink_food.setBorder(BorderFactory.createCompoundBorder(etched, margin0));
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
		done.setBorder(BorderFactory.createCompoundBorder(etched, margin0));
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
		
		deco_goc();
		add(bigFrame);
		add(vertical);
		add(horizontal);
		
		
	}
	
	public void show_movie_name() {
			for (int y = 0; y < m.length; y++) {
				gbc.gridx = 0;
				gbc.gridy = y;
				
				gbc.gridwidth = 1;
				gbc.gridheight = 1; 
				gbc.weightx = 1; 
				gbc.weighty = 1;
				gbc.fill = GridBagConstraints.BOTH;
				
				JPanel tempP = new JPanel();
				tempP.setLayout(new BorderLayout());
				tempP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
				tempP.setBackground(colo.transparent);
				
				Border temp = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(colo.cineBrown, 5), margin.marginAll(5));
				
				JTextArea tempL = new JTextArea(movie_name[1][y]);
				tempL.setEditable(false);
				tempL.setBackground(colo.cineYellow);
				tempL.setHighlighter(null);
				tempL.setBorder(temp);
				tempL.setCaretColor(colo.transparent);
				tempL.setForeground(colo.cineBrown);
//				tempL.setLineWrap(true);
//				tempL.setWrapStyleWord(true);
				tempL.setFont(font.tilt_neon(25).deriveFont(Font.BOLD));
				tempP.add(tempL);
				
				smallFrame.add(tempP,gbc);
				
			}
		
	}

	public void show_movie_screening() {
		for (int y = 0; y < m.length; y++) {
			gbc.gridx = 1;
			gbc.gridy = y;
			
			gbc.gridwidth = 1;
			gbc.gridheight = 1; 
			gbc.weightx = 1; 
			gbc.weighty = 1;
			gbc.fill = GridBagConstraints.BOTH;
			
			if (y == 0) gbc.insets = new Insets(0, 0, 10, 0);
			else if(y == m.length-1) gbc.insets = new Insets(10, 0, 0, 0);
			else gbc.insets = new Insets(5, 0, 5, 0);
			
			if (y == 0) gbc.weightx = 2; 
			
			
			Border temp = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(colo.cineBrown, 5), margin.marginAll(5));
			
			JPanel tempP = new JPanel();
			tempP.setLayout(new GridLayout(0,4, 10,10));
			tempP.setBackground(colo.cineBrownOpa(150));
			tempP.setBorder(temp);
			
			for (int i = 0; i < ms.length; i++ ) {
				if (ms[i].getM_id() == m[y].getM_id()) {
					JButton time = new JButton(ms[i].getTime_in() + " - " + ms[i].getTime_out());
					time.setFont(font.tilt_neon(15));
					time.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					time.setBackground(colo.cineBlack);
					time.setForeground(colo.cineYellow);
					
					time.setMargin(new Insets(0, 0, 0, 0));
					
					tempP.add(time);
				}else continue;
			}
			
			
			smallFrame.add(tempP,gbc);
			gbc = new GridBagConstraints();
			
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