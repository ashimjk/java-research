package com.ashim.java8.optional.jvm;

public class FinalizeDemo {

    static FinalizeDemo s;

    public static void main(String[] args) throws InterruptedException{
        FinalizeDemo f = new FinalizeDemo();
        System.out.println(f.hashCode());
        f = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println(s.hashCode());
        s = null;
        System.gc();
        Thread.sleep(5000);
        System.out.println("End of Main Method");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Finalize Method Called");

        s = this;
    }
}
