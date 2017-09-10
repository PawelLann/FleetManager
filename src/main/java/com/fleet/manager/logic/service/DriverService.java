package com.fleet.manager.logic.service;

import com.manager.api.DriversApi;
import com.manager.api.model.DriverViewDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
public interface DriverService {

  void addVehicleToDriver();
  void createDriver();
  void deleteDriver();
  List<DriverViewDto> getAllDrivers();
  DriverViewDto getDriverById();
  List<VehicleViewDto> getVehiclesByDriverId();
  void removeVehicleFromDriver();
  void updateDriver();
}
