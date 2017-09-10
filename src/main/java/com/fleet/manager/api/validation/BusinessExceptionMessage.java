package com.fleet.manager.api.validation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RequiredArgsConstructor
@Getter
public enum BusinessExceptionMessage {

  ENTITY_NOT_FOUND(400, "Entity not found"),
  DRIVER_NOT_FOUND(400, "Driver witch such id doesn't exist"),
  DRIVERS_NOT_FOUND(400, "No drivers found in repository"),
  VEHICLE_NOT_FOUND(400, "Vehicle with such id doesn't exist"),
  NO_VEHICLES_ASSIGNED(400, "No vehicles are assigned to this driver");

  private final int code;
  private final String message;
}
