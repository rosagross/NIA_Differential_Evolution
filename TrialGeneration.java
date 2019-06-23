package differentialEvolution;

/**
 * Interface for different trial generation versions
 * @author Emilia
 *
 */
public interface TrialGeneration {

	/**
	 * method for generating trial from donor and population vector
	 * @param donor
	 * @param populationX
	 * @param ranges
	 * @param crossoverRate
	 * @return
	 */
	public double[] generateTrial(double[] donor, double[]populationX, double[][] ranges, double crossoverRate);
	
	
}
