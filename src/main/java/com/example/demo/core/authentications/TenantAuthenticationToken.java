package com.example.demo.core.authentications;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class TenantAuthenticationToken extends AbstractAuthenticationToken {

    private final Object principal;
    private final Integer tenantId;

    public TenantAuthenticationToken(Object principal, Integer tenantId) {
        super(null);
        this.principal = principal;
        this.tenantId = tenantId;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    public int getTenantId() {
        return tenantId;
    }
}