package genericity;

import java.lang.reflect.Method;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bird b = new Bird();
		
		//里面放一个实例
		Gen<Bird> gen1 = new Gen<Bird>(new Bird());
		//Gen<Integer> gen2 = new Gen<Integer>(); whycant?
		
		
		
		gen1.showTypeName();
	}

}

//
class Bird{
	public void speak() {
		System.out.println("jj");
		
	}
	
	public void count(int a,int b) {
		System.out.println(a+b);
 
	}
}
//define a class
class Gen<T>{
	private T o;
	
	public Gen(T a) {
		
		o=a;
		
	}
	public void showTypeName() {
		System.out.println("type:"+o.getClass().getName());
		
		//throught feedback we can get a lot of msg!
		Method []m = o.getClass().getDeclaredMethods();
		//print
		for(int i=0;i<m.length;i++) {
			System.out.println(m[i].getName());
		}
	}
	
	
}