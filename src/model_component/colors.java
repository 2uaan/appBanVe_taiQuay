package model_component;

import java.awt.Color;

public class colors {
	
	public Color loginBack = new Color(0xD6BA73);
	public Color back = new Color(0xF0EADE);
	public Color back2 = new Color(0x222222);
	public Color button = new Color(0x31111D);
	
	public Color cineRed = new Color(0xC00F0C);
	public Color cineBrown = new Color(0x663C1F);
	public Color cineYellow = new Color(0xFFE8A3);
	public Color cineBlack = new Color(0x2C2C2C);
	public Color cineBlue = new Color(0x059abb);
	
	public Color cineRed2 = new Color(0xaa1d1d);
	public Color cineYellow2 = new Color(0xffde9c);
	
	public Color darkRed = new Color(0x780116);
	public Color lightPink = new Color(0xDD948C);
	
	public Color transparent = new Color(0,0,0,0);
	
	public Color cineRedOpa(int opa) {
		Color temp = new Color(192,15,12,opa);
		return temp;
	}
	public Color cineBrownOpa(int opa) {
		Color temp = new Color(102,60,31,opa);
		return temp;
	}
	public Color cineYellowOpa(int opa) {
		Color temp = new Color(214,186,115,opa);
		return temp;
	}
	public Color cineBlackOpa(int opa) {
		Color temp = new Color(44,44,44,opa);
		return temp;
	}
	
}
