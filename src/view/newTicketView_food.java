package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;
import javax.swing.text.StyledEditorKit.AlignmentAction;

import dao.*;
import controller.*;
import model_component.*;
import model_data.*;

public class newTicketView_food extends JFrame{
	
	private JPanel frame, vertical, horizontal, drinkFrame, foodFrame, choiceFrame;
	private JScrollPane drinkScroll, foodScroll, choiceScroll;
	private JTabbedPane fnd;
	private colors colo = new colors();
	private fonT font = new fonT();
	private margin ma = new margin();
	private JButton done,backToMainPage, movie, drink_food;
	private GridBagConstraints gbc;
	
	//Data variable
	private food[] f = new foodDAO().exportFood();
	private drink[] d = new drinkDAO().exportDrink();
	private int[] f_nums = new int[f.length];
	private int[] d_nums = new int[d.length];
	
	public static void main(String[] args) {
		new newTicketView_food().setVisible(true);
	}
	
	public newTicketView_food() {
		setTitle("New TicKet: Drink & Food");
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
		
		backToMainPage = new JButton("←");
		backToMainPage.setForeground(Color.white);

		
// 		Main Component
		
		
		 gbc = new GridBagConstraints();
         gbc.gridx = 0;
         gbc.gridy = 0;
         gbc.weightx = 1.0; // Chiều rộng chiếm toàn bộ
         gbc.weighty = 0.0; // Không kéo giãn chiều cao
         gbc.fill = GridBagConstraints.HORIZONTAL; // Đặt nút chiếm toàn bộ chiều rộng
         gbc.insets = new Insets(5, 5, 5, 5); // Khoảng cách giữa các nút

         drinkFrame = new JPanel();
         drinkFrame.setBackground(colo.cineRedOpa(50));
         drinkFrame.setLayout(new GridBagLayout());
		
		foodFrame = new  JPanel();
		foodFrame.setBackground(colo.cineYellowOpa(150));
		foodFrame.setLayout(new GridBagLayout());
		choiceFrame = new JPanel();
		choiceFrame.setLayout(new GridBagLayout());
		choiceFrame.setBorder(ma.marginAll(5));
		addFood_drink();
		
		drinkScroll = new JScrollPane(drinkFrame);
		
		foodScroll = new JScrollPane(foodFrame);
		choiceScroll = new JScrollPane(choiceFrame);
		choiceScroll.setBounds(540,40, 385,480);
		
		
		fnd = new JTabbedPane();
		fnd.setBounds(120,40, 360,480);
		fnd.add("Drink",drinkScroll);
		fnd.add("Food",foodScroll);
		
		frame.add(choiceScroll);
		add(fnd);
		
		vertical = new JPanel();
		horizontal = new JPanel();
		vertical.setBounds(0,0,70,640);
		horizontal.setBounds(70,570,1000,70);
		vertical.setLayout(null);
		horizontal.setLayout(null);
		vertical.setBackground(colo.cineBrownOpa(150));
		horizontal.setBackground(colo.cineBrownOpa(150));
		
//		Component in Vertical Bar

		Border etched = BorderFactory.createEtchedBorder();
		Border margin = BorderFactory.createEmptyBorder(0,0,5,0);
		Border margin2 = BorderFactory.createEmptyBorder(0,0,0,0);
		Border combi = BorderFactory.createCompoundBorder(etched, margin);
		
		backToMainPage.setBounds(10,20,50,40);
		backToMainPage.setFont(font.tilt_neon(35));
		backToMainPage.setFocusPainted(false);
		backToMainPage.setBackground(colo.cineBrown);
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
				Border temp = BorderFactory.createCompoundBorder(BorderFactory.createEtchedBorder(Color.white, Color.white), margin);
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
		movie.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
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
		drink_food.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		drink_food.setBackground(colo.cineYellow);
		drink_food.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		drink_food.setBorder(BorderFactory.createEtchedBorder());
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
		done.setBorder(BorderFactory.createCompoundBorder(etched, margin2));
		done.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		done.addActionListener(new ActionListener() {
					
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkTicket_infor()) {
					ticketInforView ti = new ticketInforView();
					ti.setVisible(true);
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Ticket is empty!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
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
		add(vertical);
		add(horizontal);
		
		
	}
	
	public boolean checkTicket_infor() {
		boolean ns, v, c, food, drink, result = true;
		
		ns = new nsDAO().checkSelected();
		v = new vDAO().checkSelected();
		c = new cDAO().checkSelected();
		food = new foodDAO().checkSelected();
		drink = new drinkDAO().checkSelected();
		
		if (!ns && !v && !c && !food & !drink) result = false;
		
		return result;
	}
	
	private void incre_selec(int id, JLabel num) {
		int temp = Integer.parseInt(num.getText());
		temp++;
		num.setText(temp+"");
		if (id/1000 == 2) new drinkDAO().increNum_selected(id);
		if (id/1000 == 3) new foodDAO().increNum_selected(id);
	}
	
	private void decre_selec(int id, JLabel num) {
		int temp = Integer.parseInt(num.getText());
		temp--;
		num.setText(temp+"");
		if (id/1000 == 2) new drinkDAO().decreNum_selected(id);
		if (id/1000 == 3) new foodDAO().decreNum_selected(id);
	}
	
	public void addFood_drink() {
		
		for (int i = 0; i < d.length; i++) { 
//			int dnum[] = {0};
            JButton button = new JButton(d[i].getD_name() +": "+ d[i].getPriceK());
            ImageIcon originalIcon = null;
            button.setBackground(new Color(0xED3B3B));
            originalIcon = new ImageIcon("image\\foodIcon\\d"+(i+1)+".png");
            

            
            Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage)); 
            button.setFont(font.tilt_neon(27));
            button.setIconTextGap(50);

            int panelHeight = 400;
            int buttonHeight = panelHeight / 5;
            button.setPreferredSize(new Dimension(0, buttonHeight));
            drink drink = d[i];
            JPanel tempFrame = new JPanel();
            JLabel num = new JLabel("",JLabel.CENTER);
            
            if (new drinkDAO().getNum_selected(drink.getDrink_id()) != 0) {
				panelHeight = 420;
	            buttonHeight = panelHeight / 4;
				tempFrame.setPreferredSize(new Dimension(0 , buttonHeight));
				tempFrame.setBackground(colo.cineBlack);
				tempFrame.setLayout(null);
				tempFrame.setBackground(drinkFrame.getBackground());
				tempFrame.setBorder(BorderFactory.createLineBorder(button.getBackground(), 5));
				
				 JLabel icon = new JLabel();
		         icon.setIcon(new ImageIcon(scaledImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		         icon.setBounds(40,10,80,80);
		         tempFrame.add(icon);
				//Component in one choice
				JButton incre, decre, close;
				int n = new drinkDAO().getNum_selected(drink.getDrink_id());
				num.setText(n+"");
				num.setFont(font.tilt_neon(25));
				num.setBackground(Color.white);
				num.setBounds(40,0, 60, 40);
				
				incre = new JButton("+");
				incre.setMargin(new Insets(0, 0, 0, 0));
				incre.setBounds(0,0, 40, 40);
				incre.setFont(font.tilt_neon(35));
				incre.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (drink.getAmount() < (Integer.parseInt(num.getText())+1)) {
							JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else incre_selec(drink.getDrink_id(), num);
					}
				});
				
				decre = new JButton("-");
				decre.setMargin(new Insets(0, 0, 0, 0));
				decre.setBounds(100,0, 40, 40);
				decre.setFont(font.tilt_neon(35));
				decre.addActionListener(new ActionListener() {
									
					@Override
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(num.getText()) > 1) {
							decre_selec(drink.getDrink_id(), num);
						}
					}
				});
				
				close = new JButton("X");
				close.setFont(font.tilt_neon(15));
				close.setBackground(Color.red);
				close.setForeground(Color.white);
				close.setMargin(new Insets(0, 0, 0, 0));
				close.setBounds(334, 3, 40, 20);
				close.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tempFrame.setVisible(false);
						new drinkDAO().setNum_selected(drink.getDrink_id());
					}
				});
				
				JPanel inde_cre = new JPanel();
				inde_cre.setBounds(200,35, 140, 40);
				inde_cre.setLayout(null);
