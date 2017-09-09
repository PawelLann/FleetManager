package com.fleet.manager.persistence.repository;

import com.fleet.manager.persistence.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
}