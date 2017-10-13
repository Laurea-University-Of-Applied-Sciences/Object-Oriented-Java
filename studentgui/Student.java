package studentgui;

public class Student {
	private String name;
	private String language;
	
	public Student(String name, String language) {
		this.name = name;
		this.language = language;
	}
	
	public String greet() {
		String retval;
		
		if (this.language == "Finnish") {
			retval = "Hei";
		} else {
			retval = "Hello";
		}
		return retval;
	}
	
	public String getName() {
		return this.name;
	}
	public String getLanguage() {
		return this.language;
	}
}
