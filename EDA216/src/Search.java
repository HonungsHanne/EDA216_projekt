import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.List;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class Search {
	protected Shell shlSearchPallets;
	
	private Text text;
	private Text txtStartTime;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	
	private Database db;
	
	public static void main(String[] args) {
		
		try {
			Search window = new Search();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void open() {
		Display display = Display.getDefault();
		db = new Database();
		if (db.openConnection("new-database.db")) {
			System.out.println("Connected to db");
		}
		createContents();
		shlSearchPallets.open();
		shlSearchPallets.layout();
		while (!shlSearchPallets.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	protected void createContents() {
		shlSearchPallets = new Shell();
		shlSearchPallets.setSize(450, 369);
		shlSearchPallets.setText("Search pallets");
		shlSearchPallets.setLayout(null);
		
		ListViewer listViewer = new ListViewer(shlSearchPallets, SWT.BORDER | SWT.V_SCROLL);
		List list_1 = listViewer.getList();
		list_1.setItems(new String[] {});
		list_1.setBounds(10, 185, 414, 125);
		
		Label lblPalletId = new Label(shlSearchPallets, SWT.NONE);
		lblPalletId.setBounds(10, 10, 43, 15);
		lblPalletId.setText("Pallet ID");
		
		text = new Text(shlSearchPallets, SWT.BORDER);
		text.setBounds(117, 10, 254, 18);
		
		Label lblNewLabel = new Label(shlSearchPallets, SWT.NONE);
		lblNewLabel.setBounds(10, 40, 102, 15);
		lblNewLabel.setText("Produced (time)");
		
		txtStartTime = new Text(shlSearchPallets, SWT.BORDER);
		txtStartTime.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		txtStartTime.setBounds(117, 40, 117, 18);
		
		Label label = new Label(shlSearchPallets, SWT.NONE);
		label.setBounds(240, 40, 5, 15);
		label.setText("-");
		
		text_1 = new Text(shlSearchPallets, SWT.BORDER);
		text_1.setToolTipText("Date (YYYY-MM-DD hh:mm:ss)");
		text_1.setBounds(250, 40, 121, 18);
		
		Button btnSearch = new Button(shlSearchPallets, SWT.NONE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text.getText().isEmpty()) {
					return;
				}
				
				Pallet p = new Pallet();
				
				try {
					p = db.getPalletById(Integer.parseInt(text.getText()));
				} catch(NumberFormatException exception) {
					return;
				}
				
				List list = listViewer.getList();
				String[] inList;
				
				if(p == null) {
					inList = new String[] { "There is no pallet with that ID." };
				}
				
				else {
					inList = new String[] { p.toString() };
				}
				
				list.setItems(inList);
			}
		});
		btnSearch.setBounds(378, 10, 46, 18);
		btnSearch.setText("Search");
		
		Button button = new Button(shlSearchPallets, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(txtStartTime.getText().isEmpty() || text_1.getText().isEmpty()) {
					return;
				}
				
				ArrayList<Pallet> p_list = db.getPalletsByTimespan(txtStartTime.getText(), text_1.getText());
				
				if(p_list == null) {
					listViewer.getList().setItems(new String[] { "No pallets were produced during this timespan." });
					
					return;
				}
				
				String[] tuples = new String[p_list.size()];
				
				for(int i = 0; i < p_list.size(); i++){
					tuples[i] = p_list.get(i).toString();
				}
				
				listViewer.getList().setItems(tuples);
			}
		});
		button.setText("Search");
		button.setBounds(378, 40, 46, 18);
		
		Label lblProductName = new Label(shlSearchPallets, SWT.NONE);
		lblProductName.setText("Product name");
		lblProductName.setBounds(10, 70, 101, 15);
		
		text_2 = new Text(shlSearchPallets, SWT.BORDER);
		text_2.setBounds(117, 70, 254, 18);
		
		Button button_1 = new Button(shlSearchPallets, SWT.NONE);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_2.getText().isEmpty()) {
					return;
				}
				
				ArrayList<Pallet> p_list = db.getPalletsByRecipe(text_2.getText());
				
				if(p_list == null) {
					listViewer.getList().setItems(new String[] { "No pallets with the given name exists." });
					
					return;
				}
				
				String[] tuples = new String[p_list.size()];
				for(int i = 0; i < p_list.size(); i++){
					tuples[i] = p_list.get(i).toString();
				}
				listViewer.getList().setItems(tuples);
			}
		});
		button_1.setText("Search");
		button_1.setBounds(378, 70, 46, 18);
		
		Label lblDeliveredToCustomer = new Label(shlSearchPallets, SWT.NONE);
		lblDeliveredToCustomer.setText("Delivered");
		lblDeliveredToCustomer.setBounds(10, 101, 102, 15);
		
		Button button_2 = new Button(shlSearchPallets, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				if(text_3.getText().isEmpty()) {
					return;
				}
				
				ArrayList<Pallet> p_list = db.getDeliveredToCustomer(text_3.getText());
				
				if(p_list == null) {
					listViewer.getList().setItems(new String[] { text_3.getText() + " have no delivered pallets." });
					
					return;
				}
				
				String[] tuples = new String[p_list.size()];
				for(int i = 0; i < p_list.size(); i++){
					tuples[i] = p_list.get(i).toString();
				}
				listViewer.getList().setItems(tuples);
			}
			}
		);
		button_2.setText("Search");
		button_2.setBounds(378, 101, 46, 18);
		
		Label lblBlocked = new Label(shlSearchPallets, SWT.NONE);
		lblBlocked.setText("Blocked");
		lblBlocked.setBounds(10, 133, 43, 15);
		
		Label lblpalletNumberPallet = new Label(shlSearchPallets, SWT.NONE);
		lblpalletNumberPallet.setBounds(10, 164, 414, 15);
		lblpalletNumberPallet.setText("(Pallet number, Pallet Order Id, Timestamp, Blocked, Product name)");
		
		Button button_3 = new Button(shlSearchPallets, SWT.NONE);
		
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				ArrayList<Pallet> p_list = db.getBlockedPallets();
				
				if(p_list == null) {
					listViewer.getList().setItems(new String[] { "There are no blocked pallets." });
					
					return;
				}
				
				String[] tuples = new String[p_list.size()];
				for(int i = 0; i < p_list.size(); i++){
					tuples[i] = p_list.get(i).toString();
				}
				listViewer.getList().setItems(tuples);
			
			}
		});
		button_3.setText("Search");
		button_3.setBounds(378, 133, 46, 18);
		
		text_3 = new Text(shlSearchPallets, SWT.BORDER);
		text_3.setToolTipText("Customer name");
		text_3.setBounds(117, 101, 254, 18);
	}
}