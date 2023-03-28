package X_programmers;

import java.util.ArrayList;

public class 옹알이 {
    public ArrayList<String> store = new ArrayList<>();

    public String[] text = new String[]{"aya", "ye", "woo", "ma"};
    public String[] index;
    public boolean[] checked = new boolean[]{false, false, false, false};
    public static void main(String[] args) {
		옹알이 s1 = new 옹알이();
		String[] babbling= {"aya", "yee", "u", "maa", "wyeoo"};
		System.out.println(s1.solution(babbling));
	}
    public int solution(String[] babbling) {
        int answer = 0;
        for (int i = 1; i <= text.length; i++) {
            index = new String[i];
            param(text, index, checked, 0);
        }
        for (String s : babbling
        ) {
            if (store.contains(s)) {
                answer += 1;
            }
        }
        return answer;
    }

    public void param(String[] text, String[] index, boolean[] checked, int idx) {
        if (idx >= index.length) {
            String str = "";
            for (String s : index
            ) {
                str += s;
            }
            store.add(str);
            return;
        }
        for (int i = 0; i < text.length; i++) {
            if(checked[i]) continue;
            index[idx] = text[i];
            checked[i] = true;
            param(text, index, checked, idx + 1);
            checked[i] = false;
        }
    }
}