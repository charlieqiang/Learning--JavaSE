package exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.check file 
		FileReader fr = null;
		//2.connect
		//Socket s = new Socket("192.168.1.1",78);
		
		try {
			fr = new FileReader("D:\\test.txt");
			Socket s = new Socket("192.168.1.1",78);
		} catch (FileNotFoundException e01) {
			// TODO: handle exception
			e01.printStackTrace();
			
		} catch (Exception e02) {
			// TODO: handle exception
			e02.printStackTrace();
		} finally {
			
			if (fr!=null) {
				try {
					fr.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			System.out.print("final");
		}
		
		System.out.print("haha");
	
	}
	

}
