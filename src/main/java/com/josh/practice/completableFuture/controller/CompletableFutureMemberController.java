package com.josh.practice.completableFuture.controller;

import com.josh.practice.completableFuture.manager.CompletableFutureMemberManager;
import com.josh.practice.completableFuture.model.CompletableFutureMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/completable-future/members")
public class CompletableFutureMemberController {
    public static List<CompletableFutureMember> completableFutureMemberList = new ArrayList<>();

    @Autowired
    CompletableFutureMemberManager completableFutureMemberManager;

    @GetMapping
    public ResponseEntity<?> getMembersWithUpperName() {
        // 傳送多筆請求
        List<CompletableFuture<CompletableFutureMember>> completableFutures = completableFutureMemberList.stream()
                .map(completableFutureMember -> completableFutureMemberManager.convertNameToUpperAsync(completableFutureMember))
                .collect(Collectors.toList());

        // 不需要CompletableFuture<Void>，需要的是CompletableFuture<List<Model>>，所以使用CompletableFuture.join()來建立CompletableFuture<List<Model>>
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()]));

        // 現在就可以取得最終的CompletableFuture which holds our results
        CompletableFuture<List<CompletableFutureMember>> allCompletableFuture = allFutures.thenApply(unused -> {
            return completableFutures
                    .stream()
                    .map(s -> s.join())
                    .collect(Collectors.toList());
        });

        // 操作CompletableFuture的results
        CompletableFuture<List<CompletableFutureMember>> completableFuture = allCompletableFuture.thenApply(members -> {
            return members
                    .stream()
                    .map(completableFutureMember -> completableFutureMember)
                    .collect(Collectors.toList());
        });

        return completableFuture.join().size() == 0 ? ResponseEntity.badRequest().body("there's nothing to return") : ResponseEntity.ok(completableFuture.join());
    }

    @PostConstruct
    void addMembers() {
        CompletableFutureMember josh = CompletableFutureMember.builder()
                .id(1)
                .name("josh")
                .email("josh@gmail.com")
                .age(24)
                .build();
        CompletableFutureMember joe = CompletableFutureMember.builder()
                .id(2)
                .name("joe")
                .email("joe@gmail.com")
                .age(24)
                .build();
        CompletableFutureMember jozianne = CompletableFutureMember.builder()
                .id(3)
                .name("jozianne")
                .email("jozianne@gmail.com")
                .age(26)
                .build();
        CompletableFutureMember jowin = CompletableFutureMember.builder()
                .id(4)
                .name("jowin")
                .email("jowin@gmail.com")
                .age(28)
                .build();
        completableFutureMemberList.add(josh);
        completableFutureMemberList.add(joe);
        completableFutureMemberList.add(jozianne);
        completableFutureMemberList.add(jowin);
    }
}
