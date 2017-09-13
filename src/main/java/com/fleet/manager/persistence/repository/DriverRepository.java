package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.ExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

  default Driver findOneThrowable(Long id) {
    Driver driver = findOne(id);
    if (driver == null) {
      throw new BusinessException((ExceptionMessage.DRIVER_NOT_FOUND));
    }
    return driver;
  }

  List<Driver> findAllByIncidentsContains();
}
