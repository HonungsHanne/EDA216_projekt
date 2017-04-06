import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Blocking {
	protected Shell shlBlockingPallets;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Button btnNewButton;
	
	private Database db;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Blocking window = new Blocking();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		db = new Database();
		if (db.openConnection("new-database.db")) {
			System.out.println("Connected to db");
		}
		
		Display display = Display.getDefault();
		createContents();
		shlBlockingPallets.open();
		shlBlockingPallets.layout();
		while (!shlBlockingPallets.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBlockingPallets = new Shell();
		shlBlockingPallets.setSize(450, 300);
		shlBlockingPallets.setText("Blocking pallets");
		
		text = new Text(shlBlockingPallets, SWT.BORDER);
		text.setBounds(117, 10, 254, 18);
		
		text_1 = new Text(shlBlockingPallets, SWT.BORDER);
		text_1.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		text_1.setBounds(117, 39, 117, 18);
		
		text_2 = new Text(shlBlockingPallets, SWT.BORDER);
		text_2.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		text_2.setBounds(250, 39, 121, 18);
		
		Label label = new Label(shlBlockingPallets, SWT.NONE);
		label.setText("-");
		label.setBounds(240, 39, 5, 15);
		
		Label label_1 = new Label(shlBlockingPallets, SWT.NONE);
		label_1.setText("Produced (time)");
		label_1.setBounds(10, 39, 102, 15);
		
		Label lblProductName = new Label(shlBlockingPallets, SWT.NONE);
		lblProductName.setText("Product name");
		lblProductName.setBounds(10, 13, 102, 15);
		
		Label lblNewLabel = new Label(shlBlockingPallets, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		lblNewLabel.setBounds(10, 201, 414, 60);
		
		btnNewButton = new Button(shlBlockingPallets, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String productName = text.getText();
				
				String startTime = text_1.getText();
				String stopTime = text_2.getText();
				
				int blockedPallets = db.blockPallets(startTime, stopTime, productName);
				
				if(blockedPallets > 0) {
					lblNewLabel.setText("Number of pallets blocked: " + blockedPallets);
				}
				
				else {
					lblNewLabel.setText("No pallets were blocked");
				}
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Segoe UI", 56, SWT.NORMAL));
		btnNewButton.setBounds(10, 63, 414, 132);
		btnNewButton.setText("Block pallets");
		
		

	}
}
