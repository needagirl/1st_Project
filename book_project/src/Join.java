import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class Join {

	public Join() {

	}
	
	public String joinProcess() {		
		//MemberDataSet.memberData();
		
		String grade, name, birthday, gender, tel, id, pw, email;
		do {
			grade = inputMemberGrade();
			name = inputMemberName();
			birthday = inputMemberBirthday();
			gender = inputMemberGender();
			tel = inputMemberTel();
	
			boolean chk = true;
			Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
			Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
			
			while(it.hasNext()) {
				Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
				MemberVO mvo = e.getValue();
				mvo.setId(e.getKey());
				if(mvo.getName().equals(name) && mvo.getBirthday().equals(birthday) && mvo.getGender().equals(gender) && mvo.getTel().equals(tel)) {
					System.out.println("�̹� ���Ե� ȸ�� �����Դϴ�.");
					chk = false;
					break;
				}
			} // while
			if(chk) {
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				break;
			}
		} while(true);
		
		// ���̵�, ���, �̸���
		id = inputMemberId();
		pw = inputMemberPw();
		//email = inputMemberEmail();
		
		System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�. �ش� �������� �α��ε˴ϴ�.");
		
		MemberVO mvo = new MemberVO(pw, name, birthday, gender, tel, grade);
		MemberDataSet.addMember(id, mvo);
		
		return id;
	}
	
	
	// ȸ������ ����
	public String inputMemberGrade() {
		String grade = inputData("ȸ������ ������ �����ϼ���. [1.�Ϲ�ȸ��] [2.������] :");
		do {
			if(grade.equals("1")) {
				grade="�Ϲ�ȸ��";
				break;
			} else if(grade.equals("2")) {
				grade="������";
				break;
			} else{
				System.out.println("1�� 2�߿� �����ϼ���.");
			}
		} while(true);
		
		return grade;
	}
	
	// �̸�
	public String inputMemberName() {
		String name;
		do {
			name = inputData("�̸�: ");
			if(name.length()<2 || name.length()>24) {
				System.out.println("�߸��� �̸��Դϴ�. �ٽ� �Է����ּ���.");
			} else {
				break;
			}
		} while(true);
		
		return name;
	}
	
	// �������
	public String inputMemberBirthday() {
		String birthday;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		int nowDate = Integer.parseInt(fm.format(cal.getTime()));
		do {
			try {
				birthday = inputData("�������(ex:19910101): ");
				int[] birthdayArr = new int[3];
				birthdayArr[0] = Integer.parseInt(birthday.substring(0, 4));
				birthdayArr[1] = Integer.parseInt(birthday.substring(4, 6));
				birthdayArr[2] = Integer.parseInt(birthday.substring(6));

				cal.set(birthdayArr[0], birthdayArr[1]-1, birthdayArr[2]);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH)+1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
				// System.out.println(year + ","+month + ","+day+","+nowDate);
				
				if(birthday.length()!=8) {
					System.out.println("8�ڸ� ���ڷθ� �Է����ּ���.");
				}else{
					if(birthdayArr[0]<1900 || birthdayArr[0]>2021 || birthdayArr[0] != year || birthdayArr[1] != month || birthdayArr[2] != day) {
						System.out.println("��������� �ٸ��� �Է����ּ���.");
					} else if(nowDate < Integer.parseInt(birthday)){ // ���糯¥���� �� ũ��
						System.out.println("���糯¥ ������ ��¥�� �Է��� �� �����ϴ�.");
					} else {
						break;
					}
				}
			}catch(NumberFormatException nfe) {
				System.out.println("8�ڸ� ���ڷθ� �Է����ּ���.");
			}catch(StringIndexOutOfBoundsException sie) {
				System.out.println("8�ڸ� ���ڷθ� �Է����ּ���.");
			}
		} while(true);
		
		return birthday;
	}
	
	// ����
	public String inputMemberGender() {
		String gender;
		do {
			gender = inputData("���� [1.����][2.����]: ");
			if(gender.equals("1")) {
				gender = "����";
				break;
			} else if(gender.equals("2")) {
				gender = "����"; 
				break;
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. [1.����][2.����] �߿��� ��ȣ�� �������ּ���.");
			}
		} while(true);
		
		return gender;
	}
	
	// �޴�����ȣ
	public String inputMemberTel() {
		String tel;
		do {
			try {
				tel = inputData("�޴�����ȣ (���ڸ� �Է� - ��)01012341234): ");
				Integer.parseInt(tel); // ���ڸ� �ԷµǾ����� Ȯ��
				String[] telArr = new String[2];
				if(tel.length()==11 || tel.length()==10) {
					telArr[0] = tel.substring(0, 3); //010
					telArr[1] = tel.substring(3);
				}
				else{
					System.out.println("�߸��� �����Դϴ�. �޴�����ȣ�� �Է����ּ���.");
				}
				
				if(!telArr[0].equals("010") && !telArr[0].equals("011") && !telArr[0].equals("016") && !telArr[0].equals("017") && !telArr[0].equals("019") || telArr[1].substring(0,1).equals("0")) {
					System.out.println("�߸��� �����Դϴ�. �޴�����ȣ�� �Է����ּ���.");
				} else {
					break;
				}
			} catch(NumberFormatException nfe) {
				System.out.println("���ڷθ� �Է����ּ���.");
			} catch(NullPointerException npe) {
				
			}
		} while(true);
		
		return tel;
	}
	
	// ���̵�
	public String inputMemberId() {
		String id;
		do {
			id = inputData("���̵�(����/���� 5~10�ڸ�): ").toLowerCase(); // �̹� �ִ� ���� Ȯ��, �ҹ��ڷ� ����
			if(MemberDataSet.memberList.containsKey(id)) {
				System.out.println("�̹� ��� ���� ���̵��Դϴ�. �ٽ� �Է����ּ���.");
			} else if(id.length()<5 || id.length()>10){
				System.out.println("���̵�� ����/���� 5~10�ڸ����� �մϴ�.");
			} else {
				boolean repeat = true;
				for(int i=0; i<id.length(); i++) {
					id.charAt(i);
					if(!(id.charAt(0)>=97 && id.charAt(0)<=122)) {
						repeat = false;
					} else if(!(id.charAt(i) >= 97 && id.charAt(i)<=122 || id.charAt(i)>=48 && id.charAt(i)<=57)) {
						repeat = false;
					}
				} //for
				if(repeat) break;
				else System.out.println("���̵�� ����/���ڷθ� ��� �����ϸ�, ù ���ڴ� ������ �����մϴ�.");
			} //if
		} while(true);
		
		return id;
	}
	
	// ��й�ȣ
	public String inputMemberPw() {
		String pw, pw2;
		do {
			pw = inputData("��й�ȣ (����/����/Ư�����ڸ� ��� 6~15�ڸ�(��ҹ��� ����)): ");
			if(pw.length()<6 || pw.length()>15){
				System.out.println("��й�ȣ�� ����/����/Ư������ 6~15�ڸ����� �մϴ�.");
			} else if(pw.indexOf(" ")!=-1){
				System.out.println("��й�ȣ�� ������ ������ �� �����ϴ�.");
			} else {
				char[] ascii = {33,35,36,37,38,40,41,42,43,45,64,94,95,126};
				boolean repeat = true;
				for(int i=0; i<pw.length(); i++) { // ���� �ϳ��� ��
					char c = pw.charAt(i);
					boolean repeat2 = false;
					for(int j=0; j < ascii.length; j++) { // �ƽ�Ű�ڵ� �ϳ��� ��
						if(c==ascii[j] || (c >=65 && c<=90 || c >= 97 && c<=122 || c>=48 && c<=57)) repeat2 = true; // �� ���̶� ���ǿ� �ش��ϴ� ���ڸ� true�� ��ȯ
					}
					if(!repeat2) repeat = false; // �� ���̶�, �� ���ǿ� �ش��� �� �ȴٸ� = �� �� ���� ���ڸ� false�� ��ȯ
				} //for
				
				if(repeat) {
					pw2 = inputData("��й�ȣ Ȯ��: "); // pw�� �Ȱ����� Ȯ��
					if(pw2.equals(pw)) break;
					else System.out.println("��й�ȣ�� �ٸ��ϴ�. �ٽ� �Է����ּ���.");
				} else {
					System.out.println("��й�ȣ�� ����/����/Ư������(~!@#$%^&*()-_+) �� �����մϴ�.");
				} //if
			} //if
		} while(true);
		
		return pw;
	}
	
//	// �̸���
//	public String inputMemberEmail() {
//		String email = inputData("�̸���: ");
////		if() {
////			
////		}
//		
//		return email; // ��ȿ�� ��������..�� Ȯ��
//	}
	
	
	
	
	// ������ �Է� �ޱ�
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // ������ �Է� �ޱ� ----->

}
