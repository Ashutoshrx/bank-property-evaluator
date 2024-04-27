package com.jarvis.bankevaluator.exception;

import com.jarvis.bankevaluator.exception.codes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.jarvis.bankevaluator.exception.codes.ErrorCode.NON_PROGRESSIVE_ERROR;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankingServiceRuntimeException extends RuntimeException {
  private ErrorCode errorCode;
  private String errorMessage;

  public BankingServiceRuntimeException(String message) {
    throw new BankingServiceRuntimeException(NON_PROGRESSIVE_ERROR, message);
  }
}
