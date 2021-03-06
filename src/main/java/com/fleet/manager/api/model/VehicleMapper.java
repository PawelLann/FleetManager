package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.Vehicle;
import com.manager.api.model.VehicleFormDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface VehicleMapper {

  Vehicle map(VehicleFormDto vehicleFormDto);
  VehicleFormDto map(Vehicle vehicle);
  Vehicle map(VehicleFormDto vehicleForm, @MappingTarget Vehicle vehicle);
}
