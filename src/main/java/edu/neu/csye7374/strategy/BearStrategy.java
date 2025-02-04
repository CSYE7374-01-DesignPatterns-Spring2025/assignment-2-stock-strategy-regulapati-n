package edu.neu.csye7374.strategy;

import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockStrategy;

public class BearStrategy implements StockStrategy {

    private static BearStrategy instance;

    private BearStrategy() {

    }

    public static BearStrategy getInstance() {
        if(instance == null) {
            instance = new BearStrategy();
        }
        return instance;
    }
    @Override
    public int excuteMetric(Stock stock) {
        stock.metric = stock.getMetric() - 1;
        return stock.getMetric();
    }
}
