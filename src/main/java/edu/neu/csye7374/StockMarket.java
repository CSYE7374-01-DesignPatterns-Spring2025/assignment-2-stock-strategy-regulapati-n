package edu.neu.csye7374;

import edu.neu.csye7374.factory.AmazonEagerStockFactory;
import edu.neu.csye7374.factory.AmazonStockFactory;
import edu.neu.csye7374.factory.NvidiaLazyStockFactory;
import edu.neu.csye7374.factory.NvidiaStockFactory;
import edu.neu.csye7374.interfaces.StockFactoryAPI;
import edu.neu.csye7374.interfaces.StockStrategy;
import edu.neu.csye7374.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {

	private static StockMarket instance;

	private List<Stock> stocks = new ArrayList<>();

	private StockMarket() {
		instance = null;
	}

	public static StockMarket getInstance() {

		if (instance == null) {
			instance = new StockMarket();
		}

		return instance;
	}

	public Stock getStockItem(String name, double price, String description) {
		return new Stock(name, price, description);
	}

	public void add(Stock stock) {
		stocks.add(stock);
	}

	public void remove(Stock s) {

		boolean removed = this.stocks.remove(s);

		if (!removed) {
			System.out.println("stock not found");
		}
	}

	public void displayStocks() {
		for (Stock s : this.stocks) {
			System.out.println(s.toString());
		}
	}

	public void updatePrice(Stock s, double price) {

		if (this.stocks.contains(s)) {
			s.setPrice(price);
			return;
		}

		System.out.println("stock not found");
	}

	public static void demo() {
		
		System.out.println("");
		
//		NvidiaStock nvidia_s1 = new NvidiaStock(45);
//		AmazonStock amazon_s2 = new AmazonStock(20);

		//Via Singleton
		StockFactoryAPI nvidiaSingletonStockFactory = NvidiaLazyStockFactory.getInstance();
		StockFactoryAPI amazonSingletonStockFactory = AmazonEagerStockFactory.getInstance();

		Stock amazon_s1 = amazonSingletonStockFactory.getStock(45.0);
		Stock nvidia_s1 = nvidiaSingletonStockFactory.getStock(20.0);

		StockFactoryAPI nvidiaStockFactory = NvidiaStockFactory.getInstance();
		StockFactoryAPI amazonStockFactory = AmazonStockFactory.getInstance();

		StockStrategy doubleStrategy = new DoubleBidStrategy();
		StockStrategy tripleStrategy = new TripleBidStrategy();
		StockStrategy bidStrategy = new BidStrategy();
		StockStrategy bearStrategy = BearStrategy.getInstance();
		StockStrategy bullStrategy = BullStrategy.getInstance();

		Stock nvidia_s2 = nvidiaStockFactory.getStock(21.0);
		Stock amazon_s2 = amazonStockFactory.getStock(46.0);
		
		StockMarket.getInstance().add(amazon_s2);
		StockMarket.getInstance().add(nvidia_s2);
		StockMarket.getInstance().add(nvidia_s1);
		StockMarket.getInstance().add(amazon_s1);

		
		amazon_s2.setBid(10);
		amazon_s2.getMetric();

		amazon_s1.setBid(11);
		amazon_s1.getMetric();
		
		nvidia_s1.setBid(100);
		nvidia_s1.getMetric();
		nvidia_s2.setBid(100);
		nvidia_s2.getMetric();
		StockMarket.getInstance().displayStocks();
		System.out.println();
		
		amazon_s2.setBid(40);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(120);
		nvidia_s1.getMetric();
		StockMarket.getInstance().displayStocks();
		System.out.println();
		
		amazon_s2.setBid(510);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(120);
		nvidia_s1.getMetric();
		StockMarket.getInstance().displayStocks();
		System.out.println();

		amazon_s2.setBid(60);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(20);
		nvidia_s1.getMetric();
		StockMarket.getInstance().displayStocks();
		System.out.println();
		
		amazon_s2.setBid(70);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(16);
		nvidia_s1.getMetric();
		StockMarket.getInstance().displayStocks();
		System.out.println();
		
		amazon_s2.setBid(80);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(10);
		nvidia_s1.getMetric();
		
		StockMarket.getInstance().displayStocks();
		System.out.println();
		
		amazon_s2.setBid(122);
		amazon_s2.getMetric();
		
		nvidia_s1.setBid(111);
		nvidia_s1.getMetric();

		System.out.println("CALLING STRATEGY NVIDIA====");
		nvidia_s1.useStrategicMetric(doubleStrategy);
		nvidia_s1.useStrategicMetric(tripleStrategy);
		nvidia_s1.useStrategicMetric(bidStrategy);
		nvidia_s1.useStrategicMetric(bullStrategy);
		nvidia_s1.useStrategicMetric(bearStrategy);
		StockMarket.getInstance().displayStocks();
		System.out.println("ENDING STRATEGY NVIDIA====");

		System.out.println("CALLING STRATEGY AMAZON====");
		amazon_s2.useStrategicMetric(doubleStrategy);
		amazon_s2.useStrategicMetric(tripleStrategy);
		amazon_s2.useStrategicMetric(bidStrategy);
		amazon_s2.useStrategicMetric(bullStrategy);
		amazon_s2.useStrategicMetric(bearStrategy);
		StockMarket.getInstance().displayStocks();
		System.out.println("ENDING STRATEGY AMAZON====");
		
		System.out.println();
		
		StockMarket.getInstance().remove(amazon_s2);
		StockMarket.getInstance().displayStocks();

	}
}