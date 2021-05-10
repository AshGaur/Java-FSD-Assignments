import java.util.Scanner;
class AssertionTry{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter qtys for the products separated by spaces :");
		String qtyString = sc.nextLine();
		CheckBill checker = new CheckBill();
		for(String qty:qtyString.split(" ")){
			System.out.println("Entered qty:"+checker.checkQty(Integer.parseInt(qty))+" is fine to proceed");
		}
	}
}

class CheckBill{
	int checkQty(int qty){
		assert(qty>0):"Entered qty is "+String.valueOf(qty);
		return qty;
	}

}