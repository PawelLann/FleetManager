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
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  default Vehicle findOneThrowable(Long id) {
    Vehicle vehicle = findOne(id);
    if (vehicle == null) {
      throw new BusinessException((ExceptionMessage.VEHICLE_NOT_FOUND));
    }
    return vehicle;
  }

  List<Vehicle> findAllByIncidentsContains(Incident incident);

  List<Vehicle> findAllByDriversContains(Driver driver);
}
