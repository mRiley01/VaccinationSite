
abstract class Patient implements Comparable<Patient> {

	static int idCounter = 0;
	
	private int arrivalTime;
	private int shotTime;
	private int waitTime;
	private int totalTime;
	
	private String patientID;
	
	private Vaccine vacDose;
	
	
	public Patient(int arrivalTime) {
		setArrivalTime(arrivalTime);
		setPatientID();
	}
	
	
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	
	public void setShotTime(int shotTime) {
		waitTime = shotTime - arrivalTime;
		this.shotTime = shotTime;
	}
	
	public int getShotTime() {
		return shotTime;
	}
	
	
	public int getWaitTime() {
		return waitTime;
	}
	
	
	public void setTotalTime(int endTime) {
		totalTime = endTime - arrivalTime;
	}
	
	public int getTotalTime() {
		return totalTime;
	}
	
	
	public void setPatientID() {
		idCounter += 1;
		patientID = "Patient" + idCounter;
	}
	
	public String getPatientID() {
		return patientID;
	}
	
	
	public void setVaccine(Vaccine vac) {
		vacDose = vac;
	}
	
	public Vaccine getVaccine() {
		return vacDose;
	}
	
	
	public abstract void setAge();
	
	public abstract int getAge();
	
	public abstract void setPatType();
	
	public abstract String getPatType();
	
	public abstract int compareTo(Patient pat);
	
	
}
