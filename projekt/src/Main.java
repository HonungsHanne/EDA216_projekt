public class Main {
	public static void main(String[] args) {
		(new Main()).main2();
	}
	
	private void main2() {
		Database database = new Database();
		new GUI(database);
		
		
	}
}