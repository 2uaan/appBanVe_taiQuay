package model_component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Circle extends JPanel{
	
	private int diameter;
	private Color color;

    public Circle(int diameter, Color color) {
        this.diameter = diameter;
        this.color = color;
        // Đặt kích thước ưu tiên để panel tự động điều chỉnh khi thêm vào layout
        setPreferredSize(new Dimension(diameter, diameter));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
	
	public static void main(String[] args) { 
		JFrame frame = new JFrame(); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(400, 410); 
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); 
		

//		frame.setLayout(null);
		Circle t1 = new Circle(40, Color.DARK_GRAY); 
		t1.setBackground(new Color(0,0,0,0));
		t1.setBounds(20,20,40,40);
		Circle t2 = new Circle(40, Color.DARK_GRAY); 
		t2.setBackground(new Color(0,0,0,0));
		t2.setBounds(325,20,40,40);
		Circle t3 = new Circle(40, Color.DARK_GRAY); 
		t3.setBackground(new Color(0,0,0,0));
		t3.setBounds(20,310,40,40);
		Circle t4 = new Circle(40, Color.DARK_GRAY); 
		t4.setBackground(new Color(0,0,0,0));
		t4.setBounds(325,310,40,40); 
		
		JPanel back = new JPanel();
		back.setBackground(new Color(255,255,255));
		back.setBounds(0, 0, 400,400);
		JPanel khung = new JPanel();
		khung.setBackground(Color.DARK_GRAY);
		khung.setBounds(20,20,345,330);
		
		
		JPanel v1, v2 , v3, v4;
		v1 = new JPanel();
		v2 = new JPanel();
		v3 = new JPanel();
		v4 = new JPanel();
		v1.setBackground(Color.white);
		v2.setBackground(Color.white);
		v3.setBackground(Color.white);
		v4.setBackground(Color.white);
		
		v1.setBounds(20,20,20,20);
		v2.setBounds(345,20,20,20);
		v3.setBounds(20,330,20,20);
		v4.setBounds(345,330,20,20);
		
		frame.add(t1);
		frame.add(t2);
		frame.add(t3);
		frame.add(t4);
		frame.add(v1);
		frame.add(v2);
		frame.add(v3);
		frame.add(v4);
		frame.add(khung);
		frame.add(back);
		frame.setVisible(true);
		
	}
	
}
