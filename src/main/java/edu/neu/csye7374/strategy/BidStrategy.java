package edu.neu.csye7374.strategy;

import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockStrategy;

public class BidStrategy implements StockStrategy {
    @Override
    public int excuteMetric(Stock stock) {
        stock.metric = 0;
        return 0;
    }
}
