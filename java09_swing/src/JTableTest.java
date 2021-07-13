import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{

	JTable table;
	JScrollPane sp;
	DefaultTableModel model;
	
	// JTable에서 제목으로 사용할 배열
	String title[] = {"번호", "이름","연락처","주소"};
	// JTable에서 레코드로 사용할 2차원 배열
	Object[][] data = {{100, "홍길동", "010-1234-5678", "서울시 마포구"},
					   {200, "이순신", "010-2343-3545", "서울시 종로구"},
					   {300, "홍두깨", "010-2325-3654", "서울시 강남구"}
					  };
	JLabel lbl = new JLabel(" ");
	
	public JTableTest() {
		model = new DefaultTableModel(data, title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		add(sp);
		add(BorderLayout.SOUTH, lbl);
		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//행추가: addRow()
		Object []row = {400,  "김삿갓","010-2566-3456","서울시 서초구"};
		Vector<Object> v = new Vector<Object>();
		v.add(500);
		v.add("강감찬");
		v.add("010-5436-3634");
		v.add("서울시 강서구");
		
		model.addRow(row);
		model.addRow(v);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//행삽입 : insetrRow()
		Object[] row2 = {600, "담덕","010-5356-9095","서울시 은평구"};
		model.insertRow(2, row2);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//행이동 : moveRow()
		model.moveRow(2, 4, 0);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		// 컬럼추가
//		model.addColumn("기타");
//		Object cData[] = {1,2,3,4,5,6};
//		model.addColumn("메모", cData);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		//행삭제
//		model.removeRow(3);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		//컬럼삭제
//		table.removeColumn(table.getColumn("기타"));
//		
		table.addMouseListener(new MyEvent());
	}
	// 마우스 이벤트 내부클래스
	public class MyEvent extends MouseAdapter{
		public void mouseClicked(MouseEvent me) {
			//1.버튼의 종류(1:외, 2:가,3:오른)
			int eventBtn = me.getButton();
			if(eventBtn ==1) {
				String dataStr= "";
				for (int c = 0; c < table.getColumnCount(); c++) {
					Object data= table.getValueAt(table.getSelectedRow(), c);
					dataStr += data+", ";
				}
				lbl.setText(dataStr);
			}
		}
		
	}
	public static void main(String[] args) {
		new JTableTest();
	}

}
