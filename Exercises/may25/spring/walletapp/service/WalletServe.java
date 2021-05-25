package may25.spring.walletapp.service;

import java.sql.SQLException;

public interface WalletServe {
	String NAMEPATTERN = "[A-Z][a-z]{2,14}(\\W[A-Z][a-z]{0,14})?";
	String INTPATTERN = "[1-9][0-9]{0,5}";
	String DOUBLEPATTERN = "[0-9]{1,10}(\\.[0-9]{1,3})?";
	String validateName(String customerName) throws InvalidInputException;
	int validateAccount(String accountNumber) throws InvalidInputException;
	double validateFunds(String customerFunds) throws InvalidInputException;
	String addCustomer(String customerName,Double initAmount) throws SQLException;
	Double getBalance(int accountNo) throws SQLException, InvalidInputException;
	String makeTransaction(int accountNo, Double amount, boolean isWithdrawal) throws SQLException, InvalidInputException;
	String getTransactionHistory();
}
