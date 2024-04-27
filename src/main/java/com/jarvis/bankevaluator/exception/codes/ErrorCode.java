package com.jarvis.bankevaluator.exception.codes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  NON_PROGRESSIVE_ERROR("NON PROGRESSIVE ERROR"),
  RESOURCE_NOT_FOUND("NO RESOURCE FOUND"),
  BAD_CREDENTIALS("BAD CREDENTIALS");
  private final String code;
}
