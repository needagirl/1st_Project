import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class PackMan extends JFrame {
	Image img;
	MyCanvas mc = new MyCanvas();
	
	public PackMan() {
		
		add(mc);
		
		setBounds(700, 350, 400, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		}
		public void paint(Graphics g) {
			int speed = 5;
			int imgw = img.getHeight(this);
			g.drawImage(img, 1, 1, imgw, imgw, 1, 1, imgw, imgw, this);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) {
		new PackMan();
	}

}
