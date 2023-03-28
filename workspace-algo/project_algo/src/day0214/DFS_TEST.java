package day0214;

public class DFS_TEST {
	public static void main(String[] args) {
		dfsTest(1);
	}

	private static void dfsTest(int i) {
		// TODO Auto-generated method stub
		if(i>10) {
			return;
		}
		System.out.println(i);
		dfsTest(i*2);
		dfsTest(i*2+1);
	}
}
