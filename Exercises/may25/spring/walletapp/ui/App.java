package may25.spring.walletapp.ui;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import may25.spring.walletapp.service.InvalidInputException;
import may25.spring.walletapp.service.WalletServe;
import may25.spring.walletapp.service.WalletService;

@Configuration
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
    	WalletServe walletService = context.getBean("walletService",WalletService.class);
    	int input = -1;
    	do {
    		try {
    			System.out.println("----------------------------------");
    			System.out.println("1 -> To create a new account");
    			System.out.println("2 -> To Make a Deposit or withdraw funds");
    			System.out.println("3 -> To Transfer Funds");
    			System.out.println("4 -> To Print Transactions");
    			System.out.println("5 -> To exit");
    			System.out.println("----------------------------------");
    			System.out.print("Enter your choice :");
    			input = walletService.validateAccount(sc.nextLine());
    			switch(input) {
    				case 1:{
    					System.out.print("Enter new Customer name:");
        				String customerName = walletService.validateName(sc.nextLine());
        				
        				System.out.print("Enter initial Amount at which account to Open:");
        				String amount = sc.nextLine();
    					
        				String output = walletService.addCustomer(customerName,amount.length()>0?walletService.validateFunds(amount):0);
    					System.out.println(output);
        				break;
    				}
    				case 2:{
    					System.out.println("d -> Deposit");
    					System.out.println("w -> Withdraw");
    					System.out.print("Enter choice :");
    					String choice = sc.nextLine();
    					
    					System.out.print("Enter accountNo:");
    					int accountNo = walletService.validateAccount(sc.nextLine());
    					
    					System.out.print("Enter Amount:");
    					Double amount = walletService.validateFunds(sc.nextLine());
    					
    					boolean isWithdrawal = false;
    					switch(choice) {
    						case "d": isWithdrawal=false;break;
    						case "w": isWithdrawal=true;break;
    						default: throw new InvalidInputException("Invalid choice !");
    					}
    					
    					System.out.println(walletService.makeTransaction(accountNo,amount,isWithdrawal));
    					break;
    				}
    				case 3:{
    					System.out.print("Sender Account No :");
    					int senderAccountNo = walletService.validateAccount(sc.nextLine());
    					System.out.print("Receiver Account No :");
    					int receiverAccountNo = walletService.validateAccount(sc.nextLine());
    					
    					System.out.print("Amount:");
    					Double amount = walletService.validateFunds(sc.nextLine());
    					
    					System.out.println(walletService.fundsTransfer(senderAccountNo,receiverAccountNo,amount));
    					break;
    				}
    				case 4: {
    					System.out.print("Enter Column by which data to sort :");String orderBy = sc.nextLine();
    					System.out.print("Enter ASC for ascending or DESC for descending :");String order = sc.nextLine();
    					System.out.println("TRANSACTION HISTORY:");
    					System.out.println(walletService.getTransactionHistory(orderBy,order));
    					break;
    				}
    				case 5: System.out.println("ThankYou !");break;
    				default: System.out.println("Invalid Choice !");break;
    			}
    		}catch(InvalidInputException e) {
    			System.out.println("Invalid Input: "+e.getMessage());
    		}catch(SQLException e) {
    			System.out.println("SQL Exception:"+e.getMessage());
    		}
    	}while(input!=5);
    	
    	context.close();
    	sc.close();
    }
}
