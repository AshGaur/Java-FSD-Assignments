import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Comparator;

public class LambdaComparatorCustomSort {
	public static void main(String[] args) {
		List<Participant> list = new ArrayList<>();
		list.add(new Participant("Ashutosh Gaur","Java,Node,MySQL",20));
		list.add(new Participant("Kobe Bryant","Basketball Pivot,Jab Steps,etc.",24));
		list.add(new Participant("Cristiano Ronaldo","Football Dribble,Athletics,etc.",7));
		
		System.out.println("Sorted by Name:");
		Collections.sort(list,(o1,o2)->o1.getName().compareTo(o2.getName()));
		list.forEach(value->System.out.println(value));
		
		System.out.println("\nSorted by ID:");
		Collections.sort(list,(o1,o2)->o1.getId()-o2.getId());
		list.forEach(value->System.out.println(value));
		
		System.out.println("\nSorted by Skills:");
		//Java 8 list.sort(Comparator<> SubClass object ref)
		list.sort((o1,o2)->o1.getSkills().compareTo(o2.getSkills()));
		list.forEach(value->System.out.println(value));
	}

}
