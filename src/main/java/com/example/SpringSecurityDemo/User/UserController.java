package com.example.SpringSecurityDemo.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN', 'USER', 'MANAGER')")
public class UserController {

    private final UserService userService;

    @PatchMapping
    public ResponseEntity<?> updatePassword(
            @RequestBody PasswordChangeRequest passwordChangeRequest,
            Principal connectedUser
    ) {
        userService.updatePassword(passwordChangeRequest, connectedUser);
        return ResponseEntity.ok().build();
    }
}