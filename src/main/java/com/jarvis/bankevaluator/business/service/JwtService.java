package com.jarvis.bankevaluator.business.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
  String generateToken(UserDetails userDetails);
  String extractInitiatorName(String token);
  boolean isTokenValid(String token, UserDetails userDetails);
}
