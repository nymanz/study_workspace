package cn.com.agree.jdbc;

public class Student {
	private String name;
	private int age;
	private int sid;
	private String sex;
	public String getName() {
		return name;
	}
	public Student(String name, int age, int sid, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sid = sid;
		this.sex = sex;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public Student(String name, int age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
