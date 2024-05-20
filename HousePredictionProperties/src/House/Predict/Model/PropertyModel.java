package House.Predict.Model;
import java.util.*;
public class PropertyModel {
	
	private int pid;
	private String paddress;
	private int nbed;
	private int nbath;
	private AreaMasterModel areamastermodel;
	private SquareFeetModel squarefeetmodel;
	List<Integer> list=new ArrayList<Integer>();
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPaddress() {
		return paddress;
	}
	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}
	public int getNbed() {
		return nbed;
	}
	public void setNbed(int nbed) {
		this.nbed = nbed;
	}
	public int getNbath() {
		return nbath;
	}
	public void setNbath(int nbath) {
		this.nbath = nbath;
	}
	public AreaMasterModel getAreamastermodel() {
		return areamastermodel;
	}
	public void setAreamastermodel(AreaMasterModel areamastermodel) {
		this.areamastermodel = areamastermodel;
	}
	public SquareFeetModel getSquarefeetmodel() {
		return squarefeetmodel;
	}
	public void setSquarefeetmodel(SquareFeetModel squarefeetmodel) {
		this.squarefeetmodel = squarefeetmodel;
	}
	public List<Integer> getList() {
		return list;
	}
	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	

}
