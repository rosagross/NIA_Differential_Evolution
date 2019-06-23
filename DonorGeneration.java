package differentialEvolution;


public interface DonorGeneration {

	
	public double[] generateDonor(double[][] population, double scaleFactor, double[][]ranges, double costprice, int currentIndex);

}
