package com.neuedu.Bean;

public class Student {
	private String sname;
	private int age;
	private int sid;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", age=" + age + ", sid=" + sid + "]";
	}
	public Student(String sname, int age, int sid) {
		super();
		this.sname = sname;
		this.age = age;
		this.sid = sid;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
