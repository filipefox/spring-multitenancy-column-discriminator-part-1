package com.example.demo.user;

import com.example.demo.core.models.Tenantable;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "users")
public class User extends Tenantable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;
}