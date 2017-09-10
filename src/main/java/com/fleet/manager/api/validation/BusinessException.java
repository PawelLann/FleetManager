package com.fleet.manager.api.validation;

import lombok.Getter;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Getter
public class BusinessException extends RuntimeException {

  private final BusinessExceptionMessage businessExceptionMessage;

  public BusinessException(BusinessExceptionMessage businessExceptionMessage){
    super(businessExceptionMessage.getMessage());
    this.businessExceptionMessage = businessExceptionMessage;
  }
}
