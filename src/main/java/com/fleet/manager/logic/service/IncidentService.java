package com.fleet.manager.logic.service;

import com.manager.api.model.IncidentFormDto;
import com.manager.api.model.IncidentViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
public interface IncidentService {

  void createIncident(IncidentFormDto incidentForm);
  void deleteIncident(Long id);
  List<IncidentViewDto> getAllIncidents();
  IncidentViewDto getIncidentById(Long id);
  void updateIncident(Long id, IncidentFormDto incidentForm);
}
