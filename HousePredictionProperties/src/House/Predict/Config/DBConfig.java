package House.Predict.Config;

import java.util.Properties;
import java.io.*;
import static java.lang.System.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class DBConfig extends PathHelper {  // PathHelper class call automatically when DBConfig object
	              // get created because PathHelper contain one default constructor
	
	private static Connection conn=null;
	private static PreparedStatement pstmt=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	private static DBConfig db=null;
	
	private DBConfig()  throws IOException{
		
		
		
		 Properties p=new Properties();
		 try {
			p.load(filereader);
		   // we have to handle IOException for load the file
		String driver=p.getProperty("driver");
		String url=p.getProperty("url");
		String password=p.getProperty("password");
		String username=p.getProperty("username");
		
		
			
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
			
			
		}catch(Exception ex) {
			out.println("erro is "+ex);
		}
		
		
	}   // DBConfig Constructor end;
	
	
	public static DBConfig getInstance()  {
		if(db==null)
			try {
				db=new DBConfig();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return db;
		
	}
	
	    public Connection getConnection() {
		   return conn;
	   }
	   public PreparedStatement getPreparedStatement() {
		   return pstmt;
	   }
	   public Statement getSatement() {
		   return stmt;
	   }
	   public ResultSet getResultSet() {
		   return rs;
	   }
	
	
	

}


