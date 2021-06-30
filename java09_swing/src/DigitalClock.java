import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClock extends JFrame{
	Calendar now;
	Font font = new Font("굴림",Font.BOLD,100);
	JLabel lbl = new JLabel("00:00:00", JLabel.CENTER);
	public DigitalClock()  {
		super("시계");
		add(lbl);
		lbl.setFont(font);
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image img = tk.getImage("img/img3.png");
		setIconImage(img);
		setSize(500,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		startClock();
	}
	public void startClock() {
		do {
			//시간변경
			lbl.setText(getTimer());
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				
			}
			
		}while(true);
	}
	
	public String getTimer() {
		now = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(now.getTime());
	}
	
	public static void main(String[] args) {
		new DigitalClock();
	}

}
