package com.fleet.manager.logic.service;

import com.manager.api.model.VehicleGroupViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 10.09.17.
 */
@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class VehicleGroupServiceImpl implements VehicleGroupService {
  @Override
  public void addVehiclesToGroup() {

  }

  @Override
  public void createVehicleGroup() {

  }

  @Override
  public void deleteVehicleGroup() {

  }

  @Override
  public List<VehicleGroupViewDto> getAllVehicleGroups() {
    return null;
  }

  @Override
  public VehicleGroupViewDto getVehicleGroupById() {
    return null;
  }

  @Override
  public List<VehicleViewDto> getVehiclesByGroupId() {
    return null;
  }

  @Override
  public void removeVehiclesFromGroup() {

  }
}
