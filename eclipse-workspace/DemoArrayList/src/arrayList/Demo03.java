/**
 * @author Charlie
 * msg:It`s about LinkedList.
 */
package arrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class Demo03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		LinkedList ll = new LinkedList();
		
		Emp emp01 = new Emp("172","song",100);
		Emp emp02 = new Emp("173","wu",120);
		
//		ll.addFirst(emp01);//this is a zhan! not duilie!
//		ll.addFirst(emp02);
//		ll.removeAll(ll);
//		for(int i=0;i<ll.size();i++) {
//			System.out.println(i+1+":"+((Emp)ll.get(i)).getName());
//		}
		
//		Vector vv = new Vector();
//		vv.add(emp01);
//		
//		Stack stack = new Stack();
		
		HashMap hm = new HashMap();
		
		hm.put("172", emp01);
		hm.put("173", emp02);
		
		if(hm.containsKey("173")) {
			System.out.println("ok");
			
			Emp emp = (Emp)hm.get("173");
			
			System.out.println("name:"+emp.getName());
			
		}else {
			System.out.println("no");
			
		}
		//µü´úÆ÷
		Iterator it = hm.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next().toString();
			//get value
			Emp emp = (Emp)hm.get(key);
			System.out.println("sal:"+emp.getSal());
		}
		
		
	}

}
