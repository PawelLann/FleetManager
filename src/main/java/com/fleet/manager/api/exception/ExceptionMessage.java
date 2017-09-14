package com.fleet.manager.api.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RequiredArgsConstructor
@Getter
public enum ExceptionMessage {

  DRIVER_NOT_FOUND(400,"Driver witch such id doesn't exist"),
  DRIVERS_NOT_FOUND(400,"No drivers found in repository"),
  VEHICLE_NOT_FOUND(400,"Vehicle with such id doesn't exist"),
  VEHICLES_NOT_FOUND(400,"No vehicles found in repository"),
  NO_VEHICLES_ASSIGNED(400,"No vehicles are assigned to this driver"),
  INCIDENTS_NOT_FOUND(400,"No incidents found in repository"),
  INCIDENT_NOT_FOUND(400,"Incident with such id doesn't exist"),
  VEHICLE_GROUPS_NOT_FOUND(400,"No vehicle group found in repository"),
  VEHICLE_GROUP_NOT_FOUND(400,"Vehicle group with such id doesn't exist"),
  INCIDENT_NOT_ASSIGNED_TO_DRIVER(400,"Incident wasn't assigned to the driver");

  private final int code;
  private final String message;
}
