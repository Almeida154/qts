package classes;

public class CreditAccount extends Account{

	int creditLimit;
	
	CreditAccount() {
    	super();
    	this.creditLimit = 100;
    }
	
	public CreditAccount(String name, int num, int amt, int credit) {
		super(name, num, amt);
		this.creditLimit = credit;    
    }

	public boolean setCreditLimit(int num) {
		if(num > 0) {
			creditLimit = num;
			return true;
		}
		return false;
	}
	
	public int getCreditLimit() {
		return creditLimit;
	}
	
	public void print() {
		System.out.println(accountName + " " + accountNum + " " + balance + " " + creditLimit);
	}
}