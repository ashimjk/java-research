package com.ashim.java8.optional.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LamdaCompile {

    public static void main(String[] args) {

        List<String> datas = Arrays.asList();

        datas.forEach(d -> System.out.println(d));

        datas.forEach(System.out::println);

        datas.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        for (String data : datas) {
            System.out.println(data);
        }
    }

}
