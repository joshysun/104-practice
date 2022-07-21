package com.josh.practice.completableFuture.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompletableFutureMember {
    private Integer id;
    private String name;
    private String email;
    private Integer age;
}
