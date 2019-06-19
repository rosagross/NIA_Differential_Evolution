package differentialEvolution;

public class DiffenrentialEvolution {

	private int popSize;
	double[][] population;
	
	public DiffenrentialEvolution(int popSize) {
		
		this.popSize = popSize;
	}
	
	Initialization init = new Initialization(popSize);
	population = init.initialize();

	
}
