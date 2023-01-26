package day0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException {
//		예외가 발생할 가능성이 있긴 하지만 컴파일러가 굳이 예외처리 코딩을 강요하지는 않음(선택사항)		
//		Scanner sc = new Scanner(System.in);
//		int input =sc.nextInt();
//		System.out.println("입력하신 숫자: "+input);
////////////////////////////////////////////////////////////////
//		예외가 발생할 가능성이 있는 문장에 대해 반드시 예외처리 코딩 하라고 컴파일러가 빨간줄 그으면서 강요함(필수사항)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//ver1 : 빨간줄 그어지는 곳에 try-catch 해주기
		String line = null;
		try { //예외 발생 가능성이 있는 문장을 try로 묶어서 직접(부지런하게) 예외상황에 대한 코딩하기.
			line = br.readLine();
		} catch (IOException e) { 
			// CATCH블럭은 조건문이나 마찬가지임. 예외가 발생하고 안하고에 따라 실행될 수도 안될수도 있음.
			e.printStackTrace();
		}
		
		//ver 2: 에라 모르겠다 난 그냥 집어던질래 (무책임하게)
		line =br.readLine();
		
		//ver1번이면 예외에 대한 처리를 catch에서 했으니 그 아래 문장은 이어서 실행됨.
		//ver2번이면 예외 발생 문장에서 현재 메소드 때려쳐버림. 아래 문장 실행 X.
		System.out.println("입력한 내용"+line);
	}
}
