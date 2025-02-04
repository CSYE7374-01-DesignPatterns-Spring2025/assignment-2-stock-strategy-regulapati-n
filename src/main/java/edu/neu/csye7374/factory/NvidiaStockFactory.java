package edu.neu.csye7374.factory;

import edu.neu.csye7374.NvidiaStock;
import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockFactoryAPI;

public class NvidiaStockFactory extends StockFactoryAPI {

    public static StockFactoryAPI getInstance(){
        return new NvidiaStockFactory();
    }
    @Override
    public Stock getStock(Double price) {
        return new NvidiaStock(price);
    }
}
