package com.josh.practice.designPattern.factory.factoryMethod;

// concreteFactory
public class XMLLoaderFactory implements LoaderFactory{
    public XMLLoaderFactory() {
    }

    @Override
    public Loader createLoader() {
        // some logics before constructing XMLLoder
        return new XMLLoader();
    }
}
