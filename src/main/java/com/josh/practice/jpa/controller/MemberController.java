package com.josh.practice.jpa.controller;

import com.josh.practice.jpa.manager.MemberManager;
import com.josh.practice.jpa.model.Member;
import com.josh.practice.jpa.model.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/v1")
public class MemberController {
    @Autowired
    private MemberManager memberManager;

    @GetMapping("/members/{id}")
    public ResponseEntity<?> getMemberById(@PathVariable("id") Integer id) {
        return memberManager.getMemberById(id);
    }

    @GetMapping("/members")
    public ResponseEntity<?> getMemberList() {
        return memberManager.getMemberList();
    }

    @PostMapping("/members")
    public ResponseEntity<?> addMember(Member member, HttpServletResponse response) {
        return memberManager.addMember(member, response);
    }

    @PutMapping("/members")
    public ResponseEntity<?> updateMember(Member member) {
        return memberManager.updateMember(member);
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable("id") Integer id) {
        return memberManager.deleteMemberById(id);
    }

    @DeleteMapping("/members")
    public ResponseEntity<?> deleteMemberByIdList(@RequestBody MemberDto memberDto) {
        return memberManager.deleteMember(memberDto);
    }
}
