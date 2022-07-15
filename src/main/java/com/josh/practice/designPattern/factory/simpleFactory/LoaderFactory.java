package com.josh.practice.designPattern.factory.simpleFactory;

public class LoaderFactory {
    // private建構子無法被實例化
    private LoaderFactory() {
        throw new AssertionError("factory class cannot be instantiated");
    }

    public static Loader getLoader(LoaderType loaderType) {
        switch (loaderType) {
            case XML: {
                // 建構物件所需參數的複雜邏輯
                return new XMLLoader();
            }
            case JSON: {
                // 建構物件所需參數的複雜邏輯
                return new JSONLoader();
            }
            default: {
                return null;
            }
        }

    }

    public enum LoaderType {
        XML, JSON
    }

}