//				inde_cre.setBackground(drinkFrame.getBackground());
				
				inde_cre.add(num);
				inde_cre.add(incre);
				inde_cre.add(decre);

				tempFrame.add(close);
				tempFrame.add(inde_cre);
				choiceFrame.add(tempFrame, gbc);
				gbc.gridy++;
			}
            
            
            
            button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (drink.getAmount() == 0) {
						JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
					}else {
						if (new drinkDAO().getNum_selected(drink.getDrink_id()) == 0) {
							int panelHeight = 420;
				            int buttonHeight = panelHeight / 4;
							tempFrame.setPreferredSize(new Dimension(0 , buttonHeight));
							tempFrame.setBackground(colo.cineBlack);
							tempFrame.setLayout(null);
							tempFrame.setBackground(drinkFrame.getBackground());
							tempFrame.setBorder(BorderFactory.createLineBorder(button.getBackground(), 5));
							
					         JLabel icon = new JLabel();
					         icon.setIcon(new ImageIcon(scaledImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
					         icon.setBounds(40,10,80,80);
					         tempFrame.add(icon);
							//Component in one choice
							JButton incre, decre, close;
							int n = new drinkDAO().getNum_selected(drink.getDrink_id());
							num.setText(n+"");
							num.setFont(font.tilt_neon(25));
							num.setBackground(Color.white);
							num.setBounds(40,0, 60, 40);
							
							incre = new JButton("+");
							incre.setMargin(new Insets(0, 0, 0, 0));
							incre.setBounds(0,0, 40, 40);
							incre.setFont(font.tilt_neon(35));
							incre.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									if (drink.getAmount() < (Integer.parseInt(num.getText())+1)) {
										JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
									}else incre_selec(drink.getDrink_id(), num);
								}
							});
							
							decre = new JButton("-");
							decre.setMargin(new Insets(0, 0, 0, 0));
							decre.setBounds(100,0, 40, 40);
							decre.setFont(font.tilt_neon(35));
							decre.addActionListener(new ActionListener() {
												
								@Override
								public void actionPerformed(ActionEvent e) {
									if (Integer.parseInt(num.getText()) > 1) {
										decre_selec(drink.getDrink_id(), num);
									}
								}
							});
							
							close = new JButton("X");
							close.setFont(font.tilt_neon(15));
							close.setBackground(Color.red);
							close.setForeground(Color.white);
							close.setMargin(new Insets(0, 0, 0, 0));
							close.setBounds(334, 3, 40, 20);
							close.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									tempFrame.setVisible(false);
									new drinkDAO().setNum_selected(drink.getDrink_id());
								}
							});
							
							JPanel inde_cre = new JPanel();
							inde_cre.setBounds(200,35, 140, 40);
							inde_cre.setLayout(null);
