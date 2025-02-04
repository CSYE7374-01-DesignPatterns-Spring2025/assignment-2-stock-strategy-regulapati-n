package edu.neu.csye7374.factory;

import edu.neu.csye7374.AmazonStock;
import edu.neu.csye7374.Stock;
import edu.neu.csye7374.interfaces.StockFactoryAPI;

public class AmazonStockFactory extends StockFactoryAPI {

    public static StockFactoryAPI getInstance(){
        return new AmazonStockFactory();
    }
    @Override
    public Stock getStock(Double price) {
        return new AmazonStock(price);
    }
}
