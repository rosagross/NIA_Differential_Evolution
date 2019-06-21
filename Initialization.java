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
	public double[][] initialize() {
		
		// we got 9 ranges, each with 2 numbers inside (start and end)
		double[][] ranges = new double[DIMENSIONS][2];
		for (int i = 0; i < ranges.length; i++) {
			
			if (i < 3) { // take the range for energy produced with plants of type i
				ranges[i][0] = 0;
				ranges[i][1] = plants[i].getKWH() * plants[i].getMaxPlants();
			}if (i < 6 && i >= 3) { // take the planned amount of energy sold to market of type i
				ranges[i][0] = 0;
				ranges[i][1] = markets[i%3].getDemand();
			}else if(i >= 6){
				ranges[i][0] = 0;
				ranges[i][1] = markets[i%3].getMaxPrice();
			}
		}
		System.out.println("The ranges: " + (double)(plants[1].getKWH() * plants[1].getMaxPlants()));
		printArray2D(ranges);
		
		// fill in the arrays corresponding to the given ranges
		population = new double[populationSize][DIMENSIONS];
		for (int i = 0; i < populationSize; i++) {
			for (int j = 0; j < ranges.length; j++) {
				population[i][j] = ranges[j][0] + Math.random() * (ranges[j][1] - ranges[j][0]);
			}
		}
		
		System.out.println("The population: ");
		printArray2D(population);
		return population;
	}
	
	/**
	 * Print array for test
	 */
	public static void printArray2D(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println("\n");
			for (int j = 0; j < array[0].length; j++) {
				if (j < 6) {
					System.out.println((int)array[i][j]);

				}else {
					System.out.println(array[i][j]);
				}
			}
		}
		System.out.println("\n");

	}
	
	/**
	 * Print array for test
	 */
	public static void printArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.println((int)array[i]);
		}
		System.out.println("\n");
	}

}
