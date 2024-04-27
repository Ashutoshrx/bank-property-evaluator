package com.jarvis.bankevaluator.exception;

import com.jarvis.bankevaluator.exception.codes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.jarvis.bankevaluator.exception.codes.ErrorCode.RESOURCE_NOT_FOUND;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BankingServiceResourceNotFoundException extends BankingServiceRuntimeException {
  private ErrorCode errorCode;
  private String errorMessage;

  public BankingServiceResourceNotFoundException(String message) {
    throw new BankingServiceResourceNotFoundException(RESOURCE_NOT_FOUND, message);
  }
}
