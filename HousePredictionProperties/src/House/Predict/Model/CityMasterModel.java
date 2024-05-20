package House.Predict.Model;

public class CityMasterModel {
	private int cityId;
	
	public CityMasterModel(){
		
	}
	
	public CityMasterModel(int cityId,String cityName){
		this.cityId=cityId;
		this.cityName=cityName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	private  String cityName;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	
}
