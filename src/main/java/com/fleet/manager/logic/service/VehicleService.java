package com.fleet.manager.logic.service;

import com.manager.api.model.IncidentViewDto;
import com.manager.api.model.VehicleFormDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
public interface VehicleService {

  void createVehicle(VehicleFormDto vehicleForm);
  void deleteVehicle(Long id);
  List<VehicleViewDto> getAllVehicles();
  List<IncidentViewDto> getIncidentsByVehicleId(Long id);
  VehicleViewDto getVehicleById(Long id);
  void updateVehicle(Long id,VehicleFormDto vehicleForm);
}
