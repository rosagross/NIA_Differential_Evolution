package differentialEvolution;

import java.util.Random;

/**
 * Generate donor by choosing the target vector shifted to the best vector as basis vector
 * @author Emilia
 *
 */
public class DonorGenerationTargetToBest implements DonorGeneration {

	
	/**
	 * construct donor
	 * @param population
	 * @param scaleFactor
	 * @param ranges
	 * @param costprice
	 * @param currentIndex
	 * @return donor
	 */
	public double[] generateDonor(double[][] population, double scaleFactor, double[][]ranges, double costprice, int currentIndex) {
		
		Random random = new Random();
		double donorX;
		double[] donor = new double[9];
		double[] x = population[currentIndex];
		
		//select two random vectors
		double[][] selection = new double[2][9];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = population[random.nextInt(population.length)];
		}
		
		int bestVector = 0;
		double profit = Selection.profit(population[0], costprice);

		
		//find best vector
		for (int i = 1; i < population.length; i++) {
			if (Selection.profit(population[i], costprice) > profit) {
				bestVector = i;
				profit = Selection.profit(population[i], costprice);
			}
		}
		
		//calculate basis vector shifted to best vector
		double[] xB = population[bestVector];
		double[] b = new double[9];
		
		for (int i = 0; i < 9; i++) {
			donorX = x[i] + scaleFactor*(xB[i] - x[i]);
			if (donorX < 0) {
				b[i] = 0;
			} else if(donorX > ranges[i][1]) {
				b[i] = ranges[i][1];
			} else {
				b[i] = donorX;
			}
		}
		
		//shift basis vector
		for (int i = 0; i < 9; i++) {
			donorX = b[i] + scaleFactor*(selection[0][i] - selection[1][i]);
			if (donorX < 0) {
				donor[i] = 0;
			} else if(donorX > ranges[i][1]) {
				donor[i] = ranges[i][1];
			} else {
				donor[i] = donorX;
			}
		}
	
		return donor;
	}
}
