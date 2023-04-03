package X_Professor.day3;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.sound.midi.Soundbank;

public class SW_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st =new StringTokenizer(br.readLine());
			Queue<Integer> arr = new LinkedList<>();
			for (int i = 0; i < 8; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			int i =1;
			while(true) {
				
				int tmp = arr.poll()-i;
				if(tmp<=0) {
					tmp=0;
				}
				arr.add(tmp);
				
				if(tmp==0) {
					break;
				}
				i++;
				if(i==6) {
					i%=6;
					i++;
				}
			}
		
		
		System.out.print("#"+N+" ");
		for (int j = 0; j < 8; j++) {
			System.out.print(arr.poll()+" ");
		}
		System.out.println();
	}
		
		
		
	}

}
