package com.fleet.manager.persistence.repository;

import com.fleet.manager.persistence.entity.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pawel.langwerski@gmail.pl on 09.09.17.
 */
@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
