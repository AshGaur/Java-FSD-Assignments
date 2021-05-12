package may12;

public class Participant {
	private String name;
	private String skills;
	public Participant(String name, String skills) {
		this.name = name;
		this.skills = skills;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return String.format("%-8s:%-15s  %-8s:%s","Name",this.name,"Skills",this.skills);
	}

}
