package com.josh.practice.designPattern.factory.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Loader xmlLoader = new XMLLoaderFactory().createLoader();
        xmlLoader.load();

        Loader jsonLoader = new JSONLoaderFactory().createLoader();
        jsonLoader.load();
    }
}
