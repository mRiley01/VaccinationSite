
public class Nurse {

	private static int nurseCounter = 0;
	private boolean isFree;
	private int nurseIDNumber;
	private int totalPatientsProcessedByNurse;
	private int timeRemainingForShot;
	private Patient assignedPatient;
	
	
	public Nurse(int nurseIDNumber) {
		setNurseIDNumber(nurseIDNumber);
		setIsFree(true);
	}
	
	public void setNurseIDNumber(int nurseNumberID) {
		nurseIDNumber = nurseNumberID;
	}
	
	public int getNurseIDNumber() {
		return nurseIDNumber;
	}
	
	
	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}
	
	public boolean getIsFree() {
		return isFree;
	}
	
	
	public void setAssignedPatient(Patient assignPat) {
		assignedPatient = assignPat;
		setIsFree(false);
	}
	
	public Patient removeAssignedPatient() { 
		Patient tempPatient = assignedPatient;
		assignedPatient = null;
		setIsFree(true);
		totalPatientsProcessedByNurse += 1;
		return tempPatient;
	}
	
	public Patient getAssignedPatient() {
		return assignedPatient;
	}
	
	
	public void setTimeRemainingForShot(int timeRemainingForShot) {
		this.timeRemainingForShot = timeRemainingForShot;
	}
	
	public void decrementTimeRemainingForShot() {
		timeRemainingForShot -= 1;
	}
	
	public int getTimeRemainingForShot() {
		return timeRemainingForShot;
	}
	
	
	public String toString() {
		return String.format("Nurse %d gave shots to %d people", nurseIDNumber, totalPatientsProcessedByNurse);
	}
	
	
	
	
 	
}
