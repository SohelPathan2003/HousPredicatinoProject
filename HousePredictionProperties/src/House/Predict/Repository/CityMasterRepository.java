package House.Predict.Repository;
import House.Predict.Config.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.io.*;
import House.Predict.Model.*;
import java.sql.*;

public class CityMasterRepository extends DBConnections {
	
	private int areaId=0;
	 LinkedHashMap lhm;

	  public boolean isAddCity(CityMasterModel citymastermodel) throws SQLException {
		   
//		   int cid=citymastermodel.getCityId();
		   String cname=citymastermodel.getCityName();
		   System.out.println(cname);
		   
		   pstmt=conn.prepareStatement("insert into cityMaster values('0',?)");
		   pstmt.setString(1,cname);
		  boolean b= pstmt.execute();
		  if(!b)
			  return true;
		  else
			  return false;
	  }
	  
	  
	  
	  public List<CityMasterModel> getAllCities() throws SQLException{
		  List<CityMasterModel> list=new ArrayList<CityMasterModel>();
		  
		  
		  stmt=conn.createStatement();
          rs=stmt.executeQuery("select * from citymaster");
          
          while(rs.next()) {
        	  
        	 
        	  list.add( new CityMasterModel(rs.getInt(1),rs.getString(2)));
          }
          
          return list.size()>0?list:null;
		  
		   
		  
	  }
	  
	  public boolean isAddBulkCities() throws IOException,SQLException {
		  
		  int a=0;
		 FileReader filereader=new FileReader(PathHelper.path.getAbsoluteFile()+"\\src\\BulkCities.csv");
		 
		 
		 BufferedReader br=new BufferedReader(filereader);
		 
		 
		 String line=null;
		 while((line=br.readLine())!=null) {
			 String s[]=line.split(",");
			 pstmt=conn.prepareStatement("insert into citymaster values('0',?)");
			 pstmt.setString(1,s[1]);
			a= pstmt.executeUpdate(); 	 
		 }
		 if(a!=-1)
			 return true;
		 else
		return false;  
		  
	  }
	  
	  public int getCityId(CityMasterModel citymastermodel) throws SQLException {
		  int ans=-1;
		  List<CityMasterModel> list=this.getAllCities();
		  
		  for(CityMasterModel citymastermodel1:list) {
			  if(citymastermodel.getCityName().equals(citymastermodel1.getCityName())) {

				  ans=citymastermodel1.getCityId();
			  }
		  }
		  
		 if(ans!=-1) 
			 return ans;
		 
		 else
			 return -1;
	  }
	  
	  public boolean isAreaAdd(AreaMasterModel areamastermodel) throws SQLException {
		  int autoid=this.autoIncrement();
		  
		  CallableStatement cstmt=conn.prepareCall("call savearea(?,?,?)");
		  cstmt.setInt(1,autoid);
		  cstmt.setString(2,areamastermodel.getAreaName());
		  cstmt.setInt(3,areamastermodel.getCityId());
		  
		boolean t=  cstmt.execute();
		
		
		
		
		if(!t)
			return true;
		else
			return false;
		  
//		  pstmt=conn.prepareStatement("insert into areamaster values(?,?)");
//		  pstmt.setInt(1,autoid);
//		  pstmt.setString(2,areamastermodel.getAreaName());
//		  
//		  if(!b) {
//			pstmt=  conn.prepareStatement("insert into areajoincity values(?,?)");
//			  pstmt.setInt(1,areamastermodel.getCityId());
//			  pstmt.setInt(2,autoid);
//			  pstmt.executeUpdate();
//			  return true;
//		  }
//		  else
//			  return false;
		
		
	  }
	  
	  public int autoIncrement() throws SQLException {
		     
		  rs=stmt.executeQuery("select * from areamaster");
		  while(rs.next())
		  {    
			  this.areaId=rs.getInt(1);//5
		  }
		  areaId++;//6
		   return areaId;
		     
	  }
	  
	  
	  public LinkedHashMap<String,Integer> getAllcitiesAreaWise() throws SQLException {
		  
		  pstmt=conn.prepareStatement("select c.cityname,count(ajc.aid) from citymaster c inner join areajoincity ajc on ajc.cid=c.cityid inner join areamaster am on am.aid=ajc.aid group by c.cityname");
		rs=  pstmt.executeQuery();
		lhm=new LinkedHashMap<String,Integer>();
		while(rs.next())
		{
		  lhm.put(rs.getString(1),rs.getInt(2));	
		}
		  
		  return lhm;
	  }
	  
	  
	  public LinkedHashMap<String,ArrayList<String>> getAllAreaCityWise() throws SQLException{
		  ArrayList<String> al=null;
		  String cityname="null";
		  lhm=new LinkedHashMap<String,ArrayList<String>>();

		 System.out.println("hello");
		  pstmt=conn.prepareStatement("select am.aname,cm.cityname from areamaster am right join areajoincity ajc on ajc.aid=am.aid right join citymaster cm on cm.cityid=ajc.cid where cm.cityname in (select c.cityname from citymaster c right join areajoincity ajc on ajc.cid=c.cityid right join areamaster a on a.aid=ajc.aid group by c.cityname having count(ajc.aid)>0)");
		 
		  
//		  stmt=conn.createStatement();
//		  rs=stmt.executeQuery("select cityname from citymaster");	  
//		 while(rs.next()) {
//			 cityname=rs.getString(1);
//			 System.out.println(cityname);
//			 pstmt.setString(1,cityname);
//		     ResultSet rs2=pstmt.executeQuery();
		  
		  	rs=pstmt.executeQuery();
		  	 
		  
		  	al=new ArrayList();
		  	boolean b=true;
		  	LinkedHashMap l=new LinkedHashMap();
			 while(rs.next()) {
				 if(cityname.equals(rs.getString(2))||b) {
				 al.add(rs.getString(1));//wagholi 
				 }else {
					 lhm.put(cityname,al);
					 al=new ArrayList();
					 al.add(rs.getString(1));
				 }
					 
					cityname=rs.getString(2);//pune
					b=false;
			 }
			 lhm.put(cityname,al);
		 return lhm;
		  
	  }
	  
	 
	  
}
