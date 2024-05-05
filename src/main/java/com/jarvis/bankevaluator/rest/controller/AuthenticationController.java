package com.jarvis.bankevaluator.rest.controller;

import com.jarvis.bankevaluator.business.service.AuthenticationService;
import com.jarvis.bankevaluator.dto.LogInRequestDTO;
import com.jarvis.bankevaluator.dto.RegistrationRequestDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthenticationController {
  @Autowired
  private AuthenticationService authenticationService;

  @PostMapping("/register")
  @ResponseStatus(ACCEPTED)
  public String register(@RequestBody @Valid RegistrationRequestDTO registrationRequest) {
    return authenticationService.register(registrationRequest);
  }

  @PostMapping("/login")
  @ResponseStatus(OK)
  public String logIn(@RequestBody @Valid LogInRequestDTO logInRequest) {
    return authenticationService.logIn(logInRequest);
  }

}
