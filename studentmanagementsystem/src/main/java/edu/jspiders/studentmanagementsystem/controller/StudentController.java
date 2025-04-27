package edu.jspiders.studentmanagementsystem.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.jspiders.studentmanagementsystem.entity.Students;
import edu.jspiders.studentmanagementsystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping(path = "students")
	protected ResponseEntity<Students> addStudents(@RequestBody Students students) {
		Students add = studentService.addStudents(students);
		return new ResponseEntity<Students>(add,HttpStatus.CREATED);
	}
	
	
	@GetMapping(path = "find-students")
	protected ResponseEntity<Object> findAllStudents() {
		List<Students> allStudents = studentService.findAllStudents();
		if(allStudents.isEmpty())
			return new ResponseEntity<Object>("No data avaiable",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(allStudents,HttpStatus.FOUND);
	}
	
	@GetMapping(path = "find-by-email")
	protected ResponseEntity<Object> findByEmail(@RequestParam String email) {
		Optional<Students> students = studentService.findByEmail(email);
		if(students.isEmpty())
			return new ResponseEntity<Object>("No data avaiable",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(students,HttpStatus.FOUND);
	}
	
	@PutMapping(path="update-student")
	protected String updateStudent(@RequestBody Students students) {
		studentService.updateStudent(students);
		return "Updated Students";
	}
	
	@DeleteMapping(path = "delete")
	protected String deleteStudent(@RequestParam int id) {
		studentService.deleteStudent(id);
		return "Student is deleted";	
	}
	
	@GetMapping(path = "find-by-cousre")
	protected ResponseEntity<Object> findByCousre(@RequestParam String cousre) {
		   List<Students> cousres = studentService.findByCousre(cousre);
		if(cousres.isEmpty())
			return new ResponseEntity<Object>("No data avaiable",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Object>(cousres,HttpStatus.FOUND);
	}
}
