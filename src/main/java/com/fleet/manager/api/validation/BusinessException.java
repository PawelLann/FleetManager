package com.fleet.manager.api.validation;

import lombok.Getter;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Getter
public class BusinessException extends RuntimeException {

  private final ExceptionMessage exceptionMessage;

  public BusinessException(ExceptionMessage exceptionMessage){
    super(exceptionMessage.getMessage());
    this.exceptionMessage = exceptionMessage;
  }
}
