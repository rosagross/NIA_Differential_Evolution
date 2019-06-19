package differentialEvolution;

public class Market {

	
	
	private double price;
	
	private double demand;
	
	public Market(double price, double demand) {
		this.price = price;
		this.demand = demand;
	}
	
	
	
	private double demand(double price, double maxPrice, double maxDemand) {
		
		//if price is greater than max price, return 0
		if (price > maxPrice) {
			return 0;
		}
		
		//If product is free return max demand
		if (price <= 0) {
			return maxDemand;
		}
		
		//else determine demand based on price
		demand = maxDemand - Math.pow(price, 2)*maxDemand/Math.pow(maxPrice, 2);
		
		return demand;
		
	}
}
