package VO;

import java.awt.Font;
import java.io.Serializable;

public class Grade implements Serializable{

	private static final long serialVersionUID = 1L;
	private String id = null;
	private String date = null;
	private int score = 0;
	private String level = null;
	public Grade(String id, String date, int score, String level) {
		super();
		this.id = id;
		this.date = date;
		this.score = score;
		this.level = level;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		String re = "아이디  : " + id + "   날짜 : " + date + " 점수 :" + score + "  난이도 :" + level; 
		return re;
	}
}
