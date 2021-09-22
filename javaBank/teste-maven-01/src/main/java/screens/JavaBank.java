package screens;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.util.*;
import classes.Account;

public class JavaBank extends JFrame {
	
	// Variables
	public String name = "";
	public int accountNum = 0;
	public double balance = 0;
	ArrayList<Account> accounts;

	// Containers
	private JPanel jpFormContainer;
	private JPanel jpAccountNameContainer = new JPanel();
	private JPanel jpAccountNumContainer = new JPanel();
	private JPanel jpBalanceContainer = new JPanel();
	private JPanel jpDepositContainer = new JPanel();
	private JPanel jpWithdrawContainer = new JPanel();
	
	// TextFields
	private JTextField tfName = new JTextField();
	private JTextField tfAccountNum = new JTextField();
	private JTextField tfBalance = new JTextField();
	private JTextField tfDeposit = new JTextField();
	private JTextField tfWithdraw = new JTextField();

	// Buttons
	private JButton btnCreateAccount = new JButton();
	private JButton btnDeleteAccount = new JButton();
	private JButton btnTransaction = new JButton();
	private JButton btnDisplayAccounts = new JButton();
	
	// Error Label
	private JLabel jlError = new JLabel();
	
	// Table
	private DefaultTableModel tableModel = new DefaultTableModel();
	
	private static JTextArea taAccountsContainer;
				
