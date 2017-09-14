package com.fleet.manager.logic.service;

import com.manager.api.model.VehicleGroupFormDto;
import com.manager.api.model.VehicleGroupViewDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 10.09.17.
 */
public interface VehicleGroupService {

  void addVehiclesToGroup(Long vehicleGroupId, List<Long> vehicleIds);
  void createVehicleGroup(VehicleGroupFormDto vehicleGroupForm);
  void deleteVehicleGroup(Long id);
  List<VehicleGroupViewDto> getAllVehicleGroups();
  VehicleGroupViewDto getVehicleGroupById(Long id);
  List<VehicleViewDto> getVehiclesByGroupId(Long id);
  void removeVehiclesFromGroup(Long vehicleGroupId, List<Long> vehicleIds);
  void updateVehicleGroup(VehicleGroupFormDto vehicleGroupForm, Long id);
}
