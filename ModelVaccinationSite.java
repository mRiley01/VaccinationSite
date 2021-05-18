import java.util.Scanner;

public class ModelVaccinationSite {

	public static void main(String[] args) throws Exception {
	
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter the name of the Vaccination Site:");
		String vaccinationSiteName = scan.nextLine();
		
		
		
		System.out.println("Please enter a seed value:");
		int seed = scan.nextInt();
		
		System.out.println("Please enter the number of nurses:");
		int numOfNurses = scan.nextInt();
		
		System.out.println("Please enter the total number of vaccine doses:");
		int numOfDoses = scan.nextInt();
		
		System.out.println("Please enter the number of minutes to keep entrance open after the site opens:");
		int durationForArriving = scan.nextInt();
		
		scan.nextLine();
		
		System.out.print("Please enter the name of the output file for Vaccination Site results: ");
		String vacSiteFileReport = scan.next();
		
		
		
		VaccinationSite vacSite = new VaccinationSite(vaccinationSiteName, seed, numOfNurses, numOfDoses);
		vacSite.openVaccinationSite();
		vacSite.operateVaccinationSite(durationForArriving);
		vacSite.generateVaccinationSiteResults(vacSiteFileReport);
		
		
		

	}

}
