/**
 * @author Charlie
 * Feature write and read
 */
package file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String so = "hello\r\ncharlie";
		String si = null;
		File f= new File("d:\\test.txt");
		FileInputStream fis = null;		
		FileOutputStream fos = null;		
		try {
			
			fos = new FileOutputStream(f);
			fis = new FileInputStream(f);
			
			byte []bytes = new byte[1024];
			
			//String->byte
			fos.write(so.getBytes());
			
			int n=0;
			
			while ((n=fis.read(bytes))!=-1) {
				si = new String(bytes,0,n);
				System.out.println(si);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fis.close();
				fos.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
