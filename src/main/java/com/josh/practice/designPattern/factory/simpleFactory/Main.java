package com.josh.practice.designPattern.factory.simpleFactory;

public class Main {
    public static void main(String[] args) {
        Loader loader = LoaderFactory.getLoader(LoaderFactory.LoaderType.JSON);
        loader.load();
    }
}
