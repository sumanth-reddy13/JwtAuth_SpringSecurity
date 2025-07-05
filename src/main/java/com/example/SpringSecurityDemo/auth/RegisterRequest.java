package com.example.SpringSecurityDemo.auth;

import com.example.SpringSecurityDemo.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    String firstName;
    String lastName;
    String username;
    String password;
    Role role;
}
