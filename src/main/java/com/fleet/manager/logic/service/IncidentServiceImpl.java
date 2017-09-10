package com.fleet.manager.logic.service;

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
  @Override
  public void createIncident() {
  }

  @Override
  public void deleteIncident() {
  }

  @Override
  public List<IncidentViewDto> getAllIncidents() {
    return null;
  }

  @Override
  public IncidentViewDto getIncidentById() {
    return null;
  }

  @Override
  public void updateIncident() {

  }
}
