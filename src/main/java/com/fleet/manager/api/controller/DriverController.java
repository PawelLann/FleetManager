package com.fleet.manager.api.controller;

import com.fleet.manager.logic.service.DriverService;
import com.manager.api.DriversApi;
import com.manager.api.model.DriverFormDto;
import com.manager.api.model.DriverViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

  private final DriverService driverService;

  @Override
  public ResponseEntity<Void> addVehicleToDriver(@PathVariable("driverId") Long driverId, @PathVariable("vehicleId") Long vehicleId) {
    driverService.addVehicleToDriver(driverId, vehicleId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> createDriver(@RequestBody DriverFormDto driverForm) {
    driverService.createDriver(driverForm);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteDriver(@PathVariable("id") Long id) {
    driverService.deleteDriver(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<DriverViewDto>> getAllDrivers() {
    return new ResponseEntity<>(driverService.getAllDrivers(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<DriverViewDto> getDriverById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(driverService.getDriverById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getVehiclesByDriverId(@PathVariable("id") Long id) {
    return new ResponseEntity<>(driverService.getVehiclesByDriverId(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> removeVehicleFromDriver(@PathVariable("driverId") Long driverId, @PathVariable("vehicleId") Long vehicleId) {
    driverService.removeVehicleFromDriver(driverId, vehicleId);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateDriver(@PathVariable("id") Long id, @RequestBody DriverFormDto driverForm) {
    driverService.updateDriver(id, driverForm);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}