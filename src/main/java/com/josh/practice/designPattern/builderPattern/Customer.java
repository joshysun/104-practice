package com.josh.practice.designPattern.builderPattern;

import lombok.Data;

@Data
public class Customer {
    private String id;      //必要
    private String name;    //必要

    private String email;   //選填
    private String phone;   //選填
    private Integer age;    //選填

    public Customer(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.age = builder.age;
    }
    public static Builder getBuilder(String id, String name) {
        return new Builder(id, name);
    }


    public static final class Builder {
        private String id;
        private String name;

        private String email;
        private String phone;
        private Integer age;

        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

}
