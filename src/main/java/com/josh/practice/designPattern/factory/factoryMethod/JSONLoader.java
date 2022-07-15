package com.josh.practice.designPattern.factory.factoryMethod;

// concreteProduct
public class JSONLoader implements Loader {
    public JSONLoader() {
        // some constructor logics
    }

    @Override
    public void load() {
        System.out.println("Load from JSON");
    }
}
