package thread;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.loginView;
import view.mainPageView;
import view.newTicketView_movie;

public class loading extends Thread{

	public JLabel text;
	public JPanel load;
	public int frameWidth;
	public JFrame out;
	public int no;
	
	public loading(JFrame out ,JPanel load,JLabel text, int frameWidth, int no) {
		super();
		this.out = out;
		this.load = load;
		this.text = text;
		this.frameWidth = frameWidth;
		this.no = no;
	}
	
	@Override
	public void run() {
		int num = frameWidth/16;
		int i = 0;
		while (i <  16 ) {
			
			if (text.getText().equals("Loading  .  .  .")) text.setText("Loading");
			else if (text.getText().equals("Loading")) text.setText("Loading  .");
			else if (text.getText().equals("Loading  .")) text.setText("Loading  .  .");
			else text.setText("Loading  .  .  .");
			
			load.setSize(load.getWidth() + num ,load.getHeight());
			
			load.setVisible(false);
			load.setVisible(true);
			text.setVisible(false);
			text.setVisible(true);
			
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
			
			
		}
		
		if (no == 0) {
			loginView lg = new loginView();
			lg.setVisible(true);
			out.setVisible(false);
		}else if (no == 2) {
			newTicketView_movie lg = new newTicketView_movie();
			lg.setVisible(true);
			out.setVisible(false);
		}else{
			mainPageView mp = new mainPageView();
			mp.setVisible(true);
			out.setVisible(false);
		}
	}
	
	
	
}
