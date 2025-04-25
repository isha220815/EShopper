package com.univ.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Upload {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int imgid;
	String imgname,imgtype;
	int price,status;
	public Upload() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Upload(int imgid, String imgname, String imgtype, int price, int status) {
		super();
		this.imgid = imgid;
		this.imgname = imgname;
		this.imgtype = imgtype;
		this.price = price;
		this.status = status;
	}
	public int getImgid() {
		return imgid;
	}
	public void setImgid(int imgid) {
		this.imgid = imgid;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImgtype() {
		return imgtype;
	}
	public void setImgtype(String imgtype) {
		this.imgtype = imgtype;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
