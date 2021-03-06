/**
 * @Description stumanager with db
 * @author Charlie
 * @date 2020-02-06 22:39
 */
package stuManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Demo01 extends JFrame{
	//set row and col
	Vector rowData,columnNames;
	//about view
	JTable jt=null;
	JScrollPane jsp=null;
	//about sql
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Demo01 d01 = new Demo01();
	}

	//constructor 
	public Demo01() {
		//newed
		columnNames = new Vector();
		rowData = new Vector();
		//col
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		
		//get data    from sql
		try {
			//
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//
			ct = DriverManager.getConnection
					("jdbc:microsoft:sqlserver://127.0.0.1:1433;"
							+ "databaseName=spdb1","sa","123456");
			//
			ps = ct.prepareStatement("select * from stu");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getInt(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				//System.out.println(rs.getString(6));
				rowData.add(hang);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ct!=null) {
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
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
