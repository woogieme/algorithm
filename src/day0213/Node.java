package day0213;

public class Node<T> {
	
	T data;
	Node link;
	public Node(T data, Node<T> link) {
		// TODO Auto-generated constructor stub
		super();
		this.data =data;
		this.link = link;
	}
	public Node(T data) {
		// TODO Auto-generated constructor stub
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	

}
