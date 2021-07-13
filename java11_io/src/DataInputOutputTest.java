import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputOutputTest {
	
	public DataInputOutputTest() {
		try {
			File file = new File("C://testFile", "data.txt");
			FileOutputStream fos = new FileOutputStream(file);
			DataOutputStream dos = new DataOutputStream(fos);
			
			int num = 1234;
			double data2 = 2334.23;
			boolean boo = true;
			char ch = 'A';
			
			dos.writeInt(num);
			dos.writeDouble(data2);
			dos.writeBoolean(boo);
			dos.writeChar(ch);
			
			dos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new DataInputOutputTest();
	}

}
