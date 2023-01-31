package programmers;

import java.util.Arrays;

public class StringPush {
	public static void main(String[] args) {
		String A="abca";
		String B="aabc";
		boolean isFalse=false;
		int count=0;
		for(int i=0; i<A.length(); i++) {
			if(A.equals(B)) {
				count=i;
				isFalse=true;
				break;
			}
			char[] arr1 = A.toCharArray();
			char[] arr2 = B.toCharArray();
			
			char tmp=arr2[0];
			//System.out.println(tmp);
			for (int j = 1; j <arr1.length; j++) {
				arr2[j-1] =arr2[j];
			}
			arr2[arr2.length-1]=tmp;
			B=String.valueOf(arr2);
		}
		if(isFalse) {
			if (count==0)
			{
				System.out.println(0);
			}
			else {
			System.out.println(count);
			}
		}
		else {
			System.out.println(-1);
		}
		
	}
}
