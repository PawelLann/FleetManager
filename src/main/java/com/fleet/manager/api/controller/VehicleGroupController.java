package com.fleet.manager.api.controller;

import com.manager.api.VehicleGroupsApi;
import com.manager.api.model.VehicleGroupFormDto;
import com.manager.api.model.VehicleGroupViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VehicleGroupController implements VehicleGroupsApi {
  @Override
  public ResponseEntity<Void> addVehiclesToGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createVehicleGroup(VehicleGroupFormDto vehicleGroupForm) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteVehicleGroups(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<VehicleGroupViewDto>> getAllVehicleGroups() {
    return null;
  }

  @Override
  public ResponseEntity<VehicleGroupViewDto> getVehicleGroupById(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> removeVehiclesFromGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    return null;
  }

  @Override
  public ResponseEntity<VehicleGroupViewDto> updateVehicleGroup(VehicleGroupFormDto vehicleGroupForm, Long id) {
    return null;
  }
}
