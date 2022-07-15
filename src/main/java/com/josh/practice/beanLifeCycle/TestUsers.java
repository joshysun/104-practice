package com.josh.practice.beanLifeCycle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "test_users")
@AllArgsConstructor
@NoArgsConstructor
public class TestUsers {
    @Id
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
}
