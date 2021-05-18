

public class Pfizer extends Vaccine {

	private static int pfizerDoseCounter = 0; //number of Pfizer doses given
	private String doseID; 
	private final double doseCost = 15.50;
	
	
	public Pfizer() {
		super("Pfizer");
		setDoseID();
	}
	
	
	
	public void setDoseID() {
		pfizerDoseCounter += 1;
		doseID = "Pfizer" + pfizerDoseCounter; 
	}
	
	public String getDoseID() {
		return doseID;
		
	}
	
	public double getDoseCost() {
		return doseCost;
	}
	
	
}
