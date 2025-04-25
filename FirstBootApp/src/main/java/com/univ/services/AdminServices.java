package com.univ.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.bean.Admin;

import com.univ.repository.AdminRepository;

@Service
public class AdminServices {

	@Autowired
	AdminRepository adminRepo;
	
	public Admin insert(Admin adm) {
		return (Admin) adminRepo.save(adm);
	}
	
	public Admin checkLogin(String unm,String pw) {
		return adminRepo.getLogin(unm,pw);
	 }
	
	
	
}
