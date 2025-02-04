package edu.neu.csye7374;

import edu.neu.csye7374.interfaces.StockStrategy;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Tradable {

	private String name;

	private double price;

	private String description;
	
	public int metric;

	protected double metricVal;

	protected StockStrategy strategy;

	protected List<Double> prevPrices = new ArrayList<>();

	public Stock() {
		super();
	}

	public Stock(String name, double price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		init(price);
	}

	private void init(double price) {
		prevPrices.add(price);
	}

	public String getName() {
		return name;
	}

	public List<Double> getPrevPrices() {
		return this.prevPrices;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Stock [name=" + name + ", price=" + price + ", description=" + description + "Metric : " + metric + "]";
	}

	@Override
	public int getMetric() {
		double mean = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
		double dev = 0.0;
		for (double num : prevPrices) {
			dev += mean - num;
		}
		dev = dev / prevPrices.size();
		this.metric = dev > 33.5 ? 1 : -1;

		return this.metric;
	}

	public int useStrategicMetric(StockStrategy strategy) {
		return strategy.excuteMetric(this);
	}

	@Override
	public void setBid(double bid) {
	    prevPrices.add(bid);
	    double newPrice = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum())/prevPrices.size();
	    StockMarket.getInstance().updatePrice(this, newPrice);
	}
}