 package differentialEvolution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DifferentialEvolution {

	private Market[] markets;
	private Plant[] plants;
	
	private int popSize;
	private double scaleFactor;
	private double crossoverRate;
	private double costprice;
	
	private double[][] population;
	private double[][] newPopulation;
	
	private double[] donor;
	private double[] trial;
	private double[][] ranges;
	
	private DonorGeneration donorGeneration;
	private TrialGeneration trialGeneration;

	
	final public int DIMENSIONS = 9;
	
	public DifferentialEvolution(DonorGeneration donorGeneration, TrialGeneration trialGeneration, Plant[] plants, Market[] markets, int popSize, double scaleFactor, double crossoverRate, double costprice) {
		
		this.plants = plants;
		this.markets = markets;
		this.popSize = popSize;
		this.scaleFactor = scaleFactor;
		this.crossoverRate = crossoverRate;
		this.costprice = costprice;
		this.donorGeneration = donorGeneration;
		this.trialGeneration = trialGeneration;
	}
	
	
	public double[][] differentialEvolution(int iterations) {
		
		// initialize variable for counting the iterations and saving best profit for documentation
		int count = 0;
		double currentProfit = 0;
		
		
		// set ranges of variables
		setRanges();
		// initialize population
		Initialization init = new Initialization(popSize, markets, plants, ranges);
		population = init.initialize();
		
		// initialize our instances for of the modules
		Selection select = new Selection(markets, plants, costprice);
		
		try (BufferedWriter writer =
				new BufferedWriter(new FileWriter("data.csv"))){
			
			writer.append("Filename, Iterations, Ants, BestValue, durationTotal, durationIteration");
			writer.append("\n");
		
			do {
				// clear the new population
				newPopulation = new double[popSize][DIMENSIONS];
		
				for (int i = 0; i < popSize; i++) {
					// generate the donor (Mutation)
					donor = donorGeneration.generateDonor(population, scaleFactor, ranges, costprice, i);
					// generate the trial (Crossover)
					trial = trialGeneration.generateTrial(donor, population[i], ranges, crossoverRate);
					// add the selected trial to new population
					newPopulation[i] = select.select(trial, population[i]);
					// copy the array such that population = newPopulation
					population[i] = newPopulation[i];
				}
				
				
				// for the evaluation we need to calculate the best profit for each iteration
				currentProfit = Selection.profit(population[0], costprice);
				for (int i = 1; i < population.length; i++) {
					//System.out.println("profit " + i + ": " + (long)Selection.profit(solution[i]));
					if (Selection.profit(population[i], costprice) > currentProfit) {
						currentProfit = Selection.profit(population[i], costprice);
					}
				}
				System.out.println("curr profit " + String.valueOf(currentProfit));
				
				writer.write(String.valueOf((int)currentProfit) + "," + String.valueOf(count+1));
				writer.append("\n");
				
				
				count++;
			} while (count < iterations);
			
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return population;

	}


	private void setRanges() {
		// we got 9 ranges, each with 2 numbers inside (start and end)
		this.ranges = new double[DIMENSIONS][2];
		for (int i = 0; i < this.ranges.length; i++) {
			
			if (i < 3) { // take the range for energy produced with plants of type i
				this.ranges[i][0] = 0;
				this.ranges[i][1] = plants[i].getKWH() * plants[i].getMaxPlants();
			}if (i < 6 && i >= 3) { // take the planned amount of energy sold to market of type i
				this.ranges[i][0] = 0;
				this.ranges[i][1] = markets[i%3].getDemand();
			}else if(i >= 6){
				this.ranges[i][0] = 0;
				this.ranges[i][1] = markets[i%3].getMaxPrice();
			}
		}
//		System.out.println("The ranges: " + (double)(plants[1].getKWH() * plants[1].getMaxPlants()));
//		Initialization.printArray2D(this.ranges);
	}
	

	
}