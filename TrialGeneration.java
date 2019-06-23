package differentialEvolution;

public interface TrialGeneration {

	
	public double[] generateTrial(double[] donor, double[]populationX, double[][] ranges, double crossoverRate);
	
	
}
