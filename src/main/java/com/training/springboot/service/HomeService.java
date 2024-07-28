package com.training.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.training.springboot.model.Student;
import com.training.springboot.repository.CoureseRepository;

@Service
public class HomeService {
	
@Autowired	
CoureseRepository repository;
	public Student addStudent(@RequestBody Student stud)
{
	repository.save(stud);
	return stud;
	
}
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Student getStudentbyid(long id)
	{
		Optional<Student>obj = repository.findById(id);
		return obj.orElse(null);
	}
	public void deleteStudentbyid(Long id) {
		// TODO Auto-generated method stub
//		repository.deleteById(id);
		  try {
	            repository.deleteById(id);
	            
	        } catch (EmptyResultDataAccessException e) {
	            // This exception is thrown when trying to delete an entity that doesn't exist.
	            System.err.println("Student with ID " + id + " does not exist.");
	            
	        }
	}
	public Student update(Long id,Student stu)
	{
		Student obj = repository.findById(id).orElseThrow();
		obj.setFirstName(stu.getFirstName());
		obj.setLastName(stu.getLastName());
		obj.setAge(stu.getAge()); 
//		obj.setStuId(id);
		return repository.save(obj);
//		return(repository.save(stu));
	}
}
