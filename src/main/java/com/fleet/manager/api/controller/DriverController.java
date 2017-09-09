package com.fleet.manager.api.controller;

import com.manager.api.DriversApi;
import com.manager.api.model.DriverFormDto;
import com.manager.api.model.DriverViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DriverController implements DriversApi {
  @Override
  public ResponseEntity<Void> addVehicleToDriver(Long driverId, Long vehicleId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createDriver(DriverFormDto driverForm) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteProject(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<DriverViewDto>> getAllDrivers() {
    return null;
  }

  @Override
  public ResponseEntity<DriverViewDto> getDriverById(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getVehiclesByDriverId(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> removeVehicleFromDriver(Long driverId, Long vehicleId) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateDriver(DriverFormDto driverForm, Long id) {
    return null;
  }
}
