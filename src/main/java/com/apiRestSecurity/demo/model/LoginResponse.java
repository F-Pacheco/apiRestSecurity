package com.apiRestSecurity.demo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class LoginResponse {
    private final String accesToken;
}
