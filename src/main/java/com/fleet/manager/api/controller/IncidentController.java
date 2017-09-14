package com.fleet.manager.api.controller;

import com.manager.api.IncidentsApi;
import com.manager.api.model.IncidentFormDto;
import com.manager.api.model.IncidentViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IncidentController implements IncidentsApi {
  @Override
  public ResponseEntity<Void> createIncident(@Valid @RequestBody IncidentFormDto incidentForm) {
    return null;
  }

  @Override
  public ResponseEntity<Void> deleteIncident(@PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ResponseEntity<List<IncidentViewDto>> getAllIncidents() {
    return null;
  }

  @Override
  public ResponseEntity<IncidentViewDto> getIncidentById(@PathVariable("id") Long id) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateIncident(@PathVariable("id") Long id, @Valid @RequestBody IncidentFormDto incidentForm) {
    return null;
  }
}
