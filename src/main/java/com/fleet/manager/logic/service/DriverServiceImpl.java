package com.fleet.manager.logic.service;

import com.manager.api.model.DriverViewDto;
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
public class DriverServiceImpl implements DriverService{
  @Override
  public void addVehicleToDriver() {

  }

  @Override
  public void createDriver() {

  }

  @Override
  public void deleteDriver() {

  }

  @Override
  public List<DriverViewDto> getAllDrivers() {
    return null;
  }

  @Override
  public DriverViewDto getDriverById() {
    return null;
  }

  @Override
  public List<VehicleViewDto> getVehiclesByDriverId() {
    return null;
  }

  @Override
  public void removeVehicleFromDriver() {

  }

  @Override
  public void updateDriver() {

  }
}