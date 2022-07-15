package com.josh.practice.designPattern.builderPattern;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BuildPatternTest {

    @Test
    void customerBuildPatternTest() {
        Customer customer1 = Customer.getBuilder("A0001", "Amber Wang").build();
        Customer customer2 = Customer.getBuilder("A0002", "May li")
                .setEmail("may-li@abc.com").build();
        Customer customer3 = Customer.getBuilder("A0003", "Ken Liu")
                .setEmail("ken-liu@abc.com")
                .setPhone("0917006740")
                .build();
        Customer customer4 = Customer.getBuilder("A0004", "Ray Chen")
                .setEmail("ray-chen@abc.com")
                .setPhone("0917006740")
                .setAge(22)
                .build();
        Customer customer5 = Customer.getBuilder("A0005", "Dan Hu")
                .setAge(33)
                .build();

        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        customerList.add(customer4);
        customerList.add(customer5);

        customerList.forEach(System.out::println);
    }

}