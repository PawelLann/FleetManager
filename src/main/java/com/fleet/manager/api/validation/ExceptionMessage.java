package com.fleet.manager.api.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RequiredArgsConstructor
@Getter
public enum ExceptionMessage {

  ENTITY_NOT_FOUND(400, "Entity not found");

  private final int code;
  private final String message;
}
