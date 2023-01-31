package programmers;

import java.util.ArrayList;

public class cutArray {
	public static void main(String[] args) {
		String my_str="abc1Addfggg4556bafadg41gg1";

		int n=15;
		ArrayList<String> arr = new ArrayList<>();
		while(my_str.length()>0) {
			
			if(my_str.length()/n==0 && my_str.length()%10>0) {
				n=my_str.length()%n;
			}
			String tmp = my_str.substring(0,n);
			my_str= my_str.substring(n,my_str.length());
			arr.add(tmp);
		}
		
		System.out.println(arr);
		
		
	}
}
