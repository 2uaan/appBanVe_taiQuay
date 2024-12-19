package model_component;

import java.awt.Color;

import javax.swing.JPanel;

public class borderFrame extends JPanel{
	
	private JPanel contain;
	private int doBo;
	private int width;
	private int height;
	private Color color;
	
	public borderFrame() {
		
	}
	
	public borderFrame(JPanel contain, int doBo, int width, int height, Color color) {
		super();
		this.contain = contain;
		this.doBo = doBo;
		this.width = width;
		this.height = height;
		this.color = color;
		this.setLayout(null);
		this.setBackground(color);
		
		JPanel g1,g2,g3,g4;
		Circle c1,c2,c3,c4;
		Color squa;
		squa = contain.getBackground();
		

		c1 = new Circle(doBo*2, color);
		c2 = new Circle(doBo*2, color);
		c3 = new Circle(doBo*2, color);
		c4 = new Circle(doBo*2, color);
		c1.setBackground(new Color(0,0,0,0));
		c2.setBackground(new Color(0,0,0,0));
		c3.setBackground(new Color(0,0,0,0));
		c4.setBackground(new Color(0,0,0,0));
		
		g1 = new JPanel();
		g2 = new JPanel();
		g3 = new JPanel();
		g4 = new JPanel();
		g1.setBackground(squa);
		g2.setBackground(squa);
		g3.setBackground(squa);
		g4.setBackground(squa);
		g1.setBounds(0,0,doBo, doBo);
		g2.setBounds(width-doBo,0,doBo, doBo);
		g3.setBounds(0,height-doBo,doBo, doBo);
		g4.setBounds(width-doBo,height-doBo,doBo, doBo);
		c1.setBounds(0,0,doBo*2, doBo*2);
		c2.setBounds(width-doBo*2,0,doBo*2, doBo*2);
		c3.setBounds(0,height-doBo*2,doBo*2, doBo*2);
		c4.setBounds(width-doBo*2,height-doBo*2,doBo*2, doBo*2);
		
		
		this.add(c1);
		this.add(c2);
		this.add(c3);
		this.add(c4);
		this.add(g1);
		this.add(g2);
		this.add(g3);
		this.add(g4);
		this.setSize(width, height);
		
		
		contain.add(this);
		
		
	}
	
	
}
