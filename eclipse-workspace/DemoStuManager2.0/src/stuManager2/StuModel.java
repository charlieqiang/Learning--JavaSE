package stuManager2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

public class StuModel extends AbstractTableModel{
	//set row and col
	Vector rowData;
	Vector columnNames;
	//about sql
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;

	//
	public void init(String sql) {
		if(sql.equals("")) {
			sql="select * from stu";
		}
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
		
		//get data from sql
		try {
			//
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			//
			ct = DriverManager.getConnection
					("jdbc:microsoft:sqlserver://127.0.0.1:1433;"
							+ "databaseName=spdb1","sa","123456");
			//
			ps = ct.prepareStatement(sql);
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
		
	}
	
	//add
	public void addStu(String sql) {
		//
	}
	
	//constructor
	public StuModel(String sql) {
		// TODO Auto-generated constructor stub
		this.init(sql);

	}
	//constructor
	public StuModel() {
		// TODO Auto-generated constructor stub
		this.init("");
	}
	//how many col
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		//System.out.println(getColumnCount());
		return this.columnNames.size();
	}
	//how mang row
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}
	//get value at sw.
	@Override
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(row)).get(column);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

}
