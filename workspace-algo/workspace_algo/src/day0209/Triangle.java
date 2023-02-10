package day0209;

public class Triangle {
	public static void main(String[] args) {
		int[] sides = {3,6};
		if(sides[0]<sides[1]) {
			int tmp=sides[0];
			sides[0]=sides[1];
			sides[1]=tmp;
		}
		int Big=sides[0]+sides[1];
		int Small=sides[0]-sides[1];
		int result=0;
		result+=sides[0]-Small-1;
		result+=Big-sides[0];
		System.out.println(result);
	}
}
