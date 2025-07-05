package com.example.SpringSecurityDemo.demo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/api/v1/management")
@RestController
public class ManagementController {

    @Operation(
            description = "Get endpoint for manager",
            summary = "This is a summary for management get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized / Invalid Token",
                            responseCode = "403"
                    )
            }
    )
    @GetMapping
    @PreAuthorize("hasAuthority('manager:read')")
    public String get() {
        return "This is a get method in manager controller only accessed by manager:read";
    }

    @PostMapping
    @PreAuthorize("hasAuthority('manager:create')")
    public String post() {
        return "This is a post method in manager controller only accessed by manager:create";
    }

    @PutMapping
    @PreAuthorize("hasAuthority('manager:create')")
    public String put() {
        return "This is a put method in manager controller only accessed by manager:update";
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('manager:delete')")
    public String delete() {
        return "This is a delete method in manager controller only accessed by manager:delete";
    }
}
