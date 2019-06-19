package differentialEvolution;

import java.util.Random;

/**
 * Generate donor for crossover
 * @author Emilia
 *
 */
public class DonorGeneration {
	
	/**
	 * set scaleFactor F
	 */
	private double scaleFactor;
	
	/**
	 * constructor for donor
	 * set scaleFactor
	 * @param scaleFactor
	 */
	public DonorGeneration(double scaleFactor) {
		this.scaleFactor = scaleFactor;	
	}
	
	/**
	 * generate Donor
	 * @param whole population
	 * @return donor
	 */
	public double[] generateDonor(double[][] population) {
		
		
		Random random = new Random();
		//donor
		double[] donor = new double[9];
		
		//select three random vectors from population
		double[][] selection = new double[3][9];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = population[random.nextInt(population.length)];
		}
		
		//calculate donor
		for (int i = 0; i < 9; i++) {
			donor[i] = selection[0][i] + scaleFactor*(selection[1][i] - selection[2][i]);
		}
		return donor;
	}
}
