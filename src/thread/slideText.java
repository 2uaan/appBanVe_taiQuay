package thread;

import javax.swing.*;

public class slideText extends Thread{

	private volatile boolean running = true;
	private JLabel text;
	private int startloca;
	private int endloca;
	private int textWidth;
	
	public slideText(JLabel text, int startloca, int endloca, int textWidth) {
		super();
		this.text = text;
		this.startloca = startloca;
		this.endloca = endloca;
		this.textWidth = textWidth;
	}
	
	@Override
	public void run() {
		char ch = '+';
		int temp = text.getX();
		while(running) {
			try {
				if (ch == '+') {
					temp++;
					text.setLocation(temp, text.getY());
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					text.setVisible(false);
					text.setVisible(true);
					if (temp+textWidth == endloca) {
						ch = '-';
					}
				}else {
					temp--;
					text.setLocation(temp, text.getY());
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					text.setVisible(false);
					text.setVisible(true);
					if (temp == startloca) {
						ch = '+';
					}
				}
				Thread.sleep(0);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
            }
			
		}
	}
	
	public void stopp() {
		running = false;
	}
	
}
