package com.josh.practice.designPattern.factory.factoryMethod;

// concreteFactory
public class JSONLoaderFactory implements LoaderFactory {
    public JSONLoaderFactory() {
    }

    @Override
    public Loader createLoader() {
        // some logics before creating JSONLoader
        return new JSONLoader();
    }
}
