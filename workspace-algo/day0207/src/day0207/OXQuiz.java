package day0207;

import java.util.Arrays;

public class OXQuiz {
	public static void main(String[] args) {
		String[] quiz= {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"};
		Char[] result=new String[quiz.length];
		System.out.println(result.length);
		for(int i=0; i<quiz.length; i++) {
			String[] arr = quiz[i].split(" ");
			if (arr[1]=="-") {
				if(Integer.parseInt(arr[0])-Integer.parseInt(arr[2])==Integer.parseInt(arr[4])) {
					System.out.println(Integer.parseInt(arr[0])+" : "+Integer.parseInt(arr[2])+" : "+Integer.parseInt(arr[4]));
					result[i]='O';
					System.out.println(result[i]);
					continue;
				}
				else {
					System.out.println(Integer.parseInt(arr[0])+" : "+Integer.parseInt(arr[2])+" : "+Integer.parseInt(arr[4]));
					result[i]='X';
					System.out.println(result[i]);
					continue;
				}
			}
			else {
				if(Integer.parseInt(arr[0])+Integer.parseInt(arr[2])==Integer.parseInt(arr[4])) {
					System.out.println(Integer.parseInt(arr[0])+" : "+Integer.parseInt(arr[2])+" : "+Integer.parseInt(arr[4]));
					result[i]='O';
					System.out.println(result[i]);
					continue;
				}
				else {
					System.out.println(Integer.parseInt(arr[0])+" : "+Integer.parseInt(arr[2])+" : "+Integer.parseInt(arr[4]));
					result[i]='X';
					System.out.println(result[i]);
					continue;
				}
			}
			
		}
		System.out.println(Arrays.toString(result));
	}
}
