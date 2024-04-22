package com.jarvis.bankevaluator.rest.controller;

import com.jarvis.bankevaluator.business.service.AuthenticationService;
import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.ACCEPTED)
  public String register(@RequestBody @Valid RegistrationRequestDTO registrationRequest) {
    return authenticationService.register(registrationRequest);
  }
}
