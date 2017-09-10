package com.fleet.manager.logic.service;

import com.manager.api.model.VehicleGroupViewDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 10.09.17.
 */
public interface VehicleGroupService {

  void addVehiclesToGroup();
  void createVehicleGroup();
  void deleteVehicleGroup();
  List<VehicleGroupViewDto> getAllVehicleGroups();
  VehicleGroupViewDto getVehicleGroupById();
  List<VehicleViewDto> getVehiclesByGroupId();
  void removeVehiclesFromGroup();
}
