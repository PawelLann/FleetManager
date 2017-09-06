package com.fleet.manager.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.NotEmpty;
import com.google.common.collect.Sets;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "VEHICLES")
public class Vehicle extends AbstractEntity implements Serializable {

  @NotEmpty
  @Column(nullable = false, length = 17)
  private Integer vinNumber;
  @NotEmpty
  @Column(nullable = false, length = 20)
  private String brandName;
  @NotEmpty
  @Column(nullable = false, length = 20)
  private String modelName;
  @NotEmpty
  @Column(nullable = false, length = 4)
  private Integer yearOfProduction;
  @NotEmpty
  @Column(nullable = false, length = 20)
  private String color;
  @Id
  @Enumerated(EnumType.STRING)
  @NotEmpty
  private VehicleStatus vehicleStatus;
  @Id
  @Enumerated(EnumType.STRING)
  @NotEmpty
  private VehicleType vehicleType;

  @ManyToOne
  @JoinColumn(name="VEHICLE_GROUP_ID")
  private VehicleGroup vehicleGroup;

  @ManyToMany
  @JoinTable(
      name = "DRIVERS_VEHICLES",
      joinColumns = {@JoinColumn(name = "VEHICLE_ID")},
      inverseJoinColumns = {@JoinColumn(name = "DRIVER_ID")})
  private Set<Driver> drivers = Sets.newHashSet();

  @ManyToMany
  @JoinTable(
      name = "INCIDENT_VEHICLES",
      joinColumns = {@JoinColumn(name = "VEHICLE_ID")},
      inverseJoinColumns = {@JoinColumn(name = "INCIDENT_ID")})
  private Set<Incident> incidents = Sets.newHashSet();
}