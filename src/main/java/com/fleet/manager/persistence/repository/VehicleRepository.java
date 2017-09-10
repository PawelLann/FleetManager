package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.BusinessExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import com.fleet.manager.persistence.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

  List<Vehicle> findAllByDriversContains(Driver driver);

  default Vehicle findOneThrowable(Long id) {
    Vehicle vehicle = findOne(id);
    if (vehicle == null) {
      throw new BusinessException((BusinessExceptionMessage.VEHICLE_NOT_FOUND));
    }
    return vehicle;
  }


}
