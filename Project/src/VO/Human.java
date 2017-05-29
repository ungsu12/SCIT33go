package VO;

import java.io.Serializable;

public class Human implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id = null;
	private String passWord = null;
	private String name = null;
	private String age = null;
	private String gender = null;
	
	public Human(String id, String passWord, String name, String age, String gender) {
		super();
		this.id = id;
		this.passWord = passWord;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Human [id=" + id + ", passWord=" + passWord + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ "]";
	}
	
	
}
