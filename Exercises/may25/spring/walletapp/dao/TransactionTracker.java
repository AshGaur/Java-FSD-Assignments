package may25.spring.walletapp.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import may25.spring.walletapp.bean.Customer;

@Component
public class TransactionTracker {
	@Autowired
	Customer customer;
	
	@Autowired
	@Qualifier("otherBean")
	Customer customerSecond;
	
	PrintWriter pw;
	Scanner sc;
	
	@PostConstruct
	public void createCustomer()
	{
		try {
			this.pw = new PrintWriter("TransactionHistory.txt");
			this.sc = new Scanner(new File("TransactionHistory.txt"));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void writeTransaction(Double updatedWallet,Double amount,boolean isWithdrawal) {
		this.pw.println("_________________________________________________");
		String mode = isWithdrawal?"Amount Withdrawn":"Amount Deposited";
		this.pw.println(String.format("%-20s: ","Time")+new Date());
		this.pw.println(String.format("%-20s: %d", "Account Number",this.customer.getAccountNumber()));
		this.pw.println(String.format("%-20s: %.2f", mode,amount));
		this.pw.println(String.format("%-20s: %.2f","Current Balance",updatedWallet));
		this.pw.println("_________________________________________________");
		this.pw.flush();
	}
	
	public void fundsTransfer(double amount) {
		this.pw.println("_________________________________________________");
		this.pw.println(String.format("%-20s: ","Time")+new Date());
		this.pw.println(String.format("%-20s: %d", "Sender Account",this.customer.getAccountNumber()));
		this.pw.println(String.format("%-20s: %d", "Receiver Account",this.customerSecond.getAccountNumber()));
		this.pw.println(String.format("%-20s: %.2f","Amount Transferred",amount));
		this.pw.println("_________________________________________________");
		this.pw.flush();
	}
	
	public String readTransactions() {
		StringBuffer text = new StringBuffer("");
		while(this.sc.hasNextLine()) {
			text.append(this.sc.nextLine()+"\n");
		}
		return text.length()>0?new String(text):"No Transactions made yet !";
	}
}
