package stuManaMV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.AbstractAction;
import javax.swing.table.AbstractTableModel;

public class StuModel extends AbstractTableModel{
	//set row and col
	Vector rowData;
	Vector columnNames;

	//add stu
	public boolean updStu(String sql,String []paras) {
		
		//new a sql helper(didnt care 并发！，if must make sqlhelper into static)
		SqlHelper sh = new SqlHelper();
		return sh.updExecute(sql, paras);
		
	}
	//query
	public void queryStu(String sql,String []paras) {
		//
		SqlHelper sh = null;
		//newed
		columnNames = new Vector();
		
		//col
		columnNames.add("学号");
		columnNames.add("名字");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData = new Vector();
		//get data from sql
		try {
			sh=new SqlHelper();
			ResultSet rs=sh.queryExectue(sql,paras);
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
			sh.close();
		}	
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
