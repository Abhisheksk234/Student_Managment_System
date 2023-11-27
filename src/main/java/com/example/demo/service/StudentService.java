package com.example.demo.service;

import com.example.demo.module.Student;

public interface StudentService {
	public Student addStudent(Student s);

	public Student updateStudent(Student s);

	public Student deleteStudent(Integer id);

	public Student getStudentById(Integer id);
}
