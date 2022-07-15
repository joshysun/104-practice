package com.josh.practice.designPattern.factory.simpleFactory;

public class XMLLoader implements Loader {
    public XMLLoader(){
        // some customized constructor logics
    }

    @Override
    public void load() {
        System.out.println("Load from XML");
    }
}
