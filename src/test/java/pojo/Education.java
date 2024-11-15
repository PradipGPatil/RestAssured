package pojo;

public class Education {

	private String course;
	private int mark;
	
	public Education(String course,int mark) {
		// TODO Auto-generated constructor stub
		this.course=course;
		this.mark=mark;
	}
	
	public String getCourse() {
		return course;
	}
	
	public void setEducation(String course) {
		this.course=course;
	}
	
	public int getMark() {
		return mark;
	}
}
