package programmers;

public class charaterPos {
	public static void main(String[] args) {
		String[] keyinput= {"up", "up", "up", "down"};
		int[] board = {3,3};
		int[] answer = {0,0};
    	int x=board[0]/2;
        int y=board[1]/2;
        for(int i=0; i<keyinput.length; i++){
            if(keyinput[i].equals("left")){
                if(answer[0]>=-x){
                	if(answer[0]==-x)continue;
                    answer[0]-=1;
                }
            }else if(keyinput[i].equals("right")){
                if(answer[0]<=x){
                	if(answer[0]==x)continue;
                    answer[0]+=1;
                }
            }else if(keyinput[i].equals("up")){
                if(answer[1]<=y){
                	if(answer[1]==y)continue;
                    answer[1]+=1;
                }
            }else if(keyinput[i].equals("down")) {
                if(answer[1]>=-y){
                	if(answer[1]==-y)continue;
                    answer[1]-=1;

                }
            }
        }
	        System.out.println(answer[0]+" : "+answer[1]);
	}
}
