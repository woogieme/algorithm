package test03;

import java.io.IOException;

public class Student {
	private int score;
	
	public void setScore(int score) throws IOException, JaeUkException {// throws = 개조심
		this.score = score;
		if(score<0) {
			throw new IOException("음수 점수가 어딨어... 0점도 슬픈데......");
		}
		if(score<60) {
			throw new JaeUkException(); //throw는 물어
			//객체를 생성해서 집어던져라 [ 항상 실행되는건 아님 ]
			//throws가 아닌 이유는? 
			//항상 물진 않지만 60점미만이면 물거에요
		}
	}
	public void printInfo() {
		if(score>90) {
			System.out.println("성적 A");
		}else if(score>=80) {
			System.out.println("성적 B");
		}else if(score>=70) {
			System.out.println("성적 C");
		}else if(score>=60) {
			System.out.println("성적 D");
		}
	}
}
