package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.ExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

  List<Incident> findAllByDriversContains(Driver driver);

  default Incident findOneThrowable(Long id) {
    Incident incident = findOne(id);
    if (incident == null) {
      throw new BusinessException((ExceptionMessage.INCIDENT_NOT_FOUND));
    }
    return incident;
  }
}
