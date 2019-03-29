package agree.rcpstudy;

import java.util.ArrayList;

public class PersonModel {
	private ArrayList<Person> list = new ArrayList<Person>();

	public PersonModel() {
		Person p1 = new Person();
		String[] Slist = {"病人1","男","感冒","已治愈"};
		p1.setName("病人1");
		p1.setSex("男");
		p1.setList(Slist);
		list.add(p1);
		String[] Slist2 = {"病人2","女","中风","不可治愈"};
		Person p2 = new Person();
		p2.setName("病人2");
		p2.setSex("女");
		p2.setList(Slist2);
		list.add(p2);
	}

	public ArrayList elements() {
		return list;
	}
}
