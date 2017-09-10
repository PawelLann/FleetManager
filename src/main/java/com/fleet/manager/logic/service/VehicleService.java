package com.fleet.manager.logic.service;

import com.manager.api.model.IncidentViewDto;
import com.manager.api.model.VehicleViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
public interface VehicleService {

  void createVehicle();
  void deleteVehicle();
  List<VehicleViewDto> getAllVehicles();
  List<IncidentViewDto> getIncidentsByVehicleId();
  VehicleViewDto getVehicleById();
  void updateVehicle();
}
