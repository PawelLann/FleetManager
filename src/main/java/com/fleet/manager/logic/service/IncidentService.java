package com.fleet.manager.logic.service;

import com.manager.api.model.IncidentViewDto;

import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
public interface IncidentService {

  void createIncident();
  void deleteIncident();
  List<IncidentViewDto> getAllIncidents();
  IncidentViewDto getIncidentById();
  void updateIncident();
}
