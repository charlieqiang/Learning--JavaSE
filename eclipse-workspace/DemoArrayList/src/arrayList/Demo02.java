package arrayList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Demo02 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		EmpManage em = new EmpManage();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("plz choose");
			
			String operType = br.readLine();
			
			if(operType.equals("1")) {
				System.out.println("plz input id");
				String empNo = br.readLine();
				String name = "song";
				float sal = 1100;
				Emp emp = new Emp(empNo,name,sal);
				
				em.addEmp(emp);
				
				em.showInfo(empNo);
				
				break;
				
			}
		}
	}

}

class EmpManage{
	private ArrayList al = null;
	
	public EmpManage(){
		al = new ArrayList();
		
	}
	
	public void addEmp(Emp emp) {
		al.add(emp);
		
	}
	
	//display emp message
	public void showInfo(String empNo) {

		for(int i=0;i<al.size();i++) {
			Emp emp =(Emp)al.get(i);
			
			if(emp.getEmpNo().equals(empNo)) {
				System.out.println("his msg:"+emp.getName());
				break;
			}
		}
	}
	
	//modify sal
	public void updateSal(String empNo,float newSal) {
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			if (emp.getEmpNo().equals(empNo)){
				emp.setSal(newSal);
			}
		}
	}

	//delete emp
	public void delEmp(String empNo) {
		for(int i=0;i<al.size();i++) {
			Emp emp = (Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo)) {
				al.remove(i);
			}
		}
	}
}

class Emp{
	private String empNo;
	private String name;
	private float sal;
	
	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}
	
	public Emp(String empNo,String name,float sal) {
		
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
		
	}
	
}