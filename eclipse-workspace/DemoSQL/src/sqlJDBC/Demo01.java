package sqlJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Description JDBC-SQL
 * @author Charlie
 * @date 2020-02-06 21:32
 */
import javax.naming.spi.DirStateFactory.Result;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		Connection ct=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
			ct=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=LiangShanHeros","sa","123456");
			ps=ct.prepareStatement("select HeroName,sex from heros");
			
			rs=ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String sex = rs.getString(2);
	
				System.out.println(name+""+sex);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
