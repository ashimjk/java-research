package com.ashim.solution2;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {
        new StrategyImplementation();

        String[] words = new String[]{"ashim", "ashish", "pabitra"};

        String singleWord = Stream.of(words)
                .distinct()
                .map(String::toLowerCase)
                .filter(w -> w.contains("as"))
                .distinct()
                .collect(Collectors.joining(","));

        System.out.println(singleWord);

        if (singleWord != "")
            System.out.println(singleWord);
    }

}
