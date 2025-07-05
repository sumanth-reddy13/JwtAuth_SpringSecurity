package com.example.SpringSecurityDemo.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class AdminController {

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    public String post() {
        return "This is a post method in Admin controller only accessed by admin:create";
    }

    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String get() {
        return "This is a get method in Admin controller only accessed by admin:read";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin:update')")
    public String put() {
        return "This is a put method in Admin controller only accessed by admin:update";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin:delete')")
    public String delete() {
        return "This is a delete method in Admin controller only accessed by admin:delete";
    }
}