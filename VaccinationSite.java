import java.util.Random;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class VaccinationSite {
	
	private Random randy;
	private PriorityQueue<Patient> waitingQ = new PriorityQueue<>();
	private LinkedList<Vaccine> vacSupply = new LinkedList<>();
	private ArrayList<Patient> vaccinated = new ArrayList<>();
	
	private Nurse nurses[];
	private String siteName;
	private int currentTime = 0;
	
	
	public VaccinationSite(String name, int seed, int numNurses, int numVaccines) {
		siteName = name;
		waitingQ = new PriorityQueue<Patient>(new VacPriority());
		randy = new Random(seed);
		createNurses(numNurses);
		orderVaccines(numVaccines);
	}
	
	public void createNurses(int numNurses) {
		nurses = new Nurse[numNurses];
		
		for(int i = 0; i < numNurses; i++) {
			nurses[i] = new Nurse(i+1);
		}
	}
	
	public void orderVaccines(int numVaccines) {
		
		for(int i = 0; i < (numVaccines-1); i++) {
			
			if(i % 3 == 0) {
				vacSupply.add(new Moderna());
			}
			else {
				vacSupply.add(new Pfizer());
			}
		}
	}
	
	
	
	public void openVaccinationSite() {
		
		for(currentTime = 0; currentTime < 10; currentTime++) {
			
			
			for(int i = 0; i < 6; i++) {
				int numberWheel = randy.nextInt(11 - 1) + 1;
				
				if(numberWheel >= 1 && numberWheel <= 5) {
					waitingQ.add(new Senior(currentTime));
				}
				else if(numberWheel >= 6 && numberWheel <= 9) {
					waitingQ.add(new Adult(currentTime));
				}
				else {
					waitingQ.add(new OlderTeen(currentTime));
				}
			}
			
		}
	}
	
	
	
	
	public void operateVaccinationSite(int durationForArriving) {
		
		int endArrivalsTime = currentTime + durationForArriving;
		Patient tempPatient = null;
		Vaccine tempVaccine;
		Nurse tempNurse;
		
		
		while(vaccinated.size() != tempPatient.idCounter || currentTime < endArrivalsTime) {
			
			
			if(currentTime < endArrivalsTime) {
				for(int i = 0; i < 8; i++) {
					int numberWheel = randy.nextInt(11 - 1) + 1;
					
					if(numberWheel >= 1 && numberWheel <= 5) {
						waitingQ.add(new Senior(currentTime));
					}
					else if(numberWheel >= 6 && numberWheel <= 9) {
						waitingQ.add(new Adult(currentTime));
					}
					else {
						waitingQ.add(new OlderTeen(currentTime));
					}
				
				}
			}
			
			
			for(int j = 0; j < nurses.length; j++) {
				
				tempNurse = nurses[j];
				
				if(tempNurse.getIsFree() == false) {
					tempNurse.decrementTimeRemainingForShot();
				
					
					 if(tempNurse.getTimeRemainingForShot() == 0) {
						Patient treatedPatient = tempNurse.getAssignedPatient();
						vaccinated.add(treatedPatient);
						treatedPatient.setTotalTime(currentTime);
						tempNurse.removeAssignedPatient();
					 }
				}
					
				
					if(tempNurse.getIsFree() == true && !waitingQ.isEmpty()) {
			
						
						if(vacSupply.size() == 0) {
							System.out.println("Ran out of vaccine!!! " + waitingQ.size() + " patients still waiting! Site shutting down!");
							orderVaccines(waitingQ.size());
						}
						
						tempPatient = waitingQ.remove();
						tempPatient.setShotTime(currentTime);
						tempPatient.setVaccine(vacSupply.remove());
						tempNurse.setAssignedPatient(tempPatient);
						
						int patientShotTime = randy.nextInt(4 - 1) + 1;
						
						tempNurse.setTimeRemainingForShot(patientShotTime);
						}
					
					
					}
			
			currentTime += 1;
			
		}
		
	}
	
	
	
	public void generateVaccinationSiteResults(String outputFileName) throws Exception {
		
		PrintWriter vaccinationReport = new PrintWriter(outputFileName);
		
		Nurse tempNurse;
		Senior tempSenior;
		Adult tempAdult;
		OlderTeen tempOlderTeen;
		
		double totalTimeCount = 0;
		double totalSeniorTime = 0;
		double totalAdultTime = 0;
		double totalOlderTeenTime = 0;
		int totalSeniors = 0;
		int totalAdults = 0;
		int totalOlderTeens = 0;
		int totalPatients = 0;
		
		
		vaccinationReport.write("Data For Vaccination Site " + siteName);
		
		
		vaccinationReport.write("\n\nSummary Data\n");
		for(int i = 0; i < nurses.length; i++) {
			tempNurse = nurses[i];
			
			vaccinationReport.write(tempNurse.toString());
			vaccinationReport.write("\n");
		}
		
		
		for(int j = 0; j < vaccinated.size(); j++) {
			
			if(vaccinated.get(j) instanceof Senior) {
				totalSeniors += 1;
				totalSeniorTime += vaccinated.get(j).getWaitTime();
			}
			else if(vaccinated.get(j) instanceof Adult) {
				totalAdults += 1;
				totalAdultTime += vaccinated.get(j).getWaitTime();
			}
			else {
				totalOlderTeens += 1;
				totalOlderTeenTime += vaccinated.get(j).getWaitTime();
			}
		}
		
		totalPatients = (totalSeniors + totalAdults + totalOlderTeens);
		totalTimeCount = (totalSeniorTime + totalAdultTime + totalOlderTeenTime);
		
		vaccinationReport.write("\n\n");
		
		vaccinationReport.printf("The average total time per person to vaccinate %d Seniors is %.2f minutes\n", totalSeniors, (totalSeniorTime/totalSeniors));
		
		vaccinationReport.printf("The average total time per person to vaccinate %d Adults is %.2f minutes\n", totalAdults, (totalAdultTime/totalAdults));
		
		vaccinationReport.printf("The average total time per person to vaccinate %d Older Teens is %.2f minutes\n", totalOlderTeens, (totalOlderTeenTime/totalOlderTeens));
		
		vaccinationReport.printf("The average total time per person to vaccinate %d Patients is  %.2f minutes\n\n", totalPatients, (totalTimeCount/totalPatients));
		
	
		
		vaccinationReport.write("PATIENT ID \t\t PATIENT TYPE \t\t   AGE \t\t   VACCINE \t\t ARRIVAL TIME \t\t WAIT TIME \t\t TOTAL TIME \t COST\n");
		
		Iterator iterate = vaccinated.iterator();
		
		while(iterate.hasNext()) {
			vaccinationReport.print(iterate.next() + "\t\t\t");			
			vaccinationReport.write("\n");
		}
		
		
		vaccinationReport.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
