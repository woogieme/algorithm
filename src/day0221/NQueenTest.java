package day0221;

import java.util.Arrays;
import java.util.Scanner;

//같은행 x -> No 2차원ㅂ ㅐ열 , 1차원배열에 객체를 삽입하면됨
//열체크 O , 대각선 O ( \ / ) check
//행차이 = 열차이 -> 대각선

//이런방법도있따 ! - 효율적 
//열 visit  - 1차원배열 관리
//대각선 visit - 1차원배열 관리
//대각선 visit - 1차원배열 관리
public class NQueenTest {
	static int N, col[], answer;// col은 열번호 기억, answer은 값이 얼마나 있는지

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
		setQueen(1);
		System.out.println(answer);

	}

	private static void setQueen(int rowNo) { // rowNo:놓으려고하는 퀸의 행번호
		if (!isAvailable(rowNo - 1)) { //혹시 선배님들 문제 없으시죠? 
			System.out.println("안돼 돌아가");
			return; // 유효성 확인
		}
		if (rowNo > N) { // 기저 조건
			answer += 1;
			System.out.println("난 정답이다!!!!!!!!!!!!!!!!"+Arrays.toString(col));
			return;
		}
		for (int c = 1; c <= N; c++) {
			col[rowNo] = c; //일단 값 냅다 박아 
			System.out.println(rowNo+" 퀸을 "+c+" 자리에 놓았다.");
			System.out.println(Arrays.toString(col));
			setQueen(rowNo + 1);  // 일단 후배를 생성 -> 후배가 선배님들 맞는지 안맞는지 확인 
		}
	}

	private static boolean isAvailable(int rowNo) {
		for (int k = 1; k <rowNo; k++) { // k: 비교대상 queen의 행, k는 rowNo보다 작아야한다 그 이유는 선배님들의 열체크 해야되기때문에
			if (col[k] == col[rowNo] || Math.abs(col[k] - col[rowNo]) == rowNo - k) { // 대각선 열 체ㅡ
				return false;
			}
		}
		return true;
	}
}
