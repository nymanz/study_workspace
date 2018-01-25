package com.neuedu.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.Dao.JdbcTemplateDao;

@Service
public class StudentService {

	@Autowired
	private JdbcTemplateDao stuDao;
	public StudentService() {
		super();
		System.out.println("studentService Crested!");
	}
	
	public void update(String sql,Object ...args){
		stuDao.update(sql, args);
	}

}
