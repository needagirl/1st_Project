import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class JFrameTest extends JFrame {
	ImageIcon icon1 = new ImageIcon("img/img.png");
	ImageIcon icon2 = new ImageIcon("img/img2.png");
	ImageIcon icon3 = new ImageIcon("img/img3.png");

	public JFrameTest() {
		// BorderLayout
		GridLayout layout = new GridLayout(3, 2, 10, 10);
		setLayout(layout);

		JButton btn1 = new JButton("버튼1");
		add(btn1);
		
		
		JButton btn2 = new JButton(icon1);
		add(btn2);
		// 마우스로 버튼을 누를때 아이콘 전환하기
		btn2.setPressedIcon(icon2);
		// 마우스 오버시 icon 변경
		btn2.setRolloverIcon(icon3);

		JButton btn3 = new JButton("버튼3", icon1);
		add(btn3);
		// 버튼을 활성화(true) 비활성화(false)
		btn3.setEnabled(false);
		JButton btn4 = new JButton("네번째버튼");
		add(btn4);

		// 라디오 버튼
		JPanel panel = new JPanel(new GridLayout(3, 1));// 테두리가 없는 컨테이너
		JRadioButton rBtn1 = new JRadioButton("ONE");
		JRadioButton rBtn2 = new JRadioButton("TWO");
		JRadioButton rBtn3 = new JRadioButton("THREE");

		// 라디오 버튼 그룹만들기
		ButtonGroup bg = new ButtonGroup();
		bg.add(rBtn1);
		bg.add(rBtn2);
		bg.add(rBtn3);
		panel.add(rBtn1);
		panel.add(rBtn2);
		panel.add(rBtn3);
		add(panel);

		// 토글버튼
		JToggleButton toggleBtn = new JToggleButton("토글", icon3);
		toggleBtn.setRolloverIcon(icon1);
		toggleBtn.setSelectedIcon(icon2);
		add(toggleBtn);

		// 라벨 만들기
		JLabel lb1 = new JLabel("라벨표시", JLabel.CENTER);
		add(lb1);
		
		//배경색 컬러설정하기
		btn1.setBackground(Color.ORANGE);
		Color clr = new Color(255,255,255);
		toggleBtn.setBackground(clr);
		
		//글자색 컬러정하기
		btn1.setForeground(Color.WHITE);

		//라벨에 배경색 설정하기
		lb1.setBackground(new Color(200,100,100));// 라벨은 배경이 투명처리 되어있음
		lb1.setOpaque(true);//true : 투명처리해제, false : 투명처리
		lb1.setForeground(Color.white);

		//Font : 글꼴(굴림체, 돋움체, Arial...), 글자유형(진하게, 기울임, ), 글자크기설정
		
		Font fnt = new Font("궁서체", Font.ITALIC+Font.BOLD,40);
		lb1.setFont(fnt);
		
		setSize(500, 500);
		setVisible(true);

		// DISPOSE_ON_CLOSE : 프로그램 종료시 자원을 해제하라.
		// DO_NOTHING_ON_CLOSE " 닫기가 수행되지 않는다.
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//밀리초 만큼 일시정지
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {}
		//텍스트 변경
		btn1.setText("변경된 버튼 라벨");
		lb1.setText("변경된 라벨");
	}

	public static void main(String[] args) {
		new JFrameTest();
	}

}
