package com.jarvis.bankevaluator.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Token {
  @Id
  @GeneratedValue
  private Integer id;
  private String token;
  private LocalDateTime createdAt;
  private LocalDateTime expiresAt;
  private LocalDateTime validatedAt;
  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;
}
