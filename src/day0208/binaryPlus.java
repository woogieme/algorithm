package day0208;

public class binaryPlus {
	public static void main(String[] args) {
		String bin1="100001";
		String bin2="1010101";
		int tmp = 0;
		String result="";
		StringBuilder sb = new StringBuilder(result);
		if (bin1.length()<bin2.length()) {
			StringBuilder ox =new StringBuilder(bin1);
			while(ox.length()!=bin2.length()) {
				ox.insert(0,"0");
			}
			bin1 = ox.toString();
		}
		else {
			StringBuilder ox =new StringBuilder(bin2);
			while(bin1.length()!=ox.length()) {
				ox.insert(0,"0");
			}
			bin2 = ox.toString();
		}
		tmp=bin2.length();
		
		System.out.println(bin1.toString());
		System.out.println(bin2.toString());
		int count=0;
		for(int i=tmp-1; i>=0; i--) {
			if(bin1.charAt(i)-'0'==1 && bin2.charAt(i)-'0'==0) {
				if (count==1) {
					sb.insert(0,"0");
					count=1;
				}
				else {
					sb.insert(0,"1");
				}
			}
			else if(bin1.charAt(i)-'0'==0 && bin2.charAt(i)-'0'==1) {
				if (count==1) {
					sb.insert(0,"0");
				}
				else {
					sb.insert(0,"1");
				}
			}
			else if(bin1.charAt(i)-'0'==1 && bin2.charAt(i)-'0'==1) {
				if (count==1) {
					sb.insert(0,"1");
					count=1;
				}
				else {
					sb.insert(0,"0");
					count=1;
				}
			}
			
			
			else if(bin1.charAt(i)-'0'==0 && bin2.charAt(i)-'0'==0) {
				if (count==1) {
					sb.insert(0,"1");
					count=0;
				}
				else {
					sb.insert(0,"0");
				}
			}
			System.out.println(sb.toString());
			System.out.println(count);
		}
		if(count==1) {
			sb.insert(0,"1");
		}
		System.out.println("sb.len :"+sb.length());
		System.out.println("sb: "+sb);
		
	}
}
