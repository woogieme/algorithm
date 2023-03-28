package day0214;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class CompleteBinaryTree<T> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	public CompleteBinaryTree(int size) {
		
		nodes = new Object[size+1];
		SIZE = size;
	}
	private boolean isFull() {
		return lastIndex ==SIZE;
	}
	public void add(T e) {
		
		if(isFull()) {
			return;
		}
		nodes[++lastIndex]=e;
	}
	public void dfs() {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(1); // 루트노드부터
		int current=0,size=0,level=0;
		while(!stack.isEmpty()) {
				current = stack.pop(); // 현재 탐색해야하는 노드 번호
				System.out.print(nodes[current]+"\t");
				//현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
				//완전 이진 트리 : 자식이 최대 2
				
				if(current*2+1<=lastIndex) stack.push(current*2+1);
				//왼쪽자식
				if(current*2<=lastIndex) stack.push(current*2);
				//오른쪽자식
		
		}
	}
	
	public void bfs1() {
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); // 루트노드부터
		int current=0,size=0,level=0;
		while(!queue.isEmpty()) {
			size= queue.size();
			System.out.print("levle+ "+level+":");
			while(--size>=0) {
				current = queue.poll(); // 현재 탐색해야하는 노드 번호
				System.out.print(nodes[current]+"\t");
				//현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
				//완전 이진 트리 : 자식이 최대 2
				
				//왼쪽자식
				if(current*2<=lastIndex) queue.offer(current*2);
				//오른쪽자식
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
				
			}
			level++;
			System.out.println();
			//current=queue.poll();
			//System.out.println(nodes[current]);
		
		}
	}
	void bfs() {
		
	}
	public void dfsByPreOrder() {
		System.out.println("PreOrder: ");
		dfsByPreOrder(1);
		System.out.println();
	}
	public void dfsByPreOrder(int current) {
		System.out.print(nodes[current]+"\t");
		//현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
		//완전 이진 트리 : 자식이 최대 2
		
		//왼쪽자식
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		//오른쪽자식
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	public void dfsByInOrder() {
		System.out.println("InOrder: ");
		dfsByInOrder(1);
		System.out.println();
	}
	public void dfsByInOrder(int current) {
		
		//현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
		//완전 이진 트리 : 자식이 최대 2
		
		//왼쪽자식
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		System.out.print(nodes[current]+"\t"); 
		//오른쪽자식
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
	}
	public void dfsByPostOrder() {
		System.out.println("PostOrder: ");
		dfsByPostOrder(1);
		System.out.println();
	}
	public void dfsByPostOrder(int current) {
		
		if(current>lastIndex) return;
		dfsByPostOrder(current*2);
		dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+"\t"); 
	}
}

