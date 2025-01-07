package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import controller.changePageListener;
import controller.loginListener;
import dao.staffDAO;
import model_component.*;
import model_data.staff;
import thread.slidePoster;
import view.acceptView.loadingView;

public class loginView extends JFrame{
	
	private JLabel background, nvIDL, nvPassL, slideL, snack, coca;
	private JTextField nvIDTF;
	private JPanel frame, componentLogin, slider, overlay, passFrame;
	private JPasswordField nvPassTF;
	private borderFrame loginView;
	private JButton next, show_hide;
	private ImageIcon[] slideImage = {new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p1.png"),
			new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p2.png"),
			new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p3.png"),
			new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p4.png"),
			new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p5.png"),
			new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p6.png")};
	private colors colo = new colors();
	private fonT font = new fonT();
	private String tempP;
	
	private staffDAO stdao = new staffDAO();
	private staff[] st = stdao.exportStaff();
	
	
	public loginView() {
		
		
		
		new staffDAO().staffOff();
		
		setTitle("Login");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		loginView = new borderFrame(frame, 10, 350, 300, colo.loginBack);
		loginView.setLocation(90,90);
		
		slideL = new JLabel();
		slideL.setIcon(slideImage[slideImage.length-1]);
		slideL.setBounds(0,0,340,510);
		overlay = new JPanel();
		overlay.setBounds(0,0,340,510);
		slider = new JPanel();
		slider.setLayout(null);
		slider.add(overlay);
		slider.add(slideL);
		slider.setBounds(550,60,340,510);
		
		
		  
		componentLogin = new JPanel();
		nvIDL = new JLabel("Your ID:");
		nvIDTF = new JTextField();
		nvPassL = new JLabel("Password:");
		nvPassTF = new JPasswordField();
		next = new JButton("Login");
		
		nvIDTF.setMargin(new Insets(0, 5, 0, 0));
		
		passFrame = new JPanel();
		passFrame.setLayout(null);
		
		show_hide = new JButton("show");
		show_hide.setBounds(250, 0,50, 38);
		show_hide.setMargin(new Insets(0, 0, 0, 0));
		show_hide.setFont(font.tilt_neon(12).deriveFont(Font.BOLD));
		show_hide.setBackground(colo.button);
		show_hide.setForeground(Color.white);
		show_hide.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				char text = nvPassTF.getText().charAt(0);
				if (nvPassTF.getEchoChar() == '*') {
					show_hide.setText("hide");
					nvPassTF.setEchoChar((char) 0);
				}else {
					show_hide.setText("show");
					nvPassTF.setEchoChar('*');
				}
			}
		});
		show_hide.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				show_hide.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				show_hide.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				show_hide.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				show_hide.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		
		
		nvPassTF.setMargin(new Insets(0, 5, 0, 0));
		nvPassTF.setBounds(0, 0, 250, 38);
		nvPassTF.setEchoChar('*');
		
		passFrame.add(nvPassTF);
		passFrame.add(show_hide);
		
		componentLogin.setBounds(25,25,300,230);
		componentLogin.setBackground(colo.loginBack);
		componentLogin.setLayout(new GridLayout(6,1));
		nvIDL.setFont(font.tilt_neon(17));
		
		nvPassL.setFont(font.tilt_neon(17));
		
		next.setFont(font.tilt_neon(17).deriveFont(Font.BOLD));
		next.setBackground(colo.button);
		next.setForeground(Color.white);
		next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				String pass = "";
				
				try {
					id = Integer.parseInt(nvIDTF.getText());
					pass = String.valueOf(nvPassTF.getPassword());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "OOPS!! User information is in wrong format!!!","Errorr!!!", JOptionPane.ERROR_MESSAGE);
					nvIDTF.setText("");
					nvPassTF.setText("");
					
				}
				
				int check = stdao.checkStaff(st, st.length, id, pass);
				
				
				if(check != 0) {
					stdao.setStateStaff(check);
					stdao.setStateStaff(id);
					setVisible(false);
					new loadingView(1);
				}else {
					JOptionPane.showMessageDialog(null, "OOPS!! User information is incorrect!!!","Errorr!!!", JOptionPane.ERROR_MESSAGE);
					nvIDTF.setText("");
					nvPassTF.setText("");
				}
				
			}
		});
		next.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				next.setBorder(BorderFactory.createEtchedBorder());
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				next.setBorder(BorderFactory.createEtchedBorder(Color.white, Color.white));
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				next.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				try {
					Thread.sleep(50);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				next.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				
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
		deco_login_frame();
		
		componentLogin.add(nvIDL);
		componentLogin.add(nvIDTF);
		componentLogin.add(nvPassL);
		componentLogin.add(passFrame);
		componentLogin.add(new JLabel());
		componentLogin.add(next);
		
		loginView.add(componentLogin);
		
		slidePoster sli = new slidePoster(slideImage, slideL, overlay);
		sli.start();
		
		add(slider);
		add(loginView);
		
		addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
              
                    sli.stopp(); // Dừng luồng
                    try {
                        sli.join(); // Chờ luồng dừng hẳn trước khi đóng cửa sổ
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    setVisible(false);; // Đóng cửa sổ
                }
        
        });
		
		background = new JLabel();
		background.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\back.png"));
		background.setBounds(0,0,this.getWidth(),this.getHeight());
		add(background);
		
	}

	public void deco_login_frame() {
		snack = new JLabel();
		coca = new JLabel();
		snack.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\snack.png"));
		coca.setIcon(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\cola.png"));
		snack.setBounds(75, 365, 32, 32);
		coca.setBounds(425, 365, 32, 32);
		
		frame.add(snack);
		frame.add(coca);
		frame.setVisible(false);
		frame.setVisible(true);
		
	}
	
}
