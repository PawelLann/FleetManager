package com.fleet.manager.api.validation;

import lombok.Getter;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Getter
public class ManagerBusinessException extends RuntimeException {

  private final ExceptionMessage exceptionMessage;

  public ManagerBusinessException(ExceptionMessage exceptionMessage){
    super(exceptionMessage.getMessage());
    this.exceptionMessage = exceptionMessage;
  }
}
