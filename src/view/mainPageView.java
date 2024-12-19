package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import controller.changePageListener;
import dao.staffDAO;
import model_component.*;

public class mainPageView extends JFrame{
	
	private JLabel background;
	private JButton exit, newTicket, ticketSold, allMovie;
	private JPanel frame;
	private colors colo = new colors();
	private fonT font = new fonT();
	private int xloca, yloca;
	private staffDAO stdao = new staffDAO();
	
	
	public static void main(String[] args) {
		new mainPageView().setVisible(true);
	}
	
	public mainPageView() {
		setTitle("Main Page");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
//		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		exit = new JButton("← Exit Shift");
		newTicket = new JButton("+ New Ticket");
		ticketSold = new JButton("Ticket Sold");
		allMovie = new JButton("All Movie");
		xloca = 330;
		yloca = 150;
		
		
		exit.setBounds(xloca, yloca + 170,150,150);
		newTicket.setBounds(xloca,yloca,150,150);
		ticketSold.setBounds(xloca + 170,yloca,150,150);
		allMovie.setBounds(xloca + 170,yloca + 170,150,150);
		
		exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		newTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ticketSold.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		allMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		newTicket.setBackground(colo.cineBrown);
		ticketSold.setBackground(colo.cineYellow);
		allMovie.setBackground(colo.cineRed);
		exit.setBackground(colo.cineBlack);
		
		newTicket.setForeground(Color.white);
		ticketSold.setForeground(colo.cineBrown);
		allMovie.setForeground(Color.white);
		
		
		exit.setForeground(Color.white);
		exit.setBorder(BorderFactory.createEtchedBorder());
		exit.addActionListener(new changePageListener(this, "login", false));
		exit.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				exit.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				exit.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				exit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		newTicket.setBorder(BorderFactory.createEtchedBorder());
		newTicket.addActionListener(new changePageListener(this, "newTicket", false));
		newTicket.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				newTicket.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				newTicket.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				newTicket.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				newTicket.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		ticketSold.setBorder(BorderFactory.createEtchedBorder());
		ticketSold.addActionListener(new changePageListener(this, "ticketSold", false));
		ticketSold.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				ticketSold.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				ticketSold.setBorder(BorderFactory.createEtchedBorder(colo.cineBrown, colo.cineBrown));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				ticketSold.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ticketSold.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		allMovie.setBorder(BorderFactory.createEtchedBorder());
		allMovie.addActionListener(new changePageListener(this, "allMovie", false));
		allMovie.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				allMovie.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				allMovie.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				allMovie.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				allMovie.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		newTicket.setFont(font.tilt_neon(15));
		exit.setFont(font.tilt_neon(15));
		ticketSold.setFont(font.tilt_neon(15));
		allMovie.setFont(font.tilt_neon(15));
		
		
		add(exit);
		add(newTicket);
		add(ticketSold);
		add(allMovie);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("image\\back.png"));
		background.setBounds(0,0,this.getWidth(),this.getHeight());
		add(background);
		
	}
	
}
