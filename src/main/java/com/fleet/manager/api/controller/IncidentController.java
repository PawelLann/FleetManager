package com.fleet.manager.api.controller;

import com.manager.api.IncidentsApi;
import com.manager.api.model.IncidentFormDto;
import com.manager.api.model.IncidentViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 09.09.17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IncidentController implements IncidentsApi {
  @Override
  public ResponseEntity<Void> createIncident(IncidentFormDto incidentForm) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteIncident(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<IncidentViewDto>> getAllIncidents(Long incidentId, Long vehicleId, LocalDate incidentDate) {
    return null;
  }

  @Override
  public ResponseEntity<IncidentViewDto> getIncidentById(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateIncident(Long id, IncidentFormDto incidentForm) {
    return null;
  }
}
