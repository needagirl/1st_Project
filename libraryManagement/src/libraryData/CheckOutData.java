package libraryData;

import java.util.TreeMap;

public class CheckOutData {
	public static TreeMap<String, CheckOutVO> checkout = new TreeMap<String, CheckOutVO>();
	public CheckOutData() {
	}
	public static void BasicCheckout() {
		checkout.put("고양이는 다 된다", new CheckOutVO("1","고양이는 다 된다","2021-06-20","2021-07-04","미확인"));
	}
}