//							inde_cre.setBackground(drinkFrame.getBackground());
							
							inde_cre.add(num);
							inde_cre.add(incre);
							inde_cre.add(decre);

							tempFrame.add(close);
							tempFrame.add(inde_cre);
							choiceFrame.add(tempFrame, gbc);
							gbc.gridy++;
						}
						
						
						if (drink.getAmount() < (Integer.parseInt(num.getText())+1)) {
							JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else incre_selec(drink.getDrink_id(), num);
						num.setVisible(false);
						num.setVisible(true);
						
						tempFrame.setVisible(false);
						tempFrame.setVisible(true);
						
						choiceFrame.setVisible(false);
						choiceFrame.setVisible(true);
					}
				}
			});
           
            drinkFrame.add(button, gbc);
            gbc.gridy++; 
        }
		

		
		for (int i = 0; i < f.length; i++) { // Ví dụ thêm 10 nút
            JButton button = new JButton(f[i].getF_name() +": "+ f[i].getPriceK());
            ImageIcon originalIcon = null;
            button.setBackground(new Color(0xBFA66F));
            originalIcon = new ImageIcon("image\\foodIcon\\f"+(i+1)+".png");
            
            Image scaledImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(scaledImage)); 
            button.setFont(font.tilt_neon(30));
            button.setIconTextGap(50);

            int panelHeight = 400;
            int buttonHeight = panelHeight / 5; 
            button.setPreferredSize(new Dimension(0, buttonHeight));

            food food = f[i];
            JPanel tempFrame = new JPanel();
            JLabel num = new JLabel("",JLabel.CENTER);
            
            if (new foodDAO().getNum_selected(food.getFood_id()) != 0) {
				panelHeight = 420;
	            buttonHeight = panelHeight / 4;
				tempFrame.setPreferredSize(new Dimension(0 , buttonHeight));
				tempFrame.setBackground(colo.cineBlack);
				tempFrame.setLayout(null);
				tempFrame.setBackground(foodFrame.getBackground());
				tempFrame.setBorder(BorderFactory.createLineBorder(button.getBackground(), 5));
				
				 JLabel icon = new JLabel();
		         icon.setIcon(new ImageIcon(scaledImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
		         icon.setBounds(40,10,80,80);
		         tempFrame.add(icon);
				//Component in one choice
				JButton incre, decre, close;
				int n = new foodDAO().getNum_selected(food.getFood_id());
				num.setText(n+"");
				num.setFont(font.tilt_neon(25));
				num.setBackground(Color.white);
				num.setBounds(40,0, 60, 40);
				
				incre = new JButton("+");
				incre.setMargin(new Insets(0, 0, 0, 0));
				incre.setBounds(0,0, 40, 40);
				incre.setFont(font.tilt_neon(35));
				incre.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if (food.getAmount() < (Integer.parseInt(num.getText())+1)) {
							JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else incre_selec(food.getFood_id(), num);
					}
				});
				
				decre = new JButton("-");
				decre.setMargin(new Insets(0, 0, 0, 0));
				decre.setBounds(100,0, 40, 40);
				decre.setFont(font.tilt_neon(35));
				decre.addActionListener(new ActionListener() {
									
					@Override
					public void actionPerformed(ActionEvent e) {
						if (Integer.parseInt(num.getText()) > 1) {
							decre_selec(food.getFood_id(), num);
						}
					}
				});
				
				close = new JButton("X");
				close.setFont(font.tilt_neon(15));
				close.setBackground(Color.red);
				close.setForeground(Color.white);
				close.setMargin(new Insets(0, 0, 0, 0));
				close.setBounds(334, 3, 40, 20);
				close.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						tempFrame.setVisible(false);
						new foodDAO().setNum_selected(food.getFood_id());
					}
				});
				
				JPanel inde_cre = new JPanel();
				inde_cre.setBounds(200,35, 140, 40);
				inde_cre.setLayout(null);
