import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectCompareTest {

	public ObjectCompareTest() {

		List<MemberVO> mem = new ArrayList<MemberVO>();

		mem.add(new MemberVO("홍길동", "기획부", "2020-10-22", 2000));
		mem.add(new MemberVO("장길산", "총무부", "2018-05-11", 5000));
		mem.add(new MemberVO("이산", "인사부", "2015-12-25", 10000));
		mem.add(new MemberVO("계백", "개발부", "2021-6-21", 1000));
		mem.add(new MemberVO("관창", "개발부", "2021-6-21", 1000));
		mem.add(new MemberVO("이태백", "영업부", "2010-10-10", 20000));

		System.out.println("===========정렬 전====================");
		// 제너릭 객체:컬렉션 객체
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============급여를 오름차순으로 정렬======");
		// 객체가 전체있는 컬렉션, 정렬할 기준이 되는 기능이 있는 Comparator객체
		Comparator comAsc = new CompareAscSal();
		Collections.sort(mem, comAsc);
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============급여를 내림차순으로 정렬======");
		Comparator comDesc = new CompareDescSal();
		Collections.sort(mem, comDesc);
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============이름을 기준으로 오름차순======");
		Collections.sort(mem, new CompareAscName());
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============이름을 기준으로 내림차순======");
		Collections.sort(mem, new CompareDescName());
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============입사일 기준으로 오름차순=======");
		Collections.sort(mem, new CompareAscHire());
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
		System.out.println("============입사일 기준으로 내림차순=======");
		Collections.sort(mem, new CompareDescHire());
		for (MemberVO vo : mem) {
			System.out.println(vo.toString());
		}
	}

	// 숫자를 이용한 오름차순 정렬하는 클래스
	class CompareAscSal implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// 조건식
			// 왼쪽 객체의 값이 작으면 -1, 값이 크면 +1 값을 같으면 0을 리턴
			// +1,-1, 0
			return (v1.getSal() < v2.getSal()) ? -1 : (v1.getSal() > v2.getSal()) ? 1 : 0;
		}
	}

	// 숫자를 이용한 내림차순 정렬하는 클래스
	class CompareDescSal implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// +1,-1, 0
			return (v1.getSal() < v2.getSal() ? 1 : (v1.getSal() > v2.getSal()) ? -1 : 0);
		}
	}

	// 이름을 오름차순으로 정렬하는 클래스
	class CompareAscName implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			// 왼쪽이 작으면 음수, 왼쪽이 크면 양수 , 같으면 0
//			System.out.println(v1.getName()+", "+v2.getName()+"--->"+v1.getName().compareToIgnoreCase(v2.getName()) );
			return v1.getName().compareToIgnoreCase(v2.getName());
		}
	}

	// 이름을 내림차순으로 정렬하는 클래스
	class CompareDescName implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getName().compareToIgnoreCase(v1.getName());
		}
	}

	// 입사일을 오름차순으로 정렬하는 클래스
	class CompareAscHire implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v1.getHire().compareToIgnoreCase(v2.getHire());
		}
	}

	// 입사일을 내림차순으로 정렬하는 클래스
	class CompareDescHire implements Comparator<MemberVO> {
		public int compare(MemberVO v1, MemberVO v2) {
			return v2.getHire().compareToIgnoreCase(v1.getHire());
		}
	}

	public static void main(String[] args) {
		new ObjectCompareTest();
	}

}
