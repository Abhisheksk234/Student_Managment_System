package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService ser;

	// localhost:8889/addStudent
	@PostMapping("addStudent")
	ResponseEntity<Student> addStudent(@RequestBody Student s) {
		return new ResponseEntity<Student>(ser.addStudent(s), HttpStatus.CREATED);

	}

	// localhost:8889/deleteStudent
	@DeleteMapping("deleteStudent")
	ResponseEntity<Student> deleteStudent(@RequestHeader Integer id) {
		return new ResponseEntity<Student>(ser.deleteStudent(id), HttpStatus.OK);
	}

	// localhost:8889/updateStudent
	@PutMapping("updateStudent")
	ResponseEntity<Student> updateStudent(@RequestBody Student s) {
		return new ResponseEntity<Student>(ser.updateStudent(s), HttpStatus.OK);
	}

	// localhost:8889/getStudentById
	@GetMapping("getStudentById")
	ResponseEntity<Student> getStudentById(@RequestHeader Integer id) {
		return new ResponseEntity<Student>(ser.getStudentById(id), HttpStatus.FOUND);
	}

}
