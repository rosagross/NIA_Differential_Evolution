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
	
	
	public double[][] differentialEvolution() {
		
		
		Initialization init = new Initialization(popSize);
		population = init.initialize();
		newPopulation = new double[popSize][DIMENSIONS];
		DonorGeneration donorGen = new DonorGeneration(scaleFactor);
		TrialGeneration trialGen = new TrialGeneration(crossoverRate);
		Selection select = new Selection();

		
		for (int i = 0; i < popSize; i++) {
			donor = donorGen.generateDonor(population);
			trial = trialGen.generateTrial(donor, population[i]);
			newPopulation[i] = select.select(trial, population[i]);
		}
		

	}
	

	
}
