/**
 * @Description JDBC
 * @author Charlie
 * @date 2020-02-04 13:08
 */
package sql;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Demo01 {
	
	
	public static void main(String[] args) {
		Connection ct = null;
		Statement sm=null;
		// TODO Auto-generated method stub
		try {
			//1.load driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//2.get con
			ct = DriverManager.getConnection("jdbc:odbc:mydb");
			//3.sent msg
			sm = ct.createStatement();
			//----
			//1.
			//exect..cud
			int res=sm.executeUpdate("insert into dept values(20,'accounting','dallas')");
			if(res==1) {
				System.out.println("ok");
			}else {
				System.out.println("no");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			
			try {
				//for stronger
				if(sm!=null) {
					sm.close();
				}
				if(ct!=null) {
					ct.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}


}
