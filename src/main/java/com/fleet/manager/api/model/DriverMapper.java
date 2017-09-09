package com.fleet.manager.api.model;

import com.fleet.manager.entity.Driver;
import com.manager.api.model.DriverFormDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@Mapper
public interface DriverMapper {

  Driver map(DriverFormDto driverFormDto);
  DriverFormDto map(Driver driver);
}
