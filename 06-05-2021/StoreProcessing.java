import java.util.Scanner;
class StoreProcessing{
	public static void main(String[] args) throws InvalidInputException,StockException{
		Scanner sc  = new Scanner(System.in);
		System.out.println("Please enter product names separated by spaces:-");
		String productString = sc.nextLine();
		System.out.println("Please enter qty for each product respectively separated by spaces:-");
		String qtyString = sc.nextLine();

		// To handle NumberFormatException and raise InvalidInputException 
		try{
			checkProducts(productString,qtyString);	
		}catch(NumberFormatException e){
			throw new InvalidInputException("Quantity inputs are not valid should be space separated integers");
		}
		
	}

	public static void checkProducts(String productString,String qtyString) throws InvalidInputException,StockException{
		String products[] = productString.split(" ");
		String qtys[] = qtyString.split(" ");
		//Check if input was properly given
		if(productString.split(" ").length != qtyString.split(" ").length){
			throw new InvalidInputException("Number of products and quantites entered doesn't match!");
		}
		for(int i=0;i<products.length;i++){
			boolean found = false;
			//Linear search
			for(int j=0;j<ProductData.products.length;j++){
				//check if product exists in stock
				if(products[i].toLowerCase().equals(ProductData.products[j])){
					found = true;
					//check if entered qty is available as per stock qty
					if(Integer.parseInt(qtys[i])>ProductData.qtys[j]){
						throw new StockException(products[i],ProductData.qtys[j]);
					}
				}
			}
			//if product not found
			if(!found){
				throw new StockException(products[i],0);
			}
		}
	}
}

class StockException extends Exception{
	StockException(String name,int qty){
		super(name + " qty available:"+qty);
	}
}

class InvalidInputException extends Exception{
	InvalidInputException(String message){
		super(message);
	}
}

class ProductData{
	static String products[] = new String[]{"sugar","tea","coffee","milk","butter","bread"};
	static int[] qtys = new int[]{5,5,4,3,10,7};
}