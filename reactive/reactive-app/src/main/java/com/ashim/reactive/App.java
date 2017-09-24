package com.ashim.reactive;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;

public class App {

	public static void main(String[] args) {

		Observable<Users> observable = new App().getData(getUsers());
		observable.subscribe(System.out::println, throwable -> System.out.println("Exception" + throwable),
				() -> System.out.println("Completed"));

	}

	private Observable<Users> getData(List<Users> users) {

		return Observable.create(subscriber -> {
			if (!subscriber.isUnsubscribed()) {
				users.stream().forEach(user -> {
					subscriber.onNext(user);

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// subscriber.onError(new RuntimeException("Wow Exception"));
				});
			}
			subscriber.onCompleted();
		});
	}

	private static List<Users> getUsers() {
		List<Users> users = new ArrayList<>();
		users.add(new Users("Bob", 10000L));
		users.add(new Users("Peter", 20000L));
		users.add(new Users("Chris", 10000L));
		return users;
	}

	static class Users {
		private String name;
		private Long salary;

		public Users(String name, Long salary) {
			this.name = name;
			this.salary = salary;
		}

		public String getName() {
			return this.name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getSalary() {
			return this.salary;
		}

		public void setSalary(Long salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Users [name=" + this.name + ", salary=" + this.salary + "]";
		}

	}

}
