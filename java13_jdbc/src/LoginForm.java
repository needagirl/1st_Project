import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LoginForm extends JFrame{
	JPanel top = new JPanel();
	JPanel itemPane = new JPanel();
	JPanel textPane = new JPanel();
	JPanel btnMenu = new JPanel();
	String btnName[] = {"추가","수정","삭제","지우기","종료","엑셀로저장","엑셀로불러오기"};
	String itemName[] = {"번호","이름","전화번호","이메일","주소","등록일"};
	JPanel bottom = new JPanel();
	JTable table;
	DefaultTableModel model;
	JScrollPane sp;
	
	public LoginForm() {
		setLayout(new GridLayout(2,0));
		add(top);
		top.setLayout(new BorderLayout());
		top.add(BorderLayout.WEST, itemPane);
		itemPane.setLayout(new GridLayout(6,1));
		top.add(textPane);
		textPane.setLayout(new GridLayout(6,1,10,10));
		for (int i = 0; i < itemName.length; i++) {
			itemPane.add(new JLabel(itemName[i]));
			JPanel textFieldPane = new JPanel();
			textFieldPane.setLayout(new FlowLayout(FlowLayout.LEFT));
			int size[] = {3,10,20,20,40,40};
			textPane.add(textFieldPane);
			textFieldPane.add(new JTextField(size[i]));
				
		}
		top.add(BorderLayout.SOUTH, btnMenu);
		btnMenu.setLayout(new GridLayout(0,7));
		for (int i = 0; i < btnName.length; i++) {
			btnMenu.add(new JButton(btnName[i]));
		}
		
		add(bottom);
		bottom.setLayout(new BorderLayout());
		model = new DefaultTableModel(itemName, 0);
		table = new JTable(model);
		sp = new JScrollPane(table);
		bottom.add(sp);
		
		setSize(900,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new LoginForm();
	}

}
