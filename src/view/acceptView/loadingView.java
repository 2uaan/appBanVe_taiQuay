package view.acceptView;

import java.awt.*;
import javax.swing.*;
import model_component.*;
import thread.loading;
import view.loginView;
import view.mainPageView;

public class loadingView extends JFrame{
	
	private JPanel frame, in, out;
	private JLabel load;
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	private GridBagConstraints gbc;
	
	public static void main(String[] args) {
		loadingView l = new loadingView(1);
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
		
		load = new JLabel("Loading  .  .  .");
		in = new JPanel();
		out = new JPanel();
		
		load.setBounds(130, 20, 150, 40);
		load.setFont(font.tilt_neon(25).deriveFont(Font.BOLD));
		
		out.setBounds(35, 60, 320, 20);
		out.setBackground(colo.transparent);
		out.setBorder(BorderFactory.createLineBorder(colo.cineBrown));
		out.setLayout(null);
		
		in.setBounds(0,0,0,20);
		in.setBorder(BorderFactory.createLineBorder(colo.cineBrown));
		in.setBackground(colo.cineBrown);
		
		out.add(in);
		
		add(out);
		add(load);
		
		setVisible(true);
		
		loading l = new loading(this, in, load, out.getWidth(), no);
		l.start();
		
		
	}
	
	
	
}
