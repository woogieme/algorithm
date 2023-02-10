package programmers;

public class square {
	public static void main(String[] args) {
		int dots[][] = {{-1,-1}, {1,1}, {1,-1}, {-1,1}};
		int answer=1;
		for(int i=0; i<2; i++) {
			for(int j=0; j<dots.length; j++) {
				if (dots[0][i]!= dots[j][i]) {
					answer*=Math.abs(dots[0][i]-dots[j][i]);
					break;
				}
			}
		}
		System.out.println(answer);
		
	}
}
