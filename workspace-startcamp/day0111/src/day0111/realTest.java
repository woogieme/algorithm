package day0111;

public class realTest {
	public static void main(String[] args) {
		String my_string="abcdef";
		String letter="f";
		String answer = "";
		
        for(int i=0; i<my_string.length(); i++){
        	  	
            if (String.valueOf(my_string.charAt(i))!=letter){
            	
                answer+=String.valueOf(my_string.charAt(i));
                
            }
    
        }
	}

}
