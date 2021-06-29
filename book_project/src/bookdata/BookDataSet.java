package bookdata;

import java.util.HashMap;

import memberdata.MemberVO;

public class BookDataSet {
	public static HashMap<String, BookVO> bookList = new HashMap<String, BookVO>();
	public static HashMap<String, MemberVO> memberList;
	
	public BookDataSet() {
		
	}
	
	public static void basicBookData() {
		bookList.put("9788994492032", new BookVO("Java������", "���� ��", "��������", "500", 30000, 10));
		bookList.put("9788937460449", new BookVO("���̾�", "�츣�� �켼", "������", "800", 8000, 8));
		bookList.put("9788931003352", new BookVO("���� �Ѱ��", "������ ����", "�������ǻ�", "800", 9000, 5));
		bookList.put("9788995834985", new BookVO("�������� Ŀ���Ͽ콺", "�����", "��ǳ", "800", 9000, 0));
		bookList.put("9788956250823", new BookVO("�������� ���긲��տ� ��뼭��", "�ּ���", "�а���", "600", 19800, 3));
		bookList.put("9788974793739", new BookVO("�ι����� �����ϴ� ������� ���� �ұ�����", "����", "�ұ����ǻ�", "200", 16000, 1));
		bookList.put("9788956609959", new BookVO("���� ���", "������", "���೪��", "800", 13000, 12));
		bookList.put("9791166932298", new BookVO("������ ��������", "�������н���", "������̵�", "700", 15000, 12));
		bookList.put("9788936478735", new BookVO("������ ���� ���̵�", "����", "â��", "300", 15000, 27));
		bookList.put("9788937472060", new BookVO("�츮�� �� ��", "������", "������", "800", 14000, 17));
		bookList.put("9788974564698", new BookVO("���� �̸�", "�̽¿�", "���̴�", "500", 13000, 2));
	}

}
