import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import bookdata.BookDataSet;
import bookdata.BookVO;
import memberdata.MemberDataSet;
import memberdata.MemberVO;

public class BookSystem {
	String loginId;
	
	public BookSystem() {
		MemberDataSet.memberData();
		MemberDataSet.bookingData();
		BookDataSet.basicBookData();
		bookStart();
	}
	
	// ó�� ����
	public void bookStart() {
		do {
			String select = inputData("[1.�α���][2.ȸ������][3.����]: ");
			if(select.equals("1")) {
				Login login = new Login();
				loginId = login.loginProcess();
				break;
			} else if (select.equals("2")) {
				Join join = new Join();
				loginId = join.joinProcess();
				break;
			}else if (select.equals("3")) {
				exitBookSystem();
			} else {
				System.out.println("�߸� �Է��Ͽ����ϴ�. �ٽ� �Է����ּ���.");
			}
		} while(true);
		MemberVO mvo = new MemberVO();
		mvo = MemberDataSet.memberList.get(loginId);
		
		if(mvo.getGrade().equals("�Ϲ�ȸ��")) {
			showBookList();
			bookProcess();
		} else if(mvo.getGrade().equals("������")) {
			showBookList();
			bookProcessAdmin();
		}

	}
	
	// �޴� ��� - ������
	public String bookNavAdmin() {
		System.out.println("\n[1.�������] [2.�����˻�] [3.�������] [4.������������] [5.��������] [6.������] [7.ȸ�����] [8.���� ����] [9.�α׾ƿ�] [0.����]");
		return inputData("�޴� ��ȣ�� �Է��ϼ���. : ");
	} // �޴� ��� - ������ ----->
	
	// �޴� ��� - �Ϲ���
	public String bookNav() {
		System.out.println("\n[1.�������] [2.�����˻�] [3.���������ϱ�] [4.����Ȯ��] [5.���� ����] [6.�α׾ƿ�] [7.����]");
		return inputData("�޴� ��ȣ�� �Է��ϼ���. : ");
	} // �޴� ��� - �Ϲ��� ----->
	
