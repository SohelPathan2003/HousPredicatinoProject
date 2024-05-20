package House.Predict.Client;

import static java.lang.System.*;
import java.util.Scanner;
import House.Predict.Model.*;
import House.Predict.Service.*;
import java.io.*;
import java.sql.*;

import java.util.*;
import java.util.Map.Entry;
public class PredictionClientApplication {
	public static void main(String ...args) throws SQLException,IOException{
		
		CityMasterService cms=new CityMasterService();
		SquareFeetService sfs=new SquareFeetService();
		
		Scanner sc=new Scanner(System.in);
		do {
		out.println("\n1 for add new client");
		out.println("2 for show all cities");
		out.println("3 for add bulk cities");
		out.println("4 for area add");
		out.println("5 for check number of area in city");
		out.println("6 for show area city wise");
		out.println("7 for add square feet area");
		out.println("8 for add Aminities");
		out.println("9 for add properties");
		out.println("Enter Your Choice");
		
	   
	 
	   int choice=sc.nextInt();
	   String aminity;
	   int aid=0;
	   int cid=0;
	   int sqid=0;
	   String ans=null;
	   boolean b=false;
	   String cname=null;
	   LinkedHashMap lhm=null;
	   List<AminityModel> alaminity=new ArrayList<AminityModel>();
	   switch(choice) {
	   case 1:
		   out.println("Enter City Name");
		    sc.nextLine();
		    cname=sc.nextLine();
		    CityMasterModel citymastermodel=new CityMasterModel();
		    citymastermodel.setCityName(cname);
		    b=cms.isAddCity(citymastermodel);
		    if(b)
		    	out.println("Client Added Successfully.......");
		    else
		    	out.println("Some Problem Is There.......");
		    
		    
		    break;
	   case 2:
		   List <CityMasterModel>list=cms.getAllCities();
		   if(list!=null) {
		   
		   out.println("CityId\tCityName");
		   for(CityMasterModel  cmm:list)
			   out.println(cmm.getCityId()+"\t"+cmm.getCityName());
		   }
		   else {
			   out.println("There Is No Data Present........ ");
		   }
		   
		   break;
	   case 3:
		   
		   b=cms.isAddBulkCities();
		   if(b)
			   out.println("Bulk Cities Added In DataBase.......");
		   else
			   out.println("Some Problem Is There.......");
		   
		   break;
	 
	   
	   case 4:
		   
		   out.println("Enter ciry Name");
		   sc.nextLine();
		   cname=sc.nextLine();
		   CityMasterModel citymastermodel2=new CityMasterModel();
		   citymastermodel2.setCityName(cname);
		   
		  int cityId= cms.getCityId(citymastermodel2);
		  if(cityId!=-1) {
			  out.println("City present in data base and  id of city is "+cityId);
		       out.println("Do you want to add area's in this city");
		       ans=sc.nextLine();
		       if(ans.equals("yes")) {
		    	   out.println("EnterArea Name");
		    	   
		    	   String aname=sc.nextLine();
		    	    AreaMasterModel areamastermodel=new AreaMasterModel(aname,cityId);
		    	    
		    	   b= cms.isAreaAdd(areamastermodel);
		    	   if(b)
		    		   out.println("Area added successfully.........");
		    	   else
		    		   out.println("some problem is there............");
		    	    
		    	  
		       }else {
		    	   out.println("OKAAAAAAYYYYYYY...........");
		       }
		  }
		  else {
			  out.println("city not present in data  base");
		  
		        out.println("Do you want to add this city");
		         ans=sc.nextLine();
		         if(ans.equals("yes")) {
		         citymastermodel=new CityMasterModel();
		 		    citymastermodel.setCityName(cname);
		 		    b=cms.isAddCity(citymastermodel);
		 		    if(b)
		 		    	out.println("Client Added Successfully.......");
		 		    else
		 		    	out.println("Some Problem Is There.......");
		         }else {
		        	 out.println("okkkkkkayyyyyyyyy.............");
		         }
		  }
		   
		   break;
		   
	   case 5:
		  lhm=cms.getAllcitiesAreaWise();
		  Set<Map.Entry<String,Integer>>set=lhm.entrySet();
		  
		  for(Map.Entry<String,Integer> d:set) {
			  cname=d.getKey();
			  int count=d.getValue();
			  out.println("***********************************************************************");
			  out.println("cityname is \t"+cname+"\n\n"+"Total Area's In "+cname+" "+count+"\n");
			  out.println("***********************************************************************");

		  }
		  
		   break;
		   
	   case 6:
		   lhm=cms.getAllAreaCityWise();
		   if(lhm.size()>0) {
		   Set<Map.Entry<String,ArrayList<String>>> set1=lhm.entrySet();
		   
		   for(Map.Entry<String,ArrayList<String>> d:set1) {
			   cname=d.getKey();
			   out.println("city name is   "+cname);
			   out.println("===========================================================");
			   ArrayList<String> al=d.getValue();
			   for(String s:al) {
				   out.println(s);
			   }
			   out.println("===========================================================");
		   }
		   }
		   else
			   out.println("there is no data present");
		   
		   break;
		   
	   case 7:
		        System.out.println("Enter Square Feet Area");
		        int feet=sc.nextInt();
		        
		        SquareFeetModel sfm=new SquareFeetModel();
		       sfm.setSquarefeet(feet);
		       b=sfs.isAddSquareFeet(sfm);
		        
		       if(b)
		    	   out.println("Square feet successFully Added.............!!!!!!!!!!");
		       else
		    	   out.println("Some problem is there..........!!!!!!!!");
		        
		   break;
		   
	   case 8:
		   
		   out.println("Enter Aminities ");
		   sc.nextLine();
		   aminity=sc.nextLine();
		   AminityModel am=new AminityModel();
		   am.setAminityName(aminity);
		   b=sfs.isAddAminity(am);
		   if(b)
			   out.println("Aminities Successfully added..........");
		   else
			   out.println("Aminities Not Added...........");
		   break;
	   case 9:
		   
		   ArrayList<Integer>amid=new ArrayList<Integer>();
		   out.println("Enter City Name");
		   sc.nextLine();
		   cname=sc.nextLine();
		   
		   AreaMasterModel amm=new AreaMasterModel();
//		   CityMasterModel cmm=new CityMasterModel();
//		   cmm.setCityName(cname);
//		  cid=cms.getCityId(cmm);    // here we get the city id to store in property model.
		   
		   amm.setCityName(cname);
		  cid=cms.getCityId(amm);
		   System.out.println(cid);
		  
		   amm.setCityId(cid);
		   out.println("Enter Area Name");
		   String aname=sc.nextLine();
		   aid=sfs.getAreaId(aname);
		   out.println(aid);
		   amm.setAreaId(aid);
		   out.println("Enter Property Address");
		   String paddress=sc.nextLine();
		   out.println("Enter Square Feet area");
		   int squarefeet=sc.nextInt();
		   
		   sqid=sfs.getSquareFeetId(squarefeet);
		   out.println(sqid);
		   sfm=new SquareFeetModel();
		   sfm.setSquareId(sqid);
		   
		   out.println("Enter number of bed and bath ");
		   int nbed=sc.nextInt();
		   int nbath=sc.nextInt();
		   sc.nextLine();
		   do {
			   out.println("Enter aminity");
			   aminity=sc.nextLine();
			   aid=sfs.getAminityId(aminity);
			   amid.add(aid);
			   
			   out.println("do you want to add aminity");
			   ans=sc.nextLine(); 
		   }while(ans.equals("yes"));
		   out.println("Enter price of property");
		   int price=sc.nextInt();
		   historicalpropertyprice hpp=new historicalpropertyprice();
		   hpp.setPrice(price);
		   
		   
		  PropertyModel pm=new PropertyModel();
		  pm.setAreamastermodel(amm); // cityid and areaid 
		  pm.setPaddress(paddress);
		  pm.setSquarefeetmodel(sfm);
		  pm.setNbed(nbed);
		  pm.setNbath(nbath);
		  pm.setList(amid);
		  
		b=  sfs.isAddPropertyModel(pm,hpp);
		if(b)
			out.println("yess successfully added");
		else
			out.println("no some problem");
		  
		   break;
	   }
	   }while(true);
	   
	   
		
		
		
	}

}
