import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class HashMapTest {

	public HashMapTest() {
		// Map interface를 상속받은 클래스는 key, value 가 존재한다.
		// 1. HashMap은 key와 value로 데이터를 저장한다.
		// 2. TreeMap은 key와 value로 데이터를 저장하고, key를 기준으로 정렬된다.

		HashMap<Integer, String> hm = new HashMap<Integer, String>();

		hm.put(1, "홍길동");// 객체추가
		hm.put(100, "장길산");
		hm.put(50, "이산");
		hm.put(25, "계백");
		hm.put(33, "관창");

		String name = hm.get(100); // int--> Integer
		System.out.println("key100=" + name);

		// HashMap에서 Key목록을 구하여 Set에 담아준다.
		Set<Integer> keyList = hm.keySet();
		Iterator<Integer> ii = keyList.iterator();

		while (ii.hasNext()) {
			int k = ii.next();
			System.out.println("key=" + k + ", value=" + hm.get(k));
		}
		System.out.println("=========================================");

		HashMap<String, MemberVO> hm2 = new HashMap<String, MemberVO>();
		hm2.put("홍길동", new MemberVO("홍길동", "기획부", "2020-10-22", 2000));
		hm2.put("장길산", new MemberVO("장길산", "총무부", "2018-05-11", 5000));
		hm2.put("이산", new MemberVO("이산", "인사부", "2015-12-25", 10000));
		hm2.put("계백", new MemberVO("계백", "개발부", "2021-6-21", 1000));
		hm2.put("관창", new MemberVO("관창", "개발부", "2021-6-21", 1000));

		System.out.println("======key 이용 정보 얻어오기==========");
		// key목록
		Set<String> keyList2 = hm2.keySet();
		// Iterator
		Iterator<String> iii = keyList2.iterator();

		while (iii.hasNext()) {
			String kk = iii.next();
//			System.out.println("key="+kk);
			MemberVO value = hm2.get(kk);
			System.out.println("value=" + hm2.get(kk).toString());
//			System.out.print(value.getName());
		}

		System.out.println("=======value를 이용하여 정보 얻어오기==========");

		Collection<MemberVO> values = hm2.values();
		Iterator<MemberVO> memberValue = values.iterator();
		while (memberValue.hasNext()) {
			MemberVO dd = memberValue.next();
			System.out.println(dd.toString());
		}
//		System.out.println(values);

	}

	public static void main(String[] args) {
		new HashMapTest();
	}

}
