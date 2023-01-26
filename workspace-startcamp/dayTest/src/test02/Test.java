package test02;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
			Student[] student = new Student[5];
			student[0] = new Student("정재욱",3.7);
			student[1] = new Student("김싸피",3.3);
			student[2] = new Student("김성은",4.2);
			student[3] = new Student("지은미",4.0);
			student[4] = new Student("김성은",4.2);
			
			System.out.println(student[2].equals(student[4]));
			Arrays.sort(student);
			for (int i = 0; i < student.length; i++) {
				System.out.println(student[i].name);
			}
	}
}
