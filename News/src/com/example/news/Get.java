package com.example.news;

public class Get {
	String title;
	String detail;
	String comment;
	String time;
	String image;
	String imagedata;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImagedata() {
		return imagedata;
	}
	public void setImagedata(String imagedata) {
		this.imagedata = imagedata;
	}
	
	
	@Override
	public String toString() {
		return "Get [title=" + title + ", detail=" + detail + ", comment=" + comment + ", time=" + time + ", image="
				+ image + ", imagedata=" + imagedata + "]";
	}
	
	
}
