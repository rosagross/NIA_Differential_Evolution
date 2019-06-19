package differentialEvolution;

public class Plant {

	
	private double kwHPerPlant;
	private double cost;
	private int maxPlants;
	
	
	
	public Plant(double kwHPerPlant, double cost, int maxPlants) {
		this.kwHPerPlant = kwHPerPlant;
		this.cost = cost;
		this.maxPlants = maxPlants;
		
		
	}
	
	public double cost(double x) {
	
		//if x is non-positive, return 0
		if (x <= 0) {
			return 0;
		} 
		
		//if x is greater than what can be generated return prohibitively large value
		if (x > kwHPerPlant * maxPlants) {
			return Integer.MAX_VALUE;
		}
		
		//otherwise determine number of plants needed to generate x
		double plantsNeeded = Math.ceil(x / kwHPerPlant);
		
		
		//cost is number of plants times cost per plant
		return plantsNeeded * kwHPerPlant;
		
	}
	
	/**
	 * Getter for the kwh value of a plant
	 * @return
	 */
	public double getKWH() {
		return this.kwHPerPlant;
	}
	
	/**
	 * Getter for the cost value of a plant
	 * @return
	 */
	public double getCost() {
		return this.cost;
	}
	
	/**
	 * Getter for the maximum of plants value of a plant
	 * @return
	 */
	public double getMaxPlants() {
		return this.maxPlants;
	}
}
