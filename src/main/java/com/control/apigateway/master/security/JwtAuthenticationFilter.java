package com.control.apigateway.master.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final String LOGIN_ENDPOINT = "/auth/Login/"; // Endpoint de autenticación (login)

    @Override
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*", allowCredentials = "true")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // No tenga en cuenta la ruta de login
        if (request.getRequestURI().contains(LOGIN_ENDPOINT)) {
            filterChain.doFilter(request, response);
            return;
        }

        boolean token = validateStructureToken(request);

        if (token) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(request, response);

        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
    }

    private boolean validateStructureToken(HttpServletRequest request) {
        // aqui se valida estructura del token
        // si no cumple devolver false
        return true;
    }

}
