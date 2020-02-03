/**
 * @author Charlie
 * Feature btyeflow
 */
package file;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			int n=0;

			fr = new FileReader(".//src//test01.txt");
			fw = new FileWriter(".//src//test02.txt");
			
			//input
			char c[] = new char[1024];
			while ((n=fr.read(c))!=-1) {
				
				String s = new String(c,0,n);
//				System.out.println(s);
//				//
//				System.out.println(c);
				fw.write(c,0,n);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fr.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}

}
