package differentialEvolution;

public class Initialization {

	final int DIMENSIONS = 9;
	private int populationSize;
	private double[][] population;
	private Market[] markets;
	private Plant[] plants;
	
	public Initialization(int populationSize, Market[] markets, Plant[] plants) {
		this.markets = markets;
		this.plants = plants;
		this.populationSize = populationSize;
	}
	
	/**
	 * Initialize the population with the given size and range for the values.
	 * The ranges correspond to the possible values for the 9 variables
	 * e -> [0, m*k]
	 * s -> [0 , maxDemand]
	 * p -> [0, maxPrice]
	 */
	public Double[][] initialize() {
		
		// we got 9 ranges, each with 2 numbers inside (start and end)
		double[][] ranges = new double[DIMENSIONS][2];
		for (int i = 0; i < ranges.length; i++) {
			if (i < 3) { // take the range for energy produced with plants of type i
				ranges[i][0] = 0;
				ranges[i][1] = plants[i].getKWH() * plants[i].getMaxPlants();
			}if (i < 6) { // take the planned amount of energy sold to market of type i
				ranges[i][0] = 0;
				ranges[i][1] = markets[i].getDemand();
			}
		}
				
		// fill in the arrays corresponding to the given ranges
		population = new double[9][populationSize];
		
		// define the ranges 
		
		
		for (int i = 0; i < population.length; i++) {
			
		}
		return population;
	}

}
