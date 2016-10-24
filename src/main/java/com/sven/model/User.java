package com.sven.model;

/**
 * user表实体类
 * Created by sven on 2016/10/24.
 */
public class User {
	private int id;
	private String firstName;
	private String lastName;
	private String account;
	private String passwd;
	private int sex;
	private int age;
	private String profession;
	private int mobile;
	private String email;
	private String aboutYourself;
	
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAccount(String account){
		this.account=account;
	}
	public String getAccount(){
		return account;
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

	public String getAboutYourself() {
		return aboutYourself;
	}

	public void setAboutYourself(String aboutYourself) {
		this.aboutYourself = aboutYourself;
	}
}

