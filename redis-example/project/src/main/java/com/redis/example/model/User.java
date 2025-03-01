package com.redis.example.model;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class User {

    private final Long id;
    private final String name;
    private final String email;
}
