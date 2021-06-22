import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

	public TreeMapTest() {
		
		//TreeMap은 key, value를 가진다.\
		//key를 기준으로 정렬한다.
		TreeMap<String, MemberVO> tm = new TreeMap<String, MemberVO>();
		tm.put("홍길동", new MemberVO("홍길동", "기획부", "2020-10-22", 2000));
		tm.put("장길산", new MemberVO("장길산", "총무부", "2018-05-11", 5000));
		tm.put("이산", new MemberVO("이산", "인사부", "2015-12-25", 10000));
		tm.put("계백", new MemberVO("계백", "개발부", "2021-6-21", 1000));
		tm.put("관창", new MemberVO("관창", "개발부", "2021-6-21", 1000));
		tm.put("이태백", new MemberVO("이태백", "영업부", "2010-10-10", 20000));
		
		System.out.println("============key를 이용하여 객체 얻어오기========");
		Set<String> key = tm.keySet();
		Iterator<String> ii = key.iterator();
		while(ii.hasNext()) {
			MemberVO vo = tm.get(ii.next());
			System.out.println(vo.toString());
		}
		System.out.println("==========value를 이용하여 객체 얻어오기==========");
		Collection<MemberVO> values = tm.values();
		Iterator<MemberVO> iii = values.iterator();
		while(iii.hasNext()) {
			MemberVO vo = iii.next();
			System.out.println(vo.toString());
		}
			
		
		
	}

	public static void main(String[] args) {
		new TreeMapTest();
	}

}
