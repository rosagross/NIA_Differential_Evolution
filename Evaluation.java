package differentialEvolution;

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
		int popSize = 10;
		double scaleFactor = 0.5;
		double crossoverRate = 0.5;
		
		double[][] solution = new double[popSize][DIMENSIONS];
		double bestValue;
		
		DifferentialEvolution diffEvol = new DifferentialEvolution(plants, markets, popSize, scaleFactor, crossoverRate);
	
		solution = diffEvol.differentialEvolution();
		bestValue = Selection.profit(solution[1]);
		for (int i = 0; i < solution.length; i++) {
			if (Selection.profit(solution[i]) > bestValue) {
				bestValue = Selection.profit(solution[i]);
			}
		}
		
		System.out.println(bestValue);
		
	}
	

}
