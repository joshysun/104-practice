package com.josh.practice.jpa.controller;

import com.josh.practice.jpa.manager.MemberManager;
import com.josh.practice.jpa.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
    public ResponseEntity<?> deleteMemberByIdList(@RequestParam List<Integer> deleteIdList) {
        return memberManager.deleteMember(deleteIdList);
    }

    /**
     * 測試redis流程，用id找使用者資料
     * 先從redis找，沒資料的話去db找，再回寫到redis
     */
    @GetMapping("/redis-test/members/{id}")
    public ResponseEntity<?> redisGetMemberById(@PathVariable Integer id, HttpServletResponse response) {
        return memberManager.redisGetMemberById(id);
    }
}
