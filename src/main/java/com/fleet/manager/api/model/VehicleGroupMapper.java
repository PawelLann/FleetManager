package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.VehicleGroup;
import com.manager.api.model.VehicleGroupFormDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface VehicleGroupMapper {

  VehicleGroup map(VehicleGroupFormDto vehicleGroupFormDto);
  VehicleGroupFormDto map(VehicleGroup vehicleGroup);
  VehicleGroup map(VehicleGroupFormDto vehicleGroupForm, @MappingTarget VehicleGroup vehicleGroup);
}
