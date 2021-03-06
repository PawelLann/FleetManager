package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.exception.BusinessException;
import com.fleet.manager.api.exception.ExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Incident;
import com.fleet.manager.persistence.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

  default Incident findOneThrowable(Long id) {
    Incident incident = findOne(id);
    if (incident == null) {
      throw new BusinessException((ExceptionMessage.INCIDENT_NOT_FOUND));
    }
    return incident;
  }

  List<Incident> findAllByDriversContains(Driver driver);

  List<Incident> findAllByVehiclesContains(Vehicle vehicle);
}
