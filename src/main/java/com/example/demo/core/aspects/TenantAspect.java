package com.example.demo.core.aspects;

import com.example.demo.core.contexts.TenantContext;
import com.example.demo.core.models.Tenantable;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Aspect
@Component
public class TenantAspect {

    @Autowired
    private TenantContext tenantContext;

    @PersistenceContext
    private EntityManager entityManager;

    @Before("execution(* com.example.demo.core.repositories.TenantableRepository+.find*(..))")
    public void beforeFindOfTenantableRepository() {
        entityManager
                .unwrap(Session.class)
                .enableFilter(Tenantable.TENANT_FILTER_NAME)
                .setParameter(Tenantable.TENANT_PARAMETER_NAME, tenantContext.getTenantId());
    }
}