package com.jarvis.bankevaluator.business.service;

import com.jarvis.bankevaluator.dto.LogInRequestDTO;
import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;

public interface AuthenticationService {
  String register(RegistrationRequestDTO registrationRequest);
  String logIn(LogInRequestDTO logInRequest);
}
