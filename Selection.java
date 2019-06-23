package differentialEvolution;


/**
 * This class selects either the original vector or the mutated vector (using the donor) 
 * The most simple method is implemented: We use the better one of both.
 * @author Tula
 *
 */
public class Selection {

	
	private static Market[] markets;
	private static Plant[] plants;
	private double costprice;
	
	/**
	 * set parameters
	 * @param markets
	 * @param plants
	 * @param costprice
	 */
	public Selection(Market[] markets, Plant[] plants, double costprice) {
		this.markets = markets;
		this.plants = plants;
		this.costprice = costprice;
	}
	
	
	/**
	 * Select the better one
	 * @param mutated
	 * @param original
	 * @return better vector
	 */
	public double[] select(double[] mutated, double[] original) {
		if (profit(mutated, this.costprice) > profit(original, this.costprice)) {
			return mutated;
		} else {
			return original;
		}
	}
	
	/**
	 * finds out the profit for one vector, needed to decide if we want mutated or original in new generation
	 * @param vector
	 * @returns profit of vector
	 */
	public static double profit(double[] vector, double costprice) {
		double cost = cost(vector, costprice);
		double revenue = revenue(vector);

		return revenue - cost;
	}
	
	
	/**
	 * purchasing cost computation, needed for cost computation
	 * @param vector, point in data space
	 * @returns purchasing cost for this point
	 */
	public static double purchasing_cost(double[] vector, double costprice) {
		
		double purchasing = 0;
		double produced = 0;
		double sold = 0;
		
		for (int i = 0; i < 3; i++) {
			produced += vector[i];
			sold += vector[i + 3];
		}
		
		purchasing = sold - produced;
		
		if (0 > purchasing) {
			purchasing = 0;
		}
		return purchasing*costprice;
	}
	
	
	/**
	 * production cost computation, needed for cost computation
	 * @param vector, point in data space of which first three entries indicating energies are relevant
	 * @returns production_cost
	 */
	public static double production_cost(double[] vector) {
		double productioncost = 0;
		for (int i = 0; i < 3; i++) {
			productioncost += plants[i].cost(vector[i]);
		}
		return productioncost;
	}
	
	
	/**
	 * cost computation
	 * @param vector, point in data space to evaluate with respect to cost
	 * @returns cost of this suggestion of values
	 */
	public static double cost(double[] vector, double costprice) {
		double prodCost = production_cost(vector);
		//System.out.println("Production cost: " + prodCost);
		return purchasing_cost(vector, costprice) + prodCost;
	}
	
	
	/**
	 * computes revenue of a vector, needed to determine profit
	 * @param a vector to evaluate with respect to revenue
	 * @returns revenue of this suggestion of values
	 */
	public static double revenue(double[] vector) {
		
		double revenue = 0;
		for (int i = 0; i < 3; i++) {
			double here = markets[i].demand(vector[i + 6]);
			if (here > vector[i + 3]) {
				here = vector[i + 3];
			}
			revenue += here*vector[i + 6];
		}
		return revenue;
	}
}