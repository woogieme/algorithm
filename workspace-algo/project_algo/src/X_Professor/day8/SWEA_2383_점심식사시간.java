package X_Professor.day8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public abstract class SWEA_2383_점심식사시간 implements Comparable<Person> {
	static int N;
	static final int M=1, W=2,D=3,C=4; //이동 , 대기 , 내려가는중 , 완료
	static int[][] sList;
	static List<Person> pList;
	static int cnt;
	static int[] selected;
	static int ans;
	static class Person{
		int r,c,arrivalTime,downCnt,status;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public void init() {
			arrivalTime = downCnt=0;
			status =M;
		}
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime )
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			N= Integer.parseInt(br.readLine());
			pList = new ArrayList<Person>();
			sList = new int[2][];
			
			StringTokenizer st =null;
			for (int i = 0,k=0; i < N; i++) {
				st =new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int c = Integer.parseInt(st.nextToken());
					if(c==1) {
						pList.add(new Person(i,j));
					}else if(c>1) {
						sList[k++]=new int[]  {i,j,c};
					}
					
				}
			}
			cnt= pList.size();
			selected = new int[cnt];
			divide(0);
			System.out.println("#"+" "+tc+" "+ans);
		}
		
	}
	static void divide(int index) {
		if(index==cnt) {
			int res= go();
			if(ans>res) ans=res;
			return;
		}
		selected[index]=0;
		divide(index+1);
		selected[index]=1;
		divide(index+1);
	}
	private static int go() {
		ArrayList<Person>[] list = new ArrayList[] { new ArrayList<Person>(),new ArrayList<Person>()};
		
		for (int i = 0; i < cnt; i++) {
			Person p  = pList.get(i);
			p.init();
			p.arrivalTime = Math.abs(p.r-sList[selected[i]][0] + Math.abs(p.c -sList[selected[i]][1]));
			list[selected[i]].add(p);
		}
		
		int timeA=0,timeB=0;
		if(list[0].size()>0) {
			processDown(list[0], sList[0][2]);
		}
		if(list[1].size()>0) {
			processDown(list[1], sList[1][2]);
		}
		return timeA>timeB ? timeA:timeB;
		
	}
	static int processDown(ArrayList<Person> list, int height) {
		Collections.sort(list); //계단 입구까지 도착시간이 빠른 순으로 정렬
		int time = list.get(0).arrivalTime; //먼저 도착한 사람의 시간부터 흘러가게 함 
		int size = list.size();
		
		int ingCnt=0, cCnt=0; //내려가는 사람수, 완료 사람수
		Person p = null;
		while(true) {
			for (int i = 0; i < size; i++) {
				p=list.get(i);
				
				if(p.status==C) {
					continue;
				}else if (p.arrivalTime==time) {
					p.status = W;
				}else if(p.status== W && ingCnt <3) {
					p.status=D;
					p.downCnt=1;
					ingCnt++;
				}else if(p.status==D) {
					if(p.downCnt==height) {
						p.status=C;
						ingCnt--;
						cCnt++;
					}else{
						p.downCnt++;
					}
				}
			}
			if(cCnt==size) {
				break;
				time+=1;
			}
		}
		return time;
	}
}
