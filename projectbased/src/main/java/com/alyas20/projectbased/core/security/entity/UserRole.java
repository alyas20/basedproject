package com.alyas20.projectbased.core.security.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user99_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 2405172041950251807L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_code", nullable = false, length = 10)
    private String roleCode;
    @Column(name = "role_desc", length = 10)
    private String roleDesc;
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.ALL)
    private List<User> users;
}
