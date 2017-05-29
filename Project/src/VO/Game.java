package VO;

import java.io.Serializable;

public class Game implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	private String hireDate;
	private int Score;
	private double time;
	private String level;
	public Game(String id, String hireDate, int score, double time, String level) {
		super();
		this.id = id;
		this.hireDate = hireDate;
		Score = score;
		this.time = time;
		this.level = level;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "아이디 :" + id + ", 날짜 : " + hireDate + ", 점수 : " + Score + ", 시간 : " + time + "초  난이도 : " + level;
	}
	

}
