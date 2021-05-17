import lombok.AllArgsConstructor;
import lombok.Getter;

public class CustomGeneric {
	public static void main(String[] args) {
		MyGeneric<Integer> mygen = new MyGeneric<>(0);
		System.out.println(mygen.summer(4,5,6));
		
		MyGeneric<String> mygenStr = new MyGeneric<>("");
		System.out.println(mygenStr.summer("W","O","R","K","S"));
	}
}

@AllArgsConstructor
@Getter
class MyGeneric<T>{
	T var;
	public T summer(T... args) {
		if(args[0] instanceof String) {
			String result = (String)this.var;
			for(T temp:args) {
				result += ((String)temp);
			}
			return (T) result;
		}else if(args[0] instanceof Integer) {
			Integer result = (Integer)this.var;
			for(T temp:args) {
				result += (Integer)temp;
			}
			return (T) result;
		}
		return null;
	}
}
