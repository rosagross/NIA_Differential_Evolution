package differentialEvolution;

public class Initialization {

	final int DIMENSIONS = 9;
	private int populationSize;
	private double[][] population;
	private Market[] markets;
	private Plant[] plants;
	private double[][] ranges;
	
	public Initialization(int populationSize, Market[] markets, Plant[] plants, double[][] ranges) {
		this.markets = markets;
		this.plants = plants;
		this.populationSize = populationSize;
		this.ranges = ranges;
	}
	
	/**
	 * Initialize the population with the given size and range for the values.
	 * The ranges correspond to the possible values for the 9 variables
	 * e -> [0, m*k]
	 * s -> [0 , maxDemand]
	 * p -> [0, maxPrice]
	 */
	public double[][] initialize() {
		
		// fill in the arrays corresponding to the given ranges
		population = new double[populationSize][DIMENSIONS];
		for (int i = 0; i < populationSize; i++) {
			for (int j = 0; j < this.ranges.length; j++) {
				population[i][j] = this.ranges[j][0] + Math.random() * (this.ranges[j][1] - this.ranges[j][0]);
			}
		}
		
//		System.out.println("The population: ");
//		printArray2D(population);
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
					System.out.println((long)array[i][j]);
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
			System.out.println((long)array[i]);
		}
		System.out.println("\n");
	}

}
