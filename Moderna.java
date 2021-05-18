
public class Moderna extends Vaccine {

	private static int modernaDoseCounter = 0; //number of Moderna vaccines given
	private String doseID;
	private final double doseCost = 12.50;
	
	
	public Moderna() {
		super("Moderna");
		setDoseID();
	}
	
	
	public void setDoseID() {
		modernaDoseCounter += 1;
		doseID = "Moderna" + modernaDoseCounter; 
	}
	
	public String getDoseID() {
		return doseID;
	}
	
	public double getDoseCost() {
		return doseCost;
	}
	
	
}
