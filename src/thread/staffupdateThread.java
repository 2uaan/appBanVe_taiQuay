package thread;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import dao.staffDAO;
import model_component.colors;
import model_component.fonT;
import model_data.staff;

public class staffupdateThread extends Thread{

	private volatile boolean running = true;
	private GridBagConstraints gbcd, gbcn;
	private JTextField idtf, nametf, passtf;
	private JToggleButton statetg;
	private JPanel staffFrame;
	private staff[] staff = new staffDAO().exportStaff();
	private fonT font = new fonT();
	private colors colo = new colors();
	
	public staffupdateThread(GridBagConstraints gbcd, GridBagConstraints gbcn, JTextField idtf, JTextField nametf,
			JTextField passtf, JToggleButton statetg, JPanel staffFrame) {
		super();
		this.gbcd = gbcd;
		this.gbcn = gbcn;
		this.idtf = idtf;
		this.nametf = nametf;
		this.passtf = passtf;
		this.statetg = statetg;
		this.staffFrame = staffFrame;
	}


	public JLabel createLabel(JLabel label, String text, int width) {
		JLabel temp = new JLabel(text);
		temp.setFont(label.getFont());
		temp.setBorder(label.getBorder());
		temp.setPreferredSize(new Dimension(width, 0));
		
		return temp;
	}
	

	@Override
	public void run() {
		while(running) {
			gbcd = new GridBagConstraints();
			gbcd.gridx = 0;
			gbcd.gridy = 0;
			gbcd.weightx = 1;
			gbcd.weighty = 1;
			gbcd.gridheight = 1;
			gbcd.gridwidth = 1;
			gbcd.fill = GridBagConstraints.HORIZONTAL;
			gbcd.insets = new Insets(5, 5, 5, 5);
			
			int right = 15;
			if (staff.length > 7) right = 0;
			
			for ( int i = 0; i < staff.length; i++) {
				staff s = staff[i];
				JPanel s_no = new JPanel();
				s_no.setLayout(new GridBagLayout());
				s_no.setPreferredSize(new Dimension(0, 50));
				s_no.addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
					
					@Override
					public void mouseClicked(MouseEvent e) {
						idtf.setText(s.getStaff_id()+"");
						nametf.setText(s.getStaff_name());
						statetg.setSelected(!s.isState());
						if (!s.isState()) {
							statetg.setText("OFF");
							statetg.setForeground(Color.darkGray);
						}else {
							statetg.setText("WORK");
							statetg.setForeground(Color.green);
						}
						passtf.setText(s.getPassword());
					}
				});
				String strid, strname, strstate, strpass;
				
				strid = " "+staff[i].getStaff_id();
				strname = " "+staff[i].getStaff_name();
				strstate = staff[i].isState() ? " WORK" : " OFF";
				strpass = " "+staff[i].getPassword();
				
				Color c = strstate.equals(" OFF") ? Color.DARK_GRAY : Color.green;
				
				JLabel idL, nameL, stateL, passL;
				
				idL = new JLabel(strid);
				idL.setFont(font.tilt_neon(18));
				idL.setBorder(BorderFactory.createLineBorder(colo.back, 3));
				idL.setPreferredSize(new Dimension(70,0));
				
				
				nameL = createLabel(idL, strname, 220);
				stateL = createLabel(idL, strstate, 80);
				stateL.setForeground(c);
				passL = createLabel(idL, strpass, 110 + right);

				s_no.add(idL,gbcn);
				gbcn.gridx++;
				s_no.add(nameL, gbcn);
				gbcn.gridx++;
				s_no.add(stateL, gbcn);
				gbcn.gridx++;
				s_no.add(passL, gbcn);
				gbcn.gridx++;
				
				staffFrame.add(s_no, gbcd);
				gbcd.gridy++;
			} 
		}
	}
	
}
