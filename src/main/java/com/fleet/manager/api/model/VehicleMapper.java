package com.fleet.manager.api.model;

import com.fleet.manager.entity.Vehicle;
import com.manager.api.model.VehicleFormDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@Mapper
public interface VehicleMapper {

  Vehicle map(VehicleFormDto vehicleFormDto);
  VehicleFormDto map(Vehicle vehicle);

}
