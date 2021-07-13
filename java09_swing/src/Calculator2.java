import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator2 extends JPanel implements ActionListener{
	Font fnt = new Font("굴림체", Font.BOLD, 25);
	
	JTextField tf = new JTextField("0.0");
	
	JPanel allBtnPane = new JPanel(new BorderLayout());
	JPanel northPane = new JPanel(new GridLayout(1,3));
	JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	String btnStr[] = {"BackSpace", "Clear", "End", 
						"7","8","9","+",
						"4","5","6","-",
						"1","2","3","*",
						"0",".","=","/"};
	
	
	public Calculator2() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, tf);
		tf.setHorizontalAlignment(JTextField.RIGHT);//텍스트박스의 내용을 오른쪽 정렬
		tf.setFont(fnt);
		add(BorderLayout.CENTER, allBtnPane);
		allBtnPane.add(BorderLayout.NORTH, northPane);
		allBtnPane.add(BorderLayout.CENTER, centerPane);
		/////////////////////////////////////////////
		//버튼을 JPanel에 추가
		for(int i= 0; i<btnStr.length; i++) {
			JButton btn = new JButton(btnStr[i]);
			btn.setFont(fnt);
			if (i<3) {
				northPane.add(btn);
			}else {
				centerPane.add(btn);
				
			}
			btn.addActionListener(this);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
