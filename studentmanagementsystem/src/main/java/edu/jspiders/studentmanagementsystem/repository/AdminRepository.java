package edu.jspiders.studentmanagementsystem.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.jspiders.studentmanagementsystem.entity.Admins;


@Repository
public interface AdminRepository extends JpaRepository<Admins, Integer> {

	  Optional<Admins> findByEmailAndPassword(String email,String password);

	  Optional<Admins> findByMobileAndPassword(long mobile,String password);
}
