
public class ForExtensionArray {

	public static void main(String[] args) {
		int arr[] = { 23, 32, 53, 34, 64, 12, 43 };

		// 확장된 for문
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();

		// 2차원 배열
		int arr2[][] = { { 60, 90, 40, 23 }, { 23, 65, 32, 25 }, { 66, 94, 67, 20 } };

		for (int[] data : arr2) {
			// 배열의 데이터형 변수 : 1차원 배열면
			for (int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
		}
	}

}
