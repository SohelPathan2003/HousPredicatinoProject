package House.Predict.Service;

import  House.Predict.Model.AreaMasterModel;

import java.io.IOException;
import java.sql.SQLException;

import House.Predict.Model.*;
import House.Predict.Repository.*;
import java.util.*;
public class CityMasterService {
	
	   CityMasterRepository citymasterrepo=new CityMasterRepository();
	
	public boolean isAddCity(CityMasterModel citymastermodel) throws SQLException {
		
	    return citymasterrepo.isAddCity(citymastermodel);
		
		
	}
	
	public boolean isAddBulkCities() throws IOException,SQLException {
		
		return citymasterrepo.isAddBulkCities();
	}
	
	public List<CityMasterModel> getAllCities() throws SQLException {
		return citymasterrepo.getAllCities();
	}
	
	public int getCityId(CityMasterModel citymastermodel) throws SQLException {
		
		return citymasterrepo.getCityId(citymastermodel);
	}
	
	public boolean isAreaAdd(AreaMasterModel areamastermodel)throws SQLException {
		return citymasterrepo.isAreaAdd(areamastermodel);
		
	}
	
	public LinkedHashMap<String,Integer> getAllcitiesAreaWise() throws SQLException {
		return citymasterrepo.getAllcitiesAreaWise();
	}
	
	public LinkedHashMap<String,ArrayList<String>>getAllAreaCityWise() throws SQLException{
		
		return citymasterrepo.getAllAreaCityWise();
	}
	
	

}
