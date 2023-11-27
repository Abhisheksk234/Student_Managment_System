package com.example.demo.serviceimpl;

import java.lang.module.ResolutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ResourceException.ResourceException;
import com.example.demo.module.Student;
import com.example.demo.repo.StudentRepo;
import com.example.demo.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepo repo;

	@Override
	public Student addStudent(Student s) {
		return repo.save(s);
	}

	@Override
	public Student updateStudent(Student s) {
		Student s1 = repo.findById(s.getId()).orElse(null);
		if (s1 != null) {
			s1.setName(s.getName());
			s1.setFees(s.getFees());
			s1.setGender(s.getGender());
			s1.setPhno(s.getPhno());
			s1.setPlace(s.getPlace());
			return repo.save(s1);
		} else {
			throw new ResourceException("id not valid");
		}
	}

	@Override
	public Student deleteStudent(Integer id) {
		Student s = repo.findById(id).orElse(null);
		if (s != null) {
			repo.delete(s);
			return s;
		} else {
			throw new ResolutionException("id not found");
		}
    }

	@Override
	public Student getStudentById(Integer id) {
		return repo.findById(id).orElse(null);
	}

}
