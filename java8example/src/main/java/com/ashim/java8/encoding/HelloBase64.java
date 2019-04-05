package com.ashim.java8.encoding;

import java.util.Base64;

public class HelloBase64 {

    public static void main(String[] args) {

        String msg = "Hello, Base64!";
        Base64.Encoder enc = Base64.getEncoder();
        byte[] encBytes = enc.encode(msg.getBytes());

        for (int i = 0; i < encBytes.length; i++) {
            System.out.printf("%c", (char) encBytes[i]);
            if (i != 0 && i % 4 == 0)
                System.out.print(' ');
        }

        System.out.println();

        Base64.Decoder dec = Base64.getDecoder();
        byte[] decBytes = dec.decode(encBytes);
        System.out.println(new String(decBytes));

    }

}