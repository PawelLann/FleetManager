package com.fleet.manager.persistence.entity;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

/**
 * Created by pawel.langwerski@gmail.pl on 06.09.17.
 */
@Getter
@Setter
@Entity
@Table(name = "INCIDENTS")
public class Incident extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 30)
  private String name;
  @Lob
  @Column(nullable = false, length = 10000)
  private String description;
  @Column(name = "INCIDENT_DATE_TIME", nullable = false)
  @DateTimeFormat
  private LocalDateTime date;

  @ManyToMany
  @JoinTable(
      name = "DRIVERS_INCIDENTS",
      joinColumns = {@JoinColumn(name = "INCIDENT_ID")},
      inverseJoinColumns = {@JoinColumn(name = "DRIVER_ID")})
  private Set<Driver> drivers = Sets.newHashSet();

  @ManyToMany(mappedBy = "incidents")
  private Set<Vehicle> vehicles = Sets.newHashSet();

  public void removeDriver(Driver driver) {
    drivers.remove(driver);
  }

  //addVehicle;
  public void removeVehicle(Vehicle vehicle) {
    vehicles.remove(vehicle);
  }

  ;


}