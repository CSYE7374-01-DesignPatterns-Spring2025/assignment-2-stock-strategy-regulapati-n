package edu.neu.csye7374.factory;

import edu.neu.csye7374.NvidiaStock;
import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockFactoryAPI;

public class NvidiaLazyStockFactory extends StockFactoryAPI {

    private static StockFactoryAPI instance;

    public static StockFactoryAPI getInstance() {
        if(instance == null) {
            instance = new NvidiaLazyStockFactory();
        }
        return instance;
    }
    @Override
    public Stock getStock(Double price) {
        return new NvidiaStock(price);
    }
}
