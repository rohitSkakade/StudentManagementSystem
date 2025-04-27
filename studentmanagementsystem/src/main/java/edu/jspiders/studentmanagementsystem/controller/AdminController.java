package edu.jspiders.studentmanagementsystem.controller;

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

import edu.jspiders.studentmanagementsystem.entity.Admins;
import edu.jspiders.studentmanagementsystem.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping(path = "/admin")
	protected ResponseEntity<Admins> addAdmin(@RequestBody Admins admin)
	{
		 Admins addAdmins = adminService.addAdmin(admin);
		 return new ResponseEntity<Admins>(addAdmins,HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/admin-email")
	protected ResponseEntity<String> findEmailAndPassword(@RequestParam String email,@RequestParam String password)
	{
		boolean adminIsPresent = adminService.findEmailAndPassword(email,password);
		if(adminIsPresent)
			return new ResponseEntity<String>("Admin is Present",HttpStatus.FOUND);
		else
			return new ResponseEntity<String>("something is wrong",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path = "/admin-mobile")
	protected ResponseEntity<String> findAdminByMobileAndPassword(@RequestParam long mobile,@RequestParam String password ) 
	{
		boolean adminIsPresent = adminService.findByMobileAndPassword(mobile,password);
		if(adminIsPresent)
			return new ResponseEntity<String>("Admin is Present",HttpStatus.FOUND);
		else
			return new ResponseEntity<String>("something is wrong",HttpStatus.NOT_FOUND);
	
	}
	
	@DeleteMapping(path="/delete-admin")
	protected String  deleteAdmin(@RequestParam int id) {
		 adminService.deleteAdmin(id);
		 return "admin is deleted";
	}
	
	@PutMapping(path = "update-admin")
	protected String updateAdmin(@RequestBody Admins admin) {
		@SuppressWarnings("unused")
		Admins updateAdmin = adminService.updateAdmin(admin);
		return "admin updated";
	}

}
