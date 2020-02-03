package file;

import java.io.File;
import java.io.IOException;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new file
		File f = new File("d:\\test.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			System.out.println("exist");
		}
		
		//mkdir
		File d = new File("d:\\test");
		if(f.isDirectory()) {
			System.out.println("exist");
			
		}else {
			f.mkdir();
		}
		
		//get file msg
		File fid = new File("d:\\test");
		if(f.isDirectory()) {
			System.out.println("exist");
			File lists[] = fid.listFiles();
			for(int i=0;i<lists.length;i++) {
				System.out.println("file name:"+lists[i].getName());
				
				
			}
			
		}else {
			fid.mkdir();
		}
	}

}
