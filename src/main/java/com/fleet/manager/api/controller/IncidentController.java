package com.fleet.manager.api.controller;

import com.fleet.manager.logic.service.IncidentService;
import com.manager.api.IncidentsApi;
import com.manager.api.model.IncidentFormDto;
import com.manager.api.model.IncidentViewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

  private final IncidentService incidentService;

  @Override
  public ResponseEntity<Void> createIncident(@RequestBody IncidentFormDto incidentForm) {
    incidentService.createIncident(incidentForm);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<Void> deleteIncident(@PathVariable("id") Long id) {
    incidentService.deleteIncident(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<IncidentViewDto>> getAllIncidents() {
    return new ResponseEntity<>(incidentService.getAllIncidents(), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<IncidentViewDto> getIncidentById(@PathVariable("id") Long id) {
    return new ResponseEntity<>(incidentService.getIncidentById(id), HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Void> updateIncident(@PathVariable("id") Long id, @RequestBody IncidentFormDto incidentForm) {
    incidentService.updateIncident(id, incidentForm);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
