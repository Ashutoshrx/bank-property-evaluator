package com.jarvis.bankevaluator.exception.handler;

import com.jarvis.bankevaluator.exception.BankingServiceBadCredentialsException;
import com.jarvis.bankevaluator.exception.BankingServiceResourceNotFoundException;
import com.jarvis.bankevaluator.exception.BankingServiceRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(BankingServiceResourceNotFoundException.class)
  public ResponseEntity<String> handleBankingServiceResourceNotFoundException(
          BankingServiceResourceNotFoundException exception) {
    logger.error("Resource Not Found Exception:{} with message:{} with stack trace:{}", exception.getErrorCode(),
            exception.getMessage(),
            exception.getStackTrace());
    return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
  }

  @ExceptionHandler(BankingServiceRuntimeException.class)
  public ResponseEntity<String> handleBankingServiceRuntimeException(
          BankingServiceRuntimeException exception) {
    logger.error("BankingServiceRuntimeException:{} with message:{} with stack trace:{}", exception.getErrorCode(),
            exception.getMessage(),
            exception.getStackTrace());
    return new ResponseEntity<>(exception.getMessage(), INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BankingServiceBadCredentialsException.class)
  public ResponseEntity<String> handleBankingServiceBadCredentialsException(
          BankingServiceBadCredentialsException exception) {
    logger.error("BankingServiceBadCredentialsException:{} with message:{} with stack trace:{}", exception.getErrorCode(),
            exception.getMessage(),
            exception.getStackTrace());
    return new ResponseEntity<>(exception.getMessage(), FORBIDDEN);
  }
}
