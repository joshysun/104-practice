package com.josh.practice.completableFuture.manager;

import com.josh.practice.completableFuture.model.CompletableFutureMember;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class CompletableFutureMemberManager {
    public CompletableFuture<CompletableFutureMember> convertNameToUpperAsync(CompletableFutureMember completableFutureMember) {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    completableFutureMember.setName(completableFutureMember.getName().toUpperCase());
                    return completableFutureMember;
                });
    }
}
