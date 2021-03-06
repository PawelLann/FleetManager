package com.fleet.manager.logic.service;

import com.fleet.manager.api.model.VehicleGroupMapper;
import com.fleet.manager.api.model.VehicleGroupMapperImpl;
import com.fleet.manager.api.model.VehicleGroupViewMapper;
import com.fleet.manager.api.model.VehicleGroupViewMapperImpl;
import com.fleet.manager.api.exception.BusinessException;
import com.fleet.manager.api.exception.ExceptionMessage;
import com.fleet.manager.api.model.VehicleViewMapper;
import com.fleet.manager.api.model.VehicleViewMapperImpl;
import com.fleet.manager.persistence.entity.Vehicle;
import com.fleet.manager.persistence.entity.VehicleGroup;
import com.fleet.manager.persistence.repository.VehicleGroupRepository;
import com.fleet.manager.persistence.repository.VehicleRepository;
import com.google.common.base.Preconditions;
import com.manager.api.model.VehicleGroupFormDto;
import com.manager.api.model.VehicleGroupViewDto;
import com.manager.api.model.VehicleViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by pawel.langwerski@gmail.pl on 10.09.17.
 */
@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class VehicleGroupServiceImpl implements VehicleGroupService {

  private final VehicleGroupRepository vehicleGroupRepository;
  private final VehicleRepository vehicleRepository;
  private final static VehicleViewMapper VEHICLE_VIEW_MAPPER = new VehicleViewMapperImpl();
  private final static VehicleGroupMapper VEHICLE_GROUP_MAPPER = new VehicleGroupMapperImpl();
  private final static VehicleGroupViewMapper VEHICLE_GROUP_VIEW_MAPPER = new VehicleGroupViewMapperImpl();

  @Override
  public void addVehiclesToGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    Preconditions.checkNotNull(vehicleGroupId, "Vehicle group id cannot be null");
    Preconditions.checkNotNull(vehicleIds, "Vehicle Ids cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(vehicleGroupId);
    VEHICLE_GROUP_MAPPER.map(vehicleGroupRepository.findOne(vehicleGroupId));
    vehicleIds.stream()
        .map(vehicleRepository::findOne)
        .forEach(vehicleGroup::addVehicle);
  }

  @Override
  public void createVehicleGroup(VehicleGroupFormDto vehicleGroupForm) {
    Preconditions.checkNotNull(vehicleGroupForm, "Vehicle group form cannot be null");
    VehicleGroup vehicleGroup = VEHICLE_GROUP_MAPPER.map(vehicleGroupForm);
    vehicleGroupRepository.save(vehicleGroup);
  }

  @Override
  public void deleteVehicleGroup(Long id) {
    Preconditions.checkNotNull(id, "Id cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(id);
    List<Vehicle> vehicles = vehicleRepository.findAllByVehicleGroupContains(vehicleGroup);
    vehicles.forEach(vehicleGroup::removeVehicle);
    vehicleGroupRepository.delete(vehicleGroup);
  }

  @Override
  public List<VehicleGroupViewDto> getAllVehicleGroups() {
    List<VehicleGroup> vehicleGroups = vehicleGroupRepository.findAll();
    return VEHICLE_GROUP_VIEW_MAPPER.map(Optional.ofNullable(vehicleGroups)
            .orElseThrow(() -> new BusinessException(ExceptionMessage.VEHICLE_GROUPS_NOT_FOUND)));

  }

  @Override
  public VehicleGroupViewDto getVehicleGroupById(Long id) {
    Preconditions.checkNotNull(id, "Id cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(id);
    return VEHICLE_GROUP_VIEW_MAPPER.map(vehicleGroup);
  }

  @Override
  public List<VehicleViewDto> getVehiclesByGroupId(Long id) {
    Preconditions.checkNotNull(id, "Id cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(id);
    List<Vehicle> vehicles = vehicleRepository.findAllByVehicleGroupContains(vehicleGroup);
    return VEHICLE_VIEW_MAPPER.map(Optional.ofNullable(vehicles)
            .orElseThrow(() -> new BusinessException(ExceptionMessage.NO_VEHICLES_ASSIGNED)));

  }

  @Override
  public void removeVehiclesFromGroup(Long vehicleGroupId, List<Long> vehicleIds) {
    Preconditions.checkNotNull(vehicleGroupId, "Vehicle group cannot be null");
    Preconditions.checkNotNull(vehicleIds, "Vehicle Ids cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(vehicleGroupId);
    VEHICLE_GROUP_MAPPER.map(vehicleGroup);
    vehicleIds.stream()
        .map(vehicleRepository::getOne)
        .forEach(vehicleGroup::removeVehicle);
  }

  @Override
  public void updateVehicleGroup(VehicleGroupFormDto vehicleGroupForm, Long id) {
    Preconditions.checkNotNull(vehicleGroupForm, "Vehicle group form cannot be null");
    Preconditions.checkNotNull(id, "Id cannot be null");
    VehicleGroup vehicleGroup = vehicleGroupRepository.findOneThrowable(id);
    vehicleGroup = VEHICLE_GROUP_MAPPER.map(vehicleGroupForm, vehicleGroup);
    vehicleGroupRepository.save(vehicleGroup);
  }
}
