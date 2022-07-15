package com.josh.practice.beanLifeCycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@RestController
public class TestController {
    @Autowired
    TestUsersHandler testUsersHandler;

    @PostConstruct
    void addTestUser() {
        System.out.println(".....into postConstruct method.....");
        testUsersHandler.save(new TestUsers(1, "test1", 1));
        testUsersHandler.save(new TestUsers(2, "test2", 2));
    }

    @PreDestroy
    void deleteTestUser() {
        System.out.println(".....into preDestroy method.....");
        testUsersHandler.deleteAll();
    }
}
