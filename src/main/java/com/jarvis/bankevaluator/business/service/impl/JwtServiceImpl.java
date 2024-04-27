package com.jarvis.bankevaluator.business.service.impl;

import com.jarvis.bankevaluator.business.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
  @Value("${application.security.jwt.secret-expiration}")
  private Long jwtExpiration;
  @Value("${application.security.jwt.secret-key}")
  private String secretKey;

  /**
   * @param userDetails
   * @return
   */
  @Override
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  /**
   * @param claims
   * @param userDetails
   * @return
   */
  private String generateToken(Map<String, Object> claims, UserDetails userDetails) {
    return buildToken(claims, userDetails, jwtExpiration);
  }

  /**
   * @param claims
   * @param userDetails
   * @param jwtExpiration
   * @return
   */
  private String buildToken(Map<String, Object> claims, UserDetails userDetails, Long jwtExpiration) {
    List<String> businessUnits = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
    return Jwts.builder().claims(claims).subject(userDetails.getUsername()).
            issuedAt(new Date(System.currentTimeMillis())).
            expiration(new Date(System.currentTimeMillis() + jwtExpiration)).claim("BusinessUnit", businessUnits).
            signWith(getSignInKey(), Jwts.SIG.HS256).compact();
  }

  /**
   * @return
   */
  private SecretKey getSignInKey() {
    byte[] keys = Decoders.BASE64.decode(secretKey);
    return Keys.hmacShaKeyFor(keys);
  }

  /**
   * @param token
   * @param userDetails
   * @return
   */
  @Override
  public boolean isTokenValid(String token, UserDetails userDetails) {
    String initiatorName = extractInitiatorName(token);
    return userDetails.getUsername().equalsIgnoreCase(initiatorName);
//    return userDetails.getUsername().equalsIgnoreCase(initiatorName) && !isTokenExpired(token);
  }

  /**
   * @param token
   * @return
   */
  private boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  /**
   * @param token
   * @return
   */
  private Date extractExpiration(String token) {
    return extractClaims(token, Claims::getExpiration);
  }

  /**
   * @param token
   * @return
   */
  @Override
  public String extractInitiatorName(String token) {
    return extractClaims(token, Claims::getSubject);
  }

  /**
   * @param token
   * @param claimResolver
   * @param <T>
   * @return
   */
  private <T> T extractClaims(String token, Function<Claims, T> claimResolver) {
    Claims claims = extractAllClaims(token);
    return claimResolver.apply(claims);
  }

  /**
   * @param token
   * @return
   */
  private Claims extractAllClaims(String token) {
    return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
  }

}
