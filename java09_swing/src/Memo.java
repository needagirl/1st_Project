import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
															//현재클래스를 직렬화 한다.
public class Memo extends JFrame implements ActionListener, Serializable{
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새글");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu edit = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromeMenuItem = new JMenuItem("chrome");
			JMenuItem editplusMenuItem = new JMenuItem("editplus");
			
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	public Memo() {
		setJMenuBar(mb);
		mb.add(fileMenu);
			fileMenu.add(newMenuItem);
			fileMenu.add(openMenuItem);
			fileMenu.add(saveMenuItem);
			fileMenu.addSeparator();
			fileMenu.add(endMenuItem);
		mb.add(edit);
			edit.add(cutMenuItem);
			edit.add(copyMenuItem);
			edit.add(pasteMenuItem);
		mb.add(runMenu);
			runMenu.add(chromeMenuItem);
			runMenu.add(editplusMenuItem);
			
		add(sp);
		
		setSize(700,700);
//		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		chromeMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object event = ae.getSource();
		if(event == endMenuItem) {
			System.exit(0);
		}else if(event ==newMenuItem) {
			ta.setText("");
		}else if(event== openMenuItem) {
			fileOpen();
		}else if(event==saveMenuItem) {
			
		}
	}
	
	public void fileOpen() {
		
	}
//	public static void main(String[] args) {
//		new Memo();
//	}


}
