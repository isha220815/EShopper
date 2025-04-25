package com.univ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.univ.bean.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer>{

	@Query("select c from Admin c where c.unm=?1 and c.pw=?2")
	public Admin getLogin(String unm,String pw);
}
