package com.ssafy.h_fileio.io.process.object;

import java.io.Serializable;
//TODO: Person 을 직렬화 가능하도록 처리하시오.
public class Person implements Serializable{
	
	//private static final long serialVersionUID = 6640500874707651002L;
	
	
	private String id;
	private transient String pass;

	public Person(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", pass=" + pass + "]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}

