package X_programmers;

public class 다항식더하기2 {
	public static void main(String[] args) {
		String polynomial="13x + 7 + x";
		String answer="";
		int k=0;
		int count=0;
		String[] split = polynomial.split(" ");
		for (int i = 0; i < split.length; i+=2) {
			if(split[i].contains("x")) {
				String[] strings = split[i].split("");
				if(strings.length==1) {
					count+=1;
				}
				for(String str :strings) {
					if(!str.equals("x")) {
						count+=Integer.parseInt(str);
					}
				}
			}
			else {
				k+=Integer.parseInt(split[i]);
			}//else end
		}//for end
		
		
		if(count!=0) {
			if(count==1){
				answer+="x";
			} else {
				answer+=count+"x";
			}
			if(k!=0) {
				answer+= " + "+k;
			}
		}else {
			answer+=k;
		}
		System.out.println(answer);
		
		
	}

}
