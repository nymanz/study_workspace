package agree.rcpstudy;

import java.util.ArrayList;

public class Person {
	private String name;
	private String sex;
	private String[] list = new String[10];

	public String[] getList() {
		return list;
	}

	public void setList(String[] list) {
		this.list = list;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
