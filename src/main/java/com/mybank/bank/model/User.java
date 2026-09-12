package com.mybank.bank.model;
import lombok.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class User {
    private Long id;


    private String name;

    private String password;

    private LocalDateTime createdAt;
}
