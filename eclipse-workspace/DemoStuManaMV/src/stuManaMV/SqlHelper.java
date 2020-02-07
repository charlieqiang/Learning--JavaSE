/**
 * @Description stumanager5.0
 * dao sqlhelper
 * @author Charlie
 * @date 2020-02-07 10:39
 */
package stuManaMV;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlHelper {

	//about sql
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	//sql msg
	String url = "jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=spdb1";
	String user = "sa";
	String passwd = "123456";
	String driver = "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	
	//close
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//query
	public ResultSet queryExectue(String sql) {
		
		try {
			//
			Class.forName(driver);
			//
			ct = DriverManager.getConnection(url,user,passwd);
			//
			ps = ct.prepareStatement(sql);
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			//不能this.close();
		}
		
		return rs;
	}
	//query
	public ResultSet queryExectue(String sql,String[] paras) {
		
		try {
			//
			Class.forName(driver);
			//
			ct = DriverManager.getConnection(url,user,passwd);
			//
			ps = ct.prepareStatement(sql);
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			//this.close();
		}
		
		return rs;
	}
	
	//upd
	public boolean updExecute(String sql,String[] paras) {
		boolean b=true;
		//get data from sql
		try {
			//
			Class.forName(driver);
			//
			ct = DriverManager.getConnection(url,user,passwd);
			
			ps = ct.prepareStatement(sql);
			//参数注入
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
			}
			//run  
			if(ps.executeUpdate()!=1) {
				b=false;
			}
			
		} catch (Exception e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} finally {
			this.close();
			
		}
		
		return b;
	}
}
