package thread;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class slidePoster extends Thread{

	private ImageIcon[] c;
	private JLabel b;
	private JPanel o;

	public slidePoster(ImageIcon[] c, JLabel b, JPanel o) {
		super();
		this.c = c;
		this.b = b;
		this.o = o;
	}

	int key = 0;

	@Override
	public void run() {
		while (true) {
			int doMo = 255;
			for (int i = 0; i<254; i++) {
				o.setBackground(new Color(255,255,255,doMo));
				o.setVisible(false);
				o.setVisible(true);
				doMo--;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ImageIcon co = new ImageIcon();
			for (int i = 0 ; i< c.length; i++) {
				if (key == i) {
					co = c[i];
				}
			}
			key++;
			for (int i = 0; i<254; i++) {
				o.setBackground(new Color(255,255,255,doMo));
				o.setVisible(false);
				o.setVisible(true);
				doMo++;
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			b.setIcon(co);
			
			b.setVisible(false);
			b.setVisible(true);
			if(key == c.length) key = 0;
		}
	}
	
}
