package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2346_풍선터뜨리기 {
	 public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr.length; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}

			int k= 0; // 앞으로갈지 뒤로갈지 결정
			int i = arr[0]; // 풍선의 크기로 가는것
			arr[0]=0;
			ArrayList<Integer> brr= new ArrayList<>();
			brr.add(1);
			while(true) {
				if(i<0) {
					while(i!=0) {
						k-=1;
						i+=1;
						if(k==-1 || k==arr.length) {
							if(k==-1) {
								k=arr.length-1;
							}
							else {
								k=0;
							}
						}
						if(arr[k]==0) {
							i-=1;
						}
					
					}
				}
				else if(i>0) {
					while(i!=0) {
					k+=1;
					i-=1;
					if(k==-1 || k==arr.length) {
						if(k==-1) {
							k=arr.length-1;
						}
						else {
							k=0;
						}
					}
					if(arr[k]==0) {
						i+=1;
					}
					}
				}
				if(i==0) {
					brr.add(k+1);
					i=arr[k];
					arr[k]=0;
				}
				if(brr.size()==arr.length) {
					break;
				}
			}
			for (int j = 0; j < arr.length; j++) {
				System.out.print(brr.get(j)+" ");
			}
	}
}
