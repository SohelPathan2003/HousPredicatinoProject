package House.Predict.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;

import House.Predict.Config.DBConfig;

public class DBConnections {
	
	
    protected DBConfig db=DBConfig.getInstance();
    protected Connection conn=db.getConnection();
    protected Statement stmt=db.getSatement();
    protected PreparedStatement pstmt=db.getPreparedStatement();
    protected ResultSet rs=db.getResultSet();	
	
	


}
