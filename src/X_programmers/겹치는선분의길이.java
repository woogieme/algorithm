package X_programmers;

public class 겹치는선분의길이 {
	public static void main(String[] args) {
		int[][] lines= {{0,5},{3,9},{1,10}};
		int[] arr =new int[201];
		int ans=0;
		for (int i = 0; i < 3; i++) {
			int left=lines[i][0];
			int right=lines[i][1];
			for (int j = left; j < right; j++) {
				arr[j+100]+=1;
			}
		}
		for (int i = 0; i < 200; i++) {
			if(arr[i]>1) {
				ans+=1;
			}
		}
		System.out.println(ans);
		
	}
	
}
