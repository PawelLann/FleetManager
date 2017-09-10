package com.fleet.manager.logic.service;

import com.manager.api.model.DriverFormDto;
import com.manager.api.model.DriverViewDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
public interface DriverService {

  void addVehicleToDriver(Long driverId, Long vehicleId);
  void createDriver(DriverFormDto driverForm);
  void deleteDriver(Long id);
  List<DriverViewDto> getAllDrivers();
  DriverViewDto getDriverById(Long id);
  List<VehicleViewDto> getVehiclesByDriverId(Long id);
  void removeVehicleFromDriver(Long driverId, Long vehicleId);
  void updateDriver(DriverFormDto driverForm, Long id);
}
