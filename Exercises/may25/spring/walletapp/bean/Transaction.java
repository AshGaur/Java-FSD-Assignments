package may25.spring.walletapp.bean;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	String receiverAccount;
	Integer accountNumber;
	String dateTime;
	String senderAccount;
}
