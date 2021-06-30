package memberdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDataSet {
	public static HashMap<String, MemberVO> memberList = new HashMap<String, MemberVO>();
	public static List<MemberVO> bookingList = new ArrayList<MemberVO>();
	
	public MemberDataSet() {
		
	}
	
	// ȸ�� �߰�
	public static void addMember(String id, MemberVO mvo) {
		memberList.put(id, mvo);
	}
	
	// ȸ�� ���
	public static void memberData() {
		addMember("admin1", new MemberVO("123456", "�̰���", "19910104", "����", "01011111234", "������"));
		addMember("admin2", new MemberVO("a123456", "�����", "19920220", "����", "01022221234", "������"));
		addMember("admin3", new MemberVO("a123456!", "�̰���", "19930331", "����", "01033331234", "������"));
		addMember("member1", new MemberVO("123456", "��ȸ��", "19910101", "����", "01011111111", "�Ϲ�ȸ��"));
		addMember("member2", new MemberVO("a123456", "��ȸ��", "19920220", "����", "01022222222", "�Ϲ�ȸ��"));
		addMember("member3", new MemberVO("a123456!", "��ȸ��", "19930331", "����", "01033333333", "�Ϲ�ȸ��"));
	}
	
	// ���� �߰�
	public static void addBooking(MemberVO mvo) {
		bookingList.add(mvo);
	}
	
	// ���� ���
	public static void bookingData() {
		addBooking(new MemberVO("A1", "9788995834985", "�������� Ŀ���Ͽ콺", 1, "member1", "��ȸ��", "01011111111"));
		addBooking(new MemberVO("A2", "9788995834985", "�������� Ŀ���Ͽ콺", 2, "member2", "��ȸ��", "01022222222"));
		addBooking(new MemberVO("A3", "9788995834985", "�������� Ŀ���Ͽ콺", 3, "member1", "��ȸ��", "01011111111"));
	}
	
}
