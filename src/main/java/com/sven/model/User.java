package com.sven.model;

public class User {
	private int id;
	private String name;
	private String userNum;
	private String passwd;
	private int sex;
	private int age;
	private String profession;
	private int mobile;
	private String email;
	
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setUserNum(String userNum){
		this.userNum=userNum;
	}
	public String getUserNum(){
		return userNum;
	}
	public void setPasswd(String passwd){
		this.passwd=passwd;
	}
	public String getPasswd(){
		return passwd;
	}
	public void setSex(int sex){
		this.sex=sex;
	}
	public int getSex(){
		return sex;
	}
	public void setAge(int age){
		this.age=age;
	}
	public int getAge(){
		return age;
	}
	public void setProfession(String profession){
		this.profession=profession;
	}
	public String getProfession(){
		return profession;
	}
	public void setMobile(int mobile){
		this.mobile=mobile;
	}
	public int getMobile(){
		return mobile;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
}

