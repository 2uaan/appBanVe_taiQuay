package thread;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import view.loginView;
import view.mainPageView;
import view.newTicketView_movie;

public class loading extends Thread{

	public JProgressBar load;
	public JFrame out;
	public int no;
	
	public loading(JFrame out ,JProgressBar load, int no) {
		super();
		this.out = out;
		this.load = load;
		this.no = no;
	}
	
	@Override
	public void run() {
		int i = -1;
		while (i <  100) {
			i++;

			load.setValue(i);
			try{Thread.sleep(20);}catch(Exception e){}
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
