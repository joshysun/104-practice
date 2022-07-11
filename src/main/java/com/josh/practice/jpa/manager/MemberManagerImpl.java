package com.josh.practice.jpa.manager;

import com.josh.practice.jpa.handler.MemberHandler;
import com.josh.practice.jpa.model.Member;
import com.josh.practice.jpa.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberManagerImpl implements MemberManager {
    @Autowired
    private MemberHandler memberHandler;

    @Override
    public ResponseEntity<?> addMember(Member member, HttpServletResponse response) {
        // some logic
        try {
            Member save = memberHandler.save(member);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.badRequest().body("column value is duplicated");
        }
    }

    @Override
    public ResponseEntity<?> updateMember(Member member) {
        member.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        Member update = memberHandler.save(member);
        return update == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) : ResponseEntity.ok(update);
    }

    @Override
    public ResponseEntity<?> getMemberById(Integer id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Member member = memberHandler.findById(id).orElse(null);
            return member == null ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(member);
        }
    }

    @Override
    public ResponseEntity<?> getMemberList() {
        List<Member> memberList = memberHandler.findAll();
        return memberList.size() == 0 ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(memberList);
    }

    @Override
    public ResponseEntity<?> deleteMemberById(Integer id) {
        boolean isIdExist = memberHandler.existsById(id);
        if (isIdExist) {
            memberHandler.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<?> deleteMember(MemberDto memberDto) {
        try {
            List<Integer> deleteIdList = Arrays.stream(memberDto.getDeleteIdArray()).collect(Collectors.toList());

            memberHandler.deleteAllById(deleteIdList);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
