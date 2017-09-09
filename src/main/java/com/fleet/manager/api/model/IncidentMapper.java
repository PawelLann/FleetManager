package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.Incident;
import com.manager.api.model.IncidentFormDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface IncidentMapper {

  Incident map(IncidentFormDto incidentFormDto);
  IncidentFormDto map(Incident incident);
}
