package day0213;

public class LinkedListStack<E> implements IStack<E> {

	private Node<E> top;
	
	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		// top으로 삽입
		top = new Node<E>(e,top);                                                                                                                                                                
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("공백스택이여서 불가능합니다.");
			return null;
		}
		Node<E> popNode = top;
		
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			System.out.println("공백스택이여서 불가능합니다.");
			return null;
		}
		return top.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		for(Node<E> temp= top; temp !=null; temp= temp.link) {
			
		}
		return 0;
	}


}
