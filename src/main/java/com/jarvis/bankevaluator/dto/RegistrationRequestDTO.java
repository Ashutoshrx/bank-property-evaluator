package com.jarvis.bankevaluator.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDTO {
  @NotEmpty(message = "Name must not be empty")
  private String initiatorName;
  @NotEmpty(message = "Contact Number must not be empty")
  @Size(max = 10, min = 10)
  private String contactNumber;
  @NotEmpty(message = "Password must not be empty")
  @Size(max = 8, message = "Password must be 8 characters long")
  private String password;
  private String businessUnit;
}
