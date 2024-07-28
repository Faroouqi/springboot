package com.training.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.springboot.model.Student;
import com.training.springboot.service.HomeService;

@RestController
public class HomeController {
	@Autowired
	HomeService service;
	@GetMapping("/home")
	public String greet() {
		return "we are at home page in Student";
	}
//	@GetMapping("/back")
//	public String greet1() {
//		return "we are back";
//	}
	@PostMapping("/stud")
	public ResponseEntity<Student> addStudent(@RequestBody Student stud)
	{
		return new ResponseEntity<>(service.addStudent(stud),HttpStatus.CREATED);
	}
	@GetMapping("/stud12")
	public ResponseEntity<List<Student> >getAll()
	{
		return new ResponseEntity<>(service.getAllStudents(),HttpStatus.OK);
//		return ;
	}
	
	@GetMapping("/stud")
	public ResponseEntity<Student>getStudent(@RequestParam long studId)
	{
		return new ResponseEntity<>(service.getStudentbyid(studId),HttpStatus.OK);
	}
	@GetMapping("/stud12/{id}")
	public ResponseEntity<Student>findbyId(@PathVariable("id") Long id)
	{
		return new ResponseEntity<>(service.getStudentbyid(id),HttpStatus.OK);
//		Student student = service.getStudentbyid(id);
//        if (student != null) {
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//		return ;
	}
	@DeleteMapping("/stud12/{id}")
//	ResponseEntity<String>
	public void deleteById(@PathVariable("id") Long id) {
//        boolean isDeleted = (boolean) 
        		service.deleteStudentbyid(id);
//        if (isDeleted) {
//            return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
//        }
    }
	
	@PutMapping("/stud12/{id}")
	public ResponseEntity<Student> update(@PathVariable("id") Long id,@RequestBody Student stu)
	{
		Student updated = service.update(id, stu);
		
		return new ResponseEntity<>(updated, HttpStatus.OK);
	}
}
