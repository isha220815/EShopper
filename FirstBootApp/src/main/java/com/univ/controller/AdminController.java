package com.univ.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.univ.bean.Admin;
import com.univ.bean.Customer;
import com.univ.bean.Upload;
import com.univ.services.AdminServices;
import com.univ.services.CustomerServices;
import com.univ.services.ImageServices;
import com.univ.upload.UploadCode;




@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminServices adminServ;

	@Autowired
	CustomerServices custServ;
	
	@Autowired
	UploadCode upcode;
	
	@Autowired
	ImageServices imgServ;
	
	@RequestMapping("/admin_index")
	public String admin_index() {
		return "/admin/index";
	}
	
	@RequestMapping("/admin_form")
	public String admin_form() {
		return "/admin/form";
	}
	
	@RequestMapping("/admin_table")
	public String admin_table(){
		return "/admin/table";
	}
	
	@RequestMapping("/admin_tab")
	public String admin_tab(){
		return "/admin/tab";
	}
	
	@RequestMapping("/admin_blank")
	public String admin_blank(){
		return "/admin/blank";
	}
	
	@RequestMapping("/admin_ui")
	public String admin_ui(){
		return "/admin/ui";
	}
	
	@RequestMapping("/admin_login")
	public String admin_login(){
		return "/admin/login";
	}
	
	@RequestMapping("/admin_reg")
	public String admin_reg(){
		return "/admin/reg";
	}
	
	@PostMapping("/admin_reg")
	public String admin_reg1(@ModelAttribute("adm") Admin adm) {
		if(adm.getName().isEmpty()) {
			return "/admin/reg";
		}else {
			Admin ad= adminServ.insert(adm);
			if(ad!=null) {
				return "/admin/login";
			}else {
				return "/admin/reg";
			}
		}
		
	}
	
	@PostMapping("/admin_login")
	public String login1(@ModelAttribute("adm") Admin adm) {
		if(adm.getUnm().isEmpty()) {
			return "/admin/login";
		}else {
			Admin ad=adminServ.checkLogin(adm.getUnm(),adm.getPw());
			if(ad!=null) {
				return "/admin/index";
			}else {
				return "/admin/login";
			}
		}
	}
	
	@RequestMapping("/")
	public String file() {
		return "/admin/file";
	}
	
	@RequestMapping("/admin_file")
	public String file1() {
		return "/admin/file";
	}
	
	@PostMapping("/admin_uploadfile1")
	public ModelAndView uploadFile1(@ModelAttribute("up") Upload up,@RequestParam MultipartFile file) {
		ModelAndView mv=new ModelAndView();
		if(up.getImgname().isBlank()) {
			mv.setViewName("redirect:/admin/file");
		}
		up.setImgname(file.getOriginalFilename());
		Upload data=this.imgServ.insert(up);
		try {
			if(file.isEmpty()) {
				mv.addObject(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File Not Found"));
			}
			if(!file.getContentType().equals("image/jpeg")) {
				mv.addObject(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload only jpeg image"));
			}
			boolean bt=upcode.uploadFile(file);
			if(bt) {
				mv.addObject(ResponseEntity.ok("File Stored"));
			}
		}catch(Exception ee){
			ee.getStackTrace();
		}
		mv.setViewName("/admin/file");
		return mv;
	}
	
	
	
	@RequestMapping("/admin_customer")
	public String viewAllUser(Model mv) {
		List<Customer> customers= custServ.getAllUser();
		System.out.println("Customers List" + customers);
		mv.addAttribute("customers",customers);
		return "/admin/customer";
	}
	
	
}
