package com.jarvis.bankevaluator.business.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jarvis.bankevaluator.business.mapper.UserMapper;
import com.jarvis.bankevaluator.business.service.AuthenticationService;
import com.jarvis.bankevaluator.business.service.JwtService;
import com.jarvis.bankevaluator.data.entity.User;
import com.jarvis.bankevaluator.data.repository.UserRepository;
import com.jarvis.bankevaluator.dto.LogInRequestDTO;
import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;
import com.jarvis.bankevaluator.exception.BankingServiceBadCredentialsException;
import com.jarvis.bankevaluator.exception.BankingServiceRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.jarvis.bankevaluator.exception.errorMessages.SOMETHING_WENT_WRONG;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
  private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
  @Autowired
  private ObjectMapper objectMapper;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private JwtService jwtService;
  @Autowired
  private AuthenticationManager authenticationManager;

  @Override
  public String register(RegistrationRequestDTO registrationRequest) {
    try {
      logger.info("Started registering User with details:{}",
              objectMapper.writeValueAsString(registrationRequest));
      User user = userMapper.mapToUser(registrationRequest);
      user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
      User savedUser = userRepository.save(user);
      logger.info("Registration is successful for initiatorName:{}",
              registrationRequest.getInitiatorName());
      return jwtService.generateToken(savedUser);
    } catch (Exception e) {
      throw new BankingServiceRuntimeException(SOMETHING_WENT_WRONG + e.getMessage());
    }
  }

  @Override
  public String logIn(LogInRequestDTO logInRequest) {
    try {
      authenticationManager.authenticate(new
              UsernamePasswordAuthenticationToken(logInRequest.getInitiatorName(),
              logInRequest.getPassword()));
      var user =
              userRepository.findByContactNumber(
                              logInRequest.getContactNumber()).
                      orElseThrow(() -> new BankingServiceBadCredentialsException("No User Found"));
      return jwtService.generateToken(user);
    } catch (BankingServiceBadCredentialsException e) {
      throw e;
    } catch (Exception e) {
      throw new BankingServiceRuntimeException("Something went wrong: " + e.getMessage());
    }
  }

}
