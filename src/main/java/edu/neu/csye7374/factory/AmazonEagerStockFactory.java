package edu.neu.csye7374.factory;

import edu.neu.csye7374.AmazonStock;
import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockFactoryAPI;

public class AmazonEagerStockFactory extends StockFactoryAPI {

    private static StockFactoryAPI instance = new AmazonEagerStockFactory();

    public static StockFactoryAPI getInstance() {
        return instance;
    }
    @Override
    public Stock getStock(Double price) {
        return new AmazonStock(price);
    }
}
