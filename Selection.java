package differentialEvolution;

public class Selection {

	/*
	 * This class selects either the original vector or the mutated vector (using the donor) 
	 * The most simple method is implemented: We use the better one of both.
	 * !!! The 0.6 in purchasing cost might be tunable !!!
	 * @author Tula
	 */
	
	private Market[] markets;
	private Plant[] plants;
	
	public Selection(Market[] markets, Plant[] plants) {
		this.markets = markets;
		this.plants = plants;
	}
	
	/*
	 * Select the better one
	 * @param two vectors to be compared with respect to profit maximization
	 * @returns better vector
	 */
	public double[] select(double[] mutated, double[] original) {
		if (profit(mutated) > profit(original)) {
			return mutated;
		} else {
			return original;
		}
	}
	
	
	/*
	 * finds out the profit for one vector, needed to decide if we want mutated or original in new generation
	 * @param vector
	 * @returns profit of vector
	 */
	public double profit(double[] vector) {
		return revenue(vector) - cost(vector);
	}
	
	
	/*
	 * purchasing cost computation, needed for cost computation
	 * @param vector, point in data space
	 * @returns purchasing cost for this point
	 */
	public double purchasing_cost(double[] vector) {
		
		double purchasing = 0;
		double produced = 0;
		double sold = 0;
		
		for (int i = 0; i < 4; i++) {
			produced += vector[i];
			sold += vector[i + 3];
		}
		
		purchasing = sold - produced;
		
		if (0 > purchasing) {
			purchasing = 0;
		}
		return purchasing*0.6;
	}
	
	
	/*
	 * production cost computation, needed for cost computation
	 * @param vector, point in data space of which first three entries indicating energies are relevant
	 * @returns production_cost
	 */
	public double production_cost(double[] vector) {
		double cost = 0;
		for (int i = 0; i < 4; i++) {
			cost += plants[i].cost(vector[i]);
		}
		return cost;
	}
	
	
	/*
	 * cost computation
	 * @param vector, point in data space to evaluate with respect to cost
	 * @returns cost of this suggestion of values
	 */
	public double cost(double[] vector) {
		return purchasing_cost(vector) + production_cost(vector);
	}
	
	
	/*
	 * computes revenue of a vector, needed to determine profit
	 * @param a vector to evaluate with respect to revenue
	 * @returns revenue of this suggestion of values
	 */
	public double revenue(double[] vector) {
		
		double revenue = 0;
		
		for (int i = 0; i < 4; i++) {
			double here = markets[i].demand(vector[i + 6]);
			if (here > vector[i + 3]) {
				here = vector[i + 3];
			}
			revenue += here*vector[i + 6];
		}
		
		return revenue;
	}
}
