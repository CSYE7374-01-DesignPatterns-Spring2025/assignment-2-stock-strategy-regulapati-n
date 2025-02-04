package edu.neu.csye7374;

import java.util.List;

public interface Tradeable1 {
	
    default double getMetric(List<Double> prevPrices) {
    	
		double mean = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
		double dev = 0.0;
		for (double num : prevPrices) {
			dev += mean - num;
		}
		dev = dev / prevPrices.size();
		return dev > 0.0 ? 1 : -1;
    }
    
//	void setBid(double bid);
}