package programmers;

public class aeiouDelete {
	public static void main(String[] args) {
	String my_string="bus";
	char[] array=my_string.toCharArray();
    String answer = "";
    for (int i=0; i<my_string.length(); i++){
            if (array[i]==('a') ||array[i]==('e') ||array[i]==('u')|| array[i]==('o')||array[i]==('i')){
                continue;
            }
        answer+=String.valueOf(array[i]);
    
    }
    System.out.println(answer);
	}
}
