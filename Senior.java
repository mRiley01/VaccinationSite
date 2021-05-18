import java.util.Random;

public class Senior extends Patient {
	
	private static Random randySenior = new Random(8);
	private int age;
	private String patType;
	
	
	public Senior(int arrivalTime) {
		super(arrivalTime);
		setAge();
		setPatType();
	}
	
	
	public void setAge() {
		this.age = randySenior.nextInt(101 - 61) + 61;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setPatType() {
		this.patType = "Senior";
	}
	
	public String getPatType() {
		return patType;
	}
	
	public int compareTo(Patient pat) {
		
		if(pat.getAge() > getAge()) {
			return -1;
		}
		else if(pat.getAge() < getAge() ) {
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
