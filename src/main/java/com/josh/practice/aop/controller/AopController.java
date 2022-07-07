package com.josh.practice.aop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 測試AOP
 */
@RestController
@RequestMapping("/api/aop")
public class AopController {
    @GetMapping("/test/{randomId}")
    public ResponseEntity<?> testAOP(@PathVariable String randomId) throws IllegalAccessException {
        System.out.println("AopController內自己sysout");
        boolean errorSwitch = false;
//        errorSwitch = true;
        if (errorSwitch) {
            throw new IllegalAccessException("something went wrong!!!!!");
        }
        return new ResponseEntity<>("這是一個測試aop的api", HttpStatus.OK);
    }
}
