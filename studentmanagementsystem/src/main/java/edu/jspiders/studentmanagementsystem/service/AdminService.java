package edu.jspiders.studentmanagementsystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jspiders.studentmanagementsystem.entity.Admins;
import edu.jspiders.studentmanagementsystem.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	
	public Admins addAdmin(Admins admin) {
		return adminRepository.save(admin); 
	}


	public boolean findEmailAndPassword(String email, String password) {
		 Optional<Admins> admin = adminRepository.findByEmailAndPassword(email, password);
		 if(admin.isPresent())
		 {
			 if(admin.get().getEmail().equals(email) && admin.get().getPassword().equals(password))
			 	return true;
			 else
			 	return false;
		 }else
			 return false;
	}


	public boolean findByMobileAndPassword(long mobile, String password) {
		Optional<Admins> adminmobile = adminRepository.findByMobileAndPassword(mobile, password);
		if(adminmobile.isPresent())
		{
			if(adminmobile.get().getMobile().equals(mobile) && adminmobile.get().getPassword().equals(password))
				return true;
			else
				return false;
		}
		else {
			return false;
		}
	}


	public void deleteAdmin(int id) {
		adminRepository.deleteById(id);
	}


	public Admins updateAdmin(Admins admin) {
		return adminRepository.save(admin);
		
	}

}