//				inde_cre.setBackground(foodFrame.getBackground());
				
				inde_cre.add(num);
				inde_cre.add(incre);
				inde_cre.add(decre);

				tempFrame.add(close);
				tempFrame.add(inde_cre);
				choiceFrame.add(tempFrame, gbc);
				gbc.gridy++;
			}
            
            
            
            button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (food.getAmount() == 0) {
						JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
					}else {
						if (new foodDAO().getNum_selected(food.getFood_id()) == 0) {
							int panelHeight = 420;
				            int buttonHeight = panelHeight / 4;
							tempFrame.setPreferredSize(new Dimension(0 , buttonHeight));
							tempFrame.setBackground(colo.cineBlack);
							tempFrame.setLayout(null);
							tempFrame.setBackground(foodFrame.getBackground());
							tempFrame.setBorder(BorderFactory.createLineBorder(button.getBackground(), 5));
							
					         JLabel icon = new JLabel();
					         icon.setIcon(new ImageIcon(scaledImage.getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
					         icon.setBounds(40,10,80,80);
					         tempFrame.add(icon);
							//Component in one choice
							JButton incre, decre, close;
							int n = new foodDAO().getNum_selected(food.getFood_id());
							num.setText(n+"");
							num.setFont(font.tilt_neon(25));
							num.setBackground(Color.white);
							num.setBounds(40,0, 60, 40);
							
							incre = new JButton("+");
							incre.setMargin(new Insets(0, 0, 0, 0));
							incre.setBounds(0,0, 40, 40);
							incre.setFont(font.tilt_neon(35));
							incre.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									if (food.getAmount() < (Integer.parseInt(num.getText())+1)) {
										JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
									}else incre_selec(food.getFood_id(), num);
								}
							});
							
							decre = new JButton("-");
							decre.setMargin(new Insets(0, 0, 0, 0));
							decre.setBounds(100,0, 40, 40);
							decre.setFont(font.tilt_neon(35));
							decre.addActionListener(new ActionListener() {
												
								@Override
								public void actionPerformed(ActionEvent e) {
									if (Integer.parseInt(num.getText()) > 1) {
										decre_selec(food.getFood_id(), num);
									}
								}
							});
							
							close = new JButton("X");
							close.setFont(font.tilt_neon(15));
							close.setBackground(Color.red);
							close.setForeground(Color.white);
							close.setMargin(new Insets(0, 0, 0, 0));
							close.setBounds(334, 3, 40, 20);
							close.addActionListener(new ActionListener() {
								
								@Override
								public void actionPerformed(ActionEvent e) {
									tempFrame.setVisible(false);
									new foodDAO().setNum_selected(food.getFood_id());
								}
							});
							
							JPanel inde_cre = new JPanel();
							inde_cre.setBounds(200,35, 140, 40);
							inde_cre.setLayout(null);
//							inde_cre.setBackground(foodFrame.getBackground());
							
							inde_cre.add(num);
							inde_cre.add(incre);
							inde_cre.add(decre);

							tempFrame.add(close);
							tempFrame.add(inde_cre);
							choiceFrame.add(tempFrame, gbc);
							gbc.gridy++;
						}
						
						
						if (food.getAmount() < (Integer.parseInt(num.getText())+1)) {
							JOptionPane.showMessageDialog(null, "Out of stock!!!!", "Errorr!!!", JOptionPane.ERROR_MESSAGE);
						}else incre_selec(food.getFood_id(), num);
						num.setVisible(false);
						num.setVisible(true);
						
						tempFrame.setVisible(false);
						tempFrame.setVisible(true);
						
						choiceFrame.setVisible(false);
						choiceFrame.setVisible(true);
					}
				}
			});
            
            // Thêm nút vào panel
            foodFrame.add(button, gbc);
            gbc.gridy++; // Tăng vị trí hàng
        }

		foodFrame.setVisible(false);
		drinkFrame.setVisible(false);
		foodFrame.setVisible(true);
		drinkFrame.setVisible(true);
		
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
