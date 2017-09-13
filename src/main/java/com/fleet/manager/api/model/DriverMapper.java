package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.Driver;
import com.manager.api.model.DriverFormDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface DriverMapper {

  Driver map(DriverFormDto driverFormDto);
  DriverFormDto map(Driver driver);
  Driver map(DriverFormDto driverForm, @MappingTarget Driver driver);
}
