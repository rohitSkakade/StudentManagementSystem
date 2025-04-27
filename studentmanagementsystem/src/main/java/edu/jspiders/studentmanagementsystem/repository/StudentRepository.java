package edu.jspiders.studentmanagementsystem.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.studentmanagementsystem.entity.Students;

@Repository
public interface StudentRepository  extends JpaRepository<Students, Integer>{

	   
	Optional<Students> findByEmail(String email);
	
	List<Students> findByCousre(String cousre);
}
