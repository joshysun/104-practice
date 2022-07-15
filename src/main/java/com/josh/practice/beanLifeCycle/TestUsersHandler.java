package com.josh.practice.beanLifeCycle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestUsersHandler extends JpaRepository<TestUsers, Integer> {
}
