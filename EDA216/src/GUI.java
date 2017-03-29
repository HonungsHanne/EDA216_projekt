import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GUI {
	protected Shell shell;
	private Text text;
	private Text txtStartTime;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Label lblPalletId = new Label(shell, SWT.NONE);
		lblPalletId.setBounds(10, 10, 43, 15);
		lblPalletId.setText("Pallet ID");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(117, 10, 254, 18);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 40, 102, 15);
		lblNewLabel.setText("Blocked (timespan)");
		
		txtStartTime = new Text(shell, SWT.BORDER);
		txtStartTime.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		txtStartTime.setBounds(117, 40, 102, 18);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(240, 40, 23, 15);
		label.setText("-");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		text_1.setBounds(269, 40, 102, 18);
		
		Button btnSearch = new Button(shell, SWT.NONE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		btnSearch.setBounds(378, 10, 46, 18);
		btnSearch.setText("Search");
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		button.setText("Search");
		button.setBounds(378, 40, 46, 18);
		
		Label lblProductName = new Label(shell, SWT.NONE);
		lblProductName.setText("Product name");
		lblProductName.setBounds(10, 70, 101, 15);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(117, 70, 254, 18);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		button_1.setText("Search");
		button_1.setBounds(378, 70, 46, 18);
		
		Label lblDeliveredToCustomer = new Label(shell, SWT.NONE);
		lblDeliveredToCustomer.setText("Delivered");
		lblDeliveredToCustomer.setBounds(10, 101, 102, 15);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(117, 101, 254, 18);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		button_2.setText("Search");
		button_2.setBounds(378, 101, 46, 18);
		
		Label lblBlocked = new Label(shell, SWT.NONE);
		lblBlocked.setText("Blocked");
		lblBlocked.setBounds(10, 133, 43, 15);
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(117, 133, 254, 18);
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
			}
		});
		button_3.setText("Search");
		button_3.setBounds(378, 133, 46, 18);
		
		ListViewer listViewer = new ListViewer(shell, SWT.BORDER | SWT.V_SCROLL);
		List list = listViewer.getList();
		list.setItems(new String[] {"Hej", "Tv\u00E5", "Tre", "Bajs", "Hampus", "Anus", "\u00C4r", "Inte", "Trevligt", "Ibland", "Tror", "Jag", "Hanne", "Vet"});
		list.setBounds(10, 161, 414, 90);

	}
}