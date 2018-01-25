package com.neuedu.Bean;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.neuedu.Controller.StudentController;
import com.neuedu.Dao.JdbcTemplateDao;
import com.neuedu.Service.StudentService;

public class Test {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");


	
	@org.junit.Test
	public void test01(){
		//JdbcTemplateDao dao = ioc.getBean(JdbcTemplateDao.class);
		//String sql = "INSERT INTO student(`sname`,`age`) VALUES(?,?)";
		//dao.update(sql, "李忠帅",10000000);
		
		/*StudentService stuService = ioc.getBean(StudentService.class);
		String sql = "INSERT INTO student(`sname`,`age`) VALUES(?,?)";
		stuService.update(sql, "李忠",10000000);*/
	 
		StudentController stuController = ioc.getBean(StudentController.class);
		String sql = "INSERT INTO student(`sname`,`age`) VALUES(?,?)";
		stuController.update(sql, "李忠controller",10000000);
	}
	
	//ʵ��һ
	@org.junit.Test
	public void test() throws SQLException{
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource bean = ioc.getBean(DataSource.class);
		System.out.println(bean.getConnection());

	}

	//ʵ���
	/*	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);

		@org.junit.Test
		public void test01() throws SQLException{
			//ʵ��2����sid=21020�ļ�¼��age�ֶθ���Ϊ13
			String sql = "UPDATE student SET age = ? WHERE sid = ?";
			template.update(sql, 13,21020);//��һ����sql��䣬����İ���˳�������ɣ����update�����ǽ��յĿɱ����
		}*/
	
	//ʵ����
/*	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);
	@org.junit.Test
	public void testBatch(){
		String sql="INSERT INTO student(`sname`,`age`) VALUES(?,?)";
		//ִ��sql�����Ҫ���ݵĲ���
//		Object[][] params = new Object[3][2];
//		params[0] = new Object[]{"Tom2015",1000};
//		params[1] = new Object[]{"Tom2016",2000};
//		params[2] = new Object[]{"Tom2017",3000};
//		
		List<Object[]> list = new ArrayList<Object[]>();
		list.add(new Object[]{"Tom2015",1000});
		list.add(new Object[]{"Tom2016",2000});
		list.add(new Object[]{"Tom2017",3000});
		
		template.batchUpdate(sql, list);
	}*/
	
	/*ʵ����
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);
	
	@org.junit.Test
	public void test01(){
		//��Ҫע����ǣ�sql����еı���Ҫ���Ӧʵ������������һ�£�
		String sql = "SELECT sid AS sid,sname AS sname,age FROM student WHERE sid=?";
		
		//RowMapper��һ���ӿ�,��������ʹ��������
		RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
		//���һ�������ǿɱ����������sql��������δ��ݲ���!
		Student employee = template.queryForObject(sql, rowMapper, 21020);
		System.out.println(employee);
	}*/
	
	//ʵ����
		/*private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);
		
		@org.junit.Test
		public void test01(){
			//��Ҫע����ǣ�sql����еı���Ҫ���Ӧʵ������������һ�£�
			String sql = "SELECT sid AS sid,sname AS sname,age FROM student WHERE sid > ?";
			
			//RowMapper��һ���ӿ�,��������ʹ��������
			RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
			//��query������ѯ��������һ��list�б�,query���������һ�������ǿɱ����
			List<Student> list = template.query(sql, rowMapper, 4000);
			System.out.println("list��СΪ��"+list.size());
			for (Student employee : list) {
				System.out.println(employee);
			}
		}*/
	
	//ʵ����
		/*private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		private JdbcTemplate template=ioc.getBean(JdbcTemplate.class);
		
		@org.junit.Test
		public void test01(){
			String sql = "SELECT MAX(sid) FROM student";
			//��Ҫָ������ֵ������,�������ͱ����ǰ�װ����
			Integer maxsid = template.queryForObject(sql, Integer.class);
			System.out.println(maxsid);
		}*/
	
	//ʵ����
		/*private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		private NamedParameterJdbcTemplate namedJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
		
		@org.junit.Test
		public void test01(){
			String sql="INSERT INTO student(`sname`,`age`) VALUES(:paramName,:paramSalary)";//value����paramMap�еļ�ֵ
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("paramName","��ѧ��" );
			paramMap.put("paramSalary",1000);
			
			namedJdbcTemplate.update(sql, paramMap);
		}*/
	
	//ʵ���
		/*private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		private NamedParameterJdbcTemplate namedJdbcTemplate = ioc.getBean(NamedParameterJdbcTemplate.class);
		
		@org.junit.Test
		public void test01(){
			String sql="INSERT INTO student(`sname`,`age`) VALUES(:sname,:age)";//value���Ƕ����е�������
			//��BeanPropertySqlParameterSource�๹������Ҫһ���������ö��������һ����װ��sql������Ķ���
			//��ʱҪ������������Ҫ��sql�еĲ������һ�£���������ʹ��Employee���������
			Student employee= new Student( "���",1200, 1500);
			//��ʵ��������ʽ��װ��������ֵ
			SqlParameterSource source = new BeanPropertySqlParameterSource(employee);
			
			namedJdbcTemplate.update(sql, source);
		}*/
}
