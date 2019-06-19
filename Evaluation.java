package differentialEvolution;

public class DiffenrentialEvolution {

	private int pop_size;
	double[][] population;
	
	public DiffenrentialEvolution(int pop_size) {
		
		this.pop_size = pop_size;
	}
	
	Initialization init = new Initialization(pop_size);
	population = init.initialize();

	
}
