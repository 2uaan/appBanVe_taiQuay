package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.Border;

import controller.*;
import model_component.*;

public class allMovieView extends JFrame{
	
	private JPanel frame, vertical, horizontal;
	private colors colo = new colors();
	private fonT font = new fonT();
	private JButton backToMainPage;
	
	public static void main(String[] args) {
		new allMovieView().setVisible(true);
	}
	
	public allMovieView() {
		setTitle("TicKet Sold");
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
		
		new JButton("✓ Done");
		
		backToMainPage = new JButton("←");
		backToMainPage.setForeground(Color.white);

		
// 		Main Component
		
		
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1000,70);
		vertical.setLayout(null);
		horizontal.setLayout(null);
		vertical.setBackground(colo.cineRedOpa(100));
		horizontal.setBackground(colo.cineRedOpa(100));
		
//		Component in Vertical Bar

		Border etched = BorderFactory.createEtchedBorder();
		Border margin = BorderFactory.createEmptyBorder(0,0,5,0);
		Border margin2 = BorderFactory.createEmptyBorder(0,0,0,0);
		Border combi = BorderFactory.createCompoundBorder(etched, margin);
		
		backToMainPage.setBounds(10,20,50,40);
		backToMainPage.setFont(font.tilt_neon(35));
		backToMainPage.setFocusPainted(false);
		backToMainPage.setBackground(colo.cineRed);
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
		
		
		vertical.add(backToMainPage);
		
//		Componen in Horizontal Bar		
		
		
		deco_goc();
		add(vertical);
		add(horizontal);
		
		
	}
	
	public void deco_goc() {
		JPanel vuong = new JPanel();
		Circle tron = new  Circle(50, colo.back);
		vuong.setBounds(70,545,25,25);
		vuong.setBackground(colo.cineRedOpa(100));
		tron.setBounds(70,520,50,50);
		tron.setBackground(colo.transparent);
		
		frame.add(tron);
		frame.add(vuong);
	}
	
}
