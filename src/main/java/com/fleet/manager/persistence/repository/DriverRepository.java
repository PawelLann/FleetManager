package com.fleet.manager.persistence.repository;

import com.fleet.manager.api.validation.BusinessException;
import com.fleet.manager.api.validation.BusinessExceptionMessage;
import com.fleet.manager.persistence.entity.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

  default Driver findOneThrowable(Long id) {
    Driver driver = findOne(id);
    if (driver == null) {
      throw new BusinessException((BusinessExceptionMessage.DRIVER_NOT_FOUND));
    }
    return driver;
  }
}
