package Test;
import java.awt.EventQueue;
import java.util.ArrayList;

import static org.junit.Assert.*;
import org.junit.Test;

import screens.JavaBank;
import classes.Account;
import classes.CreditAccount;

public class Tests {
	
	public static void main(String[] args) {
		
		// Scenery
		final ArrayList<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Bradesco", 1256, 1200));
		accounts.add(new Account("NuBank", 2233, 600));
		accounts.add(new Account("Banco Inter", 1830, 10000));
		accounts.add(new Account("Itaú", 4567, 990));
		accounts.add(new Account("C6", 4331, 800));
				
		// Action
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaBank app = new JavaBank(accounts);
					app.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		// Manual Tests
		System.out.println(accounts.get(1).deposit(100)); // true
		System.out.println(accounts.get(1).deposit(-1)); // false
		System.out.println(accounts.get(1).withdraw(701)); // false
	}
	
	@Test
	public void Test() {
		// Uniter Tests | Account
		Account acc = new Account("C6", 4331, 20);
		assertTrue(acc.deposit(300)); // true
		assertTrue(acc.withdraw(200)); // true
		
		// Uniter Tests | CreditAccount
		CreditAccount acc2 = new CreditAccount("NuBank", 2233, 20, 1);
		assertTrue(acc2.deposit(300)); // true
		assertTrue(acc2.setCreditLimit(10)); // true
	}
}
