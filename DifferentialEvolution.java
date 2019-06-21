package differentialEvolution;

public class DifferentialEvolution {

	private Market[] markets;
	private Plant[] plants;
	
	private int popSize;
	private double scaleFactor;
	private double crossoverRate;
	
	private double[][] population;
	private double[][] newPopulation;
	
	private double[] donor;
	private double[] trial;

	
	final public int DIMENSIONS = 9;
	
	public DifferentialEvolution(Plant[] plants, Market[] markets, int popSize, double scaleFactor, double crossoverRate) {
		
		this.plants = plants;
		this.markets = markets;
		this.popSize = popSize;
		this.scaleFactor = scaleFactor;
		this.crossoverRate = crossoverRate;
	}
	
	
	public double[][] differentialEvolution(int iterations) {
		
		// initialize variable for counting the iterations 
		int count = 0;
		
		// initialize population
		Initialization init = new Initialization(popSize, markets, plants);
		population = init.initialize();
		
		// initialize our instances for of the modules
		DonorGeneration donorGen = new DonorGeneration(scaleFactor);
		TrialGeneration trialGen = new TrialGeneration(crossoverRate);
		Selection select = new Selection(markets, plants);
		
		do {
			// clear the new population
			newPopulation = new double[popSize][DIMENSIONS];

			for (int i = 0; i < popSize; i++) {
				// generate the donor (Mutation)
				donor = donorGen.generateDonor(population);
				// generate the trial (Crossover)
				trial = trialGen.generateTrial(donor, population[i]);
				// add the selected trial to new population
				newPopulation[i] = select.select(trial, population[i]);
			}
			
			// copy the array such that population = newPopulation
			for (int i = 0; i < population.length; i++) {
		         population[i] = newPopulation[i];
		    }
			
			
			count++;
		} while (count < iterations);

		return newPopulation;

	}
	

	
}
