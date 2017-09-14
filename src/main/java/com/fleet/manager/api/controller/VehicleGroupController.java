package com.fleet.manager.api.controller;

import com.fleet.manager.logic.service.VehicleGroupService;
import com.manager.api.VehicleGroupsApi;
import com.manager.api.model.VehicleGroupFormDto;
import com.manager.api.model.VehicleGroupViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
public class VehicleGroupController implements VehicleGroupsApi {

  private final VehicleGroupService vehicleGroupService;

  @Override
  public ResponseEntity<Void> addVehiclesToGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    vehicleGroupService.addVehiclesToGroup(vehicleGroupId, vehicleIds);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> createVehicleGroup(VehicleGroupFormDto vehicleGroupForm) {
    vehicleGroupService.createVehicleGroup(vehicleGroupForm);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteVehicleGroup(Long id) {
    vehicleGroupService.deleteVehicleGroup(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleGroupViewDto>> getAllVehicleGroups() {
    return new ResponseEntity<>(vehicleGroupService.getAllVehicleGroups(),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<VehicleGroupViewDto> getVehicleGroupById(Long id) {
    return new ResponseEntity<>(vehicleGroupService.getVehicleGroupById(id),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<VehicleViewDto>> getVehiclesByGroupId(Long id) {
    return new ResponseEntity<>(vehicleGroupService.getVehiclesByGroupId(id),HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> removeVehiclesFromGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    vehicleGroupService.removeVehiclesFromGroup(vehicleGroupId, vehicleIds);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateVehicleGroup(VehicleGroupFormDto vehicleGroupForm, Long id) {
    vehicleGroupService.updateVehicleGroup(vehicleGroupForm, id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}