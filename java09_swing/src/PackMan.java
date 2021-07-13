import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PackMan extends JPanel implements Runnable, KeyListener {
	MyCanvas mc = new MyCanvas();
	Image img;
	int x,y;
	int p =0;
	Dimension dim;
	public PackMan() {
		setLayout(new BorderLayout());
		add(mc);
		mc.setFocusable(true);
		mc.addKeyListener(this);
	}
	public void setCanvasSize() {
		dim = mc.getSize();
		x= (int)(dim.getWidth()/2-25);
		y= (int)(dim.getHeight()/2-25);
	}
	public void packmanStart(PackMan p) {
		p.setCanvasSize();
		Thread t = new Thread(p);
		t.start();
	}
	public void run() {
		do {
			mc.repaint();
			x -=5;
			if(p%2==0) {
				p++;
			}else {
				p--;
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(true);
	}
	public class MyCanvas extends Canvas{
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
			
		}
		public void paint(Graphics g) {
			g.drawImage(img, x, y, x+50, y+50, 50*p, 0, 50*(p+1), 50, this);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyPressed(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}

}