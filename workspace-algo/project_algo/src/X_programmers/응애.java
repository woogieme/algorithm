package X_programmers;

public class 응애 {
	
	static String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};
	static String[] babb= {"aya","ye","woo","ma"};
	static boolean[] isSelected;
	static int[] arr;
	static int count;
	public static void main(String[] args) {
		int count=0;
		for (int i = 0; i < 5; i++) {
			isSelected=new boolean[babb.length];
			arr=new int[i+1];
			sub(i);
		}
		System.out.println(count);
	}
	private static void sub(int cnt) { //  cnt : 직전까지 고려된 원소 수
		if(cnt==isSelected.length) {
			String tmp="";
			for (int i = 0; i < isSelected.length; i++) {
				if(isSelected[i]) {
					tmp+=babb[i];
				}
				
			}
			for (int i = 0; i < babbling.length; i++) {
				if(tmp.equals(babbling[i])) {
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
			sub(cnt+1);
			isSelected[i]=false;
			
		}
		
	}
}
