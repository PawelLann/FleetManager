package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@Entity
public class VehicleEntity extends AbstractEntity {

  private Integer vinNumber;
  private String brand;
  private String model;
  private Integer yearOfProduction;
  private String color;
  private VehicleStatus vehicleStatus;

  private Collection<VehicleEntity> vehicleEntities = new ArrayList<>();
}
