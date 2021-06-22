import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {

	public PropertiesTest() {
		// Properties컬렉션 key와 value가 모두 String인 컬렉션
		
		Properties prop = new Properties();
		
		//setProperty() : 객체  추가
		prop.setProperty("네이버", "http://www.naver.com");
		prop.setProperty("다음", "http://www.daum.net");
		prop.setProperty("네이트", "http://www.nate.com");
		prop.setProperty("구글", "http://www.google.com");
		
		//getProperty() : 키를 이용하여 객체 얻어오기
		
		System.out.println(prop.getProperty("다음"));
		//키 목록 전체 구하기
		Enumeration key = prop.propertyNames();
		
		while(key.hasMoreElements()) {//객체가 남아있을경우 true, 없으면 false
			//Object obj = e.nextElement();
			String str =(String)key.nextElement();
			System.out.println("key="+str+", value="+ prop.getProperty(str));
		}
	}

	public static void main(String[] args) {
		new PropertiesTest();
	}

}
