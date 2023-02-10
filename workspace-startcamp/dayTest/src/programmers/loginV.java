package programmers;

public class loginV {
	public static void main(String[] args) {
		String[] id_pw= {"programmer01", "15789"};
		String[][] db= {{"programmer02", "111111"},{"programmer00", "134"},{"programmer01", "1145"}};
		String answer="";
		for (int i = 0; i < db.length; i++) {
			if(id_pw[0].equals(((db[i][0]))) && id_pw[1].equals(((db[i][1])))) {
				answer="login";
				break;
			}
			else if (id_pw[0].equals(((db[i][0])))) {
				answer="wrong pw";
			}
			else if (!(id_pw[0].equals(((db[i][0])))) &&(!(id_pw[0].equals(((db[i][0])))))) {
				if(answer.equals("wrong pw")) {
					continue;
				}
				else {
					answer="fail";
				}
			}
			
		}
		System.out.println(answer);
		
		
		
	}
}
