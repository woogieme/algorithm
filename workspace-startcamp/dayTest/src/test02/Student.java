package test02;

public class Student implements Comparable<Student>{
	String name;
	double grade;
	
	Student(String name, double grade) {
		this.name = name;
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {
		System.out.println("비교!!");
		if(this.grade>o.grade) {
			return 1;
		}
		else if(this.grade<o.grade){
			return -1;
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.grade == ((Student)obj).grade && this.name.equals(((Student)obj).name))
			return true;
		return false;
	}
}
