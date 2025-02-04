package edu.neu.csye7374;

public class AmazonStock extends Stock {

	public AmazonStock(double price) {
		super("Amazon", price, "Ecommerse and Shopping Mall");
	}

	@Override
	public int getMetric() { // I have overrided the getMetric method
		double mean = (this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
		double dev = 0.0;
		for (double num : prevPrices) {
			dev += mean*2 - num/3;
		}
		dev = dev / prevPrices.size();

		this.metric =  dev > 200 ? 1 : -1;
		return this.metric;
	}

	@Override
	public String toString() {
		return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + "Metric : " + this.metric + "]";
	}

}