package arrayList;

import java.util.*;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 
		ArrayList al = new ArrayList();
		//
		System.out.println("size:"+al.size());
	
		Clerk clerk = new Clerk();
		
		al.add(clerk);
		
		System.out.println("size:"+al.size());
		
		
	}

}

class Clerk{
	private String name;
	private int age;
	private float sal;
	
	public Clerk (String name,int age,float sal) {
		this.name=name;
		this.age=age;
		this.sal=sal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	
	
}
