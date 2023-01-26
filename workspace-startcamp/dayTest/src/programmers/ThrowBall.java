package programmers;

public class ThrowBall {
    public static void main(String[] args) {
    	int[] numbers= {1,2,3,4,5,6};
    	int k =5;
        int count =1;
        int answer=0;
        int idx=0;
        while(count!=k){
            if (idx+2<numbers.length){
                count+=1;
                idx+=2;
                answer=numbers[idx];
            }
            else{
                if (idx+2==numbers.length+1){
                    idx=1;
                    count+=1;
                    answer=numbers[idx];
                }//end for if
                else{
                    idx=0;
                    count+=1;
                    answer=numbers[idx];
                }//end for else
            }//end for else
        }
        System.out.println(answer);
    }
}
