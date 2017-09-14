package com.fleet.manager.api.controller;

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

import javax.validation.Valid;
import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class DriverController implements DriversApi{
  @Override
  public ResponseEntity<Void> addVehicleToDriver(@PathVariable("driverId") Long driverId,@PathVariable("vehicleId") Long vehicleId){
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> createDriver(@Valid @RequestBody DriverFormDto driverForm) {
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteDriver(@PathVariable("id") Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<DriverViewDto>> getAllDrivers() {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<DriverViewDto> getDriverById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getVehiclesByDriverId(@PathVariable("id") Long id) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> removeVehicleFromDriver(@PathVariable("driverId") Long driverId, @PathVariable("vehicleId") Long vehicleId) {
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateDriver(@PathVariable("id") Long id, @Valid @RequestBody DriverFormDto driverForm) {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}