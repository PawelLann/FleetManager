package com.fleet.manager.logic.service;

import com.fleet.manager.api.model.VehicleMapper;
import com.fleet.manager.api.model.VehicleMapperImpl;
import com.fleet.manager.api.model.VehicleViewMapper;
import com.fleet.manager.api.model.VehicleViewMapperImpl;
import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.ExceptionMessage;
import com.fleet.manager.persistence.entity.Vehicle;
import com.fleet.manager.persistence.repository.VehicleRepository;
import com.google.common.base.Preconditions;
import com.manager.api.model.IncidentViewDto;
import com.manager.api.model.VehicleFormDto;
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

  private final VehicleRepository vehicleRepository;
  private final static VehicleMapper VEHICLE_MAPPER = new VehicleMapperImpl();
  private final static VehicleViewMapper VEHICLE_VIEW_MAPPER = new VehicleViewMapperImpl();

  @Override
  public void createVehicle(VehicleFormDto vehicleForm) {
    Preconditions.checkNotNull(vehicleForm,"Vehicle form cannot be null");
    Vehicle vehicle = VEHICLE_MAPPER.map(vehicleForm);
    vehicleRepository.save(vehicle);
  }

  @Override
  public void deleteVehicle(Long id) {

  }

  @Override
  public List<VehicleViewDto> getAllVehicles() {
    List<Vehicle> vehicles = vehicleRepository.findAll();
    if(vehicles.isEmpty()){
      throw new BusinessException(ExceptionMessage.VEHICLES_NOT_FOUND);
    }
    return VEHICLE_VIEW_MAPPER.map(vehicles);
  }

  @Override
  public List<IncidentViewDto> getIncidentsByVehicleId(Long id) {
    return null;
  }

  @Override
  public VehicleViewDto getVehicleById(Long id) {
    Preconditions.checkNotNull(id,"Id cannot be null");
    Vehicle vehicle = vehicleRepository.findOneThrowable(id);
    return VEHICLE_VIEW_MAPPER.map(vehicle);
  }

  @Override
  public void updateVehicle(Long id, VehicleFormDto vehicleForm) {
    Preconditions.checkNotNull(id,"Id cannot be null");
    Preconditions.checkNotNull(vehicleForm,"Vehicle form cannot be null");
    Vehicle vehicle = vehicleRepository.findOneThrowable(id);
    vehicle = VEHICLE_MAPPER.map(vehicleForm,vehicle);
    vehicleRepository.save(vehicle);
  }
}
