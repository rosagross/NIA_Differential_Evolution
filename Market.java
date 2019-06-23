package differentialEvolution;

/**
 * 
 * @author Emilia, Rosa, Tula
 *
 */
public class Market {

	private double maxPrice;
	private double maxDemand;

	/**
	 * set parameters for market
	 * @param price
	 * @param demand
	 */
	public Market(double price, double demand) {
		this.maxPrice = price;
		this.maxDemand = demand;
	}

	/**
	 * calculate demand
	 * @param price
	 * @return demand
	 */
	public double demand(double price) {

		//if price is greater than max price, return 0
		if (price > maxPrice) {
			return 0;
		}

		//If product is free return max demand
		if (price <= 0) {
			return maxDemand;
		}

		//else determine demand based on price
		double demandNew = maxDemand - Math.pow(price, 2)*maxDemand/Math.pow(maxPrice, 2);

		return demandNew;
	}

	/**
	 * Getter method for the maxDemand of the market
	 * @return maxDemand the maximum demand of a market
	 */
	public double getDemand() {
		return this.maxDemand;
	}

	/**
	 * Getter method for the maximum price
	 * @return
	 */
	public double getMaxPrice() {
		return this.maxPrice;
	}

}