package com.ashim.reactive;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import rx.Observable;
import rx.Subscriber;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class StockService {

	private static String[] quotes = { "AAPL", "GOOG", "INTC", "BABA", "TSLA", "AIR.PA" };

	public Observable<Stock> getStock() {

		return Observable.create(subscriber -> {
			if (!subscriber.isUnsubscribed()) {
				Arrays.stream(quotes).map(quote -> this.getStock(quote, subscriber)).filter(Objects::nonNull)
						.forEach(stock -> {
							subscriber.onNext(stock);
							this.sleep(3000);
							// subscriber.onError(new RuntimeException("exception"));
						});
			}
			subscriber.onCompleted();
		});
	}

	private void sleep(int i) {
		try {
			System.out.println("Sleeping...");
			Thread.sleep(i);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private Stock getStock(String quote, Subscriber<? super Stock> subscriber) {

		System.out.println("service:: Retrieve stock info for: " + quote);
		try {
			// if (quote.equals("GOOG")) {
			// throw new IOException("Hye");
			// }
			return YahooFinance.get(quote);
		} catch (IOException e) {
			subscriber.onError(e);
		}
		return null;
	}
}