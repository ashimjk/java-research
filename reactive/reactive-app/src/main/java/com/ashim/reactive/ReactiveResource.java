package com.ashim.reactive;

import rx.Observable;
import yahoofinance.Stock;

public class ReactiveResource {

	public static void main(String[] args) {

		Observable<Stock> stockQuote = new ReactiveResource().getStockQuote();
		System.out.println("Going to Subscribe");
		stockQuote.subscribe(ReactiveResource::callBack, ReactiveResource::errorCallBack,
				ReactiveResource::completeCallBack);

		System.out.println("Processing completed");

	}

	private static void completeCallBack() {
		System.out.println("completeCallBack:: Completed Successfully");
	}

	private static void errorCallBack(Throwable throwable) {
		System.out.println("errorCallBack:: " + throwable);
	}

	private static void callBack(Stock stock) {

		System.out.println(
				String.format("callBack:: Quote: %s, Price: %s, Day's High: %s, " + "Day's Low: %s", stock.getSymbol(),
						stock.getQuote().getPrice(), stock.getQuote().getDayHigh(), stock.getQuote().getDayLow()));

	}

	private Observable<Stock> getStockQuote() {
		return new StockService().getStock();
	}

}