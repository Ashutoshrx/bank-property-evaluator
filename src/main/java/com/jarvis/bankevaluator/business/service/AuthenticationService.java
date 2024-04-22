package com.jarvis.bankevaluator.business.service;

import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;

public interface AuthenticationService {
  String register(RegistrationRequestDTO registrationRequest);
}
