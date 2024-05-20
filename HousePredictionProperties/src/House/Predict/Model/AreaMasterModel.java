package House.Predict.Model;

public class AreaMasterModel extends CityMasterModel {
	private int areaId;
	private String areaName;
	
	public AreaMasterModel(){
		
	}
	public AreaMasterModel(String aname,int cityId){
		areaName=aname;
		this.cityId=cityId;
	}
	public int getAreaId() {
		return areaId;
	}
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	private int cityId;
    public void setCityId(int cityId)
    {
    	this.cityId=cityId;
    }
    
    public int getCityId() {
    	return cityId;
    }
	

}
