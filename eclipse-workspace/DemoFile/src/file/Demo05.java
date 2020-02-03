/**
 * @author Charlie
 * 字符流
 * 
 */
package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		//1.new fileReader first
		FileReader fr;
		FileWriter fw;
		try {
			fr = new FileReader(".\\src\\test01.txt");			
			fw = new FileWriter(".\\src\\test03.txt");
			
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);
			//
			String s = "";
			while((s=br.readLine())!=null) {
				//System.out.print(s);
				bw.write(s+"\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

}
