package com.apiRestSecurity.demo.service;

import com.apiRestSecurity.demo.model.LoginResponse;
import com.apiRestSecurity.demo.security.JwtIssuer;
import com.apiRestSecurity.demo.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final JwtIssuer jwtIssuer;
    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptLoggin(String email, String password){
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email,password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();
        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        var token = jwtIssuer.issue(principal.getUserId(), principal.getEmail(), roles);
        return LoginResponse.builder()
                .accesToken(token)
                .build();
    }

}
