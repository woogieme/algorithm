package day0116;

import java.util.Arrays;

public class Test01 {
	public static void main(String[] args) {
		int num=0; //갈색은 지역변수이기때문에 초기값을 넣어주지않으면 오류가 생김 
		int[] nums= new int[1];
		//대입연산을 꼭 해줘야 사용할수있음
		//지역변수는 실제 저장되는곳은 Stack 영역
		//참조변수는 실제 저장되는 곳은 Heap 영역 [초기값은 0 , null, false]
		//참조변수는 자동초기화해줌 [기본값이 알아서 들어가줌]
		System.out.println(num); //초기화(대입)을 하지않으면 출력조차 할 수 없음. 아예 컴파일 오류남.
		System.out.println(nums[0]); 
		////////////////////////////////
		int[] arr= {1,2,3};
		
		//old for - 범위연산할때
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	 // arr의 0,1,2의 인덱스에 접근하는방법
		}
		System.out.println();
		
		//for-each - 전체를 쭉 읽을때 사용하는것임  [읽기만 가능함, 홀수-짝수 처럼 구분해서 할수없음] - 쓸모없음.,문법이 짧ㅅ아서 편해서 씀 
		for(int n : arr) {
			System.out.print(n+" ");			// n이라는 변수를 만들어 arr의 0,1,2의 인덱스를 넣어주는 방법
			n+=100;								// 이렇게해도 n만 바뀌는것이지 arr의 인덱스가 바뀌는것이 아님
		}
		System.out.println();
		///////////////////////////////////////////
		int[] arr2= {7,8,9};
		//int[] arr3=arr2; //얕은복사(배열객체는 하나인데 두 참조변수가 공유하는 상황) :arr3 건드리면 arr2도 결국 훼손됨.
		int [] arr3=Arrays.copyOf(arr2, arr2.length); //아예 배열을 생성해서 값을 옮겨담는 복사 
													  //
		arr3[0]=999;
		System.out.println(Arrays.toString(arr2)); // 똑같은 참조변수이기때문에 값이 똑같이 변해감 , 나눠지는게 아님
		//값은 그냥 반복문 통해서 옮겨담는게 편하다.
		///////////////////////////////////////////////////////////////////////////
		int[][] arr4=new int[3][];
		int count=3;
		
		for (int i = 0; i < arr4.length; i++) {
			arr4[i]=new int[count];
			count+=1;
		}
		for (int i = 0; i < arr4.length; i++) {
			for (int j = 0; j < arr4.length; j++) {
				System.out.print(arr4[i][j]);
			}
			System.out.println();
		}
		System.out.println(arr4[2][3]);
		
	}
}
