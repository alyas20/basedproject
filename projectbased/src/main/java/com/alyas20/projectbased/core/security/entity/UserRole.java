package com.alyas20.projectbased.core.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user99_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_cd",nullable = false, length = 10)
    private String roleCode;
    @Column(name = "role_desc", length = 10)
    private String roleDesc;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;
}
