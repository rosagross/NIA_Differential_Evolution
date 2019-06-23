package differentialEvolution;

/**
 * interface for different implementations of donorGeneration
 * @author Emilia
 *
 */
public interface DonorGeneration {

	/**
	 * generate donor for given population
	 * @param population
	 * @param scaleFactor
	 * @param ranges
	 * @param costprice
	 * @param currentIndex
	 * @return
	 */
	public double[] generateDonor(double[][] population, double scaleFactor, double[][]ranges, double costprice, int currentIndex);

}
