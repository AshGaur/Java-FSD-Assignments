import java.io.IOException;
class UsingThrowsDeclaration{
	public static void main(String[] args){
		new OutputMethods().display(6,0);
	}
}

class Calculator{
	int div(int a,int b) throws IOException{
		return a/b;
	}
}

class OutputMethods{
	void display(int a,int b){
		try{
			System.out.println("Output :"+new Calculator().div(a,b));
		}catch(ArithmeticException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}