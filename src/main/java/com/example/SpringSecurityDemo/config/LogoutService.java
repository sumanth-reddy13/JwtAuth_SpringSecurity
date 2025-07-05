package com.example.SpringSecurityDemo.config;

import com.example.SpringSecurityDemo.token.Token;
import com.example.SpringSecurityDemo.token.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Service;

import static io.swagger.v3.core.util.AnnotationsUtils.getHeader;

@Service
@RequiredArgsConstructor
public class LogoutService implements LogoutHandler {

    private final TokenRepository tokenRepository;

    public void logout(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken == null && !bearerToken.startsWith("Bearer ")) {
            return;
        }

        final String jwt;
        jwt = bearerToken.substring(7);
        Token token = tokenRepository.findByToken(jwt)
                                .orElse(null);
        if (token != null) {
            token.setRevoked(true);
            token.setExpired(true);
            tokenRepository.save(token);
            SecurityContextHolder.clearContext();
        }
    }
}