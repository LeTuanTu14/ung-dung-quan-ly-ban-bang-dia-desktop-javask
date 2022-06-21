package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_DB {
		private static Connection_DB db=null;
		private  Connection con=null;
		private Connection_DB()
		{
			
		}
		
		public  Connection connect() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url="jdbc:sqlserver://localhost:1433;databaseName=JAVA_QLBangDia";
			con=DriverManager.getConnection(url, "sa", "sapassword");
			System.out.println("Connect");
			return con;
			
		}
		public void disConnect() throws SQLException
		{
			System.out.println("Disconnect");
				con.close();
		}

		public static Connection_DB getDb() {
			if(db==null)
			{
				db=new Connection_DB();
			}
			return db;
		}
		
		
}
