package com.mybank.bank.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @PrePersist
    void inCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
