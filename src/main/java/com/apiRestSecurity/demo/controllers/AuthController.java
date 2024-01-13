package com.apiRestSecurity.demo.controllers;

import com.apiRestSecurity.demo.model.LoginRequest;
import com.apiRestSecurity.demo.model.LoginResponse;
import com.apiRestSecurity.demo.security.JwtIssuer;
import com.apiRestSecurity.demo.security.UserPrincipal;
import com.apiRestSecurity.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        return authService.attemptLoggin(request.getEmail(),request.getPassword());

}

    @GetMapping("/secured")
    public String secured(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return "if you see this, then you're logged in as email: "+userPrincipal.getEmail()+" ,userId: "+userPrincipal.getUserId();
    }
}
