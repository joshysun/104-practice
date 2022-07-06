package com.josh.practice.iocAndDi;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 有使用DI / IOC的例子。
 * <p>
 *     只要使用@Resouce，不用再new Tiger(), new Zebra()，以降低物件間的耦合。
 * </p>
 */
public class NewZoo {
    // @Resource: 容器會幫我們去找對應的bean名稱
    @Resource(name = "tiger")
    Animal tiger;
    @Resource(name = "zebra")
    Animal zebra;

    public NewZoo() {
        tiger.eat();
        zebra.eat();
    }


    interface Animal {
        void eat();
    }
    @Component
    class Tiger implements Animal {
        @Override
        public void eat() {
            System.out.println("老虎吃肉");
        }
    }
    @Component
    class Zebra implements Animal {
        @Override
        public void eat() {
            System.out.println("斑馬吃草");
        }
    }
}

