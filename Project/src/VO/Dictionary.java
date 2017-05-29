package VO;

import java.io.Serializable;

public class Dictionary implements Serializable {

	private static final long serialVersionUID = 1L;
	private String mean;
	private String word;
	private int seq;
	public Dictionary() {
		
	}
	public Dictionary(String mean, String word) {
		super();
		this.mean = mean;
		this.word = word;
	}
	public Dictionary(int seq, String mean, String word){
		super();
		this.seq = seq;
		this.mean = mean;
		this.word = word;
	}
	public String getMean() {
		return mean;
	}
	public void setMean(String mean) {
		this.mean = mean;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	@Override
	public String toString() {
		return "Dictionary [mean=" + mean + ", word=" + word + ", seq=" + seq + "]";
	}
}
