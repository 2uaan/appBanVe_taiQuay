package view.acceptView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import dao.msDAO;
import model_component.*;
import view.newTicketView;

public class acceptMovie_screening extends JFrame{
	
	private JLabel background;
	private JPanel frame, ms_infor;
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	private GridBagConstraints gbc;
	
	public acceptMovie_screening(String m_name, String m_time, int ms_id) {
		setTitle("Messenger!!");
		setSize(400,230);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon("image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		ms_infor = new JPanel();
		ms_infor.setBackground(colo.back);
		ms_infor.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		String[] item = {"Your Choice:", m_name, m_time};
		
		mess(item);
		
		JPanel o_cFrame = new JPanel();
		o_cFrame.setBackground(colo.back);
		o_cFrame.setBorder(BorderFactory.createEmptyBorder(10, 20, 20,20));
		o_cFrame.setLayout(new GridLayout(0,4, 5 ,5));
		
		o_cFrame.add(new Label(""));
		o_cFrame.add(new Label(""));
		
		JButton ac, ca;
		ac = new JButton("Yes");
		ac.setMargin(new Insets(0, 0, 0, 0));
		ac.setBackground(colo.cineBrown);
		ac.setForeground(colo.cineYellow);
		
		ca = new JButton("Cancel");
		ca.setMargin(new Insets(0, 0, 0, 0));
		ca.setBackground(colo.cineYellow);
		ca.setForeground(colo.cineBrown);
		ca.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				newTicketView nt = new newTicketView();
				new msDAO().updateMS_state(ms_id, false);
				nt.setVisible(true);
				setVisible(false);
			}
		});
		
		
		o_cFrame.add(ac);
		o_cFrame.add(ca);
		
		add(ms_infor, BorderLayout.CENTER);
		add(o_cFrame, BorderLayout.SOUTH);
	}
	
	public void mess(String[] item) {
		for (int i = 0; i< item.length; i++) {
			gbc.gridx = (i + 1)/2;
			gbc.gridy = i/2;
			gbc.gridwidth = 1;
			gbc.gridheight = 1;
			gbc.weightx = 1;
			gbc.weighty = 1;
			
			if (i == 0) {
				
			}
			
			if (i == 1) {
				gbc.gridwidth = 2;
				gbc.weightx = 2;
			}
			
			gbc.fill = GridBagConstraints.BOTH;
			JTextArea temp = new JTextArea(item[i]);
			temp.setEditable(false);
			temp.setBackground(colo.back);
			temp.setHighlighter(null);
			temp.setCaretColor(colo.transparent);
			temp.setForeground(colo.cineBrown);
			temp.setFont(font.tilt_neon(20));
			temp.setBorder(ma.marginAll(20));
			temp.setLineWrap(true);
			temp.setWrapStyleWord(true);
			
			if (i == 0) {
				temp.setFont(font.tilt_neon(24));
			}
			ms_infor.add(temp, gbc);
		}
	}
	
}
