import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Production {
	private Database db;
	protected Shell shlProducePallets;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Production window = new Production();
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
		if (db.openConnection("database.db")) {
			System.out.println("Connected to db");
		}
		
		Display display = Display.getDefault();
		createContents();
		shlProducePallets.open();
		shlProducePallets.layout();
		while (!shlProducePallets.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlProducePallets = new Shell();
		shlProducePallets.setSize(450, 300);
		shlProducePallets.setText("Produce pallets");
		
		Label lblNewLabel = new Label(shlProducePallets, SWT.NONE);
		lblNewLabel.setBounds(10, 13, 78, 15);
		lblNewLabel.setText("Product name");
		
		text = new Text(shlProducePallets, SWT.BORDER);
		text.setBounds(94, 10, 76, 21);
		
		Label lblNewLabel_1 = new Label(shlProducePallets, SWT.NONE);
		lblNewLabel_1.setBounds(176, 13, 55, 21);
		lblNewLabel_1.setText("Amount");
		
		Button btnNewButton = new Button(shlProducePallets, SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
			}
		});
		btnNewButton.setBounds(330, 8, 94, 25);
		btnNewButton.setText("Produce");
		
		Spinner spinner = new Spinner(shlProducePallets, SWT.BORDER);
		spinner.setBounds(237, 10, 47, 21);
		
		List list = new List(shlProducePallets, SWT.BORDER);
		list.setBounds(10, 86, 414, 165);
		
		Label label = new Label(shlProducePallets, SWT.NONE);
		label.setText("(Pallet number, Pallet Order Id, Timestamp, Blocked, Product name)");
		label.setBounds(10, 65, 414, 15);
		
		Label lblProducedPallets = new Label(shlProducePallets, SWT.NONE);
		lblProducedPallets.setBounds(10, 44, 140, 15);
		lblProducedPallets.setText("Produced pallets:");

	}
}
