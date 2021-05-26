package may25.spring.walletapp.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import may25.spring.walletapp.dao.DaoClass;
import may25.spring.walletapp.dao.TransactionTracker;

@Service
@Component("walletService")
public class WalletService implements WalletServe{
	@Autowired
	@Qualifier("dao")
	DaoClass dao;
	
	@Autowired
	TransactionTracker tracker;
	
	@Override
	public String addCustomer(String customerName,Double initAmount) throws SQLException {
		this.dao.getCustomer().setCustomerName(customerName);
		this.dao.getCustomer().setWalletBalance(initAmount);
		return this.dao.addCustomer()?"Customer Added successfully !":"Unable to add customer";
	}
	
	@Override
	public Double getBalance(int accountNo) throws SQLException, InvalidInputException{
		this.dao.getCustomer().setAccountNumber(accountNo);
		Double balance = this.dao.accountExists(); 
		if(balance==null) {
			throw new InvalidInputException("Account Number doesn't exists in database !");
		}
		return balance;
	}
	
	@Override
	public String makeTransaction(int accountNo, Double amount, boolean isWithdrawal) throws SQLException, InvalidInputException {
		this.dao.getCustomer().setAccountNumber(accountNo);
		return this.dao.makeTransaction(amount,isWithdrawal)?"Transaction Successful !":"Transaction Unsuccessful !";
	}

	@Override
	public String fundsTransfer(int senderAccount,int receiverAccount,double amount) throws SQLException {
		this.dao.getCustomer().setAccountNumber(senderAccount);
		this.dao.getCustomerSecond().setAccountNumber(receiverAccount);
		return this.dao.fundsTransfer(amount)?"Transaction Complete !":"Transaction Unsuccessful !";
	}
	
	@Override
	public String getTransactionHistory(String orderBy,String order) throws SQLException, InvalidInputException {
//		return this.tracker.readTransactions();
		return this.dao.readTransactionHistory(orderBy,order);
	}
	
	//-------------------------- Validators -------------------------------

	@Override
	public String validateName(String customerName) throws InvalidInputException {
		if(!customerName.matches(NAMEPATTERN)) {
			throw new InvalidInputException("Please enter name in format matching case: Firstname<space>Lastname !");
		}
		return customerName;
	}
	
	@Override
	public int validateAccount(String accountNumber) throws InvalidInputException{
		if(!accountNumber.matches(INTPATTERN)) {
			throw new InvalidInputException("Invalid Number Entered !");
		}
		return Integer.parseInt(accountNumber);
	}
	
	@Override
	public double validateFunds(String customerFunds) throws InvalidInputException{
		if(!customerFunds.matches(DOUBLEPATTERN)) {
			throw new InvalidInputException("Invalid Funds !");
		}
		return Double.parseDouble(customerFunds);
	}
}
