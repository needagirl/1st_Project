import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bookdata.BookDataSet;
import bookdata.BookVO;
import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class Login {

	public Login() {
		//MemberDataSet.memberData();
	}
	
	public String loginProcess() {
		String id, pw;
		MemberVO mvo = new MemberVO();
		do {
			id = inputData("���̵�: ");
			pw = inputData("��й�ȣ: ");
			if(MemberDataSet.memberList.containsKey(id)) {
				mvo = MemberDataSet.memberList.get(id);
				if(pw.equals(mvo.getPw())) {
					break;
				} else {
					System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					loginFalse();
				}
			} else {
				System.out.println("�������� �ʴ� ���̵��Դϴ�.");
				loginFalse();
			}
				
		} while(true);
		
		return id;
	}
	
	// ���� Ʋ���� �� �ٽ� ����
	public void loginFalse() {
		do {
			String select = inputData("[1.�ٽ� �α����ϱ�] [2.���̵�ã��] [3.��й�ȣ ã��] [4.ó������] : ");
			if(select.equals("1")) {
				break;
			} else if(select.equals("2")) {
				findId();
			} else if(select.equals("3")) {
				findPw();
			} else if(select.equals("4")) {
				BookSystem bs = new BookSystem();
				bs.bookStart();
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ���.");
			}
		} while(true);
	}
	
	
	// ���̵� ã��
	public void findId() {
		String name, birthday, gender, tel;
		name = inputData("�̸�: ");
		birthday = inputData("�������: ");
		gender = inputData("���� [1.����] [2.����]: ");
		if(gender.equals("1")) {
			gender = "����";
		} else if(gender.equals("2")) {
			gender = "����";
		}
		tel = inputData("�޴�����ȣ: ");

		boolean chk = false;
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO mvo = e.getValue();
			mvo.setId(e.getKey());
			if(mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
				System.out.println("�����Ǿ����ϴ�. " + name+ "���� ���̵�� "+ mvo.getId() + "�Դϴ�.");
				chk = true;
				break;
			}
		} // while
		if(!chk) System.out.println("���Ե� ȸ�� ������ �����ϴ�.");
	}
	
	// ��й�ȣ ã��
	public void findPw() {
		String id, name, birthday, gender, tel;
		id = inputData("���̵�: ");
		name = inputData("�̸�: ");
		birthday = inputData("�������: ");
		gender = inputData("���� [1.����] [2.����]: ");
		if(gender.equals("1")) {
			gender = "����";
		} else if(gender.equals("2")) {
			gender = "����";
		}
		tel = inputData("�޴�����ȣ: ");

		boolean chk = false;
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO mvo = e.getValue();
			mvo.setId(e.getKey());
			if(mvo.getId().equals(id) && mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
				System.out.println("�����Ǿ����ϴ�. �� ��й�ȣ�� �������ּ���.");
				Join join = new Join();
				String pw = join.inputMemberPw();
				mvo.setPw(pw);
				chk = true;
				break;
			}
		} // while
		if(!chk) System.out.println("���Ե� ȸ�� ������ �����ϴ�.");
	}
	
	
	
	// ������ �Է� �ޱ�
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // ������ �Է� �ޱ� ----->
}
