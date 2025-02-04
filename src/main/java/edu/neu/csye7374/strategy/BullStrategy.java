package edu.neu.csye7374.strategy;

import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockStrategy;

public class BullStrategy implements StockStrategy {

    private static BullStrategy instance;

    private BullStrategy() {

    }

    public static BullStrategy getInstance() {
        if(instance == null) {
            instance = new BullStrategy();
        }
        return instance;
    }
    @Override
    public int excuteMetric(Stock stock) {
        stock.metric = stock.getMetric() + 1;
        return stock.getMetric() + 1;
    }
}
