package com.univ.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.bean.Upload;
import com.univ.repository.ImageRepository;

@Service
public class ImageServices {

	@Autowired
	ImageRepository imgRepo;
	
	public Upload insert(Upload up) {
		return imgRepo.save(up);
		
	}

	public List<Upload> getAllImages() {
	    List<Upload> list = new ArrayList<>();
	    imgRepo.findAll().forEach(list::add);
	    return list;
	}
}
