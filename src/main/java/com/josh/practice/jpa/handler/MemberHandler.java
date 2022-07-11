package com.josh.practice.jpa.handler;

import com.josh.practice.jpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHandler extends JpaRepository<Member, Integer> {

    @Query(value = "SELECT * FROM jpa_practice.members WHERE ID = :id", nativeQuery = true)
    Member customQuery(@Param("id") Integer id);

}
