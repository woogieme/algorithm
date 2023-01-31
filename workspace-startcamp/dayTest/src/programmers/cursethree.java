package programmers;

public class cursethree {
	public static void main(String[] args) {
		int n=15;
		int[] arr = new int[n];
		for(int i=0; i<arr.length;i ++) {
			arr[i]=i+1;
		}
		int count=0;
		int i=1;
		while(i<=n) {
			int k=1;
			boolean isFlag=true;
			while(k>0) {
				int value=k%10;

				if(value==3 || value==6 || value==9 || k%3==0) {
					System.out.println(k+" : "+value);
					isFlag=false;
					break;
				}
				k/=10;
			}
			if(!isFlag) {
				
				count+=i;
				
			}
			i+=1;
			
		}
		System.out.println(count);
	}
}
