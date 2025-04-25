package com.univ.repository;

import org.springframework.data.repository.CrudRepository;

import com.univ.bean.Upload;

public interface ImageRepository extends CrudRepository<Upload, String> {

}
