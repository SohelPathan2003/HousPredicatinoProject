package House.Predict.Repository;


import House.Predict.Config.*;
import java.sql.*;
import java.util.ArrayList;

import House.Predict.Model.AminityModel;
import House.Predict.Model.PropertyModel;
import House.Predict.Model.SquareFeetModel;
import House.Predict.Model.historicalpropertyprice;
public class SquareFeetRepository  extends DBConnections{
	int b;
	int id=0;
	int pid=0;
	public boolean isAddSquareFeet(SquareFeetModel sfm) throws SQLException {
		
		pstmt=conn.prepareStatement("insert into squarefeet values('0',?)");
		pstmt.setInt(1,sfm.getSquarefeet());
		b=pstmt.executeUpdate();
		
		
		if(b>0)
		return true;
		else
			return false;
		
	}
	
	
	public int getAreaId(String aname) throws SQLException{
		
		pstmt=conn.prepareStatement("select aid from areamaster where aname=?");
		pstmt.setString(1,aname);
		rs=pstmt.executeQuery();
		while(rs.next()) {
		id= rs.getInt(1);
		}
		return id;
		
	}
	
	public int getSquareFeetId(int sqf)throws SQLException {
		pstmt=conn.prepareStatement("select squareid from squarefeet where sqfeet=?");
		pstmt.setInt(1,sqf);
		rs=pstmt.executeQuery();
		while(rs.next()) {
			id=rs.getInt(1);
		}
		return id;
		
	}
	
	
	public boolean isAddAminity(AminityModel aminitymodel)throws SQLException {
		
		pstmt=conn.prepareStatement("insert into aminities values('0',?)");
	    pstmt.setString(1,aminitymodel.getAminityName());
	    
	    b=pstmt.executeUpdate();
	    if(b>0)
	    	return true;
	    else
	    	return false;
	}
	
	
	public int getAminityId(String aminityname) throws SQLException{
		pstmt=conn.prepareStatement("select aminityid from aminities where aminityname=?");
		pstmt.setString(1,aminityname);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}else {
			return 0;
		}
	}
	
	public int getPropertyAutoId()throws SQLException {
	     
		pstmt=conn.prepareStatement("select max(pid)from propertymaster");
		rs=pstmt.executeQuery();
		if(rs.next()) {
			pid=rs.getInt(1);
			return ++pid;
					
		}
		return ++pid;
	}
	public boolean AddPropertyModel( PropertyModel pm,historicalpropertyprice hpp) throws SQLException{
		
		pid=this.getPropertyAutoId();
		System.out.println("pid\tpaddress\tsquarefeetId\tcityid\tareaid\tnbath\tnbed");
		
		System.out.println(pid+"\t"+pm.getPaddress()+"\t"+pm.getSquarefeetmodel().getSquareId()+"\t\t\t"+pm.getAreamastermodel().getCityId()+"\t"
		+pm.getAreamastermodel().getAreaId()+"\t"+pm.getNbath()+"\t"+pm.getNbed());
		
		
		System.out.println("-----------------------------------------------------------------\n\n\n");
		
		
		
		pstmt=conn.prepareStatement("insert into propertymaster values(?,?,?,?,?,?,?)");
		pstmt.setInt(1,pid);
		pstmt.setString(2,pm.getPaddress());
		pstmt.setInt(3,pm.getSquarefeetmodel().getSquareId());
		pstmt.setInt(4,pm.getAreamastermodel().getAreaId());
		pstmt.setInt(5,pm.getAreamastermodel().getCityId());
		pstmt.setInt(6,pm.getNbed());
		pstmt.setInt(7,pm.getNbath());
		b=pstmt.executeUpdate();
		if(b>0) {
			for(Integer am:pm.getList()) {
			
			pstmt=conn.prepareStatement("insert into propertyaminityjoin values(?,?);");
			pstmt.setInt(1,pid);
			pstmt.setInt(2,am);
			pstmt.executeUpdate();
			
			}
			pstmt=conn.prepareStatement("insert into registry values('0',?,?,(select curdate()))");
			pstmt.setInt(1,pid);
			pstmt.setInt(2,hpp.getPrice());
			pstmt.executeUpdate();
			return true;
		}else {
			return false;
		}
		
		
		
		
		
		
	}

}