	// �޴� ���� - ������
	public void bookProcessAdmin() {
		do {
			String nav = bookNavAdmin();
			
			if(nav.equals("1")) { // 1. �������
				showBookList();
			} else if(nav.equals("2")) { // 2. �����˻�
				searchBook();
			} else if(nav.equals("3")) { // 3. �������
				addBook();
				showBookList();
			} else if(nav.equals("4")) { // 4. ������������
				editBook();
				showBookList();
			} else if(nav.equals("5")) { // 5. ��������
				deleteBook();
				showBookList();
			} else if(nav.equals("6")) { // 6. ���� ���
				showBookingListAdmin();
			} else if(nav.equals("7")) { // 7. ȸ�� ���
				showMemberListAdmin();
			} else if(nav.equals("8")) { // 8. ���� ����
				editMyInfo();
			} else if(nav.equals("9")) { // 9. �α׾ƿ�
				bookStart();
			} else if(nav.equals("0")) { // 0. ����
				exitBookSystem();
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}while(true);
	} // �޴� ���� - ������ ----->
	
	// �޴� ���� - �Ϲ���
	public void bookProcess() {
		do {
			String nav = bookNav();
			
			if(nav.equals("1")) { // 1. �������
				showBookList();
			} else if(nav.equals("2")) { // 2. �����˻�
				searchBook();
			} else if(nav.equals("3")) { // 3. ���������ϱ�
				bookingBook();
				showBookList();
			} else if(nav.equals("4")) { // 4. ����Ȯ��
				bookingBookDetail();
				showBookList();
			} else if(nav.equals("5")) { // 5. ���� ����
				editMyInfo();
			} else if(nav.equals("6")) { // 6. �α׾ƿ�
				bookStart();
			} else if(nav.equals("7")) { // 7. ����
				exitBookSystem();
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			}
		}while(true);
	} // �޴� ���� - �Ϲ��� ----->
	
	
	// �����˻� - ISBN�� ������ �Է����� ���� �˻��ǰ� �� / �˻��� �� �񱳹��� ���� ����.
	public void searchBook() {
		String msg;
		boolean chk = false;
		boolean chk2 = false;
		try {
			int answer = Integer.parseInt(inputData("[1.���հ˻�] [2.������] [3.������] [4.���ǻ�] [5.ISBN]\n�˻��� �׸� ��ȣ�� �����ϼ���. : "));
			switch(answer) {
				case 1: msg = "�˻���"; break;
				case 2: msg = "������"; break;
				case 3: msg = "������"; break;
				case 4: msg = "���ǻ�"; break;
				case 5: msg = "ISBN"; break;
				default: throw new NumberFormatException();
			} // switch
			String findTxt = inputData(msg + ": ").replace(" ","");
			
			BookVO.printTitle();
			Set<Map.Entry<String, BookVO>> list = BookDataSet.bookList.entrySet();
			Iterator<Map.Entry<String, BookVO>> it = list.iterator();
			
			while(it.hasNext()) {
				Map.Entry<String, BookVO> e = (Map.Entry<String, BookVO>)it.next();
				BookVO vo = e.getValue();
				vo.setIsbn(e.getKey());
				switch(answer) {
					case 1:
						msg ="";
						String msg1 = vo.getBookTitle();
						String msg2 = vo.getWriter(); 
						String msg3 = vo.getCompany();
						String msg4 = vo.getIsbn();
						if(msg1.replace(" ","").indexOf(findTxt)!= -1 || msg2.replace(" ","").indexOf(findTxt)!= -1 || msg3.replace(" ","").indexOf(findTxt)!= -1 || msg4.replace(" ","").equals(findTxt)) chk=true;
						else chk=false;
						break;
					case 2: msg = vo.getBookTitle(); break;
					case 3: msg = vo.getWriter(); break;
					case 4: msg = vo.getCompany(); break;
					case 5:
						msg = "";
						if(vo.getIsbn().equals(findTxt)) chk=true;
						else chk=false;
						break;
				} // switch
				if(msg.replace(" ","").indexOf(findTxt)!= -1 || chk) {
					vo.printList();
					chk2 = true;
				} //if
			} // while
			if(chk2 == false) System.out.println(" \t \t \t \t �˻��� ������ �����ϴ�.");
		} catch(NumberFormatException nfe) {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			searchBook();
		} catch(Exception e) {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			searchBook();
		}
//		} catch(NoSuchElementException nsee) { -------------------------------------- ���� Ȯ���� ����
//			System.out.println("�߸� �Է��Ͽ����ϴ�.");
//			searchBook();
//		}// try-catch
	} // �����˻� ----->
	
	
	// �������
	public void addBook() {
		System.out.println("����� ������ ������ �Է��ϼ���.");
		String isbn, group;
		int price, stock;
		// isbn ��ȿ�� �˻�
		isbn = checkIsbn("ISBN : ", "nowIsbn"); // 2��° �Ű��������� �ƹ��ų� �ᵵ �� (ISBN ������ �ƴ� ��)
		String bookTitle = inputData("������: ");
		String writer = inputData("������: ");
		String company = inputData("���ǻ�: ");
		
		// �з� �˻�
		do {
			try {
				group = inputData("�з�: ");
				int groupInt = Integer.parseInt(group);
				if(groupInt>=0 && groupInt<1000 && group.length()==3) break;
				else throw new NumberFormatException();
			} catch(NumberFormatException nfe) {
				System.out.println("3�ڸ� ���ڸ� �Է����ּ���.");
			}
		} while(true);
		
		//���� �˻�
		do {
			try {
				price = Integer.parseInt(inputData("����: "));
				if(price>=0 && price<=10000000) break;
				else System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
			} catch(NumberFormatException nfe) {
				System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
			}
		} while(true);
		
		//��� �˻�
		do {
			try {
				stock = Integer.parseInt(inputData("���: "));
				if(stock>=0 && stock<=10000000) break;
				else System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
			} catch(NumberFormatException nfe) {
				System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
			}
		} while(true);
		
		BookDataSet.bookList.put(isbn, new BookVO(bookTitle, writer, company, group, price, stock));
		System.out.println("�ش� ���� ������ ��ϵǾ����ϴ�.");
	} // ������� ----->
	
	
	// ���� ���� ����
	public void editBook() {
		String isbn = inputData("������ ������ ISBN�� �Է��ϼ���. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("�ش� ������ ã�� �� �����ϴ�. ");
			do {
				String answer = inputData("[1.�ٽ� �Է��ϱ�] [2.������� ���ư���] : ");
				if(answer.equals("1")) {
					editBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("������")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} while(true);
		} else {
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.editDetail();
			do {
				String answer = inputData("������ �׸��� �����ϼ���. : ");
				if(answer.equals("1")) {
					System.out.println("[1.������] "+ vo.getBookTitle());
					vo.setBookTitle(inputData("������ ����: "));
					break;
				} else if(answer.equals("2")) {
					System.out.println("[2.������] "+ vo.getWriter());
					vo.setWriter(inputData("������ ����: "));
					break;
				} else if(answer.equals("3")) {
					System.out.println("[3.���ǻ�] "+ vo.getCompany());
					vo.setCompany(inputData("������ ����: "));
					break;
				} else if(answer.equals("4")) {
					System.out.println("[4.�С���] "+ vo.getGroup());
					vo.setGroup(inputData("������ ����: "));
					break;
				} else if(answer.equals("5")) {
					System.out.println("[5.������] "+ vo.getPrice());
					do {
						try {
							int price = Integer.parseInt(inputData("������ ����: "));
							if(price>=0 && price<=10000000) {
								vo.setPrice(price);
								break;
							} else {
								System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
							}
						} catch(NumberFormatException nfe) {
							System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
						}
					} while(true);
					break;
				} else if(answer.equals("6")) {
					System.out.println("[6.�硡��] "+ vo.getStock());
					do {
						try {
							int stock = Integer.parseInt(inputData("������ ����: "));
							if(stock>=0 && stock<=10000000) {
								vo.setStock(stock);
								break;
							} else {
								System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
							}
						} catch(NumberFormatException nfe) {
							System.out.println("0 ~ 1õ ������ ������ �Է����ּ���.");
						}
					} while(true);
					break;
				} else if(answer.equals("7")) {
					System.out.println("[7.ISBN] "+ vo.getIsbn());
					String newIsbn = checkIsbn("������ ISBN: ", isbn); // ISBN ��ȿ�� üũ
					BookDataSet.bookList.put(newIsbn, vo);
					BookDataSet.bookList.remove(vo.getIsbn());
					break;
				} else if(answer.equals("8")) {
					System.out.println("������ ��ҵǾ����ϴ�.");
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				} // if
			} while(true);

			System.out.println("�����Ǿ����ϴ�.");
		} // if
	} // ���� ���� ���� ----->
	
	
	// ��������
	public void deleteBook() {
		String isbn = inputData("������ ������ ISBN�� �Է��ϼ���. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("�ش� ������ ã�� �� �����ϴ�. ");
			do {
				String answer = inputData("[1.�ٽ� �Է��ϱ�] [2.������� ���ư���] : ");
				if(answer.equals("1")) {
					deleteBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("������")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} while(true);
		} else {		///////////////// ���� �˻� �Ŀ� �ۼ��ϱ�
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.printDetail();
			int answer = Integer.parseInt(inputData("�ش� ������ ���� �����Ͻðڽ��ϱ�? [1.����] [2.���] : "));
			if(answer == 1) {
				System.out.println("�����Ǿ����ϴ�.");
				BookDataSet.bookList.remove(isbn);
			}
			else if(answer == 2) {
				System.out.println("��ҵǾ����ϴ�.");
				//bookProcessAdmin();
			}
		}
	} // �������� ----->
	
	
	// ���� ��� �����ֱ� 
	public void showBookList() {
		BookVO.printTitle();
		Set<Map.Entry<String, BookVO>> list = BookDataSet.bookList.entrySet();
		Iterator<Map.Entry<String, BookVO>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String, BookVO> e = (Map.Entry<String, BookVO>)it.next();
			BookVO vo = e.getValue();
			vo.setIsbn(e.getKey());
			vo.printList();
		}
	} // ���� ��� �����ֱ� ----->
	
	
	// ���� ��� �����ֱ�
	public void showBookingListAdmin() {
		MemberVO.printBookingTitle();
		List<MemberVO> list = MemberDataSet.bookingList;
		for(int i=0; i<list.size(); i++) {
			MemberVO mvo = list.get(i);
			//MemberVO mvo2 = MemberDataSet.memberList.get(mvo.getId());
			mvo.printBookingList();
		}
		//MemberVO.printBookingList();
	} // ���� ��� �����ֱ� ----->
	
	
	// �����ϱ�
	public void bookingBook() {
		String isbn = inputData("������ ������ ISBN�� �Է��ϼ���. : ");
		boolean isbnCheck = BookDataSet.bookList.containsKey(isbn);
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		if (!isbnCheck) {
			System.out.print("�ش� ������ ã�� �� �����ϴ�. ");
			do {
				String answer = inputData("[1.�ٽ� �Է��ϱ�] [2.������� ���ư���] : ");
				if(answer.equals("1")) {
					bookingBook();
					break;
				} else if(answer.equals("2")) {
					if(mvo.getGrade().equals("������")) {
						showBookList();
						bookProcessAdmin();
						break;
					} else {
						showBookList();
						bookProcess();
						break;
					}
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} while(true);
			
		} else {
			BookVO vo = BookDataSet.bookList.get(isbn);
			vo.printDetail();
			if(vo.getStock() == 0) {
				System.out.println("�ش� ������ ǰ���Ǿ����ϴ�.");
			} else {
				int qnty = Integer.parseInt(inputData("������ ����: "));
				if(vo.getStock()-qnty<0) {
					System.out.println("���� ������ ������ �����մϴ�. ��� Ȯ�����ּ���.");
				} else {
					do {
						String answer = inputData("�ش� ������ �����Ͻðڽ��ϱ�? [1.����] [2.���] : ");
						if(answer.equals("1")) {
							// ���ฮ��Ʈ �ø���
							mvo = MemberDataSet.memberList.get(loginId);
							int listSize = MemberDataSet.bookingList.size();
							String bookingCode = "A"+(listSize+1);
							MemberDataSet.addBooking(new MemberVO(bookingCode, isbn, vo.getBookTitle(), qnty ,loginId , mvo.getName(), mvo.getTel()));
							// ��� ���� ����
							vo.setStock(vo.getStock()-qnty);
							
							System.out.println("����Ǿ����ϴ�.");
							break;
						}
						else if(answer.equals("2")) {
							System.out.println("��ҵǾ����ϴ�.");
							break;
						} else {
							System.out.println("�߸� �Է��ϼ̽��ϴ�.");
						}
					} while(true);
				}
			}
		}
	}
	
	// ���� Ȯ��
	public void bookingBookDetail() {
		System.out.println("\t\t\t���� ���� ���");
		MemberVO.printBookingCheckTitle();
		List<MemberVO> list = MemberDataSet.bookingList;
		boolean check = false;
		for(int i=0; i<list.size(); i++) {
			MemberVO mvo = list.get(i);
			if(mvo.getId().equals(loginId)) {
				mvo.printBookingCheck();
				check = true;
			}
		}
		System.out.println();
		if(!check) {
			System.out.println("���� ������ �����ϴ�.");
			do {
				String select = inputData("[1.������� ���ư���] : ");
				if(select.equals("1")) {
					break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} while(true);
		} else {
			do {
				String select = inputData("[1.������� ���ư���] [2.���� ���] : ");
				if(select.equals("1")) {
					break;
				} else if(select.equals("2")) {
					String bookingCode = inputData("�����ȣ�� �Է��ϼ���. :  ");
					boolean chk = false;
					for(int i=0; i<list.size(); i++) {
						MemberVO mvo = list.get(i);
						if(mvo.getBookingCode().equals(bookingCode) && mvo.getId().equals(loginId)) {
							int bookingNum = Integer.parseInt(bookingCode.substring(1));
							// ��� �ٽ� �߰��ϱ�
							BookVO vo = BookDataSet.bookList.get(mvo.getIsbn());
							vo.setStock(vo.getStock()+mvo.getQnty());
							// ���� ������ �����ϱ�
							MemberDataSet.bookingList.remove(bookingNum-1);
							// ���� ��� �޼���
							System.out.println("�ش� ������ ��ҵǾ����ϴ�.");
							chk = true;
							break;
						}
					}
					if(!chk) System.out.println("�߸��� ���� ��ȣ�Դϴ�.");
					else break;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			}while(true);
		}
	}
	
	
	
	// ȸ�� ��� �����ֱ�
	public void showMemberListAdmin() {
		MemberVO.printMemberTitle();
		Set<Map.Entry<String, MemberVO>> list = MemberDataSet.memberList.entrySet();
		Iterator<Map.Entry<String, MemberVO>> it = list.iterator();
		while(it.hasNext()) {
			Map.Entry<String, MemberVO> e = (Map.Entry<String, MemberVO>)it.next();
			MemberVO vo = e.getValue();
			vo.setId(e.getKey());
			vo.printMemberList();
		}
	} // ȸ�� ��� �����ֱ� ----->
	
	
	// ȸ�� ���� ���� + Ż��
	public void editMyInfo() {
		String pw, name, tel, email;
		MemberVO mvo = MemberDataSet.memberList.get(loginId);
		mvo.setId(loginId);
		Join join = new Join();
		do {
			mvo.printMyInfo();
			do {
				String select = inputData("[1.������� ���ư���] [2.ȸ������ ����] [3.ȸ�� Ż��] : ");
				if(select.equals("1")) {
					if(mvo.getGrade().equals("������")) {
						showBookList();
						bookProcessAdmin();
					} else {
						showBookList();
						bookProcess();
					}
					break;
				} else if(select.equals("2")) {
					String answer = inputData("������ �׸��� �����ϼ���. [1.��й�ȣ] [2.�̸�] [3.�޴�����ȣ] : ");
					if(answer.equals("1")) {
						pw = join.inputMemberPw();
						mvo.setPw(pw);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						break;
					} else if(answer.equals("2")) {
						name = join.inputMemberName();
						mvo.setName(name);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						break;
					} else if(answer.equals("3")) {
						tel = join.inputMemberTel();
						mvo.setTel(tel);
						System.out.println("������ �Ϸ�Ǿ����ϴ�.");
						break;
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					}
				} else if(select.equals("3")) {
					String answer = inputData("���� Ż���Ͻðڽ��ϱ�? [1.ȸ��Ż��] [2.���] : ");
					if(answer.equals("1")) {
						MemberDataSet.memberList.remove(loginId);
						System.out.println("Ż�� �Ϸ�Ǿ����ϴ�.");
						bookStart();
						break;
					} else if(answer.equals("2")) {
						System.out.println("��ҵǾ����ϴ�.");
						break;
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					}
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}
			} while(true);
		} while(true);
	} // ���� ���� ���� ----->
	
	
	// ����
	public void exitBookSystem() {
		System.out.println("����Ǿ����ϴ�.");
		System.exit(0);
	}
	
	
	// ������ �Է� �ޱ�
	public String inputData(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print(msg);
		return scan.nextLine().trim();
	} // ������ �Է� �ޱ� ----->
	
	
	// ISBN ��ȿ�� �˻� // ��� �ÿ� nowIsbn = ""; ����
	public String checkIsbn(String msg, String nowIsbn) {
		String newIsbn;
		do {
			try {
				newIsbn = inputData(msg);
				boolean newIsbnCheck = BookDataSet.bookList.containsKey(newIsbn);
				if(newIsbnCheck) {
					if(newIsbn.equals(nowIsbn)) System.out.println("�ش� ������ ���� ISBN�� �����ϴ�. �ٽ� �Է��ϼ���.");
					else System.out.println("�̹� ��ϵ� ������ ISBN�Դϴ�. �ٽ� �Է��ϼ���.");
				} else {
					long isbnLong = Long.parseLong(newIsbn);
					if(isbnLong >0 && (newIsbn.length()==10 || newIsbn.length()==13)) break;
					else throw new NumberFormatException();
				}
			} catch(NumberFormatException nfe) {
				System.out.println("10�ڸ� �Ǵ� 13�ڸ��� ���ڸ� �Է��ϼ���.");
			}
		} while(true);
		
		return newIsbn;
	} // ��ȿ�� �˻� ISBN ----->
	
}
