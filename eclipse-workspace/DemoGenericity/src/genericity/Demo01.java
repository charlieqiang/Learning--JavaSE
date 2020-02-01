package genericity;

import java.util.ArrayList;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Dog> al = new ArrayList<Dog>();
		
		Dog dog01 = new Dog();
		
		al.add(dog01);
		
		//if not AL<DOG>·ºÐÍthis is a wrong code 
		//and you must hard change
		Dog temp = al.get(0);
	}

}

class Cat{
	private String color;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
	
	
}
class Dog{
	private String name;
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
	private int age;
	
}