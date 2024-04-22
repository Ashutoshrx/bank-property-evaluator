package com.jarvis.bankevaluator.data.repository;

import com.jarvis.bankevaluator.data.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {
  Token findByToken(String token);
}
