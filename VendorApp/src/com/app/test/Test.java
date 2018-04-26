package com.app.test;

import org.springframework.util.StopWatch;

public class Test {
	public static void main(String[] args) {
		StopWatch watch = new StopWatch("sample title");
		watch.start("task1");
		int j = 10;
		for (int i = 1; i < 150000000; i++) {

			j = j + (10 * i);

		}
		System.out.println(j);
		Long ms = watch.getTotalTimeMillis();
		Double sec = watch.getTotalTimeSeconds();
		System.out.println("milliseconds" + ms + " and seconds :" + sec);
		watch.stop();
	}
}
