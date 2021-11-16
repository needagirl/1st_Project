public class MainMethod {

	public MainMethod() {
	}

	public static void main(String[] args) {
		Management mg = new Management();
		do {
			mg.start();
			mg.startLibrary();
		}while(true);
	}

}