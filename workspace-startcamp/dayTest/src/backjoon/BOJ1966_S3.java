package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1966_S3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC=Integer.parseInt(br.readLine());
		for(int tc=0; tc<TC; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int loc= Integer.parseInt(st.nextToken());
			
			
			StringTokenizer stc = new StringTokenizer(br.readLine());
			int[] arr = new int[key];
			int[] tmp = new int[key];
			for(int i=0; i<key; i++) {
				arr[i]=Integer.parseInt(stc.nextToken());
				tmp[i]=i;
			}
			int count=0;
			
			while(true) {
				int max =arr[0];
				for (int i=0; i<key; i++) {
					if(max<arr[i]) {
						max=arr[i];
					}
				}
				
				if(max==arr[0]) {
					if(loc==tmp[0]) {
						count+=1;
						break;
					}
					count+=1;
					arr[0]=-1;
				}
				
				else {
					for(int i=0; i<key; i++) {
						if(max!=arr[0]) {
							int value=arr[0];
							int value_2=tmp[0];
							for (int j = 1; j < key; j++) {
								arr[j-1]=arr[j];
								tmp[j-1]=tmp[j];
							}
							arr[arr.length-1]=value;
							tmp[tmp.length-1]=value_2;
						}
						else {
							
							break;
						}
					}
				}	
//				for(int i=0; i<key;i++) {
//					System.out.print(arr[i]+" ");
//				}
//				System.out.println();
//				for(int i=0; i<key;i++) {
//					System.out.print(tmp[i]+" ");
//				}
//				System.out.println();
			}
			System.out.println(count);

		
		}
		
	}
}
