package com.jarvis.bankevaluator.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInRequestDTO {
  @NotEmpty
  private String initiatorName;
  @NotEmpty
  private String password;
  @NotEmpty
  private String contactNumber;
}
