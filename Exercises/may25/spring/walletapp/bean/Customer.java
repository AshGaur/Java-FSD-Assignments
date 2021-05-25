package may25.spring.walletapp.bean;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;


@Component
@Getter
@Setter
public class Customer {
	
	String customerName;
	Integer accountNumber;
	Double walletBalance = 0.0;
	
	public String toString() {
		return String.format("Name:%s Account:%d Wallet:%f",this.customerName,this.accountNumber,this.walletBalance);
	}
	
}
