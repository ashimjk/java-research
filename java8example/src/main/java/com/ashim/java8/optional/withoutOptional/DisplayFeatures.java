package com.ashim.java8.optional.withoutOptional;

public class DisplayFeatures {

    private String size;
    private ScreenResolution resolution;

    public DisplayFeatures(String size, ScreenResolution resolution){
        this.size = size;
        this.resolution = resolution;
    }

    public String getSize() {
        return size;
    }
    public ScreenResolution getResolution() {
        return resolution;
    }

}