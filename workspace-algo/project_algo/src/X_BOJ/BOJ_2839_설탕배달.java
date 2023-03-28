package X_BOJ;

public class BOJ_2839_설탕배달 {
	public static void main(String[] args) {
		int[] arr= {5,3};
		int ans=0;
		int cnt=11;
		for (int key : arr) {
			ans+=cnt/key;
			cnt%=key;
			
		}
		if (cnt>0) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
}
