package com.ashim.java8.encoding;

import java.io.*;

import java.util.Base64;

public class FileEncDec {

    public static void main(String[] args) {

        args= new String[1];
        args[0] = "src/main/resources/img_ex.jpeg";
        File file = new File(args[0]);
        System.out.println(file.isFile());
        if (args.length != 1) {
            System.err.println("usage: java FileEncDec filename");
            return;
        }
        System.out.println(args[0]);

        try (FileInputStream fis = new FileInputStream(args[0])) {

            Base64.Encoder enc1 = Base64.getEncoder();
            Base64.Encoder enc2 = Base64.getMimeEncoder();
            Base64.Encoder enc3 = Base64.getUrlEncoder();

            OutputStream os1 = enc1.wrap(new FileOutputStream(args[0] + "1.enc"));
            OutputStream os2 = enc2.wrap(new FileOutputStream(args[0] + "2.enc"));
            OutputStream os3 = enc3.wrap(new FileOutputStream(args[0] + "3.enc"));

            int _byte;

            while ((_byte = fis.read()) != -1) {
                os1.write(_byte);
                os2.write(_byte);
                os3.write(_byte);
            }

            os1.close();
            os2.close();
            os3.close();

        } catch (IOException ioe) {
            System.err.printf("I/O error: %s%n", ioe.getMessage());
        }

        try (FileOutputStream fos1 = new FileOutputStream("1" + args[0]);
             FileOutputStream fos2 = new FileOutputStream("2" + args[0]);
             FileOutputStream fos3 = new FileOutputStream("3" + args[0])) {

            Base64.Decoder dec1 = Base64.getDecoder();
            Base64.Decoder dec2 = Base64.getMimeDecoder();
            Base64.Decoder dec3 = Base64.getUrlDecoder();

            InputStream is1 = dec1.wrap(new FileInputStream(args[0] + "1.enc"));
            InputStream is2 = dec2.wrap(new FileInputStream(args[0] + "2.enc"));
            InputStream is3 = dec3.wrap(new FileInputStream(args[0] + "3.enc"));

            int _byte;

            while ((_byte = is1.read()) != -1)
                fos1.write(_byte);
            while ((_byte = is2.read()) != -1)
                fos2.write(_byte);
            while ((_byte = is3.read()) != -1)
                fos3.write(_byte);

            is1.close();
            is2.close();
            is3.close();

        } catch (IOException ioe) {
            System.err.printf("I/O error: %s%n", ioe.getMessage());
        }

    }

}