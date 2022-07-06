package com.josh.practice.iocAndDi;

/**
 * 沒有使用DI / IOC的例子。
 * <p>
 *     在Zoo裡new Tiger(), new Zebra()，這樣會讓Zoo和Tiger, Zebra有了耦合。
 * </p>
 */
public class OldZoo {
    Animal tiger;
    Animal zebra;

    public OldZoo() {
        tiger = new Tiger();
        zebra = new Zebra();
        tiger.eat();
        zebra.eat();
    }


    interface Animal {
        public void eat();
    }

    class Tiger implements Animal {
        @Override
        public void eat() {
            System.out.println("老虎吃肉");
        }
    }

    class Zebra implements Animal {
        @Override
        public void eat() {
            System.out.println("斑馬吃草");
        }
    }
}
