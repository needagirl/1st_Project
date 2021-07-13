import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ObjectInputStreamTest {

	public ObjectInputStreamTest() {
		try {
			File file = new File("C://testFile/object.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Memo memo = (Memo)ois.readObject();
			
			memo.setVisible(true);
			
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ObjectInputStreamTest();
	}

}
