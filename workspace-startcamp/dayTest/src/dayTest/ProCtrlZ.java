package dayTest;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class ProCtrlZ {
	public static void main(String[] args) {
		String s="-1 -2 -3 Z";
		StringTokenizer st = new StringTokenizer(s);
		ArrayList<String> arr =new ArrayList<String>();
		while(st.hasMoreTokens()) {
			arr.add(st.nextToken());
		}
		int tmp=0;
		int value=0;
		for(int i=0; i<arr.size(); i++) {
			if(!(arr.get(i).equals("Z"))){
				tmp+=Integer.parseInt(arr.get(i));
				value=Integer.parseInt(arr.get(i));
				}
			else {
					tmp-=value;
				}
			}
		System.out.println(tmp);
	}
}
