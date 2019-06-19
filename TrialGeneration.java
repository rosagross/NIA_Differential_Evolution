package differentialEvolution;

import java.util.Random;

/**
 * generate trial from donor and current population with binomial crossover
 * @author Emilia
 *
 */
public class TrialGeneration {

	/**
	 * probability to select element from donor
	 */
	private double crossoverRate;
	
	
	final int DIMENSIONS = 9;
	
	/**
	 * constructor for TrialGeneration
	 * set crossoverRate
	 * @param crossoverRate
	 */
	public TrialGeneration(double crossoverRate) {
		this.crossoverRate = crossoverRate;
	}
	
	
	/**
	 * method for generating the trial
	 * @param donor from generate donor
	 * @param populationX from whole population
	 * @return trial
	 */
	public double[] generateTrial(double[] donor, double[]populationX) {
		
		Random random = new Random();
		//trial
		double[] trial = new double[DIMENSIONS];
		//starting point
		int r = random.nextInt(DIMENSIONS);
		//probabilities
		double[] c = new double[DIMENSIONS];
		
		//take element with index r(start) from donor
		trial[r] = donor[r];
		
		//calculate sequence of random numbers between 0 and 1
		for (int i = 0; i < trial.length; i++) {
			c[i] = random.nextDouble();
		}
		
		//generate trial with c
		for (int i = 1; i < trial.length; i++) {
			
			if (c[i] < crossoverRate) {
				trial[(r + i)%DIMENSIONS] = donor[i];
			} else {
				trial[(r + i)%DIMENSIONS] = populationX[i];
			}	
		}
		return trial;
	}
}
