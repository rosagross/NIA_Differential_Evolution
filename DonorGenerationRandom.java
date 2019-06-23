package differentialEvolution;

import java.util.Random;

public class DonorGenerationRandom implements DonorGeneration {
	
	
	
	public double[] generateDonor(double[][] population, double scaleFactor, double[][]ranges, double costprice,int currentIndex) {
		
		Random random = new Random();
		double[] donor = new double[9];
		double donorX;
		
		double[][] selection = new double[3][9];
		for (int i = 0; i < selection.length; i++) {
			selection[i] = population[random.nextInt(population.length)];
		}
		
//		System.out.println("Selection array: ");
//		Initialization.printArray2D(selection);
		for (int i = 0; i < 9; i++) {
			donorX = selection[0][i] + scaleFactor*(selection[1][i] - selection[2][i]);
			if (donorX < 0) {
				donor[i] = 0;
			}else if(donorX > ranges[i][1]) {
				donor[i] = ranges[i][1];
			}else {
				donor[i] = donorX;
			}
		}
//		System.out.println("donor");
//		Initialization.printArray(donor);
		
		return donor;
		
	}
}