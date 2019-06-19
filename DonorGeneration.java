package differentialEvolution;

import java.util.Random;

public class DonorGeneration {
	
	private double scaleFactor;
	
	
	public DonorGeneration(double scaleFactor) {
		this.scaleFactor = scaleFactor;	
	}
	
	public double[] generateDonor(double[][] population) {
		
		Random random = new Random();
		double[] donor = new double[9];
		
		double[][] selection = new double[3][9];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = population[random.nextInt(population.length)];
		}
		
		for (int i = 0; i < 9; i++) {
			donor[i] = selection[0][i] + scaleFactor*(selection[1][i] - selection[2][i]);
		}
		
		
		return donor;
		
	}

}
