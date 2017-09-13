package com.fleet.manager.api.model;

import com.fleet.manager.persistence.entity.Incident;
import com.manager.api.model.IncidentViewDto;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Mapper
public interface IncidentViewMapper {

  IncidentViewDto map(Incident incident);
  List<IncidentViewDto> map(List<Incident> incidents);
}
