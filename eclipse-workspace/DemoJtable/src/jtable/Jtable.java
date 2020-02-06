/**
 * @Description jtable
 * @author Charlie
 * @date 2020-02-06 22:39
 */
package jtable;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Jtable extends JFrame{
	//set row and col
	Vector rowData,columnNames;
	//
	JTable jt=null;
	JScrollPane jsp=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jtable jta = new Jtable();
		
		
		
	}
	
	//
	public Jtable() {
		columnNames = new Vector();
		//col
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		//
		rowData = new Vector();
		Vector hang = new Vector();
		hang.add("sp001");
		hang.add("孙悟空");
		hang.add("男");
		hang.add("500");
		hang.add("花果山");
		hang.add("少林派");
		
		//加入到rowData
		rowData.add(hang);
		
		//init JTable
		jt = new JTable(rowData,columnNames);
		//init jsp
		jsp = new JScrollPane(jt);
		//add jsp into jframe
		this.add(jsp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
		
	}

}
