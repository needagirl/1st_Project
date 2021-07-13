import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataInputTest {

	public DataInputTest() {
		try {
			File file = new File("C://testFile","data.txt");
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			
			int a = dis.readInt();
			double dou = dis.readDouble();
			boolean boo = dis.readBoolean();
			char ch = dis.readChar();
			
			System.out.println(a);
			System.out.println(dou);
			System.out.println(boo);
			System.out.println(ch);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DataInputTest();
	}

}
