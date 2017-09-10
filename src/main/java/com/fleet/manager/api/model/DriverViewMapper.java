package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Vehicle;
import com.manager.api.model.DriverViewDto;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface DriverViewMapper {

  DriverViewDto map(Driver driver);
  List<DriverViewDto> map(Iterable<Driver> drivers);
}
