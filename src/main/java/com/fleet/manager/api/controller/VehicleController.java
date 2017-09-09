package com.fleet.manager.api.controller;

import com.manager.api.VehiclesApi;
import com.manager.api.model.IncidentViewDto;
import com.manager.api.model.VehicleFormDto;
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
public class VehicleController implements VehiclesApi {
  @Override
  public ResponseEntity<Void> createVehicle(VehicleFormDto vehicleForm) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteVehicle(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getAllVehicles() {
    return null;
  }

  @Override
  public ResponseEntity<List<IncidentViewDto>> getIncidentsByVehicleId(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<VehicleViewDto> getVehicleById(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateVehicle(Long id, VehicleFormDto vehicleForm) {
    return null;
  }
}
