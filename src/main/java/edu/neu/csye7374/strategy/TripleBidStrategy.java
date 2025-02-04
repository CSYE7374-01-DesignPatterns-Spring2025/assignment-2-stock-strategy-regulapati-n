package edu.neu.csye7374.strategy;

import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockStrategy;

import java.util.List;

public class TripleBidStrategy implements StockStrategy {
    @Override
    public int excuteMetric(Stock stock) {
        List<Double> prevPrices = stock.getPrevPrices();
        double mean = (prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / prevPrices.size();
        double dev = 0.0;
        for (double num : prevPrices) {
            dev += mean - num/3;
        }
        dev = dev / prevPrices.size();
        stock.metric = dev > 150 ? 2 : 1;
        return stock.metric;
    }
}
