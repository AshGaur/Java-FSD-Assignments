
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participant {
	private String name, skills;
	private Integer id;
	@Override
	public String toString() {
		return String.format("ID:%-5d Name:%-20s Skills:%s",this.getId(),this.getName(),this.getSkills());
	}
}














