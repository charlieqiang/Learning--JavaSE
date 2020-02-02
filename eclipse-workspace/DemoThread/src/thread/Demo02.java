/**
 * @author Charlie
 * Feature sell ticket £»½²½â²¢·¢£¡£¡
 */
package thread;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TickerWindow tw = new TickerWindow();
		//TickerWindow tw2 = new TickerWindow();
		//TickerWindow tw3 = new TickerWindow();
		
		Thread t1 = new Thread(tw);
		Thread t2 = new Thread(tw);
		Thread t3 = new Thread(tw);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

}

class TickerWindow implements Runnable{
	 
	private int ticketNum = 2000;
	
	public void run() {
		
		while (true) {
			
			//i think follow should careful
			synchronized (this) {
				if(ticketNum>0) {
					System.out.println(Thread.currentThread().getName()+" "+ticketNum);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ticketNum--;
				}
				else {
					break;
				}
			}
		}			
	}
}