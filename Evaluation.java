package differentialEvolution;

import java.io.FileWriter;

/**
 * In this class we execute the Differential Evolution with all our Modules.
 * We initialize all the Markets and Plants at the beginning and uncomment them if we
 * don't use them in the evaluation.
 * CSV files are also created here.
 * @author Rosa
 *
 */
public class Evaluation {

	public static void main(String[] args) {
		
		final int DIMENSIONS = 9;
		
		// *** INITIALIZE PROBLEM ***
		
		// Plants
		Plant plantA = new Plant(50000, 10000, 100);
		Plant plantB = new Plant(600000, 80000, 50);
		Plant plantC = new Plant(4000000, 400000, 3);
		
		Plant[] plants = new Plant[]{plantA, plantB, plantC};
		
		// Markets
		Market market1 = new Market(0.45, 2000000);
		Market market2 = new Market(0.25, 30000000);
		Market market3 = new Market(0.2, 20000000);

	
		Market[] markets = new Market[]{market1, market2, market3};
	
		//parameters
		int popSize = 250;
		double scaleFactor = 0.5;
		double crossoverRate = 0.5;
		double costprice = 0.6;
		
		double[][] solution = new double[popSize][DIMENSIONS];
		double bestValue;
		
		//DonorGeneration donorGeneration = new DonorGenerationBest();
		
		//DonorGeneration donorGeneration = new DonorGenerationRandom();
		DonorGeneration donorGeneration = new DonorGenerationTargetToBest();
		
		//TrialGeneration trialGeneration = new TrialGenerationBin();
		TrialGeneration trialGeneration = new TrialGenerationExp();

		
		DifferentialEvolution diffEvol = new DifferentialEvolution(donorGeneration, trialGeneration, plants, markets, popSize, scaleFactor, crossoverRate, costprice);
	
		// do DE Algorithm for n iterations
		solution = diffEvol.differentialEvolution(popSize);
		// select the best value out of the new population
		bestValue = Selection.profit(solution[0], costprice);
		for (int i = 1; i < solution.length; i++) {
			//System.out.println("profit " + i + ": " + (long)Selection.profit(solution[i]));
			if (Selection.profit(solution[i], costprice) > bestValue) {
				bestValue = Selection.profit(solution[i], costprice);
			}
		}
		
		System.out.println("best Value: " + bestValue);
//		Initialization.printArray2D(solution);
	}
	

}