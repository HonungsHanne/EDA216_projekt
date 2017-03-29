

import java.util.ArrayList;

public class CookieMain {
	private void printPallets(ArrayList<Pallet> pallets) {
		System.out.println("Pallets:");
		
        for(Pallet pallet : pallets) {
        	pallet.print();
        }
        
        System.out.println();
	}
	
	private void main2(String[] args) {
		Database db = new Database();
        new CookieGUI(db);
        
        //db.createPallet("Nut ring");
        
        printPallets(db.getPallets());
        printPallets(db.getPalletsByTimespan("2017-03-29 16:10:12", "2017-03-29 17:29:00"));
        
        db.blockPallets("2017-03-29 17:25:31", "2017-03-29 17:28:06", "Nut ring");
        
        printPallets(db.getPallets());
	}
	
    public static void main(String[] args) {
        (new CookieMain()).main2(args);
    }
}