package model_component;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class margin {
	
	public Border marginB(int num) {
		Border b = BorderFactory.createEmptyBorder(0,0,num,0);
		return b;
	}
	
	public Border marginL(int num) {
		Border b = BorderFactory.createEmptyBorder(0,num,0,0);
		return b;
	}
	
	public Border marginR(int num) {
		Border b = BorderFactory.createEmptyBorder(0,0,0,num);
		return b;
	}
	
	public Border marginT(int num) {
		Border b = BorderFactory.createEmptyBorder(num,0,0,0);
		return b;
	}
	
	public Border marginLR(int num) {
		Border b = BorderFactory.createEmptyBorder(0,num,0,num);
		return b;
	}
	
	public Border marginTB(int num) {
		Border b = BorderFactory.createEmptyBorder(num,0,num,0);
		return b;
	}
	
	public Border marginAll(int num) {
		Border b = BorderFactory.createEmptyBorder(num, num, num, num);
		return b;
	}
	
}
