package com.univ.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.univ.bean.Customer;
import com.univ.bean.Upload;
import com.univ.repository.ImageRepository;
import com.univ.services.CustomerServices;
import com.univ.services.ImageServices;

@Controller
public class IndexController {

	@Autowired
	CustomerServices serv;
	
	@Autowired
	ImageRepository imgRepo;
	
	@Autowired
	ImageServices imgserv;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/index")
	public String index1() {
		return "index";
	}

	@RequestMapping("/detail")	
	public String detail()
	{
	  return "detail";	
	}
	@RequestMapping("/cart")	
	public String cart()
	{
	  return "cart";	
	}
	@RequestMapping("/login")	
	public String login()
	{
	  return "login";	
	}
	@RequestMapping("/reg")	
	public String reg()
	{
	  return "reg";	
	}
	
	
	
	@PostMapping("/reg")
	public String reg1(@ModelAttribute("cust") Customer cust) {
		if(cust.getCname().isEmpty()) {
			return "reg";
		}else {
			Customer c= serv.insert(cust);
			if(c!=null) {
				return "login";
			}else {
				return "reg";
			}
		}
		
	}
	
	@PostMapping("/login")
	public String login1(@ModelAttribute("cust") Customer cust) {
		if(cust.getUnm().isEmpty()) {
			return "login";
		}else {
			Customer c=serv.checkLogin(cust.getUnm(),cust.getPw());
			if(c!=null) {
				return "index";
			}else {
				return "login";
			}
		}
	}
	
	//fetch data
	@GetMapping("/users")
    public List<Customer> getAllUser() {
        return serv.getAllUser();
    }
	
	/*
	 * @RequestMapping("/shop") public ModelAndView shop1() { ModelAndView mv=new
	 * ModelAndView(); List<Upload> images = new ArrayList<Upload>();
	 * imgRepo.findAll().forEach(images::add); mv.addObject("img", images);
	 * mv.setViewName("shop"); return mv; }
	 */
	
	@GetMapping("/shop")
	public String userShop(Model model) {
	    List<Upload> images = imgserv.getAllImages();
	    model.addAttribute("images", images);
	    return "shop";
	}
}
