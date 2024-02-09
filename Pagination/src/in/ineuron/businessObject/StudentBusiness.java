package in.ineuron.businessObject;

public class StudentBusiness {

	public StudentBusiness()
	{
		System.out.println("in the business object");
	}
	
	
	private String name;
	private String course;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private Integer age;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
