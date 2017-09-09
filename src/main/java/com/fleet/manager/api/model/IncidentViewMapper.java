package com.fleet.manager.api.model;

import com.fleet.manager.entity.Incident;
import com.manager.api.model.IncidentViewDto;
import org.mapstruct.Mapper;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@Mapper
public interface IncidentViewMapper {

  IncidentViewDto map(Incident incident);
}
