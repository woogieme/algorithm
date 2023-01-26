package programmers;

public class onetimechar {
	public static void main(String[] args) {
		String s = "abdc";
        String answer = "";
        char[] arrCh=s.toCharArray();
        int[] tmp=new int[26];
        for(int i= 0; i<arrCh.length; i++){
            tmp[arrCh[i]-'a']+=1;
        }
        char a;
        for(int i=0; i<tmp.length; i++){
            if (tmp[i]==1){
            	a=(char)(i+'a');
                answer+=a;
            }
        }
        System.out.println(answer);
	}
}
