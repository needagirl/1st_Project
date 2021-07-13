import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class JSplitPaneEx extends JFrame {
	JSplitPane sp1,sp2,sp3,sp4;
	DigitalClock2 clock = new DigitalClock2(0,0);
	SwingCalendar2 cal = new SwingCalendar2();
	Calculator2 calcul = new Calculator2();
	PackMan pack = new PackMan();
	MyImage paint = new MyImage();
	public JSplitPaneEx() {
		
		sp3 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, paint, pack);
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, clock,cal);
		sp4 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, sp2, calcul);
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp4,sp3);
		
		
		
		sp1.setDividerLocation(500);
		sp2.setDividerLocation(100);
		sp3.setDividerLocation(400);
		sp4.setDividerLocation(400);
		
		sp1.setDividerSize(2);
		sp2.setDividerSize(2);
		sp3.setDividerSize(2);
		sp4.setDividerSize(2);
		
		add(sp1);
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack.packmanStart(pack);
	}
	public class MyImage extends JPanel{
		ImageIcon icon = new ImageIcon("img/img2.jpg");
		Image img = icon.getImage();
		public void paint(Graphics g) {
			g.drawImage(img,0,0,null);
		}
	}

	public static void main(String[] args) {
		new JSplitPaneEx();
	}

}
