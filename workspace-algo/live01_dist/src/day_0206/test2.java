package day_0206;

public class test2 {
	static int arr[] = {10,20,30};
	public static void main(String[] args) {
	
		
		System.out.println(re(arr,0));
	}
	private static int re(int[] arr2,int a) {
		// TODO Auto-generated method stub
		if (a==arr2.length-1) {
			return arr[arr.length-1];
		}
		System.out.print(arr[a]+" ");
		return re(arr2,a+1);
	}
}
