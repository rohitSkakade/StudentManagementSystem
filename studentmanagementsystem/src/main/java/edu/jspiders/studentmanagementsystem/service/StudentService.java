package edu.jspiders.studentmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.studentmanagementsystem.entity.Students;
import edu.jspiders.studentmanagementsystem.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Students addStudents(Students students) {
		return studentRepository.save(students);
		
	}


	public List<Students> findAllStudents() {
		return studentRepository.findAll();
	}


	public Optional<Students> findByEmail(String email) {
		return studentRepository.findByEmail(email);
	}


	public Students updateStudent(Students students) {
	    return	studentRepository.save(students);
		
	}


	public void deleteStudent(int id) {
			studentRepository.deleteById(id);
	}


	public List<Students> findByCousre(String cousre) {
		return studentRepository.findByCousre(cousre);
		
	}
	
	
}
