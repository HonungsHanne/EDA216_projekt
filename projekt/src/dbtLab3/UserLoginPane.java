package dbtLab3;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * The GUI pane where a new user logs in. Contains a text field where the user
 * id is entered and a button to log in.
 */
public class UserLoginPane extends BasicPane {

    private static final long serialVersionUID = 1;

    /**
     * The text field where the user id is entered.
     */
    private JTextField[] fields;

    /**
     * The number of the field where the user id is entered.
     */
    private static final int USER_ID = 0;

    /**
     * The total number of fields in the fields array.
     */
    private static final int NBR_FIELDS = 1;

    /**
     * Create the login pane.
     * 
     * @param db
     *            The database object.
     */
    public UserLoginPane(Database db) {
        super(db);
    }

    /**
     * Create the top panel, consisting of the text field.
     * 
     * @return The top panel.
     */
    public JComponent createTopPanelOrder() {
        String[] texts = new String[NBR_FIELDS];
        texts[USER_ID] = "Order id (INT)                                     ";
        fields = new JTextField[NBR_FIELDS];
        fields[USER_ID] = new JTextField(20);
        return new InputPanel(texts, fields);
    }

    public JComponent createTopPanelPallet() {
        String[] texts = new String[NBR_FIELDS];
        texts[USER_ID] = "Pallet id (INT)                                      ";
        fields = new JTextField[NBR_FIELDS];
        fields[USER_ID] = new JTextField(20);
        return new InputPanel(texts, fields);
    }
    
    public JComponent createTopPanelTime(){
    	 String[] texts = new String[NBR_FIELDS];
         texts[USER_ID] = "Time from to (YYMMDD-YYMMDD)";
         fields = new JTextField[NBR_FIELDS];
         fields[USER_ID] = new JTextField(20);
         return new InputPanel(texts, fields);
    }
    public JComponent createTopPanelBlocked(){
    	 String[] texts = new String[NBR_FIELDS];
         texts[USER_ID] = "Blocked (TRUE/FALSE)                    ";
         fields = new JTextField[NBR_FIELDS];
         fields[USER_ID] = new JTextField(20);
         return new InputPanel(texts, fields);
    }
    public JComponent createTopPanelCustomer(){
    	 String[] texts = new String[NBR_FIELDS];
         texts[USER_ID] = "Customer (STRING)                          ";
         fields = new JTextField[NBR_FIELDS];
         fields[USER_ID] = new JTextField(20);
         return new InputPanel(texts, fields);
    }
  
    
    /**
     * Create the bottom panel, consisting of the login button and the message
     * line.
     * 
     * @return The bottom panel.
     */
    public JComponent createBottomPanel() {
        JButton[] buttons = new JButton[1];
        buttons[0] = new JButton("Search");
        buttons[0].setPreferredSize(new Dimension(440, 50));
        ActionHandler actHand = new ActionHandler();
        fields[USER_ID].addActionListener(actHand);
        return new ButtonAndMessagePanel(buttons, messageLabel, actHand);
        
    }

    /**
     * Perform the entry actions of this pane, i.e. clear the message line.
     */
    public void entryActions() {
        clearMessage();
    }

    /**
     * A class which listens for button clicks.
     */
    class ActionHandler implements ActionListener {
        /**
         * Called when the user clicks the login button. Checks with the
         * database if the user exists, and if so notifies the CurrentUser
         * object.
         * 
         * @param e
         *            The event object (not used).
         */
        public void actionPerformed(ActionEvent e) {
            String userId = fields[USER_ID].getText();

            boolean b = db.login(userId);
         
            
            if(b) {
            	//DISPLAY RESULT
            	displayMessage("Logged in!");
            	CurrentUser.instance().loginAs(userId);
            	//CurrentUser.instance
            }
            
            else {
            	displayMessage("Failed to logon.");
            }
            
            
            /* --- insert own code here --- */
            

            
            
        }
    }
}
