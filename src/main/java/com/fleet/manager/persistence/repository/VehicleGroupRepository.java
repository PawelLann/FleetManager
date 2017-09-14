package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.exception.BusinessException;
import com.fleet.manager.api.exception.ExceptionMessage;
import com.fleet.manager.persistence.entity.VehicleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface VehicleGroupRepository extends JpaRepository<VehicleGroup, Long> {

  default VehicleGroup findOneThrowable(Long id) {
    VehicleGroup vehicleGroup = findOne(id);
    if (vehicleGroup == null) {
      throw new BusinessException((ExceptionMessage.VEHICLE_GROUP_NOT_FOUND));
    }
    return vehicleGroup;
  }
}
