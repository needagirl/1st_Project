import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest extends JFrame{
	JSplitPane sp1;
	JSplitPane sp2;
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	Calculator2 cal = new Calculator2();
	SwingCalendar2 sc = new SwingCalendar2();
	public JSplitPaneTest() {
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,cal,sc);
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, sp);
		add(sp1);
		
		//경계선의 위치를 설정할 수 있다.
		sp2.setDividerLocation(350);// 위쪽이 350
		sp1.setDividerLocation(800);//왼쪽이 800
		
		//경계선의 두께 설정
		sp2.setDividerSize(3);//px
		sp1.setDividerSize(20);
		
		//원터치
		
		sp1.setOneTouchExpandable(true);
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JSplitPaneTest();
	}

}
