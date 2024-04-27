package com.jarvis.bankevaluator.exception;

import com.jarvis.bankevaluator.exception.codes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.jarvis.bankevaluator.exception.codes.ErrorCode.BAD_CREDENTIALS;

@AllArgsConstructor
@Getter
@Setter
public class BankingServiceBadCredentialsException extends BankingServiceRuntimeException {
  private ErrorCode errorCode;
  private String message;

  public BankingServiceBadCredentialsException(String message) {
    throw new BankingServiceBadCredentialsException(BAD_CREDENTIALS, message);
  }
}
