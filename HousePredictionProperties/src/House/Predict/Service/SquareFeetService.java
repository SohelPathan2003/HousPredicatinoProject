package House.Predict.Service;

import House.Predict.Model.AminityModel;
import House.Predict.Model.PropertyModel;
import House.Predict.Model.SquareFeetModel;
import House.Predict.Model.historicalpropertyprice;
import House.Predict.Repository.*;
import House.Predict.Repository.*;
import java.sql.*;

public class SquareFeetService {
	SquareFeetRepository sfr=new SquareFeetRepository();
	
	public boolean isAddSquareFeet(SquareFeetModel sfm) throws SQLException {
		
		return sfr.isAddSquareFeet(sfm);
		
	}
	
	public boolean isAddAminity(AminityModel aminitymodel) throws SQLException {
		return sfr.isAddAminity(aminitymodel);
	}
	
	
	public int getAreaId(String aname) throws SQLException{
		return sfr.getAreaId(aname);
	}

	public int getSquareFeetId(int sqf) throws SQLException{
		return sfr.getSquareFeetId(sqf);
		
	}
	
	public boolean isAddPropertyModel(PropertyModel propertymodel,historicalpropertyprice hpp) throws SQLException {
		return sfr.AddPropertyModel(propertymodel,hpp);
	}
	
	public int getAminityId(String Aminityname)throws SQLException {
		return sfr.getAminityId(Aminityname);
	}
	
}
