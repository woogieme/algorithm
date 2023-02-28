package X_programmers;

import java.util.Arrays;

import javax.sound.midi.Soundbank;

class 응애_Test {
    static String[] babb= {"aya","ye","woo","ma"};
	static boolean[] isSelected;
	static int[] arr;
	static int count;
	static String[] iam;
    public static int solution(String[] babbling) {
        count=0;
        iam=babbling.clone();
        for (int i = 0; i < 5; i++) {
            isSelected=new boolean[babb.length];
            arr=new int[i+1];
            sub(0);
            }
            return count;
    	}
        
    private static void sub(int cnt) { //  cnt : 직전까지 고려된 원소 수
		if(cnt==arr.length) {
			String tmp="";
			for (int i = 0; i < arr.length; i++) {
				tmp+=babb[arr[i]];
				
			}
			System.out.println(tmp);
			for (int i = 0; i < iam.length; i++) {
				if(tmp.equals(iam[i])) {
					//System.out.println(tmp);
					count+=1;
				}
			}
			return;
		}
		//현재 원소를 부분집합의 구성에 포함
		for (int i = 0; i < babb.length; i++) {
			if(isSelected[i]) continue;
			isSelected[i]=true;
			arr[cnt]=i;
			sub(cnt+1);
			isSelected[i]=false;
			
		}
	}
}