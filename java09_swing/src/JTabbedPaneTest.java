import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame{
	JTabbedPane tp;
	
	ImageIcon ii = new ImageIcon("img/img.png");
	JLabel lbl = new JLabel(ii);
	
	JButton btn;
	ImageIcon iii = new ImageIcon("img/img2.jpg");
	
	DigitalClock2 dc = new DigitalClock2(0,0);
	Calculator2 cal = new Calculator2();
	SwingCalendar2 sc= new SwingCalendar2();
	Dimension dim;
	PackMan pm = new PackMan();
	public JTabbedPaneTest() {
		super("탭메뉴");
		tp = new JTabbedPane(JTabbedPane.TOP);
		tp.addTab("라벨", lbl);
		
		btn = new JButton(iii);
		tp.addTab("버튼", btn);
		
		tp.addTab("시계", dc);
		tp.addTab("계산기", cal);
		tp.addTab("달력", sc);
		
		tp.insertTab("Button", null, new JButton("추가된 버튼"), "중간에 추가", 3);
		tp.insertTab("PackMan", null, pm, "packman", 4);
		//탭의 활성화 및 비활성화
						//index, true/false
//		tp.setEnabledAt(3,false);
		//setEnabled(false) : 첫번째 탭을 제외한 나머지 모든 탭을 비활성화 한다.
		add(tp);
		setSize(500,500);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//탭의 삭제
		pm.setCanvasSize();
		Thread t = new Thread(pm);
		t.start();
	
//		pm.setCanvasSize();//팩맨 캔버스 크기를 설정한다.
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
//		tp.remove(3);
	}

	public static void main(String[] args) {
		new JTabbedPaneTest();
	}

}
