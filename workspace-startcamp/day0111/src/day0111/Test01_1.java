package day0111;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test01_1 {
	public static void main(String[] args) throws IOException {
		
		//BufferedReader는 메모리, 속도 다 좋은데 무조건 한줄 통으로 문자열로만 입력받아져요.
		//그래서 입력받은 한줄을 내가  쪼개는 코딩을 해야돼서 약간 번거로워요
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  // 하나의 문자열로 인식 , 띄어쓰기해도 통으로 인식한다. 그래서 숫자가 들어오면 숫자로 인식해야한다.
		int TC= Integer.parseInt(br.readLine()); // 한줄을 통으로 읽고, Integer 형식으로 바꾼것을 TC로 넣는다.
		
		for (int tc = 1; tc <=TC; tc++) { 
			//tc 테스트 시작
			int sum = 0;
			String line = br.readLine(); //10개의 숫자를 하나의 문자열 통으로 입력받기 "1 2 3 4 5 6"
			StringTokenizer st = new StringTokenizer(line); // 통으로 입력받은것을 하나씩 자르는 역할
			for(int i=0; i<10; i++) {
				int num= Integer.parseInt(st.nextToken());
				if (num%2!=0) { //홀수가 맞는지 조건문 검사.
					sum+=num;
				}
			}
			System.out.println("#"+tc+" "+sum);
		}//tc 테스트 끝
	}	
}
