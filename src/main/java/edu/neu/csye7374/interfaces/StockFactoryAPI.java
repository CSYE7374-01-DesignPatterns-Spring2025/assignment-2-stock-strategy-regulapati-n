package edu.neu.csye7374.interfaces;

import edu.neu.csye7374.Stock;

public abstract class StockFactoryAPI {

    public abstract Stock getStock(Double price);
}
