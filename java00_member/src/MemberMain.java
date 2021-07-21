import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North
	JPanel formPane = new JPanel(new BorderLayout());
		JPanel formWestPane = new JPanel(new GridLayout(6,1,5,5));
			String formLbl[] = {"  번  호 ","  이  름 ","  전화번호 ","  이메일 ","  주  소 ","  등록일 "};
		JPanel formCenter = new JPanel(new GridLayout(6,1,5,5));
			int textFieldsize[] = {5,15,20,30,40,20};
			JTextField formTf[] = {new JTextField(5), new JTextField(15), new JTextField(20), new JTextField(30), new JTextField(40), new JTextField(20)};
			
	//JFrame = Center
	JPanel centerPane = new JPanel(new BorderLayout());
		JPanel btnList = new JPanel(new GridLayout(1,0,3,3));
			String btn[] = {"전체목록","사원추가","사원수정","사원삭제","폼지우기","종  료","엑셀쓰기","엑셀읽기"};
			JButton formtf[] = {new JButton("전체목록"),new JButton("사원추가"),new JButton("사원수정"),new JButton("사원삭제"), new JButton("폼지우기"), new JButton("종료"),new JButton("엑셀쓰기"),new JButton("엑셀읽기")};
		DefaultTableModel model;
			String itemName[] = {"번호","이름","전화번호","이메일","주소","등록일"};
		JTable memberList;
		JScrollPane sp;
		
	//JFrame - South
	JPanel southPane = new JPanel();
		JLabel searchLbl = new JLabel(" 이름 ");
		JTextField searchWord = new JTextField(15);
		JButton searchBtn = new JButton("Search");
		
	public MemberMain() {
		super("회원관리시스템");
		
		//Frame - North
		setForm();
		//Frame - Center
		setBtnTable();
		//Frame - South
		setSearch();
		
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		memberAllList();
	}
	//데이터 베이스에서 회원전체 목록(이름순으로) 가져오기  - JTable목록을 보여준다.
	public void memberAllList() {
		//기존 JTable 의 목록을 지우고 새로 리스트를 출력한다.
		model.setRowCount(0);
		
		
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.allRecord();
		
		//컬렉션의 vo를 get하여 jtable에 목록으로 추가한다.
		for (int i = 0; i < list.size(); i++) {
			MemberVO vo = list.get(i);
			Object obj[] = {vo.getMem_no(), vo.getUsername(), vo.getTel(), vo.getEmail(), vo.getAddr(), vo.getWrithe_date()};
			model.addRow(obj);
			
		}
		
	}
	
	//Frame - North
	public void setForm() {
		add(BorderLayout.NORTH, formPane);
			formPane.add(BorderLayout.WEST, formWestPane);
				for (int i = 0; i < formLbl.length; i++) {
					formWestPane.add(new JLabel(formLbl[i]));
				}
			formPane.add(formCenter);
				for (int i = 0; i < textFieldsize.length; i++) {
					JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
					p.add(formTf[i]);
					formCenter.add(p);
					if(i==0||i==5) formTf[i].setEditable(false);
				}
	}
	//Frame - Center
	public void setBtnTable() {
		add(centerPane);
			centerPane.add(BorderLayout.NORTH, btnList);
				for (int i = 0; i < btn.length; i++) {
					btnList.add(formtf[i]);
					formtf[i].addActionListener(this);
				}
		model = new DefaultTableModel(itemName, 0);
		memberList = new JTable(model);
		sp = new JScrollPane(memberList);
		centerPane.add(sp);
		memberList.addMouseListener(new JTableMouseEventProcess(formTf, memberList));
	}
	//Frame - South
	public void setSearch() {
		add(BorderLayout.SOUTH, southPane);
			southPane.add(searchLbl);
			southPane.add(searchWord);
			southPane.add(searchBtn);
			
			searchBtn.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		if(event.equals("사원추가")) {
			memberInsert();
		}else if(event.equals("폼지우기")) {
			formDataClear();
		}else if(event.equals("종료")) {
			System.exit(0);
		}else if(event.equals("사원수정")) {
			memberUpdate();
		}
	}
	public void memberUpdate() {
		MemberVO vo = new MemberVO();
		vo.setMem_no(Integer.parseInt(formTf[0].getText()));
		vo.setTel(formTf[2].getText());
		vo.setEmail(formTf[3].getText());
		vo.setAddr(formTf[4].getText());
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.updateRecord(vo);
		if(cnt>0) {
			memberAllList();
		}else{
			JOptionPane.showMessageDialog(this, "회원정보 수정이 실패하였습니다.");
		}
		
	}
	//사원추가
	public void memberInsert() {
		String username = formTf[1].getText();
		if(username ==null||username.equals("")) {
			JOptionPane.showMessageDialog(this, "이름을 입력하세요.");
		}else {
			MemberVO vo = new MemberVO();
			vo.setUsername(username);
			vo.setTel(formTf[2].getText());
			vo.setEmail(formTf[3].getText());
			vo.setAddr(formTf[4].getText());
			
			MemberDAO dao = new MemberDAO();
			int cnt = dao.insertRecord(vo);
			if(cnt>0) {//회원추가
				memberAllList();
			}else{//회원추가 실패
				JOptionPane.showMessageDialog(this, "회원추가 실패하였습니다.");
			}
		}
	}
	//폼지우기
	public void formDataClear() {
		for (int i = 0; i < formTf.length; i++) {
			formTf[i].setText("");
		}
	}
	
	//마우스 이벤트 처리 
	public static void main(String[] args) {
		new MemberMain();
	}


}
