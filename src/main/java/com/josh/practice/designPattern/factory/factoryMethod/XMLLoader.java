package com.josh.practice.designPattern.factory.factoryMethod;

// concreteProduct
public class XMLLoader implements Loader {
    public XMLLoader() {
        // some constructor logics
    }

    @Override
    public void load() {
        System.out.println("Load from XML");
    }
}
