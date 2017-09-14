package com.fleet.manager.api.controller;

import com.fleet.manager.logic.service.VehicleService;
import com.manager.api.VehiclesApi;
import com.manager.api.model.IncidentViewDto;
import com.manager.api.model.VehicleFormDto;
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
public class VehicleController implements VehiclesApi {

  private final VehicleService vehicleService;

  @Override
  public ResponseEntity<Void> createVehicle(@RequestBody VehicleFormDto vehicleForm) {
    vehicleService.createVehicle(vehicleForm);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteVehicle(@PathVariable("id") Long id) {
    vehicleService.deleteVehicle(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getAllVehicles() {
    return new ResponseEntity<>(vehicleService.getAllVehicles(),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<IncidentViewDto>> getIncidentsByVehicleId(@PathVariable("id") Long id) {
    return new ResponseEntity<>(vehicleService.getIncidentsByVehicleId(id),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VehicleViewDto> getVehicleById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(vehicleService.getVehicleById(id),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateVehicle(@PathVariable("id") Long id, VehicleFormDto vehicleForm) {
    vehicleService.updateVehicle(id, vehicleForm);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
