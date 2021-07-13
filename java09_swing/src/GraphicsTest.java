import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GraphicsTest extends JFrame{

	MyCanvas mycan = new MyCanvas();
	public GraphicsTest() {
		add(mycan);
		
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public class MyCanvas extends Canvas{
		public MyCanvas() {
		}
		public void paint(Graphics g) {
			
			g.drawRoundRect(300, 300, 500, 500, 100, 200);
			
			//문자를 그리기
			String txt = "JAVA 프로그래밍";
			g.setColor(Color.magenta);
			g.setFont(new Font("굴림체",Font.BOLD, 40));
			g.drawString(txt, 200, 200);
			
			
		}
	}
	public static void main(String[] args) {
		new GraphicsTest();
	}

}
