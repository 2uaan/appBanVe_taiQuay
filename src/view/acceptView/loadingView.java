package view.acceptView;

import java.awt.*;
import javax.swing.*;
import model_component.*;
import thread.loading;
import view.loginView;
import view.mainPageView;
import view.newTicketView_movie;

public class loadingView extends JFrame{
	
	private JPanel frame;
	private JLabel load;
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	private JProgressBar bar = new JProgressBar(0,100);
	
	public static void main(String[] args) {
		loadingView l = new loadingView(0);
	}
	
	public loadingView(int no) {
		setTitle("Loading . . .");
		setSize(400,150);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		load = new JLabel("Loading ^.^");
		
		load.setBounds(130, 20, 150, 40);
		load.setFont(font.tilt_neon(25).deriveFont(Font.BOLD));

		bar.setBounds(35, 60, 320, 30);
		bar.setValue(2000);
		bar.setBackground(colo.back);
		bar.setForeground(colo.cineBrown);
		bar.setStringPainted(true);
    	bar.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0,0,0,5), BorderFactory.createLineBorder(Color.darkGray, 3)));

		
		add(bar);
//		add(out);
		add(load);
		
		setVisible(true);
		
		loading l = new loading(this, bar, no);
		l.start();
	}
	
	
}
