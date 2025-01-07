package view.acceptView;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import model_component.*;
import thread.*;

public class welcomeStaffView extends JFrame{
	
	private JLabel background, welcome, admin, load;
	private JPanel frame, welcomeFrame;
	private colors colo = new colors();
	private fonT font = new fonT();
	private JProgressBar bar = new JProgressBar(0,100);
	
	public welcomeStaffView() {
		setTitle("Welcome Admin !!");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_QuanLy\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		welcomeFrame = new JPanel();
		welcomeFrame.setBounds(100,170,350,400);
		welcomeFrame.setBackground(colo.back2);
		welcomeFrame.setLayout(null);
		
		
		welcome = new JLabel("Welcome", JLabel.CENTER);
		welcome.setBounds(0,20,350,60);
		welcome.setForeground(colo.cineRed2);
		welcome.setFont(font.tilt_neon(75).deriveFont(Font.BOLD));
		
		admin = new JLabel("Staff", JLabel.RIGHT);
		admin.setBounds(0,70,350,50);
		admin.setForeground(colo.cineYellow2);
		admin.setFont(font.bahnschrift(50));
		
		load = new JLabel("Loading . . .");
		load.setForeground(Color.white);
		load.setFont(font.bahnschrift(20));
		load.setBounds(25, 200, 350, 25);
		
		bar.setBounds(25,230,300,30);
		bar.setValue(2000);
		bar.setForeground(colo.cineBlue);
		bar.setStringPainted(true);
    	bar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,0,0), BorderFactory.createLineBorder(Color.lightGray, 3)));
		
		welcomeFrame.add(bar);
		welcomeFrame.add(load);
		welcomeFrame.add(admin);
		welcomeFrame.add(welcome);
		
		add(welcomeFrame);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_QuanLy\\image\\background.png"));
		background.setBounds(0,-25,this.getWidth(),this.getHeight());
		add(background);
		
		loading l = new loading(this, bar, 0);
		l.start();
	}
	
}
