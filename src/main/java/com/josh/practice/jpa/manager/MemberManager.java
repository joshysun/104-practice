package com.josh.practice.jpa.manager;

import com.josh.practice.jpa.model.Member;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MemberManager {
    ResponseEntity<?> addMember(Member member, HttpServletResponse response);

    ResponseEntity<?> updateMember(Member member);

    ResponseEntity<?> getMemberById(Integer id);

    ResponseEntity<?> getMemberList();

    ResponseEntity<?> deleteMemberById(Integer id);

    ResponseEntity<?> deleteMember(List<Integer> deleteIdList);

    ResponseEntity<?> redisGetMemberById(Integer id);
}
