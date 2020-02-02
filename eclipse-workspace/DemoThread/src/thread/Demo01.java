/**
 * @author Charlie
 * Feature sell ticket
 */
package thread;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cat cat = new Cat();
		Dog dog = new Dog();
	
		Thread t = new Thread(dog);
		
		t.start();
		cat.start();
		
	}

}

class Cat extends Thread{
	int i = 0;
	public void run() {
		
		while(true)
		{
			try {
				//if sleep go to blocked
				Thread.sleep(1000);
				System.out.println(i);
				i++;
				
				if(i>10)
				{
					break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class Dog implements Runnable
{
	int i=0;
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			i++;
			System.out.println(i+"wang");
			
			if(i>10)
			{
				break;
			}
		}	
	}
}