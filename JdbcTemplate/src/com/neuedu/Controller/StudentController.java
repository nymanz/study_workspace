package com.neuedu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.Service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService stuService;

	public StudentController() {
		System.out.println("studentController created!");
	}
	
	public void update(String sql,Object...args){
		stuService.update(sql, args);
	}

}
