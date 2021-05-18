
abstract class Vaccine {

	private String maker; //brand name company of vaccine
	
	public Vaccine(String maker) {
		setMaker(maker);
	}
	
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public String getMaker() {
		return maker;
	}
	
	
	
	public abstract void setDoseID();
	
	public abstract String getDoseID();
	
	public abstract double getDoseCost();
	
	public String toString() {
		return String.format("%s", maker);
	}

}
