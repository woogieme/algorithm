package hw;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw1974_good {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC=Integer.parseInt(br.readLine());

        for(int tc=1; tc<=TC; tc++){
            System.out.print("#"+tc+" ");
            int[][] arr = new int[9][9];
            boolean isFalse=false;

            for (int i = 0; i < 9; i++) {
                StringTokenizer st =new StringTokenizer(br.readLine());
                for (int j = 0; j < 9;j++) {
                        arr[i][j]=Integer.parseInt(st.nextToken());
                }//end for k
            }//end for j

            
            
            //가로비교,세로비교
            for (int i = 0; i < 9; i++) {
            	boolean[] isOk= {true,true,true,true,true,true,true,true,true};
                for (int j = 0; j < 9;j++) {
                    if(isOk[arr[i][j]-1]==false) {
                    	isFalse=true;
                    	break;
                    }
                	isOk[arr[i][j]-1]=false;
                }//end for j
                if (isFalse){
                    break;
                }//end for if
            }//end for i
            if(isFalse){
                System.out.print(0);
                System.out.println();
                continue;
            }
            
            for (int i = 0; i < 9; i++) {
            	boolean[] isOk= {true,true,true,true,true,true,true,true,true};
                for (int j = 0; j < 9;j++) {
                    if(isOk[arr[j][i]-1]==false) {
                    	isFalse=true;
                    	break;
                    }
                	isOk[arr[j][i]-1]=false;
                }//end for j
                if (isFalse){
                    break;
                }//end for if
            }//end for i
            if(isFalse){
                System.out.print(0);
                System.out.println();
                continue;
            }
            
            //숫자
            int[] d1={-1,-1,0,1,1,1,0,-1};
            int[] d2={0,1,1,1,0,-1,-1,-1};
           
            for(int i=1; i<=7; i+=3){
            	
                for(int j=1; j<=7; j+=3){ 
                	boolean[] isOk_2= {true,true,true,true,true,true,true,true,true};
                	isOk_2[arr[i][j]-1]=false;
                	
                    for(int x=0; x<d1.length; x++){
                        int dx=i+d1[x];
                        int dy=j+d2[x];
                        if(isOk_2[arr[dx][dy]-1]==false) {
                        	isFalse=true;
                        	break;
                        }
                     
                        else {
                        	isOk_2[arr[dx][dy]-1]=false;
                        }
                    }
                    if(isFalse){
                        break;
                    }
                }
                if(isFalse){
                    break;
                }
            }
            
            if(isFalse){
                System.out.print(0);
                System.out.println();
                continue;
            }

            System.out.print(1);
            System.out.println();






        }//end for TC
    }
}