	// Application Interface
	public JavaBank(ArrayList<Account> accounts) {
		this.accounts = accounts;
		
		JPanel contentPane = new JPanel();
	    setTitle("JavaBank");
	    setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 400);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(242, 242, 242));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Form Container	
		jpFormContainer = new JPanel();
		jpFormContainer.setBounds(0, 0, 260, 400);
	    jpFormContainer.setLayout(null);
	    jpFormContainer.setBackground(new Color(250, 250, 250));
	    contentPane.add(jpFormContainer);
	    
	    // Account Name
		Integer[] accountNameJPanelBounds = {40, 20, 180, 40};
		jpFormContainer.add(myJPanel(jpAccountNameContainer, accountNameJPanelBounds, "Acount Name"));
		jpAccountNameContainer.add(myJTextField(tfName));

		// Account Number
		Integer[] accountNumJLabelBounds = {40, 65, 180, 40};
		jpFormContainer.add(myJPanel(jpAccountNumContainer, accountNumJLabelBounds, "Account Number"));
		jpAccountNumContainer.add(myJTextField(tfAccountNum));
	
		// Account Balance
		Integer[] balanceJLabelBounds = {40, 110, 180, 40};
		jpFormContainer.add(myJPanel(jpBalanceContainer, balanceJLabelBounds, "Balance"));
		jpBalanceContainer.add(myJTextField(tfBalance));

		// Deposit
		Integer[] depositJLabelBounds = {40, 155, 180, 40};
		jpFormContainer.add(myJPanel(jpDepositContainer, depositJLabelBounds, "Deposit"));
		jpDepositContainer.add(myJTextField(tfDeposit));

		// Withdraw
		Integer[] withdrawJLabelBounds = {40, 200, 180, 40};
		jpFormContainer.add(myJPanel(jpWithdrawContainer, withdrawJLabelBounds, "Withdraw"));
		jpWithdrawContainer.add(myJTextField(tfWithdraw));

		// Create Account | Button
		Integer[] createAccountBtnBounds = {42, 250, 85, 24};
		jpFormContainer.add(myJButton(btnCreateAccount, createAccountBtnBounds, "Create"));
		btnCreateAccount.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { handleCreateAccount(event); }
		});

		// Delete Account | Button
		Integer[] deleteAccountBtnBounds = {132, 250, 85, 24};
		jpFormContainer.add(myJButton(btnDeleteAccount, deleteAccountBtnBounds, "Delete"));
		btnDeleteAccount.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { handleDeleteAccount(event); }
		});

		// Transaction | Button
		Integer[] btnTransactionBounds = {42, 280, 175, 24};
		jpFormContainer.add(myJButton(btnTransaction, btnTransactionBounds, "Make Transaction"));
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) { handleTransaction(event); }
		});

		// Display Accounts | Button
		Integer[] btnDisplayaccountsBounds = {42, 310, 175, 24};
		jpFormContainer.add(myJButton(btnDisplayAccounts, btnDisplayaccountsBounds, "Display Accounts"));
		btnDisplayAccounts.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { handleDisplayAccounts(event); }
		});
		
	    // Error Label
	    jlError.setBounds(330, 300, 400, 60);
	    jlError.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
	    jlError.setForeground(Color.RED);
	    contentPane.add(jlError);
	    
	    // Accounts Container
	    taAccountsContainer = new JTextArea();
	    JScrollPane scrollPane = new JScrollPane(taAccountsContainer);
	    scrollPane.setBounds(330, 50, 400, 260);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		scrollPane.setBackground(Color.darkGray);
	    contentPane.add(scrollPane);
	    
	    // Table
	    tableModel.addColumn("Acc Name");
		tableModel.addColumn("Acc Number");
		tableModel.addColumn("Balance");
		
		JTable table = new JTable(tableModel);
		
		UIManager.getDefaults().put("TableHeader.cellBorder", BorderFactory.createEmptyBorder(0, 0, 0, 0));
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setFillsViewportHeight(true);
		table.setGridColor(new Color(230, 230, 230));
		table.setBackground(new Color(250, 250, 250));
		table.setForeground(Color.GRAY);
		table.setRowHeight(25);
		table.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		table.getTableHeader().setBackground(Color.WHITE);
		table.getTableHeader().setForeground(Color.GRAY);
		table.getTableHeader().setFont(new Font("Yu Gothic UI Semibold", Font.BOLD | Font.ITALIC, 14));
		
		for (int i = 0; i < 3; i++) table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
				
		JTableHeader header = table.getTableHeader();
		header.setPreferredSize(new Dimension(0, 40));
		scrollPane.setViewportView(table);
		
		this.clean();
		this.listAccounts();
	}

	private void handleCreateAccount(ActionEvent event) {
		this.jlError.setText("");
	    
	    this.accountNum = (tfAccountNum.getText() == "0") ? 0 : Integer.parseInt(tfAccountNum.getText());
	    this.balance = (tfBalance.getText() == "0") ? 0 : Integer.parseInt(tfBalance.getText());
	    this.name = (tfName.getText() != "") ? tfName.getText() : null;

	    if (name != null && accountNum != 0) {
	    	boolean exists = false;
	    	for(int i = 0; i < this.accounts.size(); i++) if (this.accounts.get(i).getAccountNum() == accountNum) { exists = true; break; }
	    	if (!exists) {
	    		this.accounts.add(new Account(name, accountNum, balance));
		      this.listAccounts();
		      this.clean();
	    	} else this.jlError.setText("Account Number unavailable");
	    } else this.jlError.setText("Fill at least: Name Account & Number Account");
	}

	private void handleDeleteAccount(ActionEvent event) {
    	if (this.accounts.size() == 0) this.jlError.setText("No Accounts currently created");
    	else {
    		int AccountNum = (!tfAccountNum.getText().isEmpty()) ? Integer.parseInt(tfAccountNum.getText()) : 0;
    		boolean exists = false;
    		for (int i = 0; i < this.accounts.size(); i++) { 
    			if(this.accounts.get(i).getAccountNum() == AccountNum) { exists = true; break; }
			};
            if (AccountNum != 0) {
            	if (exists) {
                	for (int i = 0; i < this.accounts.size(); i++)
                		if (this.accounts.get(i).getAccountNum() == AccountNum) this.accounts.remove(i);
                	this.listAccounts();
                	this.clean();
            	} else this.jlError.setText("Account doesn't exist");
            } else this.jlError.setText("Insert the Account Number");
    	}
	}

	private void handleTransaction(ActionEvent event) {	
	    if (this.accounts.size() == 0) this.jlError.setText("No Accounts currently created"); 
	    else {
	    	int AccountNum = (!tfAccountNum.getText().isEmpty()) ? Integer.parseInt(tfAccountNum.getText()) : 0;
	    	int Deposit = Integer.parseInt(tfDeposit.getText());
	    	int Withdraw = Integer.parseInt(tfWithdraw.getText());
	
	    	for (int i = 0; i < this.accounts.size(); i++) {
		        if (this.accounts.get(i).getAccountNum() == AccountNum && (Deposit >= 0 || Withdraw >= 0)) {
		        	this.accounts.get(i).setBalance(this.accounts.get(i).getBalance() + Deposit - Withdraw);
		        	this.listAccounts();
		        } else this.jlError.setText("Fill at least one of: Deposit & Withdraw"); 
	    	}
	    }
	    this.clean();
	}

	private void handleDisplayAccounts(ActionEvent event) {
	    this.listAccounts();
	    this.clean();
	}
		
	private void listAccounts() {
		this.jlError.setText("");
	    if (this.accounts.isEmpty()) this.jlError.setText("No Accounts currently created");
	    else {
	    	tableModel.setRowCount(0);
			for (int i = 0; i < this.accounts.size(); i++) {
				this.tableModel.addRow(new Object[] {
					this.accounts.get(i).getAccountName(),
					this.accounts.get(i).getAccountNum(),
					"R$ " + this.accounts.get(i).getBalance()
				});
			}
	    }
	}
	
	private void clean() {
		this.tfName.setText("");
		this.tfAccountNum.setText("0");
		this.tfBalance.setText("0");
		this.tfDeposit.setText("0");
		this.tfWithdraw.setText("0");
	}
	
	private void onButtons(final JButton btn) {
		btn.setBackground(new Color(230, 230, 230));
		btn.setForeground(Color.gray);
		btn.setFocusPainted(false);
		btn.setBorderPainted(false);
		btn.addMouseListener(new MouseAdapter() {
	        public void mouseEntered(MouseEvent e) {
	        	btn.setBackground(new Color(215, 215, 215));
	        }
	        public void mouseExited(MouseEvent e) {
	        	btn.setBackground(new Color(230, 230, 230));
	        }
		});
	}
	
	JPanel myJPanel(JPanel jPanel, Integer bounds[], String text) {
		jPanel.setBorder(new TitledBorder(
			new LineBorder(
				new Color(192, 192, 192), 2),
				" " + text + " ",
				TitledBorder.LEADING,
				TitledBorder.TOP,
				null,
				new Color(128, 128, 128))
			);
		jPanel.setBackground(new Color(250, 250, 250));
		jPanel.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		jPanel.setLayout(null);
		return jPanel;
	}
	
	JTextField myJTextField(JTextField tf) {
		tf.setBounds(10, 14, 160, 22);
		tf.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 12));
		tf.setColumns(10);
		tf.setBorder(new LineBorder(Color.RED, 0));
		tf.setForeground(Color.BLACK);
		return tf;
	}
	
	JButton myJButton(JButton btn, Integer bounds[], String text) {
		btn.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		btn.setText(text);
		btn.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		this.onButtons(btn);
		return btn;
	}
}