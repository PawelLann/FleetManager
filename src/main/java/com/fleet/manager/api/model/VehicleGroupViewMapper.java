package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.VehicleGroup;
import com.manager.api.model.VehicleGroupViewDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface VehicleGroupViewMapper {

  VehicleGroupViewDto map(VehicleGroup vehicleGroup);
}
