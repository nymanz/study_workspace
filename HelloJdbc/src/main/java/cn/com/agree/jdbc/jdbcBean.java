package cn.com.agree.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import cn.com.agree.jdbcUtil.JdbcUtil;


class jdbcBean {
	public static void main(String[] args) {
		List<Student> list=select();
		System.out.println(list);
/*		jdbcBean jdbcBean=new jdbcBean();
		jdbcBean.tset();*/
		/*delete();*/
		/*add();*/
	}
	
	public static int delete(){	
		return JdbcUtil.executeUpdate("delete from student where sid=? and sname=?", 10,"��ʿ��");
		
	}
	
	public static int update(){	
		return JdbcUtil.executeUpdate("update student set sname=?,age=?,sex=? where sid=?","mojie",2,"��",1);
		
	}
	
	public static int add(){
		return JdbcUtil.executeUpdate("insert into student(sname,age,sex) values(?,?,?)", "�۹�",3,"��");
		
	}
	 public static List select(){
		 
		 return cn.com.agree.jdbcUtil.JdbcUtil.executeSelect("select * from student",new RowMap<Student>(){
			public Student rowMapping(ResultSet rs){
				 Student student=new Student();	
				try {
					student.setAge(rs.getInt("age"));
					student.setName(rs.getString("sname"));
					student.setSex(rs.getString("sex"));
					student.setSid(rs.getInt("sid"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 return student;
			 }
		 }, null);
			/*Connection connection=JdbcUtil.getConnection();
			List<Student> list=new ArrayList<>();
			try {
				PreparedStatement pstmt=connection.prepareStatement("select * from student");
				ResultSet rs= pstmt.executeQuery();
				while (rs.next()) {
					Student student=new Student();	
					student.setAge(rs.getInt("age"));
					student.setName(rs.getString("sname"));
					student.setSex(rs.getString("sex"));
					student.setSid(rs.getInt("sid"));
					list.add(student);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcUtil.close(connection);
			}
			return list;*/
	}
	 public void tset(){
		 HashMap<String,Student> sHashMap=new HashMap();
		 for(int i=0;i<4;i++){
			 System.out.println("qingshuru");
			 Scanner scanner=new Scanner(System.in);
			 Integer sid=scanner.nextInt();
			 String sname=scanner.next();
			 Integer age=scanner.nextInt();
			 String sex=scanner.next();
			 Student student=new Student(age, sname, sex, sid );
			 sHashMap.put("Student"+i, student);
		 }
		 for(int i=0;i<4;i++){
			 System.out.println(sHashMap.get("Student"+i));
		 }
			 
		
	 }
}
