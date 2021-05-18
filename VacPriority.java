import java.util.Comparator;

public class VacPriority implements Comparator<Patient> {

	public int compare(Patient pat1, Patient pat2) {
		
		if(pat1.getClass().equals(pat2.getClass())) {
			if(pat1.getArrivalTime() < pat2.getArrivalTime()) {
				return -1;
			}
			else if(pat1.getArrivalTime() > pat2.getArrivalTime()) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			if(pat1 instanceof Senior) {
				return -1;
			}
			else if(pat2 instanceof Senior) {
				return 1;
			}
			else if(pat1 instanceof Adult) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
	
}
