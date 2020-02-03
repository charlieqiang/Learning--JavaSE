/**
 * @author Charlie
 * copy img
 */
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		//
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(".//src//shoes.jpeg");
			fos = new FileOutputStream(".//src//test01.jpeg");
			//cache
			byte buf[] = new byte[512];
			int n=0;
			while ((n=fis.read(buf))!=-1) {
				fos.write(buf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//
			
			try {
				fos.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
