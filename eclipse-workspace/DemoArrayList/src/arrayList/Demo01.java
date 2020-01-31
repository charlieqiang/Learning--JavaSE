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
	
}
