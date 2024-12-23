package thread;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.loginView;
import view.mainPageView;
import view.newTicketView_movie;

public class loading extends Thread{

	public JPanel load;
	public int frameWidth;
	public JFrame out;
	public int no;
	
	public loading(JFrame out ,JPanel load, int frameWidth, int no) {
		super();
		this.out = out;
		this.load = load;
		this.frameWidth = frameWidth;
		this.no = no;
	}
	
	@Override
	public void run() {
		int num = frameWidth/10;
		int i = 0;
		while (i <  10 ) {
			load.setSize(load.getWidth() + 32 ,load.getHeight());
			
			load.setVisible(false);
			load.setVisible(true);
			
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
