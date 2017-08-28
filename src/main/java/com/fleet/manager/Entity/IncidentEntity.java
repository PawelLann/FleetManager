package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Getter
@Setter
@Entity
public class IncidentEntity extends AbstractEntity {

  private String name;
  @Lob
  private String description;
  private String date;
}
