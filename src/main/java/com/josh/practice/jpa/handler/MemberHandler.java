package com.josh.practice.jpa.handler;

import com.josh.practice.jpa.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHandler extends JpaRepository<Member, Integer> {

}
