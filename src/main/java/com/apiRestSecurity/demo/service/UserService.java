package com.apiRestSecurity.demo.service;

import com.apiRestSecurity.demo.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String EXISTING_EMAIL= "fedekpo";
    private static final String ANOTHER_EMAIL= "marikpa";
    private static final String THIRD_EMAIL= "donaboris";
    public Optional<UserEntity> findByEmail(String email){
        if(EXISTING_EMAIL.equalsIgnoreCase(email)){
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$UgeWgjdxZqI9Yzhdjly2zObuf6PLvvXz9XiPgG2XMcgYOREoXPfIi");//12345
            user.setRole("ADMIN");
            user.setExtraInfo("Re crack el admin");
            return Optional.of(user);
        }else if (ANOTHER_EMAIL.equalsIgnoreCase(email)){
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(ANOTHER_EMAIL);
            user.setPassword("$2a$12$UgeWgjdxZqI9Yzhdjly2zObuf6PLvvXz9XiPgG2XMcgYOREoXPfIi");//12345
            user.setRole("USER");
            user.setExtraInfo("Re crack el user");
            return Optional.of(user);
        } else if (THIRD_EMAIL.equalsIgnoreCase(email)){
            var user = new UserEntity();
            user.setId(25L);
            user.setEmail(THIRD_EMAIL);
            user.setPassword("$2a$12$UgeWgjdxZqI9Yzhdjly2zObuf6PLvvXz9XiPgG2XMcgYOREoXPfIi");//12345
            user.setRole("PESCADO");
            user.setExtraInfo("Re crack el pescado");
            return Optional.of(user);
        }
        return Optional.empty();



 }
}
