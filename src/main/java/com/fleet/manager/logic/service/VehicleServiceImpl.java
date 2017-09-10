package com.fleet.manager.logic.service;

import com.manager.api.model.IncidentViewDto;
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
public class VehicleServiceImpl implements VehicleService {
  @Override
  public void createVehicle() {

  }

  @Override
  public void deleteVehicle() {

  }

  @Override
  public List<VehicleViewDto> getAllVehicles() {
    return null;
  }

  @Override
  public List<IncidentViewDto> getIncidentsByVehicleId() {
    return null;
  }

  @Override
  public VehicleViewDto getVehicleById() {
    return null;
  }

  @Override
  public void updateVehicle() {

  }
}
