package 	day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for (int tc = 1; tc <=TC; tc++) {
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int rotate=N/4;
		char[] arr = br.readLine().toCharArray();
		ArrayList<Character> brr = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			brr.add(arr[i]);
		}
		int tmp=0;
		ArrayList<Integer> pw = new ArrayList<>();
		while(true) {
			if(tmp==rotate) {
				break;
			}
			for (int i = 0; i < arr.length; i+=rotate) {
				String ans="";
				for (int j = i; j <i+rotate; j++) {
					ans+=brr.get(j);
				}
				pw.add(Integer.parseInt(ans,16));
				}
			brr.add(0,brr.remove(brr.size()-1));
			tmp++;
		
		}
		Collections.sort(pw);
		Collections.reverse(pw);
		ArrayList<Integer> hashSet = new ArrayList<>();
		for(Integer item : pw) {
			if(!hashSet.contains(item)) {				
				hashSet.add(item);
			}
		}
		System.out.println("#"+tc+" "+hashSet.get(M-1));
		}
	}
}
