
public class MainMethod {

	public MainMethod() {
	}

	public static void main(String[] args) {
		Management mg = new Management();
		do {
			mg.start();
			do {
				mg.startLibrary();
			}while(true);
		}while(true);
	}

}
