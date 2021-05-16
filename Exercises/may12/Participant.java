package may12;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Participant{
	private String firstName;
	private String lastName;
	private String skills;

	@Override
	public String toString() {
		return String.format("%-8s:%-15s  %-8s:%s","Name",this.firstName+" "+this.lastName,"Skills",this.skills);
	}
	
	@Override
	public int hashCode() {
		return this.getFirstName().hashCode()+this.getLastName().hashCode()+this.getSkills().hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		Participant temp = (Participant)o;
		String one = this.getFirstName()+this.getLastName()+this.getSkills();
		String two = temp.getFirstName()+temp.getLastName()+temp.getSkills();
		return one.equals(two);
	}
	
}
