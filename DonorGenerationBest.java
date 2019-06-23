package differentialEvolution;

import java.util.Random;

public class DonorGenerationBest implements DonorGeneration{

	
	
	
	public double[] generateDonor(double[][] population, double scaleFactor, double[][]ranges, double costprice, int currentIndex) {
		
		int bestVector = 0;
		double profit = Selection.profit(population[0], costprice);
		double[] b;
		double[] donor = new double[9];
		double donorX;
		Random random = new Random();


		double[][] selection = new double[2][9];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = population[random.nextInt(population.length)];
		}
		
		for (int i = 1; i < population.length; i++) {
			
			if (Selection.profit(population[i], costprice) > profit) {
				bestVector = i;
				profit = Selection.profit(population[i], costprice);
			}
		}
		
		b = population[bestVector];
		
		for (int i = 0; i < 9; i++) {
			donorX = b[i] + scaleFactor*(selection[0][i] - selection[1][i]);
			if (donorX < 0) {
				donor[i] = 0;
			}else if(donorX > ranges[i][1]) {
				donor[i] = ranges[i][1];
			}else {
				donor[i] = donorX;
			}
		}
		
		return donor;
	}
}