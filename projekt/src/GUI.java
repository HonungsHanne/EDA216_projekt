import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI {
	private Database database;
	
	public GUI(Database database) {
		this.database = database;
		
		JFrame frame = new JFrame("Cookies");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("Cookies");
        frame.getContentPane().add(label);
        
        frame.pack();
        
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setResizable(false);
	}
}