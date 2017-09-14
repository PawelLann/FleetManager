package com.fleet.manager.logic.service;

import com.fleet.manager.api.model.IncidentMapper;
import com.fleet.manager.api.model.IncidentMapperImpl;
import com.fleet.manager.api.model.IncidentViewMapper;
import com.fleet.manager.api.model.IncidentViewMapperImpl;
import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.ExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Incident;
import com.fleet.manager.persistence.entity.Vehicle;
import com.fleet.manager.persistence.repository.DriverRepository;
import com.fleet.manager.persistence.repository.IncidentRepository;
import com.fleet.manager.persistence.repository.VehicleRepository;
import com.google.common.base.Preconditions;
import com.manager.api.model.IncidentFormDto;
import com.manager.api.model.IncidentViewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by pawel.langwerski@coi.gov.pl on 10.09.17.
 */
@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class IncidentServiceImpl implements IncidentService {

  private final IncidentRepository incidentRepository;
  private final DriverRepository driverRepository;
  private final VehicleRepository vehicleRepository;
  private final static IncidentMapper INCIDENT_MAPPER = new IncidentMapperImpl();
  private final static IncidentViewMapper INCIDENT_VIEW_MAPPER = new IncidentViewMapperImpl();


  @Override
  public void createIncident(IncidentFormDto incidentForm) {
    Preconditions.checkNotNull(incidentForm,"Incident form cannot be null");
    Incident incident = INCIDENT_MAPPER.map(incidentForm);
    incidentRepository.save(incident);
  }

  @Override
  public void deleteIncident(Long id) {
    Preconditions.checkNotNull(id,"Id cannot be null");
    Incident incident = incidentRepository.findOneThrowable(id);
    //drivers i vehicles
    List<Driver> drivers = driverRepository.findAllByIncidentsContains(incident);
    List<Vehicle> vehicles = vehicleRepository.findAllByIncidentsContains(incident);
    //drivers.forEach(incident::)

  }

  @Override
  public List<IncidentViewDto> getAllIncidents() {
    List<Incident> incidents = incidentRepository.findAll();
    if(incidents.isEmpty()){
      throw new BusinessException((ExceptionMessage.INCIDENTS_NOT_FOUND));
    }
    return INCIDENT_VIEW_MAPPER.map(incidents);
  }

  @Override
  public IncidentViewDto getIncidentById(Long id) {
    Preconditions.checkNotNull(id,"Id cannot be null");
    Incident incident = incidentRepository.findOneThrowable(id);
    return INCIDENT_VIEW_MAPPER.map(incident);
  }

  @Override
  public void updateIncident(Long id, IncidentFormDto incidentForm) {
    Preconditions.checkNotNull(id,"Id cannot be null");
    Preconditions.checkNotNull(incidentForm,"Incident form cannot be null");
    Incident incident = incidentRepository.findOneThrowable(id);
    incident = INCIDENT_MAPPER.map(incidentForm, incident);
    incidentRepository.save(incident);
  }
}
