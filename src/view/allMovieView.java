package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.Border;

import controller.*;
import dao.*;
import model_component.*;
import model_data.*;
import thread.slideText;

public class allMovieView extends JFrame{
	
	//Interface variable
	private JPanel frame, vertical, horizontal, showMovie;
	private borderFrame mainFrame;
	private colors colo = new colors();
	private fonT font = new fonT();
	private JButton backToMainPage;
	private GridBagConstraints gbc = new GridBagConstraints();
	
	//Data variable
	
	public static void main(String[] args) {
		new allMovieView().setVisible(true);
	}
	
	public allMovieView() {
		setTitle("All Movie");
		setSize(1000,675);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = new JPanel();
		setContentPane(frame);
		setLayout(null);
		setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\logo.png").getImage());
		frame.setBackground(colo.back);
		
		new JButton("✓ Done");
		
		backToMainPage = new JButton("←");
		backToMainPage.setForeground(Color.white);

		
// 		Main Component
		
		mainFrame = new borderFrame(frame, 20, 840, 490, colo.darkRed);
//		mainFrame.setBackground(colo.cineBlack);
		mainFrame.setLayout(null);
		mainFrame.setLocation(110, 40);
		
		showMovie = new JPanel();
		showMovie.setBounds(20,20,800, 450);
		showMovie.setBackground(colo.lightPink);
		showMovie.setLayout(new GridBagLayout());
		
		addMovie();
		
		mainFrame.add(showMovie);
		
		frame.add(mainFrame);
		
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
	
	
	public void addMovie() {
		movie[] movie = new mDAO().exportMovie();
		
		for (int i = 0; i < movie.length; i++) {
			movie m = movie[i];
			JLabel temp = new JLabel();
			ImageIcon before = new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\poster\\p"+(i+1)+".png");
			Image after = before.getImage().getScaledInstance(128, 204, Image.SCALE_SMOOTH);
			
			temp.setIcon(new ImageIcon(after));
			temp.setBorder(BorderFactory.createLineBorder(colo.darkRed, 5));
			temp.addMouseListener(new MouseListener() {
				
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
					new movieInfor(m).setVisible(true);
					
				}
			});
			
			gbc.gridx = i%3;
			gbc.gridy = i/3;
			gbc.weightx = 1;
			gbc.weighty = 1;
			gbc.gridheight = 1;
			gbc.gridwidth = 1;
			
			showMovie.add(temp, gbc);
			
		}
	}
	
	class movieInfor extends JFrame{
		
		int m_id;
		GridBagConstraints gbcc = new GridBagConstraints();
		
		public void addMs() {
			movie_screening ms[] = new msDAO().selectMS_whereM_id(m_id);
			for (int i = 0; i < ms.length; i++) {
				JPanel temp = new JPanel();
				temp.setPreferredSize(new Dimension(300, 0));
				temp.setLayout(new GridLayout(0,1));
				temp.setBorder(BorderFactory.createLineBorder(colo.cineBrown, 5));
				
				String time_room = "<html><div style=\"text-align: center;\">"+ms[i].getTime_in() + " - " + ms[i].getTime_out()+"<br>Room "+ms[i].getOrder_cinema()+"</div></html>";
				String ns, v, c;
				ns = "Near Screen: " + (24 - new nsDAO().get_nsStateTrue(ms[i].getMs_id()).length) + "/24 seat";
				v = "Vip: " + (24 - new vDAO().get_vStateTrue(ms[i].getMs_id()).length) + "/24 seat";
				c = "Couple: " + (12 - new cDAO().get_cStateTrue(ms[i].getMs_id()).length) + "/12 seat";
				
				ns = "<html><div style=\"text-align: center;\">" + ns+"<br>" + v +"<br>"+ c +"</div></html>" ;
				
				temp.add(new JLabel(time_room, JLabel.CENTER)).setFont(font.tilt_neon(40));
				temp.add(new JLabel(ns, JLabel.CENTER)).setFont(font.bahnschrift(22));
				
				temp.setBackground(colo.cineYellow);
				showMovie.add(temp, gbcc);
				gbcc.gridx++;
			}
		}
		
		public movieInfor(movie m) {
			this.m_id = m.getM_id();
			setTitle(m.getM_name()+" --- Details");
			setSize(1000,675);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame = new JPanel();
			setContentPane(frame);
			setLayout(null);
			setIconImage(new ImageIcon("C:\\Users\\tlmqu\\OneDrive\\Desktop\\Java Project\\appBanVe_taiQuay\\image\\logo.png").getImage());
			frame.setBackground(colo.back);
			
			new JButton("✓ Done");
			
			backToMainPage = new JButton("←");
			backToMainPage.setForeground(Color.white);

			
//	 		Main Component
			
			JLabel movieName = new JLabel(m.getM_name()+" --- Empty Seat");
			movieName.setBounds(130, 35, 15*movieName.getText().length(), 30);
			
			movieName.setFont(font.tilt_neon(30));
			add(movieName);
			
			slideText st = new slideText(movieName, 130 , 930 , movieName.getWidth());
			st.start();
			
			showMovie = new JPanel();
			showMovie.setBackground(colo.lightPink);
			showMovie.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
			showMovie.setLayout(new GridBagLayout());
			
			gbcc.gridx = 0;
			gbcc.gridy = 0;
			gbcc.weightx = 1;
			gbcc.weighty = 1;
			gbcc.gridheight = 1;
			gbcc.gridwidth = 1;
			gbcc.fill = GridBagConstraints.VERTICAL;
			gbcc.insets = new Insets(10, 10, 10, 10);
			
			addMs();
			
			JScrollPane showJScrollPane = new JScrollPane(showMovie);
			showJScrollPane.setBorder(BorderFactory.createLineBorder(colo.darkRed, 10));
			showJScrollPane.setBounds(130,70,800, 450);
			
			frame.add(showJScrollPane);
			
			vertical = new JPanel();
			horizontal = new JPanel();
			vertical.setBounds(0,0,70,640);
			horizontal.setBounds(70,570,1000,70);
			vertical.setLayout(null);
			horizontal.setLayout(null);
			vertical.setBackground(colo.cineRedOpa(100));
			horizontal.setBackground(colo.cineRedOpa(100));
			
//			Component in Vertical Bar

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

			addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                    st.stopp(); // Dừng luồng
	                    try {
	                        st.join(); // Chờ luồng dừng hẳn trước khi đóng cửa sổ
	                    } catch (InterruptedException ex) {
	                        ex.printStackTrace();
	                    }
	                    setVisible(false); // Đóng cửa sổ
	            }
	        });
			
//			Componen in Horizontal Bar		
			
			
			deco_goc();
			add(vertical);
			add(horizontal);
		}
		
	}
}
