package POJO;

public class GetCourse {
	private String url;
	private String instructor;
	private String services;
	private String expertise;
	private Courses courses;
	private String linkedIn;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public POJO.Courses getCourses() {
		return courses;
	}
	public void setCourses(POJO.Courses courses) {
		this.courses = courses;
	}
	public String getlinkedIn() {
		return linkedIn;
	}
	public void setlinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	

}
