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
	
	private double cost(int x, double kwHPerPlant, double costPerPlant, int maxPlants) {
	
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
		return plantsNeeded * costPerPlant;
		
	}
}
