package com.fleet.manager.logic.service;

import com.fleet.manager.api.model.DriverMapper;
import com.fleet.manager.api.model.DriverMapperImpl;
import com.fleet.manager.api.model.DriverViewMapper;
import com.fleet.manager.api.model.DriverViewMapperImpl;
import com.fleet.manager.api.model.VehicleViewMapper;
import com.fleet.manager.api.model.VehicleViewMapperImpl;
import com.fleet.manager.api.exception.BusinessException;
import com.fleet.manager.api.exception.ExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Incident;
import com.fleet.manager.persistence.entity.Vehicle;
import com.fleet.manager.persistence.repository.DriverRepository;
import com.fleet.manager.persistence.repository.IncidentRepository;
import com.fleet.manager.persistence.repository.VehicleRepository;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.manager.api.model.DriverFormDto;
import com.manager.api.model.DriverViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 10.09.17.
 */
@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

  private final DriverRepository driverRepository;
  private final VehicleRepository vehicleRepository;
  private final IncidentRepository incidentRepository;
  private final static DriverMapper DRIVER_MAPPER = new DriverMapperImpl();
  private final static DriverViewMapper DRIVER_VIEW_MAPPER = new DriverViewMapperImpl();
  private final static VehicleViewMapper VEHICLE_VIEW_MAPPER = new VehicleViewMapperImpl();

  @Override
  public void addVehicleToDriver(Long driverId, Long vehicleId) {
    Preconditions.checkNotNull(driverId, "Driver id cannot be null");
    Preconditions.checkNotNull(vehicleId, "Vehicle id cannot be null");
    Driver driver = driverRepository.findOneThrowable(driverId);
    Vehicle vehicle = vehicleRepository.findOneThrowable(vehicleId);
    driver.addVehicle(vehicle);
  }

  @Override
  public void createDriver(DriverFormDto driverForm) {
    Preconditions.checkNotNull(driverForm, "New driver form cannot be null");
    Driver driver = DRIVER_MAPPER.map(driverForm);
    driverRepository.save(driver);
  }

  @Override
  public void deleteDriver(Long id) {
    Preconditions.checkNotNull(id, "Driver id cannot be null");
    Driver driver = driverRepository.findOneThrowable(id);
    List<Vehicle> vehicles = vehicleRepository.findAllByDriversContains(driver);
    List<Incident> incidents = incidentRepository.findAllByDriversContains(driver);
    vehicles.forEach(driver::removeVehicle);
    incidents.forEach(driver::removeIncident);
    driverRepository.delete(driver);
  }

  @Override
  public List<DriverViewDto> getAllDrivers() {
    ArrayList<Driver> drivers = Lists.newArrayList(driverRepository.findAll());
    if (drivers.isEmpty()) {
      throw new BusinessException(ExceptionMessage.DRIVERS_NOT_FOUND);
    }
    return DRIVER_VIEW_MAPPER.map(driverRepository.findAll());
  }

  @Override
  public DriverViewDto getDriverById(Long id) {
    Preconditions.checkNotNull(id, "Driver id cannot be null");
    Driver driver = driverRepository.findOneThrowable(id);
    return DRIVER_VIEW_MAPPER.map(driver);
  }

  @Override
  public List<VehicleViewDto> getVehiclesByDriverId(Long id) {
    Preconditions.checkNotNull(id, "Id cannot be null");
    Driver driver = driverRepository.findOneThrowable(id);
    List<Vehicle> vehicles = vehicleRepository.findAllByDriversContains(driver);
    if (vehicles.isEmpty()) {
      throw new BusinessException(ExceptionMessage.NO_VEHICLES_ASSIGNED);
    }
    return VEHICLE_VIEW_MAPPER.map(vehicles);
  }

  @Override
  public void removeVehicleFromDriver(Long driverId, Long vehicleId) {
    Preconditions.checkNotNull(driverId, "Driver id cannot be null");
    Preconditions.checkNotNull(vehicleId, "Vehicle id cannot be null");
    Driver driver = driverRepository.findOneThrowable(driverId);
    Vehicle vehicle = vehicleRepository.findOneThrowable(vehicleId);
    driver.removeVehicle(vehicle);
  }

  @Override
  public void updateDriver(Long id, DriverFormDto driverForm) {
    Preconditions.checkNotNull(driverForm, "Driver form cannot be null");
    Preconditions.checkNotNull(id, "Driver id cannot be null");
    Driver driver = driverRepository.findOneThrowable(id);
    driver = DRIVER_MAPPER.map(driverForm, driver);
    driverRepository.save(driver);
  }
}