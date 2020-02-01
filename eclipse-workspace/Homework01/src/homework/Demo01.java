/**
 * @author Charlie
 * 
 * 跳水比赛
 * 打分功能:去头去尾求平均
 */

package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Judge judge = new Judge();
		System.out.println(judge.lastFen());
	}

}

class Judge{
	float fens[]=null;
	//float a = 1.3f;
	
	int size=5;
	
	public Judge() {
		fens=new float[size];
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
			try {
				for(int i=0;i<fens.length;i++)
				{
					System.out.println("plz input"+(i+1)+"goal");
					fens[i]=Float.parseFloat(br.readLine());
				}
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
	}
	
	//get goal
	public float lastFen() {
		//1.pass max(find index)

		//2.pass min
		
		//3.get max
		//float lastFen=0;
		float allFen=0;
		int minIndex=this.getLowFenIndex();
		int maxIndex=this.getHightFenIndex();
		for(int i=0;i<fens.length;i++)
		{
			if(i!=minIndex&&i!=maxIndex)
			{
				allFen+=fens[i];
			}
		}
		
		return allFen/(fens.length-2);
	}
	public int getLowFenIndex() {
		float minFen=fens[0];
		int minIndex=0;
		for(int i=1;i<fens.length;i++) {
			if(minFen>fens[i]) {
				minFen=fens[i];
				minIndex=i;
				
			}
		}
		return minIndex;
	}
	public int getHightFenIndex() {
		float maxFen=fens[0];
		int maxIndex=0;
		for(int i=1;i<fens.length;i++) {
			if(maxFen<fens[i]) {
				maxFen=fens[i];
				maxIndex=i;
				
			}
		}
		return maxIndex;
	}
}