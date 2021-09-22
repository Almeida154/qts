package classes;

public class Account {

	String accountName;
    int accountNum;
    double balance;
    
    public Account() {
    	this.accountName = "EMPTY";
    	this.accountNum = 0;
    	this.balance = 0;
    }
    
    public Account(String name, int num, double amt) {
        accountName = name;
	    accountNum = num;
        balance = amt;
    }
    

    public boolean deposit(double amt) {
		if(amt > 0) {
			this.balance += amt;
			return true;
		}
		return false;
    }
    
    public boolean withdraw(double amt) {
		if(this.balance >= amt && amt > 0) {
			this.balance -= amt;	
			return true;
		}
		return false;
    }
    
    public boolean setAccountName(String name) {
	    if (!accountName.equals("")) {
	    	this.accountName = name;
	    	return true;
	    }
	    return false;
    }
    
    public boolean setAccountNum(int num) {
		if(num > 0) {
			this.accountNum = num;
			return true;
		}
		return false;
    }
    
    public boolean setBalance(double num) {
		if(num > 0) {
			this.balance = num;
			return true;
		}
		return false;
    }
    
    public String getAccountName() {
    	return accountName;
    }
    
    public int getAccountNum() {
    	return accountNum;
    }
    
    public double getBalance() {
    	return balance;
    }
    
    public void print() {
    	System.out.println(accountName + " " + accountNum + " " + balance);
    }
}