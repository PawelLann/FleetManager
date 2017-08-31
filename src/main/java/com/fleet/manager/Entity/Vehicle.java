package com.fleet.manager.Entity;

import lombok.Getter;
import lombok.Setter;
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
  private String brand;
  @NotEmpty
  @Column(nullable = false, length = 20)
  private String model;
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

  @ManyToMany
  @JoinTable(
      name = "VEHICLE_INCIDENT",
      joinColumns = @JoinColumn(name = "ID_VEHICLE"),
      inverseJoinColumns = @JoinColumn(name = "ID_INCIDENT"))
  private Set<Incident> incidentSet = Sets.newHashSet();
}