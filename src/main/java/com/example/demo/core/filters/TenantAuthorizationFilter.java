package com.example.demo.core.filters;

import com.example.demo.core.authentications.TenantAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TenantAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        TenantAuthenticationToken tenantAuthenticationToken = getTenantAuthenticationToken();
        SecurityContextHolder.getContext().setAuthentication(tenantAuthenticationToken);
        filterChain.doFilter(request, response);
    }

    private TenantAuthenticationToken getTenantAuthenticationToken() {
        return new TenantAuthenticationToken("foo@bar.com", 1);
    }
}