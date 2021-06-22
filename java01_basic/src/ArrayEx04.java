
public class ArrayEx04 {

	public static void main(String[] args) {
		int[][] data = new int[10][10];
		for (int i = 0; i < data.length-1; i++) {
			data[0][i]= i+1;
		}
		for (int i = 1; i < data.length-1; i++) {
			for (int k = 0; k < data.length-1; k++) {
				data[i][k] = data[0][k]*(i+1);
			}
		}
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length-1; j++) {
				data[i][9] += data[i][j];
				data[9][i]+=data[i][j];
			}
		}
		for (int[] is : data) {
			for (int is2 : is) {
				System.out.print(is2+"\t");
			}
			System.out.println();
		}
		
	}

}
