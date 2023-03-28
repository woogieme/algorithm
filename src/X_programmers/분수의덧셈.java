package X_programmers;

import java.util.Arrays;

public class 분수의덧셈 {
	public static void main(String[] args) {
		int numer1=512;
		int denom1=512;
		int numer2=512;
		int denom2=512;
		
		int down = denom1 * denom2;
		int up = (denom1*numer2)+(numer1*denom2);
		
		int tmp = 0;
		boolean isFlag=true;
		if(down>up) {
			tmp=up;
			up=down;
			down=tmp;
			isFlag=false;
		}
		int downTmp=down;
		int upTmp=up;
		int value=1;
		while(upTmp%downTmp!=0) {
			value = upTmp%downTmp;
			upTmp=downTmp;
			downTmp=value;
		}
		if(value==1) {
			if(up%down==0) {
				tmp=up;
				up=up/down;
				down=1;
			}
		}
		if(!isFlag) {
			tmp=up;
			up=down;
			down=tmp;
		}
		up=up/value;
		down=down/value;
		int[] result= {up,down};
		System.out.println(Arrays.toString(result));
	}
}
