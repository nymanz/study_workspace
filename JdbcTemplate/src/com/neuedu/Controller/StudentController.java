package com.neuedu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.neuedu.Service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService stuservice;

	public StudentController() {
		System.out.println("studentController created!");
	}

}
