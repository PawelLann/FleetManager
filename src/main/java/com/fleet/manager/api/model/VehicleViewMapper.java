package com.fleet.manager.api.model;

import com.fleet.manager.entity.Vehicle;
import com.manager.api.model.VehicleViewDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@Mapper
public interface VehicleViewMapper {

  VehicleViewDto map(Vehicle vehicle);
}
