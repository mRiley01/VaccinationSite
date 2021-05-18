import java.util.Random;

public class Adult extends Patient{

	private static Random randyAdult = new Random(5);
	private int age;
	private String patType;
	
	
	public Adult(int arrivalTime) {
		super(arrivalTime);
		setAge();
		setPatType();
	}
	
	
	public void setAge() {
		this.age = randyAdult.nextInt(61 - 20) + 20;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setPatType() {
		this.patType = "Adult";
	}
	
	public String getPatType() {
		return patType;
	}
	
	public int compareTo(Patient pat) {
		
		if(pat.getAge() > getAge()) {
			return -1;
		}
		else if(pat.getAge() < getAge()) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	public String toString() {
		return String.format("%10s  %14s  %14s  %14s  %14d  %14d  %14d  %14.2f", super.getPatientID(), patType, age, super.getVaccine().getMaker(), super.getArrivalTime(), super.getWaitTime(), super.getTotalTime(), super.getVaccine().getDoseCost());
	}

	
}
